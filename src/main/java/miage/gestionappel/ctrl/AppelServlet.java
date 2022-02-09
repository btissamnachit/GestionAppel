package miage.gestionappel.ctrl;

import miage.gestionappel.dao.EtudiantDao;
import miage.gestionappel.dao.OccurenceDao;
import miage.gestionappel.dao.PresenterDao;
import miage.gestionappel.metier.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AppelServlet extends HttpServlet {
    OccurenceDao occurenceDao = new OccurenceDao();
    PresenterDao presenterDao = new PresenterDao();
    EtudiantDao etudiantDao = new EtudiantDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String cours = request.getParameter("cours");

        int idOccurence = Integer.parseInt(request.getParameter("idOccurence"));

        Occurence occurence = occurenceDao.getOc(idOccurence);
        if (occurence.getAppelValide()) {
            Set<Presenter> presences = occurence.getPresences();
            request.setAttribute("presences", presences);
        } else {
            Set<Presenter> presences = occurence.getPresences();
            request.setAttribute("presences", presences);
            Set<Groupe> groupes = occurence.getGroupes();
            request.setAttribute("groupes", groupes);
        }
        session.setAttribute("occurence", occurence);
        request.setAttribute("cours", cours);
        request.setAttribute("isValide", occurence.getAppelValide());
        request.getRequestDispatcher("/listeEtudiantsSeance").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Occurence occurence = (Occurence) session.getAttribute("occurence");
        String action = request.getParameter("action");
        switch (action) {
            case "EnregistrerEtudiant":
                String statut = request.getParameter("statut");
                int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
                Etudiant etudiant = etudiantDao.get(idEtudiant);
                PrensenterId prensenterId = new PrensenterId(occurence.getIdOc(),idEtudiant);
                Presenter presenter = new Presenter(prensenterId,occurence,etudiant,statut);
                presenterDao.saveOrUpdate(presenter);
                break;
            case "Enregistrer":
                occurence.setAppelValide(true);
                occurenceDao.update(occurence,null);
                // vers emploi du temps
                break;
            case "Retour":
                // vers emploi du temps
                break;

        }
    }
}

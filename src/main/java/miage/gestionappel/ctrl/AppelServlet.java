package miage.gestionappel.ctrl;

import miage.gestionappel.dao.OccurenceDao;
import miage.gestionappel.metier.Groupe;
import miage.gestionappel.metier.Occurence;
import miage.gestionappel.metier.Presenter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AppelServlet extends HttpServlet {

    OccurenceDao occurenceDao = new OccurenceDao();
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
        String action = request.getParameter("action");
        switch (action) {
            case "Enregistrer":
                Occurence occurence = (Occurence) session.getAttribute("occurence");
                occurence.setAppelValide(true);
                occurenceDao.update(occurence,null);
                break;
            case "Retour":
                // vers emploi du temps
                break;

        }
    }
}

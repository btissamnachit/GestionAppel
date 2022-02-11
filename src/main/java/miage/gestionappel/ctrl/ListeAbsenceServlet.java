package miage.gestionappel.ctrl;

import miage.gestionappel.dao.EtudiantDao;
import miage.gestionappel.dao.OccurenceDao;
import miage.gestionappel.dao.PresenterDao;
import miage.gestionappel.metier.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ListeAbsenceServlet  extends HttpServlet {


    EtudiantDao etudiantDao = new EtudiantDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        List<Occurence> absences = null;
        String email = (String)session.getAttribute("email");

        EtudiantDao etudiantDao = new EtudiantDao();

        Etudiant etudiant = etudiantDao.getByEmail(email);

        absences = etudiantDao.getAllAbsence(etudiant);

        request.setAttribute("absencesetudiant", absences);
        request.getRequestDispatcher("/listeabsences").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {


    }
}
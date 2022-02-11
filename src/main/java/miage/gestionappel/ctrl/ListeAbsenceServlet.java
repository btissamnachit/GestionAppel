package miage.gestionappel.ctrl;

import miage.gestionappel.dao.EtudiantDao;
import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.Occurence;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListeAbsenceServlet  extends HttpServlet {


    EtudiantDao etudiantDao = new EtudiantDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        List<Occurence> absences = new ArrayList<>();
        EtudiantDao etudiantDao = new EtudiantDao();
        Etudiant etudiant;
        if (request.getParameter("idE") == null) {
            String email = (String) session.getAttribute("email");
            etudiant = etudiantDao.getByEmail(email);
        } else {
            etudiant = etudiantDao.get(Integer.parseInt(request.getParameter("idE")));
        }
        absences = etudiantDao.getAllAbsence(etudiant);

        request.setAttribute("absencesetudiant", absences);
        request.getRequestDispatcher("/listeabsences").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {


    }
}
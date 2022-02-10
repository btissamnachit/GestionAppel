package miage.gestionappel.ctrl;

import miage.gestionappel.dao.CoursDao;
import miage.gestionappel.dao.EtudiantDao;
import miage.gestionappel.dao.OccurenceDao;
import miage.gestionappel.dao.ProfesseurDao;
import miage.gestionappel.metier.Cours;
import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.Professeur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ListeCoursServlet extends HttpServlet {
    ProfesseurDao professeurDao = new ProfesseurDao();
    CoursDao coursDao = new CoursDao();
    OccurenceDao occurenceDao = new OccurenceDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");
        ProfesseurDao dao = new ProfesseurDao();
        CoursDao coursDao = new CoursDao();
        EtudiantDao etudiantDao = new EtudiantDao();
        Professeur professeur = dao.getByEmail(email);

        Set<Cours> coursProfesseur = professeur.getCours();
        HashMap<Cours, Integer> nbAbsence = null;
        HashMap<Cours, Float> moyenneAbsence = null;
        HashMap<Cours, List<Etudiant>> etudiantsAbsenteistes = null;
        HashMap<Etudiant, Integer> absenceEtudiantGlobal = null;
        for (Cours cours : coursProfesseur) {
            int absensesCours = coursDao.nbAbsence(cours);
            float moyenneAbsenceCours = coursDao.moyenneAbscence(cours);
            List<Etudiant> etudiantsAbsenteistesCours = coursDao.getEtudiantsAbsentistes(cours);
            nbAbsence.put(cours, absensesCours);
            moyenneAbsence.put(cours, moyenneAbsenceCours);
            etudiantsAbsenteistes.put(cours, etudiantsAbsenteistesCours);
            for (Etudiant etudiantAbsenteiste : etudiantsAbsenteistesCours) {
                if (!absenceEtudiantGlobal.entrySet().contains(etudiantAbsenteiste)) {
                    int nbAbsencesEtudiantGlobal = etudiantDao.getAllAbsence(etudiantAbsenteiste).size();
                    absenceEtudiantGlobal.put(etudiantAbsenteiste, nbAbsencesEtudiantGlobal);
                }
            }
        }
        request.setAttribute("cours", coursProfesseur);
        request.setAttribute("nbAbsence", nbAbsence);
        request.setAttribute("moyenneAbsence", moyenneAbsence);
        request.setAttribute("etudiantsAbsenteistes", etudiantsAbsenteistes);
        request.setAttribute("absenceEtudiantGlobal", absenceEtudiantGlobal);
        request.getRequestDispatcher("listeetudiants").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}





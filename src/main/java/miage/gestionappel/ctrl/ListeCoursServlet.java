package miage.gestionappel.ctrl;
import miage.gestionappel.dao.CoursDao;
import miage.gestionappel.dao.ProfesseurDao;
import miage.gestionappel.metier.Cours;
import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.Groupe;
import miage.gestionappel.metier.Professeur;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Set;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class ListeCoursServlet extends HttpServlet {
    ProfesseurDao professeurDao = new ProfesseurDao();
    CoursDao coursDao = new CoursDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        HttpSession session = request.getSession(true);
        // String email = (String) session.getAttribute("email");
        String action = request.getParameter("action");
        if(action!= null && action == "listEtudiantsCours"){
            int idCours = Integer.parseInt(request.getParameter("idCours"));
            Cours cours = coursDao.get(idCours);
            Set<Groupe> groupes = cours.getGroupes();
            for (Groupe g : groupes){
                Set<Etudiant> etudiants = g.getEtudiants();
                request.setAttribute("etudiants",etudiants);
            }

        }else {
            ProfesseurDao professeurDao = new ProfesseurDao();
            Professeur professeur = professeurDao.getByEmail("nathalie.valles-parlangeau@ut-capitole.fr");

            Set<Cours> cours = professeur.getCours();
            request.setAttribute("cours", cours);

            for (Cours c : cours) {
                Set<Groupe> groupes = c.getGroupes();
                for (Groupe g : groupes){
                    Set<Etudiant> etudiants = g.getEtudiants();
                    request.setAttribute("etudiants",etudiants);
                }
            }
            request.getRequestDispatcher("/listeetudiants").forward(request, response);
        }

        }

        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

        }
    }



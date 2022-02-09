package miage.gestionappel.ctrl;
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


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");
        request.getParameter("email");

        ProfesseurDao professeurDao = new ProfesseurDao();
        Professeur professeur = professeurDao.getByEmail(email);

        Set<Cours> cours = professeur.getCours();
        request.setAttribute("cours", cours);

        for (Cours c : cours) {
            System.out.println("résultat : " + c.getNomC());
            Set<Groupe> groupes = c.getGroupes();
            for (Groupe g : groupes){
                Set<Etudiant> etudiants = g.getEtudiants();

            }

        }
        request.getRequestDispatcher("/listeetudiants").forward(request, response);
        }

        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

        }
    }



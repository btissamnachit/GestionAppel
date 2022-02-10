package miage.gestionappel.ctrl;

import miage.gestionappel.dao.EtudiantDao;
import miage.gestionappel.dao.ExceptionDao;
import miage.gestionappel.dao.ProfesseurDao;
import miage.gestionappel.dao.UserDao;
import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.Professeur;
import miage.gestionappel.metier.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ConnexionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        UserDao userDao = new UserDao();

        String email = request.getParameter("email");
        String motdepasse = request.getParameter("motdepasse");
        System.out.println(email+motdepasse);
        String msg_avert = "";
        if(email == null || motdepasse == null || email.isEmpty() || motdepasse.isEmpty()){
            msg_avert = "Veuillez saisir votre mail ou/et mot de passe";
            request.setAttribute("msg_a", msg_avert);
            request.getRequestDispatcher("login").forward(request,response);
        }
        else{
            try{
                User user =  userDao.getConnexion(email,motdepasse);
                sessionUtilisateur(user, session);
                session.setAttribute("nom", user.getNomU());
                session.setAttribute("prenom", user.getPrenomU());
                session.setAttribute("email", user.getMailU());
                session.setAttribute("role", user.getRoleU());


                if (user.getRoleU() == "professeur"){

                    ProfesseurDao professeurDao = new ProfesseurDao();

                    Professeur professeur = professeurDao.getByEmail(email);
                    System.out.println(professeur.toString());
                    session.setAttribute("professeur", professeur);

                }
                else if (user.getRoleU() == "etudiant"){

                    EtudiantDao etudiantDao = new EtudiantDao();

                    Etudiant etudiant = etudiantDao.getByEmail(email);
                    System.out.println(etudiant.toString());

                    session.setAttribute("etudiant", etudiant);

                }

                System.out.println("hello "+session.getAttribute("nom"));
                request.getRequestDispatcher("profil").forward(request, response);
            } catch (ExceptionDao e) {
                request.setAttribute("msg_e", e.getMessage());
                request.getRequestDispatcher("login").forward(request, response);
            }
        }
    }

    private void sessionUtilisateur(User user, HttpSession session){

    }
}


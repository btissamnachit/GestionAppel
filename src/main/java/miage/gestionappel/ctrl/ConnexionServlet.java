package miage.gestionappel.ctrl;

import com.google.protobuf.Message;
import miage.gestionappel.dao.ExceptionDao;
import miage.gestionappel.dao.UserDao;
import miage.gestionappel.metier.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name = "ConnexionServlet", value = "/connexion")
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

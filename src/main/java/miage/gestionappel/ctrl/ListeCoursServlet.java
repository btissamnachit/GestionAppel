package miage.gestionappel.ctrl;


import miage.gestionappel.dao.GroupeDao;
import miage.gestionappel.metier.Cours;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListeCoursServlet", value = "/ListeCoursServlet")

public class ListeCoursServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*----- Récupérer les informations -----*/
        String cours = request.getParameter("cours");

        /*----- Chainage vers ListeCours.jsp -----*/
        request.setAttribute("cours", cours);


        GroupeDao groupe = new GroupeDao();

        try {

            groupe.getListeEtudiantCour();
            /*----- Vers la page -----*/
            request.getRequestDispatcher("ListeEtudiants").forward(request, response);

        } catch (ServletException e) {

            /*----- Chainage vers ListeEtuidiants.jsp -----*/
            request.getRequestDispatcher("ListeEtudiants").forward(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
        ;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }
}

package miage.gestionappel.ctrl;


import miage.gestionappel.dao.GroupeDao;
import miage.gestionappel.dao.ProfesseurDao;
import miage.gestionappel.metier.Cours;
import miage.gestionappel.metier.Professeur;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListeCoursServlet", value = "/ListeCoursServlet")

public class ListeCoursServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        /*----- Récupérer les informations -----*/
        String email = request.getParameter("email");

        ProfesseurDao professeurDao = new ProfesseurDao();
        Professeur professeur = new Professeur();

        professeur = professeurDao.getByEmail(email);

//        Cours cours =
//        Set<Cours> cours = professeur.getCours();
//
//            for (Cours c : cours) {
//                System.out.println("résultat : " + c.getNomC());
//            }
//
//            request.setAttribute("cours", cours);
//            request.getRequestDispatcher("/listeetudiants").forward(request, response);
//
//
}

        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }


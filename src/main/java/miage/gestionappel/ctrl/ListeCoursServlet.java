package miage.gestionappel.ctrl;

import miage.gestionappel.dao.CoursDao;
import miage.gestionappel.dao.OccurenceDao;
import miage.gestionappel.dao.ProfesseurDao;
import miage.gestionappel.metier.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class ListeCoursServlet extends HttpServlet {
    ProfesseurDao professeurDao = new ProfesseurDao();
    CoursDao coursDao = new CoursDao();
    OccurenceDao occurenceDao = new OccurenceDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        // String email = (String) session.getAttribute("email");
        String action = request.getParameter("action");
        switch (action) {
            case "listParCours":
                int idOccurence = Integer.parseInt(request.getParameter("idOccurence"));
                Occurence occurence = occurenceDao.getOc(idOccurence);
                xmlResponse(request, response, occurence);
                break;
            case "list":
                ProfesseurDao professeurDao = new ProfesseurDao();
                Professeur professeur = professeurDao.getByEmail("nathalie.valles-parlangeau@ut-capitole.fr");
                Set<Cours> coursP = professeur.getCours();
                request.setAttribute("cours", coursP);
                request.getRequestDispatcher("/listeetudiants").forward(request, response);
                // vers emploi du temps
                break;
            case "listOccurences":
                int idCoursO = Integer.parseInt(request.getParameter("idCours"));
                Cours coursO = coursDao.get(idCoursO);
                Set<Occurence> occurencesO = coursO.getOccurences();
                xmlResponseOccurences(request, response, occurencesO);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void xmlResponseOccurences(HttpServletRequest request, HttpServletResponse response, Set<Occurence> occurences) throws IOException {
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<liste_occurrence>");

            try {
                for (Occurence o : occurences) {
                    out.println("<occurrence>");
                    out.println("<id>" + o.getIdOc() + "</id>");
                    out.println("<date" + o.getDateOc() + "</date>");
                    out.println("<debut>" + o.getHeureDebutOc() + "</debut>");
                    out.println("<fin>" + o.getHeureFinOc() + "</fin>");
                    out.println("</occurrence>");
                }

            } catch (Exception ex) {
                out.println("<occurrence>Erreur - " + ex.getMessage() + "</occurrence>");
            }

            out.println("</liste_occurrence>");
        }
    }

    protected void xmlResponse(HttpServletRequest request, HttpServletResponse response, Occurence occurence) throws IOException {
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<liste_etudiant>");
            try {
                for (Presenter p : occurence.getPresences()) {
                    Etudiant etudiant = p.getEtudiant();
                    out.println("<etudiant>");
                    out.println("<id>" + etudiant.getIdE() + "</id>");
                    out.println("<nom>" + etudiant.getNomE() + "</nom>");
                    out.println("<prenom>" + etudiant.getPrenomE() + "</prenom>");
                    out.println("<mail>" + etudiant.getMailE() + "</mail>");
                    out.println("<statut>" + p.getStatut() + "</statut>");
                    out.println("</etudiant>");
                }

            } catch (Exception ex) {
                out.println("<etudiant>Erreur - " + ex.getMessage() + "</etudiant>");
            }

            out.println("</liste_etudiant>");
        }
    }

}





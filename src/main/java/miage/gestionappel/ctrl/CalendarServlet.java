package miage.gestionappel.ctrl;

import miage.gestionappel.dao.OccurenceDao;
import miage.gestionappel.metier.Occurence;
import miage.gestionappel.metier.Professeur;
import miage.gestionappel.util.DateManipulation;
import org.joda.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        LocalDate dateFocus = (LocalDate) request.getAttribute("week");
        DateManipulation dm = new DateManipulation();
        dm.setDateNow(dateFocus);
        HashMap<String, Date> weekDetails = dm.getWeekDetails();
        Professeur professeur = (Professeur) session.getAttribute("user");
        int idP = professeur.getIdP();

        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<Calendar>");
            OccurenceDao dao = new OccurenceDao();
            List<Occurence> occurenceList = dao.getOccurenceProfesseur(idP, dateFocus);
            out.println("<day>" + occurenceList);
            out.println("<event>" + occurenceList + "</event>");
            out.println("</day>");
            out.println("</Calendar>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

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
        Professeur professeur = (Professeur) session.getAttribute("user");
        int idP = professeur.getIdP();
        HashMap<String, Date> weekDetails = getFocusWeekDetails(request);


        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<Calendar>");
            OccurenceDao dao = new OccurenceDao();
            List<Occurence> occurenceList = dao.getAll();
            out.println("<day>" + occurenceList);
            out.println("<event>" + occurenceList + "</event>");
            out.println("</day>");
            out.println("</Calendar>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected HashMap<String, Date> getFocusWeekDetails(HttpServletRequest request) {
        LocalDate dateFocus = (LocalDate) request.getAttribute("week");
        DateManipulation dm = new DateManipulation();
        dm.setDateNow(dateFocus);
        return dm.getWeekDetails();
    }

    protected HashMap<Date, Occurence> getWeekClasses() {
        HashMap<Date, Occurence> weekClasses = new HashMap<>();
        OccurenceDao dao = new OccurenceDao();
        List<Occurence> occurenceList = dao.getAll();
        return weekClasses;
    }
}

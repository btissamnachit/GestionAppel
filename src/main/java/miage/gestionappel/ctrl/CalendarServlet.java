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
import java.util.*;
import java.util.stream.Collectors;

public class CalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Professeur professeur = (Professeur) session.getAttribute("user");
        Set<Occurence> occurencesList = professeur.getOccurences();
        List<Date> weekDetails = getFocusWeekDetails(request);


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

    protected List<Date> getFocusWeekDetails(HttpServletRequest request) {
        LocalDate dateFocus = (LocalDate) request.getAttribute("startOfWeek");
        DateManipulation dm = new DateManipulation();
        dm.setDateNow(dateFocus);
        return dm.getAllDateOfWeek();
    }

    protected HashMap<Date, List<Occurence>> getWeekClasses(List<Date> weekDates, Set<Occurence> occurencesList) {
        HashMap<Date, List<Occurence>> weekClasses = new HashMap<>();
        for (Date date : weekDates) {
            List<Occurence> dayClasses = getDayClasses(date, occurencesList);
            weekClasses.put(date, dayClasses);
        }
        return weekClasses;
    }

    protected List<Occurence> getDayClasses(Date dDay, Set<Occurence> occurencesList) {
        List<Occurence> dayClasses = new ArrayList<>();
        dayClasses = occurencesList.stream().filter(occurence -> occurence.getDateOc() == dDay).collect(Collectors.toList());
        return dayClasses;
    }


}

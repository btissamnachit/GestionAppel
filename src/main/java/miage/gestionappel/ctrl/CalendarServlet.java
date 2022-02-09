package miage.gestionappel.ctrl;

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
import java.util.*;
import java.util.stream.Collectors;

public class CalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Professeur professeur = (Professeur) session.getAttribute("professeur");
        Set<Occurence> occurencesList = professeur.getOccurences();
        DateManipulation dm = new DateManipulation();
        setFocusWeek(request, dm);
        List<Date> weekDetails = getFocusWeekDetails(dm);

        String action = request.getParameter("week");
        switch (action) {
            case "thisWeek":
                request.setAttribute("week", dm.getDateNow());
                request.setAttribute("timetable", getWeekClasses(weekDetails, occurencesList));
                request.getRequestDispatcher("calendar").forward(request, response);
            case "precedent":
                dm.removeOneWeek();
                request.setAttribute("week", dm.getDateNow());
                request.setAttribute("timetable", getWeekClasses(weekDetails, occurencesList));
                request.getRequestDispatcher("calendar").forward(request, response);
            case "suivant":
                dm.addOneWeek();
                request.setAttribute("week", dm.getDateNow());
                request.setAttribute("timetable", getWeekClasses(weekDetails, occurencesList));
                request.getRequestDispatcher("calendar").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void setFocusWeek(HttpServletRequest request, DateManipulation dm) {
        if (request.getAttribute("week") != null) {
            LocalDate week = (LocalDate) request.getAttribute("week");
            dm.setDateNow(week);
        }

    }

    protected List<Date> getFocusWeekDetails(DateManipulation dm) {
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

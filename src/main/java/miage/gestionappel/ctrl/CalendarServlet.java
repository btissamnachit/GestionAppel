package miage.gestionappel.ctrl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
        DateManipulation dm = new DateManipulation();
        JsonObject timeTable = new JsonObject();
        JsonArray eventsOfTheWeek = new JsonArray();
        for (Date weekDate : weekDetails) {
            JsonArray eventsOfTheDay = new JsonArray();
            getDayClasses(weekDate, occurencesList).forEach(cours -> {
                JsonObject event = new JsonObject();
                event.addProperty("event", cours.getCours().getNomC());
                event.addProperty("dataStart", String.valueOf(cours.getHeureDebutOc()));
                event.addProperty("dataEnd", String.valueOf(cours.getHeureFinOc()));
                eventsOfTheDay.add(event);
            });
            eventsOfTheWeek.add(eventsOfTheDay);
        }
        timeTable.add("timeTable", eventsOfTheWeek);
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(timeTable);
        }

        this.getServletContext().getRequestDispatcher("/depotjustificatif").forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected List<Date> getFocusWeekDetails(HttpServletRequest request) {
        LocalDate dateFocus = (LocalDate) request.getAttribute("startOfWeek");
        DateManipulation dm = new DateManipulation();
        if (dateFocus != null) {
            dm.setDateNow(dateFocus);
        }
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

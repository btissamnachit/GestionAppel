package miage.gestionappel.ctrl;

import com.google.gson.Gson;
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
        HashMap<Date, List<Occurence>> timeTable = getWeekClasses(weekDetails, occurencesList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Gson gson = new Gson();
            out.print(gson.toJson(timeTable));
            out.flush();
        }
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

package miage.gestionappel.ctrl;

import miage.gestionappel.dao.ProfesseurDao;
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
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CalendarServlet extends HttpServlet {
    private final SimpleDateFormat comparaisonFormat = new SimpleDateFormat("dd-MM-yyyy");
    private final SimpleDateFormat displayFormat = new SimpleDateFormat("EEEE, dd/MM");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");
        ProfesseurDao dao = new ProfesseurDao();
        Professeur professeur = dao.getByEmail(email);
        //Professeur professeur = (Professeur)session.getAttribute("professeur");
        Set<Occurence> occurencesList = professeur.getOccurences();
        DateManipulation dm = new DateManipulation();
        setFocusWeek(request, dm);
        List<Date> weekDetails = getFocusWeekDetails(dm);
        System.out.println(getWeekClasses(weekDetails, occurencesList));
        String action = request.getParameter("week");
        switch (action) {
            case "thisWeek":
                request.setAttribute("week", dm.getDateNow());
                request.setAttribute("timetable", getWeekClasses(weekDetails, occurencesList));
                request.getRequestDispatcher("calendar").forward(request, response);
            case "precedent":
                dm.setDateNow((LocalDate) request.getAttribute("week"));
                dm.removeOneWeek();
                request.setAttribute("week", dm.getDateNow());
                request.setAttribute("timetable", getWeekClasses(weekDetails, occurencesList));
                request.getRequestDispatcher("calendar").forward(request, response);
            case "suivant":
                dm.setDateNow((LocalDate) request.getAttribute("week"));
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

    protected LinkedHashMap<String, List<Occurence>> getWeekClasses(List<Date> weekDates, Set<Occurence> occurencesList) {
        LinkedHashMap<String, List<Occurence>> weekClasses = new LinkedHashMap<>();
        Collections.sort(weekDates);
        for (Date date : weekDates) {
            List<Occurence> dayClasses = getDayClasses(date, occurencesList);
            weekClasses.put(displayFormat.format(date), dayClasses);
        }
        return weekClasses;
    }

    protected List<Occurence> getDayClasses(Date dDay, Set<Occurence> occurencesList) {
        List<Occurence> dayClasses;
        dayClasses = occurencesList.stream().filter(occurence -> comparaisonFormat.format(occurence.getDateOc()).equals(comparaisonFormat.format(dDay))).collect(Collectors.toList());
        return dayClasses;
    }


}

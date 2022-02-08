package miage.gestionappel.util;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class DateManipulation {
    private LocalDate dateNow = LocalDate.now();
    private DateTime startOfTheWeek;
    private DateTime endOfTheWeek;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");


    public DateManipulation() {
        DateTime startOfTheWeek = new DateTime().withYear(dateNow.getYear()).withWeekOfWeekyear(dateNow.getWeekOfWeekyear())
                .withDayOfWeek(1);
        DateTime endOfTheWeek = startOfTheWeek.plusDays(5);
    }

    public LocalDate getDateNow() {
        return dateNow;
    }

    public void setDateNow(LocalDate dateNow) {
        this.dateNow = dateNow;
    }

    public DateTime getStartOfTheWeek() {
        return startOfTheWeek;
    }

    public void setStartOfTheWeek(DateTime startOfTheWeek) {
        this.startOfTheWeek = startOfTheWeek;
    }

    public DateTime getEndOfTheWeek() {
        return endOfTheWeek;
    }

    public void setEndOfTheWeek(DateTime endOfTheWeek) {
        this.endOfTheWeek = endOfTheWeek;
    }

    public HashMap<String, Date> getWeekDetails() {
        HashMap<String, Date> weekDetails = new HashMap<>();
        DateTime start = this.startOfTheWeek;
        DateTime end = this.endOfTheWeek;
        while (start.isBefore(end)) {
            String dayName = dateFormat.format(start);
            weekDetails.put(dayName, start.toDate());
            start.plusDays(1);
        }
        String dayName = dateFormat.format(end);
        weekDetails.put(dayName, end.toDate());
        return weekDetails;
    }

}

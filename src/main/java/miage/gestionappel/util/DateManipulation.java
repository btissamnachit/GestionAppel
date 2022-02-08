package miage.gestionappel.util;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<Date> getAllDateOfWeek() {
        List<Date> dateList = new ArrayList<>();
        DateTime iterator = this.startOfTheWeek;
        DateTime end = this.endOfTheWeek;
        while (iterator.isBefore(end)) {
            dateList.add(iterator.toDate());
            iterator.plusDays(1);
        }
        String dayName = dateFormat.format(end);
        dateList.add(end.toDate());
        return dateList;
    }

    public String getDateName(Date date) {
        return dateFormat.format(date);
    }

}

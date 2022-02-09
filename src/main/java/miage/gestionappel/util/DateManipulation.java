package miage.gestionappel.util;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateManipulation {
    private LocalDate dateNow;
    private DateTime startOfTheWeek;
    private DateTime endOfTheWeek;
    private final SimpleDateFormat dateNameFormat = new SimpleDateFormat("EEEE");
    private final DateTimeFormatter localDateFormat = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss zzz yyyy");

    public DateManipulation() {
        this.dateNow = LocalDate.now();
        this.startOfTheWeek = new DateTime().withYear(dateNow.getYear()).withWeekOfWeekyear(dateNow.getWeekOfWeekyear())
                .withDayOfWeek(1);
        this.endOfTheWeek = startOfTheWeek.plusDays(4);
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

    public void setStartOfTheWeek(LocalDate date) {
        this.startOfTheWeek = new DateTime().withYear(date.getYear()).withWeekOfWeekyear(date.getWeekOfWeekyear())
                .withDayOfWeek(1);
    }

    public DateTime getEndOfTheWeek() {
        return endOfTheWeek;
    }

    public void setEndOfTheWeek() {
        this.endOfTheWeek = startOfTheWeek.plusDays(4);
    }

    public List<Date> getAllDateOfWeek() {
        List<Date> dateList = new ArrayList<>();
        DateTime iterator = this.startOfTheWeek;
        for (int i = 0; i < 5; i++) {
            dateList.add(iterator.plusDays(i).toDate());
        }
        return dateList;
    }

    public String getDateName(Date date) {
        return dateNameFormat.format(date);
    }

    public LocalDate toLocalDate(String date) {
        return LocalDate.parse(date, localDateFormat);
    }

    public void addOneWeek() {
        this.dateNow = dateNow.plusDays(7);
        setStartOfTheWeek(this.dateNow);
        setEndOfTheWeek();
    }

    public void removeOneWeek() {
        this.dateNow = dateNow.minusDays(7);
        setStartOfTheWeek(this.dateNow);
        setEndOfTheWeek();
    }

}

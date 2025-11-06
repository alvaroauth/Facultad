package ejercicio19;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
    private LocalDate from;
    private LocalDate to;

    public DateLapse(LocalDate f, LocalDate t) {
        this.from = f;
        this.to = t;
    }

    public LocalDate getFrom() {
        return this.from;
    }

    public LocalDate getTo() {
        return this.to;
    }

    public int sizeInDays(){
        return (int)ChronoUnit.DAYS.between(from, to);
    }

    public boolean includesDate(LocalDate other){
        return ((from.isBefore(other) || from.isEqual(other)) && (to.isAfter(other) || to.isEqual(other)));
    }

    public boolean overlaps(DateLapse another) {
        return this.from.isBefore(another.to) && another.from.isBefore(this.to);
    }
}
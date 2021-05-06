package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.time.util.Calendars;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Calendar;
import java.util.Objects;

@Embeddable
public class Dateofbirth implements ValueObject {

    private static final long serialVersionUID = 1L;
    private Calendar calendars;

    public Dateofbirth() {
    }

    public Dateofbirth(final Calendar calendars) {
        Preconditions.noneNull(calendars);
        hasagetoWork(calendars);
        this.calendars = calendars;
    }
    private int calculateage(Calendar calendar){
        int year=calendar.get(Calendar.YEAR);
        Calendar calendar1=Calendar.getInstance();
        int presentyear=calendar1.get(Calendar.YEAR);
        return presentyear-year;
    }
    private void hasagetoWork(Calendar calendar){
        int age=calculateage(calendar);
        if (age<16){
            throw new IllegalArgumentException("The collaborator is to young to work");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dateofbirth that = (Dateofbirth) o;
        return calendars.equals(that.calendars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calendars);
    }

    @Override
    public String toString() {
        return "calendars=" + Calendars.format(calendars);
    }
}

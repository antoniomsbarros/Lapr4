package eapli.base.taskmanagement.domain;

import eapli.base.clientusermanagement.domain.Dateofbirth;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.time.util.Calendars;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author marly
 */
@Embeddable
public class Deadline implements ValueObject {

    private static final long serialVersionUID = 1L;
    private Calendar deadline;

    public Deadline(){}

    public Deadline(final Calendar deadline) {
        if(deadline.compareTo(Calendar.getInstance()) < 1){
            throw new IllegalArgumentException("Date has to be grather then the actual");
        }
        Preconditions.noneNull(deadline);
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deadline date = (Deadline) o;
        return deadline.equals(date.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deadline);
    }

    @Override
    public String toString() {
        return "Date: " + Calendars.format(deadline);
    }

    public Calendar Date() {
        return deadline;
    }

}

package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.time.util.Calendars;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import java.io.File;
import java.util.Calendar;

@Entity
public class Draft implements AggregateRoot<Long> {
    @Id
    @GeneratedValue
    private  Long id;
    @Version
    private Long version;
    private File file;

    @Temporal(TemporalType.DATE)
    private Calendar deadline;

    private Number urgency;

    private String assigned;

    public Draft() {
    }

    public Draft(final String assigned, final File filepath,final Calendar deadline,final Number urgency)  {
        Preconditions.noneNull(assigned,filepath,deadline, urgency);
        this.file = filepath;
        this.deadline = deadline;
        this.urgency = urgency;
        this.assigned=assigned;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Draft)){
            return  false;
        }
        final  Draft draft=(Draft) other;
        if (this== draft){
            return true;
        }
        return identity().equals(draft.identity()) && deadline.equals(draft.deadline) && file.equals(draft.file)
                && assigned.equals(draft.assigned);
    }

    @Override
    public Long identity() {
        return this.id;
    }
    public Calendar date(){
        return  deadline;
    }
    public Number urgency(){
        return  urgency;
    }
    public  File filepath(){
        return  file;
    }
    public  String assigned(){
        return assigned;
    }

    @Override
    public String toString() {
        return "id=" + id +  ", deadline=" + Calendars.format(deadline) + ", urgency=" + urgency.toString();
    }
}

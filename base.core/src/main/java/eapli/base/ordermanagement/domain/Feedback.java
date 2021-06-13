package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.DomainEntity;
import eapli.framework.time.util.Calendars;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import java.util.Calendar;
@Entity
public class Feedback  implements DomainEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;

    private Long feedbackScale;

    @Temporal(TemporalType.DATE)
    private Calendar date;

    public Feedback() {
    }

    public Feedback(final Long feedbackScale,final Calendar date) {
        Preconditions.noneNull(feedbackScale,date);
        if (feedbackScale<0){
            throw new IllegalArgumentException("The Scale of the feedback cant be negative");
        }
        if (feedbackScale>5){
            throw new IllegalArgumentException("The Scale of the feedback cant be superior to 5");
        }
        this.feedbackScale = feedbackScale;
        this.date = date;
    }
    public Calendar date(){
        return date;
    }
    public  Long scale(){
        return feedbackScale;
    }

    @Override
    public String toString() {
        return ", feedbackScale=" + feedbackScale.toString() + ", date=" + Calendars.format(date);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return id;
    }
}

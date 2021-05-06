package eapli.base.ordermanagement.domain;

import eapli.framework.time.util.Calendars;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import java.util.Calendar;
@Entity
@Embeddable
public class Feedback  {
    @Id
    @GeneratedValue
    private Long id;

    private FeedbackScale feedbackScale;

    @Temporal(TemporalType.DATE)
    private Calendar date;

    public Feedback() {
    }

    public Feedback( FeedbackScale feedbackScale, Calendar date) {
        Preconditions.noneNull(feedbackScale,date);

        this.feedbackScale = feedbackScale;
        this.date = date;
    }
    public Calendar date(){
        return date;
    }
    public  FeedbackScale scale(){
        return feedbackScale;
    }

    @Override
    public String toString() {
        return ", feedbackScale=" + feedbackScale.toString() + ", date=" + Calendars.format(date);
    }
}

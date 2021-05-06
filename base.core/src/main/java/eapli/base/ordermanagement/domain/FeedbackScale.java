package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class FeedbackScale implements ValueObject {
    @Id
    @GeneratedValue
    private Long id;

    private Integer scale;

    public FeedbackScale() {
    }

    public FeedbackScale(Integer scale) {
        Preconditions.noneNull(scale);
        if (scale<0){
            throw new IllegalArgumentException("The Scale of the feedback cant be negative");
        }
        if (scale>5){
            throw new IllegalArgumentException("The Scale of the feedback cant be superior to 5");
        }
        this.scale = scale;
    }
    public Integer scale(){
        return scale;
    }

    @Override
    public String toString() {
        return "scale=" + scale;
    }
}

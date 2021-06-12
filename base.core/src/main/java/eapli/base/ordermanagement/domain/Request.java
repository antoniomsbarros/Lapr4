package eapli.base.ordermanagement.domain;

import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.taskmanagement.domain.Answer;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity
public class Request implements AggregateRoot<Long>  {
    @Id
    @GeneratedValue
    private Long idRequest;
    @Enumerated(EnumType.STRING)
    private State stateofResquest;

    @Temporal(TemporalType.DATE)
    private Calendar dateofRequest;

    @OneToOne()
    private Feedback feedback;
    @OneToOne()
    private Workflow workflow;
    @OneToOne(optional = false)
    private Draft draft;
    @OneToOne()
    private Form form;
    @ElementCollection
    private List<Answer> lstResposta;

    public Request() {
    }

    public Request(final Workflow workflow,final State stateofResquest,final Calendar dateofRequest,final Feedback feedback,final Draft draft,final Form form) {
        Preconditions.noneNull(draft,dateofRequest,stateofResquest,workflow,form);
        this.stateofResquest = stateofResquest;
        this.dateofRequest = dateofRequest;
        this.feedback = feedback;
        this.draft = draft;
        this.workflow=workflow;
        this.form = form;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Request)){
            return false;
        }
        Request request=(Request) other;
        if (this==request){
            return true;
        }
        return  identity().equals(((Request) other).identity()) && stateofResquest.equals(((Request) other).stateofResquest)
                && dateofRequest.equals(((Request) other).dateofRequest) && feedback.equals(request.feedback) && workflow.equals(request.workflow) && form.equals(request.form);
    }

    @Override
    public Long identity() {
        return idRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return idRequest.equals(request.idRequest) && stateofResquest == request.stateofResquest && dateofRequest.equals(request.dateofRequest) && Objects.equals(feedback, request.feedback) && draft.equals(request.draft) && form.equals(request.form);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRequest, stateofResquest, dateofRequest, feedback, draft, form);
    }

    @Override
    public String toString() {
        return "Request{" +
                "idRequest=" + idRequest +
                ", stateofResquest=" + stateofResquest +
                ", dateofRequest=" + dateofRequest +
                ", feedback=" + feedback +
                ", workflow=" + workflow +
                ", draft=" + draft +
                ", form=" + form +
                '}';
    }
}

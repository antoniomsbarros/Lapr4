package eapli.base.ordermanagement.domain;

import eapli.base.catalogmanagement.domain.Workflow;
import eapli.framework.domain.model.DomainFactory;

import java.util.Calendar;
import java.util.List;

public class RequestBuilder implements DomainFactory<Request> {

    private State stateRequest;
    private Calendar dateRequest;
    private Feedback feedback;
    private Workflow workflow;
    private Draft draft;
    private Form form;

    public RequestBuilder(State stateRequest, Calendar dateRequest, Feedback feedback, Workflow workflow, Draft draft, Form form) {
        this.stateRequest = stateRequest;
        this.dateRequest = dateRequest;
        this.feedback = feedback;
        this.workflow = workflow;
        this.draft = draft;
        this.form = form;
    }

    public RequestBuilder withState(State stateRequest){
        this.stateRequest = stateRequest;
        return this;
    }

    public RequestBuilder withDate(Calendar dateRequest){
        this.dateRequest = dateRequest;
        return this;
    }

    public RequestBuilder withFeedback(Feedback feedback){
        this.feedback = feedback;
        return this;
    }

    public RequestBuilder withWorkflow(Workflow workflow){
        this.workflow = workflow;
        return this;
    }

    public RequestBuilder withDraft(Draft draft){
        this.draft = draft;
        return this;
    }

    public RequestBuilder withForm(Form form){
        this.form = form;
        return this;
    }

    @Override
    public Request build() {
        return new Request(workflow,stateRequest,dateRequest,feedback,draft,form);
    }
}
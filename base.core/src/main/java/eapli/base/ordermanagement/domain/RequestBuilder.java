package eapli.base.ordermanagement.domain;

import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.taskmanagement.domain.Answer;
import eapli.framework.domain.model.DomainFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RequestBuilder implements DomainFactory<Request> {

    private State stateRequest;
    private Calendar dateRequest;
    private Feedback feedback;
    private Workflow workflow;
    private Draft draft;
    private Form form;
    private Answer lstAnswers;

    public RequestBuilder(){}

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

    public RequestBuilder withListAnswers(Answer lstAnswers){
        this.lstAnswers = lstAnswers;
        return this;
    }

    @Override
    public Request build() {
        return new Request(workflow,stateRequest,dateRequest,feedback,draft,lstAnswers);
    }
}
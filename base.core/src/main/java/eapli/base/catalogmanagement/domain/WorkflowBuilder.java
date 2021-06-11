package eapli.base.catalogmanagement.domain;

import eapli.framework.domain.model.DomainFactory;

import java.util.List;

public class WorkflowBuilder implements DomainFactory<Workflow> {

    private List<Sequence> sequences;

    public WorkflowBuilder(List<Sequence> sequences) {
        this.sequences = sequences;
    }

    public WorkflowBuilder() {
    }

    public WorkflowBuilder withSequences(List<Sequence> sequences){
        this.sequences=sequences;
        return  this;
    }
    @Override
    public Workflow build() {
        return new Workflow(this.sequences);
    }
}

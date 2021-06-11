package eapli.base.catalogmanagement.domain;

import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.model.DomainFactory;

public class SequenceBuilder implements DomainFactory<Sequence> {
    private Long position;
    private Task task;

    public SequenceBuilder() {
    }

    public SequenceBuilder(Long position, Task task) {
        this.position = position;
        this.task = task;
    }
    public SequenceBuilder withPosition(Long position){
        this.position=position;
        return this;
    }
    public  SequenceBuilder withTask(Task task){
        this.task=task;
        return this;
    }

    @Override
    public Sequence build() {
        return new Sequence(position, task);
    }
}

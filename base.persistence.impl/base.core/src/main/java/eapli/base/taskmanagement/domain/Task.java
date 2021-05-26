package eapli.base.taskmanagement.domain;


import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 * @author marly
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Task implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskCode;

    @Enumerated(EnumType.STRING)
    private TaskState state;
    private Deadline deadline;
    private Integer priority;

    private boolean active;

    public Task() {

    }

    public Task(TaskState state, Deadline deadline, Integer priority){
        this.state = state;
        this.deadline = deadline;
        this.priority = priority;
        this.active = true;
    }

    /**
     *
     * @return true or false whether is or not active
     */
    public boolean isActive() {
        return this.active;
    }

    /**
     *
     * @return whether the Task is active or not
     */
    public boolean toogleState() {
        this.active = !this.active;
        return isActive();
    }

    @Override
    public boolean sameAs(final Object other) {

        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }

        final Task task = (Task) other;

        return taskCode.equals(task.taskCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskCode);
    }

    @Override
    public boolean equals(final Object o) {

        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        final Task task = (Task) o;

        return taskCode.equals(task.taskCode);
    }
    @Override
    public Long identity() {
        return this.taskCode;
    }

}

package eapli.base.taskmanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.ordermanagement.domain.Attribute;
import eapli.framework.domain.model.DomainEntity;

import eapli.framework.general.domain.model.Description;
import eapli.framework.time.util.Calendars;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class ManualTask extends Task implements DomainEntity<Long> {

    @Enumerated(EnumType.STRING)
    private TaskType type;

    @OneToOne
    private ClientUser collaborator;

    private Description commentary;
    private Description decision;

    public ManualTask() {

    }


    public ManualTask(TaskState state, Deadline deadline, Integer priority,
                      TaskType type,
                      ClientUser collaborator,
                      Description decision,
                      Description commentary) {

        super(state, deadline, priority);

        try {
            if (Calendars.now().compareTo(deadline.Date()) == 1) {
                throw new IllegalArgumentException("Invalid DeadLine!");
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Invalid DeadLine: " + e);
        }


        this.collaborator = collaborator;

        try {
            if (this.collaborator == null) {
                throw new IllegalArgumentException("Invalid Collaborator!");
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Invalid Collaborator: " + e);
        }
        this.type = type;
        this.decision = decision;
        this.commentary = commentary;
    }


    public boolean isCollabValid (List<ClientUser> collaboratorList){
        return collaboratorList.contains(this.collaborator);
    }

    public void setType(TaskType type) {
        this.type = type;
    }
}

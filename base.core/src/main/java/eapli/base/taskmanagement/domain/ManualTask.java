package eapli.base.taskmanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.ordermanagement.domain.Attribute;
import eapli.framework.domain.model.DomainEntity;

import eapli.framework.time.util.Calendars;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class ManualTask extends Task implements DomainEntity<Long> {


    private TaskType type;

    @OneToOne
    private ClientUser collaborator;

    @OneToMany
    private Set<Attribute> commentaryList;

    @OneToMany
    private Set<Attribute> decisionList;

    public ManualTask() {

    }


    public ManualTask(TaskType type,TaskState state, Deadline deadline, Integer priority,
                      ClientUser collaborator,
                      Set<Attribute> decisionList,
                      Set<Attribute> commentaryList) {

        super(state, deadline, priority);

        try {
            if (Calendars.now().compareTo(deadline.Date()) == 1) {
                throw new IllegalArgumentException("Invalid DeadLine!");
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Invalid DeadLine: " + e);
        }
        this.collaborator = collaborator;
        this.type = type;
        this.decisionList = decisionList;
        this.commentaryList = commentaryList;
    }

    public boolean verifyCommentaryToManualTask(Attribute commentary){
       for (Attribute a : commentaryList){
           if(a.description().equals(commentary)){
               return true;
           }
       }
       return false;
    }

    public boolean verifyDecisionToManualTask(Attribute decision){
        for (Attribute a : decisionList){
            if(a.description().equals(decision)){
                return true;
            }
        }
        return false;
    }

    public boolean addDecisionToManualTask(Attribute decision){
        return decisionList.add(decision);
    }

    public boolean addCommentaryToManualTask(Attribute commentary){
        return commentaryList.add(commentary);
    }

    public boolean isCollabValid (List<ClientUser> collaboratorList,ClientUser clientUser){
        return collaboratorList.contains(clientUser);
    }

}

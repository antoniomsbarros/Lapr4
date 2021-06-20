package eapli.base.taskmanagement.domain;

import eapli.base.catalogmanagement.domain.Responsable;
import eapli.base.ordermanagement.domain.Form;
import eapli.framework.domain.model.DomainEntity;

import eapli.framework.general.domain.model.Description;
import eapli.framework.time.util.Calendars;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class ManualTask extends Task {

    @Enumerated(EnumType.STRING)
    private TaskType type;

    @OneToOne(cascade = CascadeType.ALL)
    private Responsable collaborator;
    @AttributeOverride(name = "value", column = @Column(name = "commentary"))
    private Description commentary;
    @AttributeOverride(name = "value", column = @Column(name = "decision"))
    private Description decision;
    @OneToOne
    private Form form;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Executor> listExecutors= new ArrayList<>();

    @ElementCollection
    private List<Answer> lstResposta;

    public ManualTask() {

    }


    public ManualTask(TaskState state, Deadline deadline, Integer priority,
                      TaskType type,
                      Responsable collaborator,
                      Description decision,
                      Description commentary, Form form, List<Answer> lstResposta) {
        super(state, deadline, priority);
        try {
            if (Calendars.now().compareTo(deadline.Date()) > 0) {
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
        this.form = form;
        this.lstResposta = lstResposta;
        this.listExecutors = new ArrayList<>();
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public Responsable Responsible() {
        return collaborator;
    }

    public List<Executor> executorsList() {
        return listExecutors;
    }

    public Form Form(){return form;}

    public String decison(){
        return  this.decision.toString();
    }

    public TaskType type(){
        return type;
    }

    @Override
    public String toString() {
        return "ManualTask{" +
                "id=" +identity()+
                ", type=" + type +
                ", collaborator=" + collaborator +
                ", commentary=" + commentary +
                ", decision=" + decision +
                ", form=" + form +
                '}';
    }
}

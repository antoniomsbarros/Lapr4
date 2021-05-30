package eapli.base.ordermanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.domain.model.DomainFactory;

import java.util.Calendar;

public class DraftBuilder implements DomainFactory<Draft> {

    private String file;
    private Calendar deadline;
    private ClientUser collaborator;
    private Number urgency;
    private String assigned;


    public DraftBuilder(String file, Calendar deadline, ClientUser collaborator, Number urgency, String assigned) {
        this.file = file;
        this.deadline = deadline;
        this.collaborator = collaborator;
        this.urgency = urgency;
        this.assigned = assigned;
    }

    public DraftBuilder withFile(String file){
        this.file = file;
        return this;
    }

    public DraftBuilder withDeadLine(Calendar deadline){
        this.deadline = deadline;
        return this;
    }

    public DraftBuilder withCollaborator(ClientUser collaborator){
        this.collaborator = collaborator;
        return this;
    }

    public DraftBuilder withUrgency(Number urgency){
        this.urgency = urgency;
        return this;
    }

    public DraftBuilder withAssigned(String assigned){
        this.assigned = assigned;
        return this;
    }

    @Override
    public Draft build() {
        return new Draft(collaborator,assigned,file,deadline,urgency);
    }
}
package eapli.base.teamManagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.teamManagement.dto.TeamDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Team implements AggregateRoot<Uniquecode>{


    @EmbeddedId
    private Uniquecode uniquecode;
    @Version
    private Long version;

    private Designation designationTeam;

    private Acronym teamAcronym;

    @OneToOne(optional = false)
    private  TeamType teamType;
    @OneToMany()
    private Set<ClientUser> collaboratorList;
    @OneToOne()
    private ClientUser responsable;

    @Column(nullable = false)
    private boolean active;

    public Team() {
    }

    public Team(final Uniquecode uniquecode,final ClientUser responsable,final Set<ClientUser> collaboratorList,
                final Designation designacaoEquipa,final Acronym acronimoEquipa,final TeamType teamType) {

        Preconditions.noneNull(designacaoEquipa,collaboratorList,teamType, responsable,uniquecode.Code());
        if (designacaoEquipa.length()>50){
            throw new IllegalArgumentException("The designaction of the team cant passed the size of 50 caracteres");
        }
        this.designationTeam = designacaoEquipa;
        this.teamAcronym = acronimoEquipa;
        this.teamType=teamType;
        this.collaboratorList=collaboratorList;
        this.responsable=responsable;
        this.uniquecode=uniquecode;
        active = true;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Team)){
            return false;
        }
        final  Team temp= (Team) other;
        if (this==temp){
            return  true;
        }
        return identity().equals(temp.identity()) && designationTeam.equals(temp.designationTeam)
                && teamAcronym.equals(temp.teamAcronym);
    }

    @Override
    public Uniquecode identity() {
        return uniquecode;
    }

    @Override
    public String toString() {
        return "Team{" +
                "uniquecode=" + uniquecode +
                ", version=" + version +
                ", designationTeam=" + designationTeam +
                ", teamAcronym=" + teamAcronym +
                ", teamType=" + teamType +
                ", collaboratorList=" + collaboratorList +
                ", responsable=" + responsable +
                '}';
    }

    public  String teamAcronym(){
        return  teamAcronym.toString();
    }
    public  String designationTeam(){
        return designationTeam.toString();
    }
    public  ClientUser clientUser() {return responsable;}
    public  TeamType teamType(){
        return  teamType;
    }

    public TeamDTO toDTO(){
        return new TeamDTO(uniquecode.Code(), designationTeam.toString(), teamAcronym.AcronymName());
    }

    public boolean isActive() {
        return active;
    }

    public boolean exist (ClientUser clientUser){ return collaboratorList.contains(clientUser); }


    public Set<ClientUser> collaboratorList() { return collaboratorList;    }
}

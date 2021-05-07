package eapli.base.teamManagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team implements AggregateRoot<Long>{

    @Id
    @GeneratedValue
    private Uniquecode uniquecode;
    @Version
    private Long version;
    private Designation designationTeam;

    private Acronym teamAcronym;

    @OneToOne(optional = false)
    private  TeamType teamType;
    @OneToMany()
    private List<ClientUser> collaboratorList;
    @OneToOne()
    private ClientUser responsable;
    public Team() {
    }

    public Team(final ClientUser responsable,final List<ClientUser> collaboratorList,final Uniquecode codigoUnico,final Designation designacaoEquipa,final Acronym acronimoEquipa,final TeamType teamType) {
        Preconditions.noneNull(designacaoEquipa,collaboratorList,teamType, responsable);
        this.uniquecode = codigoUnico;
        this.designationTeam = designacaoEquipa;
        this.teamAcronym = acronimoEquipa;
        this.teamType=teamType;
        this.collaboratorList=collaboratorList;
        this.responsable=responsable;
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
    public Long identity() {
        return Long.valueOf(uniquecode.toString());
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
    public  TeamType teamType(){
        return  teamType;
    }
}

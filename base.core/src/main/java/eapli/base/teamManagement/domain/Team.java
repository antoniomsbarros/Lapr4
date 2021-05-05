package eapli.base.teamManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
public class Team implements AggregateRoot<Long>{

    @Id
    private Uniquecode uniquecode;

    private Designation designationTeam;

    private Acronym teamAcronym;

    @OneToOne(optional = false)
    private  TeamType teamType;


    public Team() {
    }

    public Team(final Uniquecode codigoUnico,final Designation designacaoEquipa,final Acronym acronimoEquipa,final TeamType teamType) {
        Preconditions.noneNull(designacaoEquipa);
        this.uniquecode = codigoUnico;
        this.designationTeam = designacaoEquipa;
        this.teamAcronym = acronimoEquipa;
        this.teamType=teamType;
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
        return "uniquecode=" + uniquecode.toString() + ", designationTeam=" + designationTeam.toString() + ", teamAcronym=" + teamAcronym.toString();
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

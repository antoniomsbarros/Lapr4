package eapli.base.teamManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
public class TeamType implements AggregateRoot<Uniquecode> {

    @EmbeddedId
    private Uniquecode singleInternalcode;
    @Version
    private Long version;
    @AttributeOverride(name = "value", column = @Column(name = "descriptionTypeTeam"))
    private Description descriptionTypeTeam;

    @AttributeOverride(name = "value", column = @Column(name = "color"))
    private Description color;


    public TeamType() {
    }

    public TeamType(final Uniquecode codigoUnicoInterno, final Description descricaoTipoEquipa,final Description cor) {
        Preconditions.noneNull(codigoUnicoInterno, descricaoTipoEquipa, cor);
        if (descricaoTipoEquipa.length()>50){
            throw new IllegalArgumentException("The description of the team can't over size 50 characters");
        }
        this.singleInternalcode = codigoUnicoInterno;
        this.descriptionTypeTeam = descricaoTipoEquipa;
        this.color=cor;
    }

    @Override
    public boolean sameAs(Object other) {
        if(!(other instanceof TeamType)){
            return false;
        }
        final TeamType temp=(TeamType) other;
        if (this== temp){
            return true;
        }
        return  identity().equals(temp.identity()) && descriptionTypeTeam.equals(temp.descriptionTypeTeam)
                && color.equals(temp.color);
    }

    @Override
    public Uniquecode identity() {
        return singleInternalcode;
    }
    public  Description cor(){
        return  color;
    }
    public  Description descricaoTipoEquipa(){
        return  descriptionTypeTeam;
    }

    public TeamType teamtype () { return this;}

    @Override
    public String toString() {
        return "codigoUnicoInterno=" + singleInternalcode.toString() +
                ", descricaoTipoEquipa=" + descriptionTypeTeam.toString() +
                ", cor=" + color.toString();
    }
}

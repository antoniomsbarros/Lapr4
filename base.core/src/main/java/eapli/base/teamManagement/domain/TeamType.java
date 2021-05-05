package eapli.base.teamManagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
public class TeamType implements AggregateRoot<Long> {

    @Id
    private Uniquecode singleInternalcode;

    @AttributeOverride(name = "value", column = @Column(name = "descriptionTypeTeam"))
    private Description descriptionTypeTeam;

    @AttributeOverride(name = "value", column = @Column(name = "color"))
    private Description color;

    public TeamType() {
    }

    public TeamType(final Uniquecode codigoUnicoInterno, final Description descricaoTipoEquipa,final Description cor) {
        Preconditions.noneNull(codigoUnicoInterno, descricaoTipoEquipa, cor);
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
    public Long identity() {
        return Long.getLong(singleInternalcode.toString());
    }
    public  Description cor(){
        return  color;
    }
    public  Description descricaoTipoEquipa(){
        return  descriptionTypeTeam;
    }

    @Override
    public String toString() {
        return "codigoUnicoInterno=" + singleInternalcode.toString() +
                ", descricaoTipoEquipa=" + descriptionTypeTeam.toString() +
                ", cor=" + color.toString();
    }
}

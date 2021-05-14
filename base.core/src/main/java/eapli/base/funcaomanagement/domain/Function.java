package eapli.base.funcaomanagement.domain;

import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
public class Function implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long functioncode;

    @Version
    private Long version;

    @AttributeOverride(name = "value", column = @Column(name = "name"))
    private Designation functionname;

    @AttributeOverride(name = "value", column = @Column(name = "description"))
    private Description  descriptionFunction;

    @Column(nullable = false)
    private boolean active;

    public Function() {
    }

    public Function(final Designation nomeFuncao,final Description descricaoFuncao) {
        Preconditions.noneNull(nomeFuncao, descricaoFuncao);
        this.functionname = nomeFuncao;
        if (descricaoFuncao.length()> 50){
        throw new IllegalArgumentException("Function description's can't over size 50 characters");
        }
        this.descriptionFunction=descricaoFuncao;
        active = true;
    }


    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Long)){
            return  false;
        }
        Long tempother= (Long) other;
        return identity().equals(tempother);
    }

    @Override
    public Long identity() {
        return functioncode;
    }

    @Override
    public String toString() {
        return "codigoFuncao=" + functioncode.toString() + ", nomeFuncao='" + functionname.toString() + ", descricaoFuncao='" + descriptionFunction.toString()+'\n';
    }

    public Designation Name() {
        return functionname;
    }

    public Description Description() {
        return descriptionFunction;
    }

    public boolean isActive() {
        return active;
    }
}

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
    private Uniquecode functioncode;
    @Version
    private Long version;
    private Designation functionname;

    private Description  descriptionFunction;


    public Function() {
    }

    public Function(final Designation nomeFuncao,final Description descricaoFuncao) {
        Preconditions.noneNull(nomeFuncao, descricaoFuncao);
        this.functionname = nomeFuncao;
        this.descriptionFunction=descricaoFuncao;
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
        return Long.valueOf(functioncode.toString());
    }

    @Override
    public String toString() {
        return "codigoFuncao=" + functioncode.toString() + ", nomeFuncao='" + functionname.toString() + ", descricaoFuncao='" + descriptionFunction.toString()+'\n';
    }
}

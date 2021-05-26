package eapli.base.funcaomanagement.dto;

import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;

/**
 *
 * @author marly
 */
public class FunctionDTO {

    public Long functioncode;
    public String functionname;
    public String descriptionFunction;

    public FunctionDTO(Long code, String nomeFuncao, String descricaoFuncao) {
        this.functioncode = code;
        this.functionname= nomeFuncao;
        this.descriptionFunction = descricaoFuncao;
    }
}

package eapli.base.funcaomanagement.dto;

import java.util.Calendar;

/**
 *
 * @author marly
 */
public class FunctionDTO {

    public Long functioncode;
    public String designation;
    public String description;

    public FunctionDTO(){}

    public FunctionDTO(Long functioncode,  String designation, String description){

        this.functioncode = functioncode;
        this.designation = designation;
        this.description = description;
    }
}

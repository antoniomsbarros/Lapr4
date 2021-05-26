package eapli.base.teamManagement.dto;

import eapli.framework.representations.dto.DTO;

@DTO
public class TeamDTO {

    public TeamDTO (final String uniquecode,final String designationTeam, final String teamAcronym){
        this.designationTeam=designationTeam;
        this.uniquecode=uniquecode;
        this.teamAcronym=teamAcronym;
    }
    public void TeamDTOEmpty() {

    }

    public String  uniquecode;
    public String designationTeam;
    public  String teamAcronym;
}

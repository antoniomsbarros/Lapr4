package eapli.base.teamManagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import java.util.HashSet;
import java.util.Set;

public class TeamBuilder implements DomainFactory<Team> {
    private Uniquecode uniquecode;
    private Designation designationTeam;
    private  Acronym teamAcronym;
    private TeamType teamType;
    private Set<ClientUser> collaboratorList;
    private ClientUser responsable;

    public TeamBuilder withUniqueCode(String uniqueCode){
        this.uniquecode= Uniquecode.valueOf(uniqueCode);
        return this;
    }
    public TeamBuilder withDesignationTeam(String designationTeam){
        this.designationTeam=Designation.valueOf(designationTeam);
        return this;
    }
    public TeamBuilder withteamAcronym(String teamAcronym){
        this.teamAcronym=Acronym.valueOf(teamAcronym);
        return this;
    }
    public TeamBuilder withTeamType(TeamType teamType){
        this.teamType=teamType;
        return this;
    }
    public TeamBuilder withCollaboratorList(Set<ClientUser> collaboratorList){
        this.collaboratorList=collaboratorList;
        return this;
    }
    public TeamBuilder withResponsable(ClientUser responsable){
        this.responsable=responsable;
        return this;
    }


    @Override
    public Team build() {
        return new Team(uniquecode, responsable, collaboratorList, designationTeam, teamAcronym, teamType);
    }
}

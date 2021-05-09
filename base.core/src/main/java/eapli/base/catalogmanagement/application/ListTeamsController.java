package eapli.base.catalogmanagement.application;

import eapli.base.teamManagement.domain.Team;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class ListTeamsController {

    private final ListTeamsService lts = new ListTeamsService();

    public Iterable<Team> allTeams() {
        return this.lts.allTeams();
    }
}

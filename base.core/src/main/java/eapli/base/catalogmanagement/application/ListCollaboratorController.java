package eapli.base.catalogmanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;

public class ListCollaboratorController {

    private final ListCollaboratorService lcs = new ListCollaboratorService();

    public Iterable<ClientUser> allCollaborators(){
        return this.lcs.allCollaborators();
    }
}

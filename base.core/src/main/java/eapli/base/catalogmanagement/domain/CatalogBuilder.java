package eapli.base.catalogmanagement.domain;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;
//import sun.security.krb5.internal.crypto.Des;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogBuilder implements DomainFactory<Catalog> {

    private Description title;
    private Description shortdescription;
    private Description longdescription;
    private Description icone;
    private List<Team> team;
    private ClientUser responsibleCollaborator;


    public CatalogBuilder (final Description title, final Description shortdescription,
                           final Description longdescription, final Description icone, final List<Team> team,
                           final ClientUser responsibleCollaborator){

        this.title = title;
        this.shortdescription = shortdescription;
        this.longdescription = longdescription;
        this.icone = icone;
        this.team = team;
        this.responsibleCollaborator = responsibleCollaborator;
    }

    public CatalogBuilder withTittle(Description title){
        this.title = title;
        return this;
    }

    public CatalogBuilder withShortDescription(Description shortdescription){
        this.shortdescription = shortdescription;
        return this;
    }

    public CatalogBuilder withLongDescription(Description longdescription){
        this.longdescription = longdescription;
        return this;
    }

    public CatalogBuilder withIcone(Description icone){
        this.icone = icone;
        return this;
    }

    public CatalogBuilder withTeam(List<Team> team){
        this.team = team;
        return this;
    }

    public CatalogBuilder withResponsibleCollaborator(ClientUser responsibleCollaborator){
        this.responsibleCollaborator = responsibleCollaborator;
        return this;
    }

    @Override
    public Catalog build() {
        return new Catalog(title, shortdescription, longdescription,icone,team, responsibleCollaborator, new Criticalitylevel());
    }
}

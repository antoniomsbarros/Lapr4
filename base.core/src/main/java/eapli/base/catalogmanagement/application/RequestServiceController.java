package eapli.base.catalogmanagement.application;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.CollaboratorEmail;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.*;
import eapli.base.ordermanagement.repository.DraftRepository;
import eapli.base.ordermanagement.repository.RequestRepository;
import eapli.base.teamManagement.domain.Team;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


import java.util.*;

public class RequestServiceController {

    private final AuthorizationService authz;
    private final ClientUserRepository ct;
    private final CatalogRepository cr;
    private final ServiceRepository sr;
    private final DraftRepository dr;
    private final RequestRepository rr;

    public RequestServiceController() {
        this.authz= AuthzRegistry.authorizationService();
        this.ct = PersistenceContext.repositories().clientUsers();
        this.cr =PersistenceContext.repositories().catalogs();
        this.sr= PersistenceContext.repositories().services();
        this.dr = PersistenceContext.repositories().drafts();
        this.rr = PersistenceContext.repositories().requests();
    }

    public Set<Service> SearchService(){
        CollaboratorEmail email = new CollaboratorEmail(authz.session().get().authenticatedUser().email().toString());
        ClientUser user = ct.getClientUserByEmail(email).get();
        List<Team> teams = user.listOfTeams();
        Set<Catalog> catalogs = new HashSet<>();
        Set<Service> services = new HashSet<>();

        for(Team tm : teams){
            while(cr.findByTeams(tm).iterator().hasNext()){
                catalogs.add(cr.findByTeams(tm).iterator().next());
            }
        }

        for(Catalog catalog : catalogs){
            while(sr.findByCatalog(catalog).iterator().hasNext()){
                services.add(sr.findByCatalog(catalog).iterator().next());
            }
        }

        return services;
    }

    public Service getService(Long code){
        return sr.findByID(code).get();
    }

    public Draft creatDraft(final ClientUser clientUser,final String assigned,final String filepath,final Calendar deadline,final Long urgency){
        final DraftBuilder draftBuilder = new DraftBuilder(filepath,deadline,clientUser,urgency,assigned);
        draftBuilder.withFile(filepath).withDeadLine(deadline).withCollaborator(clientUser).withUrgency(urgency).withAssigned(assigned);
        return dr.save(draftBuilder.build());
    }

    public Request creatRequest(final Workflow workflow, final State stateofResquest,final Calendar dateofRequest,final Feedback feedback,final Draft draft,final Form form){
        final RequestBuilder requestBuilder = new RequestBuilder(stateofResquest,dateofRequest,feedback,workflow,draft,form);
        requestBuilder.withState(stateofResquest).withDate(dateofRequest).withFeedback(feedback).withWorkflow(workflow).withDraft(draft).withForm(form);
        return rr.save(requestBuilder.build());
    }

    public Feedback creatFeedback(final Long feedbackScale,final Calendar date){
        return new Feedback(feedbackScale,date);
    }
}

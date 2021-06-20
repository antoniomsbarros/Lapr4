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
import eapli.base.ordermanagement.repository.TicketRepository;
import eapli.base.taskmanagement.domain.Answer;
import eapli.base.teamManagement.domain.Team;
import eapli.base.teamManagement.repositories.TeamRepository;
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
    private final TicketRepository tr;
    private final TeamRepository teamr;

    public RequestServiceController() {
        this.authz= AuthzRegistry.authorizationService();
        this.ct = PersistenceContext.repositories().clientUsers();
        this.cr =PersistenceContext.repositories().catalogs();
        this.sr= PersistenceContext.repositories().services();
        this.dr = PersistenceContext.repositories().drafts();
        this.rr = PersistenceContext.repositories().requests();
        this.tr = PersistenceContext.repositories().ticket();
        this.teamr = PersistenceContext.repositories().team();
    }

    public Set<Service> SearchService(){
        CollaboratorEmail email = new CollaboratorEmail(authz.session().get().authenticatedUser().email().toString());
        ClientUser user = ct.getClientUserByEmail(email).get();
        Iterable<Team> teams = teamr.collaboratorTeams(user.mecanographicNumber());

        Set<Service> services = new HashSet<>();

        ArrayList<Catalog> cata1 = new ArrayList<>();

        for(Team t: teams){
            Iterable<Catalog> iC = cr.findByTeams(t);
            for(Catalog c : iC) {
                cata1.add(c);
            }
        }

        for(Catalog ct : cata1){
            Iterable<Service> iS = sr.findByCatalog(ct);
            for(Service s : iS){
                services.add(s);
            }
        }

        for(Service s : services){
            System.out.println(s);
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

    public Feedback creatFeedback(final Long feedbackScale){
        return new Feedback(feedbackScale);
    }

    public Request creatRequest(final Workflow workflow, final State stateofResquest,final Calendar dateofRequest,final Feedback feedback,final Draft draft,final Form form, Answer lstAn){
        RequestBuilder requestBuilder = new RequestBuilder();
        if (feedback.equals(new Feedback())){
            requestBuilder.withState(stateofResquest).withDate(dateofRequest).withWorkflow(workflow).withDraft(draft).withForm(form).withListAnswers(lstAn);

        } else {
            requestBuilder.withState(stateofResquest).withDate(dateofRequest).withFeedback(feedback).withWorkflow(workflow).withDraft(draft).withForm(form).withListAnswers(lstAn);
        }
        return rr.save(requestBuilder.build());
    }

    public Ticket createTicket(Service service ,Integer priorityTicket, Request request) {
        Ticket ticket = new Ticket(service, priorityTicket, request);
        return tr.save(ticket);
    }

    public Form getFormToAnswer(Service s){
        return s.form().get(0);
    }

}

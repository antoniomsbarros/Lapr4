package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.RequestServiceController;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.CollaboratorEmail;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.*;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import java.util.Calendar;
import java.util.Set;

public class RequestServiceUI extends AbstractUI {

    RequestServiceController controller = new RequestServiceController();
    private final AuthorizationService authz;
    private final ClientUserRepository ct;

    public RequestServiceUI() {
        this.authz= AuthzRegistry.authorizationService();
        this.ct = PersistenceContext.repositories().clientUsers();
    }

    @Override
    protected boolean doShow() {

        Set<Service> listServico = controller.SearchService();

        for(Service sv : listServico){
            System.out.println(sv.print());
        }

        Long option = Long.valueOf(Console.readLine("Select the code of the Service: "));

        Service servico = controller.getService(option);

        String option2 = String.valueOf(Console.readLine("Do you want to do a Draft or a Request?:"));

        if(option2.equals("Draft") || option2.equals("draft")){
            CollaboratorEmail email = new CollaboratorEmail(authz.session().get().authenticatedUser().email().toString());
            ClientUser user = ct.getClientUserByEmail(email).get();
            final String assigned = String.valueOf(Console.readLine("Assigned to:"));
            final String filepath = String.valueOf(Console.readLine("File path:"));
            final Calendar deadline = Calendar.getInstance();
            final String urgency = String.valueOf(Console.readLine("Urgency:"));
            final Number urgency2 = Integer.parseInt(urgency);

            controller.creatDraft(user,assigned,filepath,deadline,urgency2);
            return true;
        }

        if(option2.equals("Request") || option2.equals("request")){
            CollaboratorEmail email = new CollaboratorEmail(authz.session().get().authenticatedUser().email().toString());
            ClientUser user = ct.getClientUserByEmail(email).get();
            final String assigned = String.valueOf(Console.readLine("Assigned to:"));
            final String filepath = String.valueOf(Console.readLine("File path:"));
            final Calendar deadline = Calendar.getInstance();
            final String urgency = String.valueOf(Console.readLine("Urgency:"));
            final Number urgency2 = Integer.parseInt(urgency);

            final Draft draft = controller.creatDraft(user,assigned,filepath,deadline,urgency2);

            final Workflow workflow = servico.workflow();
            final State state = State.SUBMETIDO;
            final Calendar dateRequest = Calendar.getInstance();
            final Long feedbackScale = Console.readLong("Feedback Scale (1-5)");

            final Calendar date = Calendar.getInstance();

            final  Feedback feedback = controller.creatFeedback(feedbackScale,date);

            final Form form = new Form();

            controller.creatRequest(workflow,state,dateRequest,feedback,draft,form);
            return true;
        }


        return false;
    }

    @Override
    public String headline() {
        return "Request a Service";
    }
}

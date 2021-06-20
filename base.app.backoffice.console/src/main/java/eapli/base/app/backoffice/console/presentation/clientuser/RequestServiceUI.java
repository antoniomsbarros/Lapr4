package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.DashboardManagement.TcpClient;
import eapli.base.catalogmanagement.application.RequestServiceController;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.domain.Service;
import eapli.base.catalogmanagement.domain.Workflow;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.CollaboratorEmail;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.*;
import eapli.base.taskmanagement.domain.Answer;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

        System.out.println(servico);

        String option2 = String.valueOf(Console.readLine("Do you want to do a Draft or a Request?:"));

        if(option2.equals("Draft") || option2.equals("draft")){
            CollaboratorEmail email = new CollaboratorEmail(authz.session().get().authenticatedUser().email().toString());
            ClientUser user = ct.getClientUserByEmail(email).get();
            final String assigned = String.valueOf(Console.readLine("Assigned to:"));
            final String filepath = String.valueOf(Console.readLine("File path:"));
            final Calendar deadline = Calendar.getInstance();
            final String urgency = String.valueOf(Console.readLine("Urgency:"));
            final Long urgency2 = Long.valueOf(urgency);

            controller.creatDraft(user,assigned,filepath,deadline,urgency2);
            return true;
        }

        if(option2.equals("Request") || option2.equals("request")){
            CollaboratorEmail email = new CollaboratorEmail(authz.session().get().authenticatedUser().email().toString());
            System.out.println(email);
            Feedback feedback = new Feedback();
            ClientUser user = ct.getClientUserByEmail(email).get();
            System.out.println(user);
            final String assigned = String.valueOf(Console.readLine("Assigned to:"));
            final String filepath = String.valueOf(Console.readLine("File path:"));
            final Calendar deadline = Calendar.getInstance();
            final String urgency = String.valueOf(Console.readLine("Urgency:"));
            final Long urgency2 = Long.valueOf(urgency);

            final Draft draft = controller.creatDraft(user,assigned,filepath,deadline,urgency2);

            final Workflow workflow = new Workflow();
            final State state = State.SUBMETIDO;
            final Calendar dateRequest = Calendar.getInstance();
            if(needFeedback(servico)) {
                final Long feedbackScale = Console.readLong("Feedback Scale (1-5)");
                feedback = controller.creatFeedback(feedbackScale);
            }

            final Form form = controller.getFormToAnswer(servico);
            Answer lstAnswers = answerForm(form);
            List<String> listAnswer = new ArrayList<>();

            for (String resp: lstAnswers.getResposta()){
                listAnswer.add(resp);
            }
            Request request = controller.creatRequest(state,dateRequest,feedback,draft,form,listAnswer);

            for(String s: lstAnswers.getResposta()){
                System.out.println(s);
            }
            final Integer ticketPriority = Integer.valueOf(Console.readLine("Ticket priority:"));
            controller.createTicket(servico,ticketPriority,request);
            try {
                TcpClient.tcpConnecting(6, String.valueOf(request.identity()),"10.9.21.107" );
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }


        return false;
    }

    private Answer answerForm(Form form) {
        Answer lstAnswer= new Answer();
        String a;
        for (Attribute at : form.attribute()) {
            System.out.println(at.name() + "(" + at.typeofData().toString() + "):");
            String resp = Console.readLine("Answer the attribute");
           // lstAnswer = new Answer();
            lstAnswer.addResposta(resp);
        }
        return lstAnswer;
    }

    private boolean needFeedback(Service s) {
        if(s.requirefeedback().equals("y")) {
            return true;
        }
        return false;
    }

    @Override
    public String headline() {
        return "Request a Service";
    }
}

package TCPSERVER;

import eapli.base.DashboardManagement.TcpClient;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.application.SearchAutomaticTask;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

public class main {

    public static void main(String args[]) throws Exception {
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());


        FirstComeFirstServedAlgoritm firstComeFirstServedAlgoritm=new FirstComeFirstServedAlgoritm();
        SearchAutomaticTask searchAutomaticTask=new SearchAutomaticTask();
        firstComeFirstServedAlgoritm.firstComeFirstServerd(searchAutomaticTask.findAll());


    }
}

package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.Dashboardmanagement.TCPSrvMFA;
import eapli.framework.presentation.console.AbstractUI;

public class DashboardUI extends AbstractUI {
    private TCPSrvMFA tcpSrvMFA;

    public DashboardUI(){
        try {
            String[] temp=new String[1];
            TCPSrvMFA.main(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected boolean doShow() {
        return false;
    }

    @Override
    public String headline() {
        return null;
    }


}

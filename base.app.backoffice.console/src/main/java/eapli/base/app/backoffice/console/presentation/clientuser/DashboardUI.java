package eapli.base.app.backoffice.console.presentation.clientuser;


import eapli.framework.presentation.console.AbstractUI;

public class DashboardUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        return false;
    }

    @Override
    public String headline() {
        return null;
    }
    /*private TCPSrvMFA tcpSrvMFA;

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

*/
}

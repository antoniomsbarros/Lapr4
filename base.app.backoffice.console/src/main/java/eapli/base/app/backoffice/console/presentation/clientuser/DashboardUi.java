package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.DashboardManagement.HTTPCLientDashboard;
import eapli.base.clientusermanagement.application.SearchCollaboratorController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.presentation.console.AbstractUI;

public class DashboardUi extends AbstractUI {
        private final AuthorizationService authz = AuthzRegistry.authorizationService();
        private SearchCollaboratorController controller=new SearchCollaboratorController();
        @Override
        protected boolean doShow() {
                Username username=authz.session().get().authenticatedUser().identity();

                String[] strings=new String[1];
                strings[0]=controller.getCollaboratorbyUsername(username.toString()).identity().toString();
                try {
                        HTTPCLientDashboard.main(strings);
                        return true;
                } catch (Exception e) {
                        e.printStackTrace();
                }
return false;
        }

        @Override
        public String headline() {
                return "Dashboard";
        }
}

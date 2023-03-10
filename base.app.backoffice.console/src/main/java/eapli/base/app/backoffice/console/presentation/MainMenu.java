/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.AutomaticTaskExecution.AutomaticTaskExecutionAction;
import eapli.base.app.backoffice.console.presentation.ManualTask.DoManualTaskPendingAction;
import eapli.base.app.backoffice.console.presentation.ManualTask.SearchManualTaskToClaimAction;
import eapli.base.app.backoffice.console.presentation.clientuser.*;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // COLLABORATORS
    private static final int SPECIFY_COLLABORATOR_OPTION = 1;
    private static final int ASSOCIATE_REMOVE_COLLABORATOR_TEAM_OPTION = 2;

    //TEAM TYPE
    private static final int CREATE_TEAM_TYPE_OPTION = 1;

    // SETTINGS
    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;


    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 3;
    private static final int COLLABORATOR_OPTION = 4;
    private static final int CATALOG_OPTION = 5;
    private static final int REQUESTSERVICE_OPTION = 6;
    private static final int DASHBOARD=10;
    // HEAD
    private static final int SERVICE_OPTION = 6;
    private static final int CRITICALITYLEVEL_OPTION = 7;

    private static final int TEAM_OPTION=8;
    private static final int TEAM_TYPE_OPTION = 9;
    private static final int MANUALTASK_OPTION = 15;
    private static final int AUTOMATICTASK_OPTION = 16;

    //CATALOG
    private static final int CREATE_CATALOG_OPTION = 1;
    private static final int SEARCH_CATALOGBYTITLE_OPTION = 2;
    private static final int SEARCH_CATALOGBYSHORT_OPTION = 3;
    private static final int SEARCH_CATALOGBYLONG_OPTION = 4;
    private static final int LIST_CATALOG_OPTION = 5;


    private static final int CREATE_CRITICALITYLEVEL_OPTION = 14;
    private static final  int CREATE_TEAM_OPTIOM= 13;
    private static final int CREATE_SERVICE_OPTION= 11;

    //DASHBOARD
    private static final int DASHBOARD1=1;
    private static final String SEPARATOR_LABEL = "--------------";

    //MANUAL TASK
    private static final int CREATE_MANUALTASK_OPTION = 1;
    private static final int SEARCH_MANUALTASK_OPTION = 2;
    private static final int DO_MANUALTASK_PENDING_OPTION = 3;

    //AUTOMATIC TASK
    private static final int EXECUTE_AUTOMATICTASK_OPTION = 1;

    //REQUEST SERVICE
    private static final int REQUEST_A_SERVICE_OPTION= 1;
    private static final int SHOWPENDENTREQUEST_OPTION = 2;


    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
            final Menu collaboratorMenu = builderCollaboratorMenu();
            mainMenu.addSubMenu(COLLABORATOR_OPTION, collaboratorMenu);
            final Menu catalogMenu = builderCatalogMenu();
            mainMenu.addSubMenu(CATALOG_OPTION, catalogMenu);
            final Menu serviceMenu = builderServiceMenu();
            mainMenu.addSubMenu(SERVICE_OPTION, serviceMenu);
            final Menu criticalityMenu = builderCriticalitylevelMenu();
            mainMenu.addSubMenu(CRITICALITYLEVEL_OPTION, criticalityMenu);
            final Menu teamMenu=builderTeamMenu();
            mainMenu.addSubMenu(TEAM_OPTION, teamMenu);
            final Menu criticalitylevelMenu = builderCriticalitylevelMenu();
            mainMenu.addSubMenu(CREATE_CRITICALITYLEVEL_OPTION,criticalitylevelMenu);
            final Menu teamTypeMenu = builderTeamTypeMenu();
            mainMenu.addSubMenu(TEAM_TYPE_OPTION,teamTypeMenu);
            final  Menu dashboard=buildderDashboard();
            mainMenu.addSubMenu(DASHBOARD, dashboard);
            final  Menu automaticTask = builderAutomaticTaskMenu();
            mainMenu.addSubMenu(AUTOMATICTASK_OPTION, automaticTask);
        }
        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.RRH_MANAGER)) {
            final Menu teamTypeMenu = builderTeamTypeMenu();
           mainMenu.addSubMenu(TEAM_TYPE_OPTION,teamTypeMenu);
            final Menu teamMenu=builderTeamMenu();
            mainMenu.addSubMenu(TEAM_OPTION, teamMenu);
            final Menu collaboratorMenu = builderCollaboratorMenu();
            mainMenu.addSubMenu(COLLABORATOR_OPTION, collaboratorMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.GSH_MANAGER)){
            final Menu criticalityMenu = builderCriticalitylevelMenu();
            mainMenu.addSubMenu(CRITICALITYLEVEL_OPTION, criticalityMenu);
            final Menu catalogMenu = builderCatalogMenu();
            mainMenu.addSubMenu(CATALOG_OPTION, catalogMenu);
            final Menu serviceMenu = builderServiceMenu();
            mainMenu.addSubMenu(SERVICE_OPTION, serviceMenu);
        }

        if(authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.COLLABORATOR)){
            final Menu requestServiceMenu = builderRequestServiceMenu();
            mainMenu.addSubMenu(REQUESTSERVICE_OPTION,requestServiceMenu);
            final Menu manualTaskMenu = builderManualTaskMenu();
            mainMenu.addSubMenu(MANUALTASK_OPTION,manualTaskMenu);
            final  Menu dashboard=buildderDashboard();
            mainMenu.addSubMenu(DASHBOARD, dashboard);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu builderCatalogMenu(){
        final Menu menu = new Menu("Catalog >");

        menu.addItem(CREATE_CATALOG_OPTION, "Create Catalog", new CreateCatalogUI()::show);
        menu.addItem(SEARCH_CATALOGBYTITLE_OPTION, "Search Catalog by Title", new SearchByTitleUI()::show);
        menu.addItem(SEARCH_CATALOGBYSHORT_OPTION,"Search Catalog By Short Description", new SearchByShortDescriptionUI()::show);
        menu.addItem(SEARCH_CATALOGBYLONG_OPTION,"Search Catalog By Long Description", new SearchByLongDescriptionUI()::show);
        menu.addItem(LIST_CATALOG_OPTION,"List all Catalogs",new ListAllCatalogsUI()::show);

        return menu;
    }

    private Menu builderRequestServiceMenu(){
        final Menu menu = new Menu("Request Service >");

        menu.addItem(REQUEST_A_SERVICE_OPTION,"Request Service", new RequestServiceUI()::show);
        menu.addItem(SHOWPENDENTREQUEST_OPTION,"Show Pendent Request Service By Date",new SortPendentRequestByHistoryUI()::show);

        return menu;
    }

    private Menu builderTeamMenu() {
        final Menu menu = new Menu("Team >");
        menu.addItem(CREATE_TEAM_OPTIOM, "Create Team", new RegisterTeamUI()::show);
        return menu;
    }

    private Menu builderServiceMenu(){
        final Menu menu = new Menu("Service >");

        menu.addItem(1, "Create Service ", new CreateServiceUI()::show);
        menu.addItem(2, "Continue/Complete Service Draft ", new ContinueServiceDraftUI()::show);

        return menu;
    }


    private Menu builderCriticalitylevelMenu(){
        final Menu menu = new Menu("Criticality Level >");
        menu.addItem(CREATE_CRITICALITYLEVEL_OPTION, "Create Criticality Level", new CreateCriticalityLevelUI()::show);

        return menu;
    }

    private Menu builderCollaboratorMenu(){
        final Menu menu = new Menu("Collaborator >");

        menu.addItem(SPECIFY_COLLABORATOR_OPTION, "Specify Collaborator",
                new SpecifyCollaboratorAction());
        menu.addItem(ASSOCIATE_REMOVE_COLLABORATOR_TEAM_OPTION, "Associate/Remove Collaborator-Team",
                new AssociateRemoveCollaboratorTeamAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu builderManualTaskMenu(){
        final Menu menu = new Menu("Manual Task >");

        menu.addItem(CREATE_MANUALTASK_OPTION,"Create Manual Task",
                new CreateManualTaskUI()::show);
        menu.addItem(SEARCH_MANUALTASK_OPTION, "Search Manual Task To Claim",
                new SearchManualTaskToClaimAction());
        menu.addItem(DO_MANUALTASK_PENDING_OPTION, "Do Manual Task Pending",
                new DoManualTaskPendingAction());

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu builderAutomaticTaskMenu(){
        final Menu menu = new Menu("Automatic Task >");

        menu.addItem(EXECUTE_AUTOMATICTASK_OPTION,"Execute Automatic Task",
                new AutomaticTaskExecutionAction());

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu builderTeamTypeMenu(){
        final Menu menu = new Menu("Team Type >");

        menu.addItem(CREATE_TEAM_TYPE_OPTION, "New Team Type",new CreateTeamTypeAction()::show);

        return menu;
    }
private Menu buildderDashboard()  {
    final Menu menu = new Menu("Dashboard >");
    menu.addItem(DASHBOARD1, "dashboard", new DashboardUi()::show);
    return menu;
}



}

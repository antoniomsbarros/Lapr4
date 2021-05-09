package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;

public class SearchCatalogUI extends AbstractUI {

    private static final int SEARCH_BY_TITLE = 1;

    @Override
    protected boolean doShow() {
        System.out.println("ola");
        final Menu menu = new Menu("Search Catalog<");
        menu.addItem(SEARCH_BY_TITLE, "Search by Title ", new SearchByTitleAction());

        return false;
    }

    @Override
    public String headline() {
        return "Search Catalog";
    }
}

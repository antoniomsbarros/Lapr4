package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.SearchCatalogController;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class SearchByLongDescriptionUI extends AbstractUI {
    SearchCatalogController controller = new SearchCatalogController();

    @Override
    protected boolean doShow() {
        final Description longdescription = Description.valueOf( Console.readLine("Long Description: "));
        Catalog res =controller.searchCatalogByLongDescription(longdescription);
        if(res==null){
            System.out.println("Catalog doesn't exists");
        }else{
            System.out.println(res.toString());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Search Catalog By Long Description";
    }
}

package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.SearchCatalogController;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class SearchByShortDescriptionUI extends AbstractUI {
    SearchCatalogController controller = new SearchCatalogController();

    @Override
    protected boolean doShow() {
        final Description shortdescription = Description.valueOf( Console.readLine("Short Description: "));
        Catalog res =controller.searchCatalogByShortDescription(shortdescription);
        if(res==null){
            System.out.println("Catalog doesn't exists");
        }else{
            System.out.println(res.toString());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Search Catalog By Short Description";
    }

}

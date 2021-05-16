package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.catalogmanagement.application.SearchCatalogController;
import eapli.base.catalogmanagement.domain.Catalog;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListAllCatalogsUI extends AbstractUI {
    SearchCatalogController controller = new SearchCatalogController();


    @Override
    protected boolean doShow() {
        Iterator<Catalog> iterator1 = controller.findAllCatalogs().iterator();
        ArrayList<Catalog> listCatalog = new ArrayList<>();

        while(iterator1.hasNext()){
            Catalog ct = iterator1.next();
            listCatalog.add(ct);
        }

        if(listCatalog.isEmpty()){
            System.out.println("No Catalog found");
        }else{
            System.out.println(listCatalog.toString());
        }
        return false;
    }

    @Override
    public String headline() {
        return "List all Catalogs";
    }
}

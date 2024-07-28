import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItemList;

    Catalog(){
        catalogItemList = new ArrayList<>();
    }

    public List<CatalogItem> getCatalogItemList() {
        return catalogItemList;
    }

    public void addCatalogItem(CatalogItem catalogItem) {
        this.catalogItemList.add(catalogItem);
    }

    public void print(){
        for(CatalogItem item: catalogItemList){
            item.print();
        }
    }
}

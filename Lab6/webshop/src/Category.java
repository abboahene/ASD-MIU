import java.util.ArrayList;
import java.util.List;

public class Category implements CatalogItem{

    private String catId;
    private String name;

    private List<CatalogItem> catalogItemList;

    Category(String catId, String name){
        this.catId = catId;
        this.name = name;
        catalogItemList = new ArrayList<>();
    }

    public void addToCategory(CatalogItem catalogItem){
        catalogItemList.add(catalogItem);
    }

    public void removeFromCategory(CatalogItem catalogItem){
        catalogItemList.removeIf(item -> item.equals(catalogItem));
    }

    @Override
    public void print() {
        System.out.println("----------"+name+"--------");
        for(CatalogItem item: catalogItemList){
            item.print();
        }
        System.out.println("----------"+name+"--------");
    }
}

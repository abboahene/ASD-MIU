public class Main {
    public static void main(String[] args) {
        //create 3 products
        // create two cats
        // add prods to cats
        // call print

        Product product1 = new Product("9032", "Tomato", 4.3, 10);
        Product product2 = new Product("9033", "Foot Ball", 4.3, 10);
        Product product3 = new Product("9034", "Volley Ball", 4.3, 10);

        Category foods = new Category("c3223", "Foods");
        foods.addToCategory(product1);

        Category sports = new Category("c4393", "Sports");
        sports.addToCategory(product2);
        sports.addToCategory(product3);

        Catalog catalog = new Catalog();
        catalog.addCatalogItem(foods);
        catalog.addCatalogItem(sports);

        catalog.print();

    }
}
import java.util.ArrayList;
import java.util.List;

public class Product implements CatalogItem{

    private String productId;
    private String name;
    private double price;
    private int stock;

    public Product(String productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("Product ID: ").append(productId);
        sb.append("\n");
        sb.append("Name: ").append(name);
        sb.append("\n");
        sb.append("Price: ").append(price);
        sb.append("\n");
        sb.append("Stock: ").append(stock);
        sb.append("\n");
        sb.append("}");
        System.out.println(sb);
    }
}

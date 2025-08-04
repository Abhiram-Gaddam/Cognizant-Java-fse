import java.util.HashMap;
import java.util.Map;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

public class InventoryManager {
    Map<Integer, Product> inventory = new HashMap<>();

    //O(1)
    public void add(Product product) {
        inventory.put(product.productId, product);
    }

    //O(1)
    public void update(int productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.quantity = quantity;
            product.price = price;
        }
    }

    //O(1)
    public void delete(int productId) {
        inventory.remove(productId);
    }

    //O(n)
    public void display() {
        for (Product product : inventory.values()) {
            System.out.println(product.productId + " " + product.productName + " " +
                    product.quantity + " " + product.price);
        }
    }

    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();

        inventory.add(new Product(1, "Mouse", 100, 250.0));
        inventory.add(new Product(2, "Keyboard", 150, 500.0));

        inventory.update(1, 90, 240.0);

        inventory.display();

        inventory.delete(2);

        inventory.display();
    }
}

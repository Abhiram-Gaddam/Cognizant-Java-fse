import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(203, "Shoes", "Footwear"),
            new Product(150, "Phone", "Electronics"),
            new Product(309, "T-shirt", "Apparel"),
            new Product(180, "Watch", "Accessories")
        };
        int linearResult = linearSearch(products, 150);
        System.out.println("Linear Search Result Index: " + linearResult);

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        int binaryResult = binarySearch(products, 150);
        System.out.println("Binary Search Result Index: " + binaryResult);
    }

    public static int linearSearch(Product[] products, int productId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == productId) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, int productId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == productId) {
                return mid;
            } else if (products[mid].productId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}
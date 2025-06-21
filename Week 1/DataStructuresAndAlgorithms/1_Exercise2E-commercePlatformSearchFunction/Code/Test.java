
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Socks", "Footwear"));
        products.add(new Product(2, "Mobile", "Electronics"));
        products.add(new Product(3, "Watch", "Accessories"));
        products.add(new Product(4, "Desktop", "Electronics"));

        // Linear Search
        Product res1 = Product.linearSearch(products, "Watch");
        System.out.println("Linear Search Result: " + (res1 == null ? "Not Found" : res1));

        // Binary Search
        Product res2 = Product.binarySearch(products, "Watch");
        System.out.println("Binary Search Result: " + (res2 == null ? "Not Found" : res2));
    }
}

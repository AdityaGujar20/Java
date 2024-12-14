import java.util.*;

// Customer Class to represent customer details and their loyalty points
class Customer {
    private String id; // Unique ID of the customer
    private String name; // Name of the customer
    private int loyaltyPoints; // Loyalty points accumulated by the customer

    // Constructor to initialize a customer
    public Customer(String id, String name, int loyaltyPoints) {
        this.id = id;
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

    // Getters and setters for accessing and modifying customer details
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    // Override toString to display customer information
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}

// Product Class to represent product details and their price
class Product {
    private String id; // Unique ID of the product
    private String name; // Name of the product
    private double price; // Price of the product

    // Constructor to initialize a product
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and setters for accessing and modifying product details
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Override toString to display product information
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

// Order Class to represent an order placed by a customer
class Order {
    private String orderId; // Unique ID of the order
    private String customerId; // ID of the customer who placed the order
    private Date deliveryDate; // Delivery date of the order

    // Constructor to initialize an order
    public Order(String orderId, String customerId, Date deliveryDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.deliveryDate = deliveryDate;
    }

    // Getters and setters for accessing and modifying order details
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    // Override toString to display order information
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}

// Comparator for sorting products by price in ascending order
class ProductPriceComparator implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

// Comparator for sorting customers by loyalty points in descending order
class CustomerLoyaltyComparator implements Comparator<Customer> {
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c2.getLoyaltyPoints(), c1.getLoyaltyPoints());
    }
}

public class AmazonManagementSystem {
    public static void main(String[] args) {
        // Create dynamic lists to store customers, products, and orders
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        // HashMaps for fast retrieval of customers and products by their ID
        HashMap<String, Customer> customerMap = new HashMap<>();
        HashMap<String, Product> productMap = new HashMap<>();

        // HashSet to ensure unique products
        HashSet<Product> uniqueProducts = new HashSet<>();

        // TreeSets for maintaining sorted orders of products and customers
        TreeSet<Product> sortedProducts = new TreeSet<>(new ProductPriceComparator());
        TreeSet<Customer> sortedCustomers = new TreeSet<>(new CustomerLoyaltyComparator());

        // Adding sample customer data
        Customer c1 = new Customer("C001", "Alice", 150);
        Customer c2 = new Customer("C002", "Bob", 200);
        customers.add(c1);
        customers.add(c2);
        customerMap.put(c1.getId(), c1);
        customerMap.put(c2.getId(), c2);
        sortedCustomers.add(c1);
        sortedCustomers.add(c2);

        // Adding sample product data
        Product p1 = new Product("P001", "Laptop", 75000);
        Product p2 = new Product("P002", "Phone", 50000);
        products.add(p1);
        products.add(p2);
        productMap.put(p1.getId(), p1);
        productMap.put(p2.getId(), p2);
        sortedProducts.add(p1);
        sortedProducts.add(p2);
        uniqueProducts.add(p1);
        uniqueProducts.add(p2);

        // Adding sample order data
        Order o1 = new Order("O001", "C001", new Date());
        orders.add(o1);

        // Display sorted products by price
        System.out.println("Sorted Products by Price:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }

        // Display sorted customers by loyalty points
        System.out.println("\nSorted Customers by Loyalty Points:");
        for (Customer customer : sortedCustomers) {
            System.out.println(customer);
        }
    }
}

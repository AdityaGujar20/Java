import java.util.*;

class Customer {
    private String id;
    private String name;
    private int loyaltyPoints;

    public Customer(String id, String name, int loyaltyPoints) {
        this.id = id;
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

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

    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}

class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

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

    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class Order {
    private String orderId;
    private String customerId;
    private Date deliveryDate;

    public Order(String orderId, String customerId, Date deliveryDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.deliveryDate = deliveryDate;
    }

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

    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}

class ProductPriceComparator implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

class CustomerLoyaltyComparator implements Comparator<Customer> {
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c2.getLoyaltyPoints(), c1.getLoyaltyPoints());
    }
}

public class AmazonManagementSystem {
    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        HashMap<String, Customer> customerMap = new HashMap<>();
        HashMap<String, Product> productMap = new HashMap<>();

        HashSet<Product> uniqueProducts = new HashSet<>();

        TreeSet<Product> sortedProducts = new TreeSet<>(new ProductPriceComparator());

        TreeSet<Customer> sortedCustomers = new TreeSet<>(new CustomerLoyaltyComparator());

        Customer c1 = new Customer("C001", "Alice", 150);
        Customer c2 = new Customer("C002", "Bob", 200);
        customers.add(c1);
        customers.add(c2);
        customerMap.put(c1.getId(), c1);
        customerMap.put(c2.getId(), c2);
        sortedCustomers.add(c1);
        sortedCustomers.add(c2);

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

        Order o1 = new Order("O001", "C001", new Date());
        orders.add(o1);

        System.out.println("Sorted Products by Price:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }

        System.out.println("\nSorted Customers by Loyalty Points:");
        for (Customer customer : sortedCustomers) {
            System.out.println(customer);
        }
    }
}

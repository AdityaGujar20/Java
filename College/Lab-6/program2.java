class CounterEmptyException extends Exception {
    public CounterEmptyException(String message) {
        super(message);
    }
}

class CoffeeShop {
    private final String[] counter = new String[3]; 
    private int count = 0; 

    public synchronized void prepareCoffee(String baristaName) throws InterruptedException {
        while (count == counter.length) { 
            System.out.println(baristaName + " is waiting. Counter is full.");
            wait();
        }
        counter[count] = "Coffee from " + baristaName;
        count++;
        System.out.println(baristaName + " prepared coffee. (Counter: " + count + ")");
        notifyAll(); 
    }

    public synchronized String pickUpCoffee(String customerName) throws InterruptedException, CounterEmptyException {
        while (count == 0) { 
            System.out.println(customerName + " is waiting. Counter is empty.");
            wait();
        }
        String coffee = counter[count - 1]; 
        counter[count - 1] = null;
        count--;
        System.out.println(customerName + " picked up coffee. (Counter: " + count + ")");
        notifyAll();
        return coffee;
    }

    public synchronized String sampleCoffee(String reviewerName) throws InterruptedException, CounterEmptyException {
        while (count == 0) {
            System.out.println(reviewerName + " is waiting. Counter is empty.");
            wait();
        }
        String coffee = counter[count - 1];
        counter[count - 1] = null;
        count--;
        System.out.println(reviewerName + " sampled coffee. (Counter: " + count + ")");
        notifyAll();
        return coffee;
    }
}

class Barista extends Thread {
    private final CoffeeShop coffeeShop;
    private final String name;
    private final int coffeesToPrepare;

    public Barista(CoffeeShop coffeeShop, String name, int coffeesToPrepare) {
        this.coffeeShop = coffeeShop;
        this.name = name;
        this.coffeesToPrepare = coffeesToPrepare;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < coffeesToPrepare; i++) {
                coffeeShop.prepareCoffee(name);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Customer extends Thread {
    private final CoffeeShop coffeeShop;
    private final String name;
    private final int coffeesToPick;

    public Customer(CoffeeShop coffeeShop, String name, int coffeesToPick) {
        this.coffeeShop = coffeeShop;
        this.name = name;
        this.coffeesToPick = coffeesToPick;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < coffeesToPick; i++) {
                coffeeShop.pickUpCoffee(name);
                Thread.sleep(500);
            }
        } catch (InterruptedException | CounterEmptyException e) {
            e.printStackTrace();
        }
    }
}

class Reviewer extends Thread {
    private final CoffeeShop coffeeShop;
    private final String name;

    public Reviewer(CoffeeShop coffeeShop, String name) {
        this.coffeeShop = coffeeShop;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            coffeeShop.sampleCoffee(name);
        } catch (InterruptedException | CounterEmptyException e) {
            e.printStackTrace();
        }
    }
}

public class program2 {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();

        Barista barista1 = new Barista(coffeeShop, "Barista 1", 2);
        Barista barista2 = new Barista(coffeeShop, "Barista 2", 3);
        Customer customer1 = new Customer(coffeeShop, "Customer 1", 1);
        Customer customer2 = new Customer(coffeeShop, "Customer 2", 2);
        Customer customer3 = new Customer(coffeeShop, "Customer 3", 1);
        Reviewer reviewer = new Reviewer(coffeeShop, "Reviewer");

        barista1.start();
        barista2.start();
        customer1.start();
        customer2.start();
        customer3.start();
        reviewer.start();
    }
}

class Order {
    int id;
    public Order(int id) {
        this.id = id;
    }
}

class OrderQueue {
    private Order[] orders = new Order[10];
    private int count = 0;

    public synchronized void addOrder(Order order) throws InterruptedException {
        while (count >= orders.length) {
            wait();
        }
        orders[count++] = order;
        System.out.println("Waiter added order #" + order.id);
        notify();
    }

    public synchronized Order getOrder() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        Order order = orders[0];
        for (int i = 0; i < count - 1; i++) {
            orders[i] = orders[i + 1];
        }
        count--;
        notify();
        return order;
    }
}

class Chef implements Runnable {
    private OrderQueue queue;
    private int ordersCompleted = 0;

    public Chef(OrderQueue queue) {
        this.queue = queue;
    }

    public void run() {
        while (ordersCompleted < 15) {
            try {
                Order order = queue.getOrder();
                System.out.println("Chef preparing order #" + order.id);
                Thread.sleep(2000);
                System.out.println("Chef completed order #" + order.id);
                ordersCompleted++;
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class Waiter implements Runnable {
    private OrderQueue queue;

    public Waiter(OrderQueue queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 1; i <= 15; i++) {
            try {
                queue.addOrder(new Order(i));
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

public class Program2 {
    public static void main(String[] args) throws InterruptedException {
        OrderQueue queue = new OrderQueue();
        
        Thread chef = new Thread(new Chef(queue));
        Thread waiter = new Thread(new Waiter(queue));
        
        chef.start();
        waiter.start();
        
        chef.join();
        waiter.join();
        
        System.out.println("Restaurant is closed!");
    }
}
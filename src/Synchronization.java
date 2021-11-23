public class Synchronization {
    public static void main(String[] args) {
        Runnable r = new ThreadEx(); // Create an instance of a class that implements Runnable
        // run multi thread
        new Thread(r).start();
        new Thread(r).start();
    }
}

class Account {
    // Block external access to private to control value change
    private int balance = 1000;
    public int getBalance() {
        return balance;
    }
    // 1. Designate the entire method as a critical section
    public synchronized void withdraw(int money) {
        // 2. Designate a specific area as a critical section
//        synchronized(this) {
            if (balance >= money) {
                try {
                    Thread.sleep(1000); // Passing control to another thread for example
                } catch (Exception e) {
                    // Throwing an exception
                    System.out.println("Exception is caught");
                }
                balance -= money;
            }
//        }
    }
}

class ThreadEx implements Runnable {
    Account ac = new Account();
    public void run() {
        while(ac.getBalance() > 0) {
            // Randomly select a value from 100, 200, or 300 to withdraw
            int money = (int) (Math.random() * 3 + 1) * 100;
            ac.withdraw(money);
            System.out.println("balance: " + ac.getBalance());
        }
    }
}

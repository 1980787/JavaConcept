public class MultiThread {
    public static void main(String[] args) {
        // thread class inheritance
        ThreadInheritance thread1 = new ThreadInheritance(); // Create an instance of Thread's descendant class

        // Implement runnable interface
//        Runnable r = new ThreadImplements(); // Create an instance of a class that implements Runnable
//        Thread thread2 = new Thread(r); // Thread class constructor (Runnable target)
        Thread thread2 = new Thread(new ThreadImplements());

        // Threads do not run automatically, only by calling start(). start() can only be called once per thread.
        // A thread is not executed immediately when start() is called, but is executed only when it is its turn after waiting for execution.
        // Of course, if there is no thread waiting to be executed, it immediately enters the running state.
        // The execution order of threads is determined by the schedule created by the OS scheduler.
        thread1.start(); // run thread1
        thread2.start(); // run thread2
    }
}
// thread creating by extending the Thread class
class ThreadInheritance extends Thread {
    public void run() {
        for(int i = 0; i < 5; i++) {
            try {
                // If the Thread class is inherited, the descendant class can directly call the method of the ancestor Thread class.\
                // Displaying the thread that is running
                System.out.println("Extending Thread class: " + getId()); // Call getName() on ancestor Thread
            } catch (Exception e) {
                // Throwing an exception
                System.out.println("Exception is caught");
            }
        }
    }
}
// thread creating by implementing the Runnable Interface
class ThreadImplements implements Runnable {
    public void run() {
        for(int i = 0; i < 5; i++) {
            try {
                // If Runnable is implemented, it can be called only after obtaining a reference to the thread by calling currentThread(),
                // which is a static method of the Thread class.
                // Displaying the thread that is running
                System.out.println("Implementing the runnable interface: " + Thread.currentThread().getId()); // print currently running thread
            } catch (Exception e) {
                // Throwing an exception
                System.out.println("Exception is caught");
            }
        }
    }
}

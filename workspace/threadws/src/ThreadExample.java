public class ThreadExample {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread(1, 100); // new state

        NumberThread t2 = new NumberThread(700, 1100); // new state
//        t2.setDaemon(true);
        // here we have one thread ready --> main thread

        CharThread ct = new CharThread();

        Thread t3 = new Thread(ct);
        t3.setName("CHAR THREAD");
        t3.setPriority(9);
        
        t1.start(); // main, t1 are eligible --> ready
        t2.start(); // main, t1, t2 are eligible --> ready
        t3.start();

        System.out.println("Main dies...");
    }
}

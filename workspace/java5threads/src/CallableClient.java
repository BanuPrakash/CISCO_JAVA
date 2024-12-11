import java.util.concurrent.*;

public class CallableClient {
    public static void main(String[] args) {
        ExecutorService service =
                Executors.newFixedThreadPool(2); // thread pool of size 4

        Future<Integer> f1 = service.submit(new FibanocciThread(34));
        Future<Integer> f2 = service.submit(new FibanocciThread(40));
        Future<Integer> f3 = service.submit(new FibanocciThread(28));

        try {
            System.out.println(f1.get()); //blocking code
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        service.shutdown(); // terminate the thread pool
    }
}

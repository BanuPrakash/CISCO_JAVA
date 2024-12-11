import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;

public class PCExample {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);

        p.start();
        c.start();
    }
}

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DefaultHandlerExample {
    public static void main(String[] args) {
//        Thread.currentThread()
//                .setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                System.err.println("Boom :-( " + e.getMessage());
//            }
//        });
        Thread.currentThread().setUncaughtExceptionHandler
                ((t, e) -> System.err.println("Boom :-( " + e.getMessage()));

        System.out.println("Main Called");
        doTask();
    }
    private static void doTask() {
        System.out.println("doTask() called!!!");
        // a.txt can exist or not
        try {
            FileInputStream fis = new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

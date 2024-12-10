import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedTypeThrowsExample {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Main Called");
        doTask();
    }

    private static void doTask() throws FileNotFoundException {
        System.out.println("doTask() called!!!");
        // a.txt can exist or not
        FileInputStream fis = new FileInputStream("a.txt");
    }
}

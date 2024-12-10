import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedTypeOfException {
    public static void main(String[] args) {
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

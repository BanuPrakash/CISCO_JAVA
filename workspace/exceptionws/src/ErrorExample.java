public class ErrorExample {
    public static void main(String[] args) {
        System.out.println("Main called");
        doTask();
    }

    private static void doTask() {
        System.out.println("DoTask called!!!");
        doTask(); // recursive without exit condition; StackOverflowError
    }
}

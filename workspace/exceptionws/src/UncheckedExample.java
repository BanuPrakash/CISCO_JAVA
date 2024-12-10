public class UncheckedExample {
    public static void main(String[] args) {
        System.out.println("Main called");
        doTask();
    }

    private static void doTask()  {
        int data = 100;
        int no = 0;
        System.out.println(data / no); // ArithmeticException
    }
}

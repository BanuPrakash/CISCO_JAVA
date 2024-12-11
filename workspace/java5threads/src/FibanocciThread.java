import java.util.concurrent.Callable;

// Callable instead of Runnable
public class FibanocciThread implements Callable<Integer> {
    private int number;

    public FibanocciThread(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread : " + Thread.currentThread());
        return fibanocci(number);
    }

    public int fibanocci(int no) {
        if(no == 0 || no == 1) {
            return  1;
        } else  {
            return fibanocci(no - 1) + fibanocci(no -2);
        }
    }
}

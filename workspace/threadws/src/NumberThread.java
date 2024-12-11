public class NumberThread extends Thread{
    private int begin;
    private int end;

    public NumberThread(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
       Thread t = Thread.currentThread();
        for (int i = begin; i <= end ; i++) {
            System.out.println(t + " : " + i);
        }
    }
}

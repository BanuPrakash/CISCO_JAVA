public class CharThread implements  Runnable{

    @Override
    public void run() {
        for (int i = 'A'; i < 'z'; i++) {
            Thread t = Thread.currentThread();
            System.out.println(t + " : " + (char) i);
        }
    }
}

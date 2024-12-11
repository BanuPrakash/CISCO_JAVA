public class Producer extends  Thread{
    Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((long)(Math.random() * 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Producer : " + i);
            buffer.setData(i);
        }
    }
}

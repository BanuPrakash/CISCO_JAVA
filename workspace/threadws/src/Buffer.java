public class Buffer {
    private int data;
    private volatile boolean flag = false;

    public synchronized int getData() {
        while(!flag) {
            try {
                wait(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        flag = false;
        notify();
        return data;
    }

    public synchronized void setData(int data) {
        while(flag) {
            try {
                wait(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.data = data;
        flag = true;
        notify();
    }
}

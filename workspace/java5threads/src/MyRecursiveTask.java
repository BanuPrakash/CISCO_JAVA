import java.util.concurrent.RecursiveTask;

// RecursiveTask [ returns a value] and RecursiveAction [doesn't return value]
public class MyRecursiveTask extends RecursiveTask<Long> {

    private long workLoad = 0;

    public MyRecursiveTask(long workLoad) {
        this.workLoad = workLoad;
    }

    // workload 64
    protected Long compute() {

        //if work is above threshold, break tasks up into smaller tasks
        if(this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);

            long workload1 = this.workLoad / 2; // 32
            long workload2 = this.workLoad - workload1; // 32

            MyRecursiveTask subtask1 = new MyRecursiveTask(workload1); // 16
            MyRecursiveTask subtask2 = new MyRecursiveTask(workload2); // 16

            subtask1.fork(); // schedule a thread
            subtask2.fork(); // schedule a thread

            long result = 0;
            result += subtask1.join();
            result += subtask2.join();
            return result;

        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
            return workLoad * 3;
        }
    }
}
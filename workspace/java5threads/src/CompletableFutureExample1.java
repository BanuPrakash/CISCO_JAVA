import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample1 {
    public static void main(String[] args) {
        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> {
                            System.out.println(Thread.currentThread());
                            return 10;
                        })
                .thenApplyAsync(result -> {
                    System.out.println(Thread.currentThread());
                    return result * 2;
                })
                .thenApplyAsync(result -> result + 5);

        future.thenAccept(result -> System.out.println(result));
    }
}

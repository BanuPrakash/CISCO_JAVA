public class AccountClient {
    public static void main(String[] args) {
        Account account = new Account(5000);
        TransactionThread t1 =
                new TransactionThread(account, "Anna", TransactionType.CREDIT, 3000);
        TransactionThread t2 =
                new TransactionThread(account, "\tRoger", TransactionType.CREDIT, 2500);
        TransactionThread t3 =
                new TransactionThread(account, "\t\tPeter", TransactionType.DEBIT, 2000);

        t3.start();

        t1.start();
        t2.start();

        // Barrier, join() makes the thread wait for the other thread to finish
        try {
            t1.join(); // main waits for t1 to complete
            t2.join(); // main waits for t2 to complete
            t3.join(); // main waits for t3 to complete
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final Balance : " + account.getBalance());
    }
}

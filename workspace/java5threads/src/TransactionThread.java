public class TransactionThread extends  Thread{
    private  Account account;
    private  String name;
    private  TransactionType type;
    private  double amt;

    public TransactionThread(Account account, String name, TransactionType type, double amt) {
        this.account = account;
        this.name = name;
        this.type = type;
        this.amt = amt;
    }

    @Override
    public void run() {
        if(type == TransactionType.CREDIT) {
            account.deposit(name, amt);
        } else {
            account.withdraw(name, amt);
        }
    }
}

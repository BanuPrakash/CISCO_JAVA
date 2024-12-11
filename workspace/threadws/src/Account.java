public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return balance;
    }

    private void setBalance(double balance) {
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.balance = balance;
    }

    public void withdraw(String name, double amt) {
        System.out.println(name + " is trying to withdraw " + amt);
        double bal = getBalance();
        System.out.println(name  + " got existing balance : " + bal);
        bal -= amt;
        System.out.println(name + " setting the balance...");
        setBalance(bal);
        System.out.println(name +" sets balance to : " + bal);
    }

    public void deposit(String name, double amt) {
        System.out.println(name + " is trying to deposit " + amt);
        double bal = getBalance();
        System.out.println(name  + " got existing balance : " + bal);
        bal += amt;
        System.out.println(name + " setting the balance...");
        setBalance(bal);
        System.out.println(name +" sets balance to : " + bal);
    }

}

package workshop.bank.entity;

public abstract class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원\n", amount, balance);
    }

    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new workshop.bank.exception.InsufficientBalanceException("잔액이 부족합니다.");
        }
        balance -= amount;
        System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f원\n", amount, balance);
    }

    public abstract void printInfo();
}

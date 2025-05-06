package workshop.bank.entity;

import workshop.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(withdrawalLimit);
        }
        super.withdraw(amount);
    }

    @Override
    public void printInfo() {
        System.out.printf("계좌번호: %s, 소유자: %s, 잔액: %.1f원, 출금 한도: %.1f원\n",
                accountNumber, ownerName, balance, withdrawalLimit);
    }
}
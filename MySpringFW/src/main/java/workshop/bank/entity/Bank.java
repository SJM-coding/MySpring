package workshop.bank.entity;

import workshop.bank.exception.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int nextNumber = 1000;

    public Account createSavingsAccount(String owner, double amount, double rate) {
        String accountNum = "AC" + nextNumber++;
        Account acc = new SavingsAccount(accountNum, owner, amount, rate);
        accounts.add(acc);
        System.out.print("Saving(저축) 계좌가 생성되었습니다: ");
        acc.printInfo();
        return acc;
    }

    public Account createCheckingAccount(String owner, double amount, double limit) {
        String accountNum = "AC" + nextNumber++;
        Account acc = new CheckingAccount(accountNum, owner, amount, limit);
        accounts.add(acc);
        System.out.print("체킹 계좌가 생성되었습니다: ");
        acc.printInfo();
        return acc;
    }

    public Account findAccount(String accNum) throws AccountNotFoundException {
        return accounts.stream()
                .filter(a -> a.getAccountNumber().equals(accNum))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException(accNum));
    }

    public void transfer(String fromAcc, String toAcc, double amount) throws Exception {
        Account src = findAccount(fromAcc);
        Account tgt = findAccount(toAcc);
        src.withdraw(amount);
        tgt.deposit(amount);
        System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.\n", amount, fromAcc, toAcc);
    }

    public void printAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account acc : accounts) {
            acc.printInfo();
        }
        System.out.println("===================");
    }
}
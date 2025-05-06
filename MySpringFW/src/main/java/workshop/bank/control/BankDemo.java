package workshop.bank.control;

import workshop.bank.entity.*;
import workshop.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // 계좌 생성
        bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        bank.createSavingsAccount("이영희", 30000.0, 2.0);

        bank.printAllAccounts();

        // 입출금
        try {
            Account acc = bank.findAccount("AC1000");
            acc.deposit(5000);
            acc.withdraw(3000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 이자 적용
        try {
            SavingsAccount acc = (SavingsAccount) bank.findAccount("AC1000");
            acc.applyInterest();
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 송금
        try {
            bank.transfer("AC1002", "AC1001", 5000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        bank.printAllAccounts();

        // 예외 테스트
        try {
            Account acc = bank.findAccount("AC1001");
            acc.withdraw(6000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}

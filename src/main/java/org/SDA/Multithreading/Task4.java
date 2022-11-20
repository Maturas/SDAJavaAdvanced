package org.SDA.Multithreading;

public class Task4 {
    public static class BankAccount {
        private Integer amount;

        public BankAccount(Integer amount) {
            this.amount = amount;
            System.out.printf("Initialized bank account with amount: %d%n", amount);
        }

        public synchronized void deposit(Integer deposit) {
            amount += deposit;
            System.out.printf("%s New deposit: %d. Current amount: %d%n", Thread.currentThread().getName(), deposit, amount);
            notify();
        }

        public synchronized void tryWithdraw(Integer withdrawAmount) {
            while (withdrawAmount > amount) {
                System.out.printf("%s Insufficient funds to withdraw: %d%n", Thread.currentThread().getName(), withdrawAmount);
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            amount -= withdrawAmount;
            System.out.printf("%s New withdraw: %d. Current amount: %d%n", Thread.currentThread().getName(), withdrawAmount, amount);
        }
    }

    public static class DepositThread extends Thread {
        private final Integer amount;
        private final BankAccount account;

        public DepositThread(Integer amount, BankAccount account, String name) {
            super(name);
            this.amount = amount;
            this.account = account;
        }

        @Override
        public void run() {
            account.deposit(amount);
        }
    }

    public static class WithdrawThread extends Thread {
        private final Integer amount;
        private final BankAccount account;

        public WithdrawThread(Integer amount, BankAccount account, String name) {
            super(name);
            this.amount = amount;
            this.account = account;
        }

        @Override
        public void run() {
            account.tryWithdraw(amount);
        }
    }

    public static void exercise() {
        BankAccount account = new BankAccount(5000);
        DepositThread threadA = new DepositThread(1000, account, "Thread A");
        WithdrawThread threadB = new WithdrawThread(6000, account, "Thread B");
        WithdrawThread threadC = new WithdrawThread(2000, account, "Thread C");
        WithdrawThread threadD = new WithdrawThread(3000, account, "Thread D");
        DepositThread threadE = new DepositThread(10000, account, "Thread E");

        Thread[] threads = new Thread[] { threadA, threadB, threadC, threadD, threadE };
        for (Thread thread : threads) {
            thread.start();
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Account class
class Account {
    private double balance;
    private final List<String> transactionHistory;

    public Account(String accountHolder, double initialBalance) {
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            System.out.println("Successfully withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Main class
public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        Account account = new Account(name, initialBalance);

        while (true) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Show Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                }
                case 2 -> {
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                }
                case 3 -> account.showBalance();
                case 4 -> account.showTransactionHistory();
                case 5 -> {
                    System.out.println("Thank you for banking with us!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
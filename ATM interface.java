import java.util.Scanner;

// BankAccount class representing user's bank account
class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor Initialisation
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit Amount
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdraw Amount
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        }
    }

    // Checking balance 
    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }
}

// ATM interface
interface ATM {
    void deposit();
    void withdraw();
    void checkBalance();
}


// ATMImplementation class implementing ATM interface

import java.util.Scanner;
class ATMImplementation implements ATM {
    private BankAccount userAccount;

    // Constructor Initialisation
    public ATMImplementation(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    // Implementation of depositing amount
    @Override
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: $");
        double depositAmount = scanner.nextDouble();
        userAccount.deposit(depositAmount);
        System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
    }

    // Implementation of withdrawing amount
    @Override
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: $");
        double withdrawalAmount = scanner.nextDouble();
        userAccount.withdraw(withdrawalAmount);
    }

    // Implementation of checkBalance 
    @Override
    public void checkBalance() {
        userAccount.checkBalance();
    }

    public static void main(String[] args) {
    
        BankAccount userAccount = new BankAccount("123456789", "John Doe", 0.0);

        // ATMImplementation instance
        ATMImplementation atm = new ATMImplementation(userAccount);
        System.out.println("1.Deposit\n2.Withdraw \n3.Checkbalance \nPlease Enter your choice : ");
        Scanner sc= new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice)
        {
           case 1:
               atm.deposit();
               break;
               
           case 2:
               atm.withdraw();
               break;
               
           case 3:
               atm.checkBalance();
               break;
           default:
               System.out.println("Please Enter the right choice : ");
        }
    }
}

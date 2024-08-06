

public class BankingApplication {
    public static void main(String[] args) {
        try {
            // Create a new account with initial balance
            BankAccount account = new BankAccount("12345", 1000.0);

            // Test deposit operation
            account.deposit(500.0);
            System.out.println("Balance after deposit: " + account.getBalance());

            // Test withdraw operation
            account.withdraw(200.0);
            System.out.println("Balance after withdrawal: " + account.getBalance());

            // Test invalid deposit
            try {
                account.deposit(-50.0);
            } catch (NegativeDepositException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Test insufficient funds
            try {
                account.withdraw(2000.0);
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Test invalid account
            try {
                BankAccount.validateAccount(null);
            } catch (InvalidAccountException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}


 class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws NegativeDepositException {
        if (amount <= 0) {
            throw new NegativeDepositException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
    }

    public static void validateAccount(BankAccount account) throws InvalidAccountException {
        if (account == null) {
            throw new InvalidAccountException("Account does not exist.");
        }
    }
}





class NegativeDepositException extends Exception {
    public NegativeDepositException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAccountException extends Exception {
    public InvalidAccountException(String message) {
        super(message);
    }
}

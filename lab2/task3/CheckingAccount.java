package lab2.task3;
public class CheckingAccount extends Account {
    private int transactionCount;
    private static final int FREE_TRANSACTIONS = 3;
    private static final double FEE_PER_TRANSACTION = 0.02;

    public CheckingAccount(int accNumber) {
        super(accNumber);
        this.transactionCount = 0;
    }

    @Override
    public void deposit(double sum) {
        super.deposit(sum);
        transactionCount++;
    }

    @Override
    public void withdraw(double sum) {
        super.withdraw(sum);
        transactionCount++;
    }

    public void deductFee() {
        if (transactionCount > FREE_TRANSACTIONS) {
            int chargeableTransactions = transactionCount - FREE_TRANSACTIONS;
            double fee = chargeableTransactions * FEE_PER_TRANSACTION;
            super.withdraw(fee);
        }
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void resetTransactionCount() {
        transactionCount = 0;
    }

    @Override
    public String toString() {
        return "CheckingAccount #" + (int) getAccountNumber() +
               " | Balance: $" + String.format("%.2f", getBalance()) +
               " | Transactions: " + transactionCount +
               " | Free: " + FREE_TRANSACTIONS;
    }
}

package lab2.task3;
import java.util.Vector;

public class Bank {
    private Vector<Account> accounts;

    public Bank() {
        accounts = new Vector<>();
    }

    public void openAccount(Account account) {
        accounts.add(account);
    }

    public void closeAccount(int accNumber) {
        accounts.removeIf(a -> (int) a.getAccountNumber() == accNumber);
    }

    public Account findAccount(int accNumber) {
        for (Account a : accounts) {
            if ((int) a.getAccountNumber() == accNumber) return a;
        }
        return null;
    }

    public void update() {
        for (Account a : accounts) {
            if (a instanceof SavingsAccount) {
                ((SavingsAccount) a).addInterest();
            } else if (a instanceof CheckingAccount) {
                ((CheckingAccount) a).deductFee();
                ((CheckingAccount) a).resetTransactionCount();
            }
        }
    }

    public void printAllAccounts() {
        for (Account a : accounts) {
            a.print();
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        Account acc1 = new Account(1001);
        acc1.deposit(500.00);

        SavingsAccount sav1 = new SavingsAccount(2001, 5.0);
        sav1.deposit(1000.00);

        SavingsAccount sav2 = new SavingsAccount(2002, 3.5);
        sav2.deposit(2000.00);

        CheckingAccount chk1 = new CheckingAccount(3001);
        chk1.deposit(300.00);
        chk1.deposit(100.00);
        chk1.withdraw(50.00);
        chk1.withdraw(20.00);
        chk1.deposit(200.00);

        CheckingAccount chk2 = new CheckingAccount(3002);
        chk2.deposit(150.00);
        chk2.withdraw(30.00);

        bank.openAccount(acc1);
        bank.openAccount(sav1);
        bank.openAccount(sav2);
        bank.openAccount(chk1);
        bank.openAccount(chk2);

        System.out.println("=== Before Update ===");
        bank.printAllAccounts();

        bank.update();

        System.out.println("\n=== After Update ===");
        bank.printAllAccounts();

        System.out.println("\n=== Closing Account 2002 ===");
        bank.closeAccount(2002);
        bank.printAllAccounts();
    }
}

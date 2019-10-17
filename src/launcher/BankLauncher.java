package launcher;

import domain.Account;
import domain.Accountlogger;
import domain.Auditor;
import domain.Bank;

import javax.security.auth.login.AccountLockedException;
import java.util.Map;

public class BankLauncher {
    public static void main(String[] args) {
        Bank bank = new Bank("KBC");
        Auditor auditor = new Auditor(bank);
        Accountlogger accountlogger = new Accountlogger(bank);
        Map<Integer,Account> accountMap = bank.getAccounts();
        for (Account a:accountMap.values()) {

        }
        bank.addAccount(1000);
        bank.addAccount(69);
        bank.addAccount();
        bank.addAccount(420);
    }
}

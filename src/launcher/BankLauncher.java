package launcher;

import domain.Account;
import domain.Accountlogger;
import domain.Auditor;
import domain.Bank;

import javax.security.auth.login.AccountLockedException;

public class BankLauncher {
    public static void main(String[] args) {
        Bank bank = new Bank("KBC");
        Auditor auditor = new Auditor(bank);
        Accountlogger accountlogger = new Accountlogger(bank);
        bank.addAccount();
    }
}

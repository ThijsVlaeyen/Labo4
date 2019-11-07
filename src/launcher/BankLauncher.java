package launcher;

import domain.*;

import javax.security.auth.login.AccountLockedException;
import java.util.Arrays;
import java.util.Map;

public class BankLauncher {
    public static void main(String[] args) {
        Bank bank = new Bank("KBC");
        Auditor auditor = new Auditor();
        Accountlogger accountlogger = new Accountlogger();

        bank.addObserver(EventType.ADD, auditor);
        bank.addObserver(Arrays.asList(EventType.values()), accountlogger);

        bank.addAccount(123);
        bank.deposit(1, 1000);

        auditor.display();

        accountlogger.display();

        bank.deposit(1,123);
        accountlogger.display();

    }
}

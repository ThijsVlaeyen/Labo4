package domain;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

public class Bank implements Subject{
    private Map<Integer,Account> accounts;
    private Map<EventType,List<Observer>> observers;
    private String name;

    public Bank(String name){
       this.name = name;
       observers = new HashMap<>();
       accounts = new HashMap<>();
       for (EventType event : EventType.values()){
          observers.put(event, new LinkedList<>());
       }
    }

    public void addAccount(int id){
       Account account = new Account(id);
       accounts.put(id, account);
       updateObservers(EventType.ADD, id);
    }

    @Override
    public void registerObserver(List<EventType> eventTypes, Observer o){
        for (EventType e:eventTypes) {
            //e.addObserver(o);
            addObserver(e,o);
        }
    }

   @Override
   public void addObserver(Collection<EventType> bankEvents, Observer observer) {
      for (EventType eventType: bankEvents){
         addObserver(eventType, observer);
      }
   }

@Override
    public void addObserver(EventType e, Observer o){
        observers.get(e).add(o);
    }

    @Override
    public void removeObserver(EventType e ,Observer o) {
        this.observers.get(e).remove(o);
    }

    @Override
    public void updateObservers(EventType e, int accountNumber) {
       for (Observer observer : observers.get(e)){
          Account account = accounts.get(accountNumber);
          observer.update(e, account);
       }
    }

    public Account getAccount(int accountNumber){
        return this.accounts.get(accountNumber);
    }

   public Map<Integer, Account> getAccounts() {
      return accounts;
   }

   public void withdraw(int accountnumber, double amount){
       if (amount <= 0){
          throw new IllegalArgumentException("Not a legal number");
       }
       Account account = accounts.get(accountnumber);
       account.setAccountBalance(account.getAccountBalance() - amount);
       updateObservers(EventType.WITHDRAW,accountnumber);
    }

    public void deposit(int id, double amount){
       if (amount <= 0){
          throw new IllegalArgumentException("Not a legal number");
       }
       Account account = accounts.get(id);
       account.setAccountBalance(account.getAccountBalance() + amount);
       updateObservers(EventType.DEPOSIT,id);
    }
}

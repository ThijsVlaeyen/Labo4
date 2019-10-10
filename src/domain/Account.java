package domain;

public class Account {

   private int accountNumber;
   private double accountBalance;

   public Account(int accountNumber, double accountBalance){
      this.accountNumber = accountNumber;
      this.accountBalance = accountBalance;
   }

   public Account(int accountNumber){
      this(accountNumber, 0);
   }

   public void updateAccount(double newBalance){
      this.accountBalance = newBalance;
   }

   @Override
   public String toString(){
      return "\nAccount Number: " + this.accountNumber + "\nAccount Balance: " + this.accountBalance;
   }


}

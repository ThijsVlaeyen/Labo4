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

   public void setAccountBalance(double newBalance){
      this.accountBalance = newBalance;
   }

   public double getAccountBalance() {
      return accountBalance;
   }

   public int getAccountNumber() {
      return accountNumber;
   }

   @Override
   public String toString(){
      return "\nAccount Number: " + this.accountNumber + "\nAccount Balance: " + this.accountBalance;
   }


}

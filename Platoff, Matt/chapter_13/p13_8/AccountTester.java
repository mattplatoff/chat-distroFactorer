package p13_8;
/**
   This program tests the BankAccount class and
   its subclasses. 
*/
public class AccountTester
{  
   public static void main(String[] args)
   {  
      SavingsAccount momsSavings 
            = new SavingsAccount(0.5);
      
      CheckingAccount harrysChecking
            = new CheckingAccount(100);
         
      BankAccount.test(momsSavings);
      BankAccount.test(harrysChecking);
   }
}

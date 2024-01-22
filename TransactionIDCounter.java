/**
  The TransactionIDCounter class uses a class variable to produce a unique transaction identifier for a
  Transaction. (Description from Assignment) 
  
  Isis Gonsalves
  816026980
*/

public class TransactionIDCounter
{
    public static int currentTransactionID = 0; //class var
    public static int newTransactionID = 0;     //class var
    
    public static int getCurrentTransactionID(){
        return currentTransactionID;
    }
    
    public static int getNewTransactionID(){
        newTransactionID++;
        return newTransactionID; // tried to change
    }
    
}

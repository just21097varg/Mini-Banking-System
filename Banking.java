import java.util.*;
class Banking
{
  private static long cents=0;
  private static long dollars=0;
  
  public static void main(String args[]) throws Exception
  {
     Scanner sc=new Scanner(System.in);
     int input;
     String amount;
     while(true)
     {
        System.out.println("Select an option:\n 1. Credit\n 2. Debit\n 3. Check Balance\n 4. Exit");
        input=sc.nextInt();
        if(input==1)
        {   
              System.out.println("Enter Amount:");
              credit();
              System.out.println("Successful!");
              
        }
        else if(input==2)
        {
              System.out.println("Enter Amount");
              debit();
              System.out.println("Done");
              
        }
        else if(input==3)
        {
              System.out.println("Current Balance is "+dollars+"D "+cents+"C");
              
        }
        else
        {
           System.out.println("Thank you!");
           break;
        }
        
      }
    }
    
   private static void credit()
   {
       Scanner sc=new Scanner(System.in);
       String amount=sc.nextLine();
       String[] amount_sp = amount.split("\\s+");
       if(amount_sp.length==2)
       {
           cents+=Long.parseLong(amount_sp[1].substring(0,amount_sp[1].length()-1));
           if(cents>=100)
           {
              cents%=100;
              dollars+=1;
           }
           dollars+=Long.parseLong(amount_sp[0].substring(0,amount_sp[0].length()-1));
       }
       else if(amount_sp[0].charAt(amount_sp[0].length()-1)=='C')
       {
           cents+=Long.parseLong(amount_sp[0].substring(0,amount_sp[0].length()-1));
           if(cents>=100)
           {
              cents%=100;
              dollars+=1;
           }
       }
       else
       {
           dollars+=Long.parseLong(amount_sp[0].substring(0,amount_sp[0].length()-1));
       }
    }

    private static void debit()
    {
       Scanner sc=new Scanner(System.in);
       String amount=sc.nextLine();
       String[] amount_sp = amount.split("\\s+");
       int cent=0,dollar=0;
       if(amount_sp.length==2)
       {
           cent=Integer.parseInt(amount_sp[1].substring(0,amount_sp[1].length()-1));
           dollar=Integer.parseInt(amount_sp[0].substring(0,amount_sp[0].length()-1));
       }
       else
       {
           if(amount_sp[0].charAt(amount_sp[0].length()-1)=='C')
              cent=Integer.parseInt(amount_sp[0].substring(0,amount_sp[0].length()-1));
           else
              dollar=Integer.parseInt(amount_sp[0].substring(0,amount_sp[0].length()-1));
       }
       cents-=cent;
       dollars-=dollar;
       if(cents<0)
       {
           cents+=100;
           dollars--;
       }     
    }       
}       
              
package com.mycompany.bluewaves2;

import java.util.ArrayList;
import java.util.Scanner;


public class Bluewaves {
    public static void main(String[] args) {
       
        
        
       Scanner input = new Scanner(System.in);
       
        int price = 5000; //the price of reservation
   
        ReservationDetail R = new ReservationDetail();
        Payments P = new Payments();
        CreditCardPayment C = new CreditCardPayment();
        CashPayment S = new CashPayment();
        
        
          int choice;
      do{
        System.out.println("************************* Welcome to our application! ***********************");
        System.out.println("Please choose what do you want to do from the following list: ");
        System.out.println("1- Add a reservation.");
        System.out.println("2- Edit reservation.");
        System.out.println("3- Delete reservation.");
        System.out.println("4- Display reservation details.");
        System.out.println("5- Pay (Using credit card or cash).");
        System.out.println("6- Enter 999 to exit the program.");
        System.out.println("**************************************************************************************************************");
       
        choice = input.nextInt();
        
        switch(choice)
    {
            
            case 1: //Add reservation
            R.AddDetails();
            if (R.getNumofGuests().equals("30")){
             price += 2000;
            }
            
            R.Events(); //to display the list event s
            int events = input.nextInt(); 
            
            P.CalculatePrice4Activities(events);
    
           double total= P.CalculateTotal(events,price);
            System.out.println("Your final price of reservation is  " +total);
            break;  //END OF CASE 1
               
            
  
            
            case 2: //Edit reservation
                R.EditReservation();
            break;  //END OF CASE 2
      
           
            
            case 3://Delete reservation
                R.DeleteReservation();
            break;  //END OF CASE 3
            
            
            
            
            case 4:
          R.Display(); //displays the reservation details.
            break;  //END OF CASE 4
            
            
            
            
            case 5:
                 System.out.println("Enter 1 for paying with Cash  or 2 for paying with Creditcard");
                 int payment=input.nextInt();
                 if(payment ==1 ){
                     P.display();
                     S.display();}
                 else if (payment == 2){    
                          C.CardInfo();
                          P.display();
                          C.display(); }
            break;  //END OF CASE 5
            
            
            
            
            
            case 999: //exit
            break;
            default:
              System.out.println("Wrong Entry. Please enter a valid option.");
             break;
        }}while(choice != 999);}
}
///////////////////////////////////////END OF MAIN


































 /////////////////////////////////////////////////////////////
class Payments {
    double total;

public double CalculatePrice4Activities(int event){
     
 
  if(event == 1){
      return 1500;}
  else if (event == 2)
  {return 2000;}
  else if (event == 3)
  { return 1500;}
  else if (event == 4)
  { return 3000;}
 
{return 0;}}

public double CalculateTotal(int numofactvity,int price ){
total=(numofactvity *price +price*0.15);
 return  total;
}

public void display() //polymorphism
{
  System.out.print("you will pay "+total);
}}
 /////////////////////////////////////END OF PAYMENT CLASS




















class CashPayment extends Payments{
 @Override
  public void display() //method to display cash payment confirmation (polymorphism) 
 {System.out.println(" at the counter.");}
}
/////////////////////////////////////END OF CASH Cash payment CLASS




















//////////////////////////////////////////////
class CreditCardPayment extends Payments{
private String CardName, ExpirationDate, CreditCardNumber ,PIN;

        public void setCardName(String CardName) {
            this.CardName = CardName;
        }

        public void setExpirationDate(String ExpirationDate) {
            this.ExpirationDate = ExpirationDate;
        }

        public void setCreditCardNumber(String CreditCardNumber) {
            this.CreditCardNumber = CreditCardNumber;
        }   
        
     
     public void setPin(String pin) {
           this.PIN=PIN;
        }

     public void CardInfo() //to let user enter credit card info
     {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter card information : ");
                          System.out.println("Enter your full name :");   
                          setCardName(input.next());
                          
                          System.out.println("Enter creditcard number :");
                          setCreditCardNumber(input.next());
                         
                          System.out.println("Enter expiration date of the card :");
                          setExpirationDate(input.next());
                           
                          System.out.println("PIN number : ");
                          setPin(input.next());
                  
     }//end of cardinfo 
     
public void display()  //method to display credit card payment confirmation (polymorphism)
{
  System.out.print(" using your credit card");
}//end of display
}
/////////////////////////////////////END OF CREDIT CARD CLASS
     




























class ReservationDetail {
    Scanner input = new Scanner(System.in);
    
  private String NumOfGuests;
  private String ReservationDate; 
  public  String CustomerName;
  private String Email;
  private String PhoneNumber;
  private String CreditCardInfo;
  public ArrayList <String> reservations;


  
  //SET

  public void setNumOfGuests(String NumOfGuests){
      this.NumOfGuests = NumOfGuests;
  }
  

  public void setReservationDate(String ReservationDate){
      this.ReservationDate = ReservationDate;
  }

  
  public void setCustomerName(String CustomerName){
      this.CustomerName = CustomerName;
  }
 
  public void setEmail(String Email){
      this.Email = Email;
      
      
  }
  
  
  public void setPhoneNumber(String PhoneNumber){
      this.PhoneNumber = PhoneNumber;
  }
  
      
  //Get 
 
  public String getNumofGuests(){
      return this.NumOfGuests;
  } 
    
  public String getReservationDate(){
      return this.ReservationDate;
  } 
  
    public String getCustomerName(){
      return this.CustomerName;
  } 
  
  public String getEmail(){
      return this.Email;
  } 
  
  
  public String getPhoneNumber(){
      return this.PhoneNumber;
  }

 
  public void AddDetails() //add items to the array list.
  {   
      reservations = new ArrayList<>();
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter the number of guests: ");
      NumOfGuests = input.next(); 
      reservations.add(NumOfGuests); //index 0
      
            
      System.out.println("Enter Month");
      String month;
      String Enteredmonth =input.next();
      boolean flagmonth;
      flagmonth = ValidMonth(Enteredmonth);
      if (flagmonth == true){
      month = Enteredmonth; 
      System.out.println("Valid month . ");
      }
      else{
          do
      {
          System.out.println("invalid month . \nEnter again: from 1 to 12 only  ");
          month =input.next();
          ValidMonth(month);
          flagmonth = true;
      }while (flagmonth == false);
      }
      
      System.out.println("Enter Day");
      String day;
      String Enteredday =input.next();
       boolean flagday;
      flagday =ValidDay(Enteredday);
      if (flagday == true){
      day = Enteredday;
      System.out.println("Valid Day. ");
      }
      else{
          do
      {
          System.out.println("invalid Day . \nEnter again: from 1 to 31 ");
         Enteredday =input.next();
          ValidDay(Enteredday);
          day = Enteredday;
          flagday = true;
      }while (flagday == false);
      }
      
  

      ReservationDate = DateMonthDay (month,day);
      reservations.add(ReservationDate); //index 1
      
      

      System.out.println("Enter the name: ");
      CustomerName = input.next();
      reservations.add(CustomerName); //index 2
      
      System.out.print("Enter the phone number: +966");
      PhoneNumber =input.next();
      boolean flag;
      flag = ValidatePhoneNumber(PhoneNumber);
      if (flag == true){
      reservations.add(PhoneNumber); //index 3
      System.out.println("Valid phone number. ");
      }
      else{
          do
      {
          System.out.print("invalid phone number. \nEnter again: +966");
          PhoneNumber =input.next();
          ValidatePhoneNumber(PhoneNumber);
          flag = true;
      }while (flag == false);
      }
      
      System.out.println("Enter the email: ");
      Email =input.next();
      ValidateEmail(Email);
      reservations.add(Email); //index 4
      
      boolean Emailflag;
      Emailflag = ValidateEmail(Email);
      if (Emailflag == true){
      reservations.add(Email);
      System.out.println("Valid email. ");
      }
      else{
          do
      {
          System.out.print("invalid email. \nEnter again: ");
          Email =input.next();
          ValidateEmail(Email);
          Emailflag = true;
      }while (Emailflag == false);
      }
  }
  
  public void EditReservation()
  {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter your name: "); //letting user enter their username to find their details.
      boolean found;
      String SearchedName = input.next();
      
      if (SearchedName.equals(reservations.get(2)))
              {
                found = true;
      System.out.println("Choose what do you want to edit:");
      System.out.println("Enter 1 if you want to edit the number of guests.");
      System.out.println("Enter 2 if you want to edit the reservation date.");
                
                int editchoice = input.nextInt(); //letting user choose what they want to edit. 
                switch (editchoice)
                {
                case 1: //editing location
                System.out.println("Enter the new number of guests:");
                String NewNumOfGuest = input.next();
                //replace old number of guests with new number of guests
                reservations.set(0, NewNumOfGuest);
                 break;
                 
                 case 2: //editing date
                 System.out.println("Enter the day: ");
                 String Newday = input.next();
           
      
                 
                        boolean flag1;
                          flag1 = ValidDay(Newday);
      if (flag1 == true){
      reservations.add(Newday);
      System.out.println("Valid Day. ");
      }
      else{
          do
      {
          System.out.println("invalid Day . \nEnter again: from 1 to 31");
         Newday =input.next();
          ValidDay(Newday);
          flag1 = true;
      }while (flag1 == false);
      }
      
                       
                 
                 System.out.println("Enter the month: ");
                 String Newmonth = input.next();
              
     
      boolean flags;
      flags = ValidMonth(Newmonth);
      if (flags == true){
      reservations.add(Newmonth);
      System.out.println("Valid month . ");
      }
      else{
          do
      {
          System.out.println("invalid month . \nEnter again: from 1 to 12 only  ");
          Newmonth =input.next();
          ValidMonth(Newmonth);
          flags = true;
      }while (flags == false);
      }
                
                 
                 
                 
     
                 String NewDate = DateMonthDay (Newmonth,Newday);
                 //replace old date with new date
                 reservations.set(3, NewDate);
                 break;
         
                 default:
                 System.out.println("Invalid input!!");
                 break;
                }
      
  }
      
      
      else{
  System.out.println("The name you are looking for is not found.");    
  found = false;}}
 
  

  public void DeleteReservation()
 {
     System.out.println("Enter your name: ");
  //letting user enter their username to find their details.
      boolean found;
      String SearchedName = input.next();
      if (SearchedName.equals(reservations.get(4)))
          
         {
            reservations.clear();
             System.out.println("youre reservation has bee deleted" ); 
         } 
      else
      {
        System.out.println("The name you are looking for is not found.");    
        found = false;}
      
 }
 

   public void Display(){
    System.out.println("*********************************************************************************************************************************************");
    System.out.println("Name : " + reservations.get(2));
    System.out.println("Number of guests : " + reservations.get(0));
    System.out.println("Reservation date  " + reservations.get(1));
    System.out.println("Phone number: +966" + reservations.get(3));
    System.out.println("Email: " + reservations.get(4));
       
    }    
   
   
  
  
  
  public void Events(){
     System.out.println("*********************************************************************************************************************************************");
      System.out.println(" Optional Events Managment ");
      System.out.println("Select the number of event:");
      System.out.println("1.Birthday | 2.Movie Night | 3.Graduation Party | 4.Wedding | 5.No Theme");
      System.out.println("*********************************************************************************************************************************************");
  }
  
   
  public boolean ValidatePhoneNumber(String PhoneNumber) {
           boolean flag = false;
 
     if (PhoneNumber.startsWith("5") && PhoneNumber.length() == 9)
         flag = true;
      return flag;
  }
  
  
  boolean EmailChecker = false;
  public boolean ValidateEmail(String Email)
  {if (Email.contains("@gmail.com") ||  Email.contains("@hotmail.com") || Email.contains("@yahoo.com"))
       EmailChecker = true;
  return EmailChecker;
      }
//////////////////////////////////////

  
  
  public boolean ValidMonth(String month){
    Integer i = Integer.parseInt(month);
    boolean flag = false;      
  
     if (i<=12)
         flag = true;
      return flag;
  }
  
  
   
  public boolean ValidDay(String day){
  Integer i = Integer.parseInt(day);
      boolean flag = false;
  
     if (i<=31)
         flag = true;
      return flag;
  }
  
  
public String DateMonthDay (String month, String Day)
{
String date = Day + "/" + month;
return date;
}

}

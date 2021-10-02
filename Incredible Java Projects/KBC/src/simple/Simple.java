package simple;
import java.sql.*;
import java.util.*;

public class Simple {
    int ap=0,ph=0,ff=0,fq=0,pp=0,ask=0,dd=0;

    public static void main(String args[]) throws Exception{

        String sname;
         int age;
             Connection connect=DriverManager.getConnection("Jdbc:mysql://localhost:3306/kbc","root","12345");
     Statement statement=connect.createStatement();
     
        try{
        Simple x=new Simple(); 
        Scanner m=new Scanner(System.in);
 
  
        Long Logo;
        Logo = System.currentTimeMillis();
        if(Logo%3==0){
     
       
      System.out.println("\t\t              ________________________________________________________________________________________________");
      System.out.println("\t\t            /|                                                                                                |");
      System.out.println("\t\t           / |  ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''    |");
      System.out.println("\t\t          |  |  ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''    |");
      System.out.println("\t\t          |  |  ''       __       _ ___         _____________________           ___________________     ''    |");
      System.out.println("\t\t          |  |  ''     /|  |     / /  /       /|   _______________   |        /|   ________________|    ''    |");
      System.out.println("\t\t          |  |  ''    | |  |    / /  /       | |  |_____________ /|  |       | |  |_______________/     ''    |");
      System.out.println("\t\t          |  |  ''    | |  |   / /  /        | |  |             | |  |       | |  |                     ''    |");
      System.out.println("\t\t          |  |  ''    | |  |  / /  /         | |  |             | |  |       | |  |                     ''    |");
      System.out.println("\t\t          |  |  ''    | |  | / /  /          | |  |             | |  |       | |  |                     ''    |");
      System.out.println("\t\t          |  |  ''    | |  |/ /  /           | |  |_____________|_|  |       | |  |                     ''    |");
      System.out.println("\t\t          |  |  ''    | |  | /  /            | |   _______________   |       | |  |                     ''    |");
      System.out.println("\t\t          |  |  ''    | |  |/\\  \\            | |  |______________/|  |       | |  |                     ''    |");
      System.out.println("\t\t          |  |  ''    | |  |\\ \\  \\           | |  |             | |  |       | |  |                     ''    |");
      System.out.println("\t\t          |  |  ''    | |  | \\ \\  \\          | |  |             | |  |       | |  |                     ''    |");
      System.out.println("\t\t          |  |  ''    | |  |  \\ \\  \\         | |  |             | |  |       | |  |                     ''    |");
      System.out.println("\t\t          |  |  ''    | |  |   \\ \\  \\        | |  |_____________|_|  |       | |  |________________     ''    |");
      System.out.println("\t\t          |  |  ''    | |__|    \\ \\__\\       | |_____________________|       | |___________________|    ''    |");
      System.out.println("\t\t          |  |  ''    |/__ /     \\/__/       |/_____________________/        |/___________________/     ''    |");
      System.out.println("\t\t          |  |  ''                                                                                      ''    |");
      System.out.println("\t\t          |  |  ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''    |");
      System.out.println("\t\t          |  |  ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''    |");
      System.out.println("\t\t          |  |________________________________________________________________________________________________|");
      System.out.println("\t\t          | /                                                                                                /");
      System.out.println("\t\t          |/________________________________________________________________________________________________/");
     
        }

        else if(Logo%3==2){
        System.out.println("\t\t     [@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@] ");
        System.out.println("\t\t     [@]                                                                  [@] ");
	System.out.println("\t\t     [@]  K K      K K    BBBBBBBBBBBBBBBBBBBBB     CCCCCCCCCCCCCCCCCCCC  [@] ");
        System.out.println("\t\t     [@]  K K     K K     B BBBBBBBBBBBBBBBBB B     C CCCCCCCCCCCCCCCCCC  [@] ");
        System.out.println("\t\t     [@]  K K    K K      B B               B B     C C                   [@] ");
        System.out.println("\t\t     [@]  K K   K K       B B               B B     C C                   [@] ");
        System.out.println("\t\t     [@]  K K  K K        B B               B B     C C                   [@] ");
        System.out.println("\t\t     [@]  K K K K         B B               B B     C C                   [@] ");
        System.out.println("\t\t     [@]  K KK K          B BBBBBBBBBBBBBBBBB B     C C                   [@] ");
        System.out.println("\t\t     [@]  K   K           B BBBBBBBBBBBBBBBBB B     C C                   [@] ");
        System.out.println("\t\t     [@]  K KK K          B B               B B     C C                   [@] ");
        System.out.println("\t\t     [@]  K K K K         B B               B B     C C                   [@] ");
        System.out.println("\t\t     [@]  K K  K K        B B               B B     C C                   [@] ");
        System.out.println("\t\t     [@]  K K   K K       B B               B B     C C                   [@] ");
        System.out.println("\t\t     [@]  K K    K K      B B               B B     C C                   [@] ");
        System.out.println("\t\t     [@]  K K     K K     B BBBBBBBBBBBBBBBBB B     C CCCCCCCCCCCCCCCCCC  [@] ");
        System.out.println("\t\t     [@]  K K      K K    BBBBBBBBBBBBBBBBBBBBB     CCCCCCCCCCCCCCCCCCCC  [@] ");
        System.out.println("\t\t     [@]                                                                  [@] ");
        System.out.println("\t\t     [@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@][@] ");

     
        
        
        
            
        }
                else if(Logo%3==1){
System.out.println("\t\t                                                                          ");
System.out.println("\t\t           •••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••    ");
System.out.println("\t\t         •••                                                                   •••   ");
System.out.println("\t\t        ••••    ¶ ¶      ¶ ¶      ¶¶¶¶¶¶¶¶¶¶¶¶¶¶       ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶     ••••    ");
System.out.println("\t\t       •••••    ¶ ¶     ¶ ¶       ¶ ¶¶¶¶¶¶¶¶¶¶¶ ¶      ¶ ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶     •••••   ");
System.out.println("\t\t      ••••••    ¶ ¶    ¶ ¶        ¶ ¶          ¶ ¶     ¶ ¶                     ••••••   ");
System.out.println("\t\t     •••••••    ¶ ¶   ¶ ¶         ¶ ¶           ¶ ¶    ¶ ¶                     •••••••   ");
System.out.println("\t\t    ••••••••    ¶ ¶  ¶ ¶          ¶ ¶           ¶ ¶    ¶ ¶                     ••••••••   ");
System.out.println("\t\t   •••••••••    ¶ ¶ ¶ ¶           ¶ ¶          ¶ ¶     ¶ ¶                     •••••••••   ");
System.out.println("\t\t  ••••••••••    ¶ ¶¶ ¶            ¶ ¶¶¶¶¶¶¶¶¶¶¶ ¶      ¶ ¶                     ••••••••••   ");
System.out.println("\t\t   •••••••••    § §§ §            § §§§§§§§§§§§ §      § §                     •••••••••  ");
System.out.println("\t\t    ••••••••    § § § §           § §          § §     § §                     ••••••••   ");
System.out.println("\t\t     •••••••    § §  § §          § §           § §    § §                     •••••••   ");
System.out.println("\t\t      ••••••    § §   § §         § §          § §     § §                     ••••••  ");
System.out.println("\t\t       •••••    § §    § §        § §§§§§§§§§§§ §      § §§§§§§§§§§§§§§§§§§    ••••  ");
System.out.println("\t\t        ••••    § §     § §       §§§§§§§§§§§§§§       §§§§§§§§§§§§§§§§§§§§    •••   ");
System.out.println("\t\t         •••                                                                   •• ");
System.out.println("\t\t          ••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••    ");
System.out.println("\t\t     ");
        }
             else    {
            

	System.out.print("                        _______________________________________________________  \n");
	System.out.print("                      /|                                                       | \n");
	System.out.print("                     | |  * *     * *    * ** ** ** ** *   * ** ** ** ** **    | \n");
	System.out.print("                     | |  * *    * *     * ** ** ** ** *   * ** ** ** ** **    | \n");
        System.out.print("                     | |  * *   * *      * *         * *   * *                 | \n");
        System.out.print("                     | |  * *  * *       * *         * *   * *                 | \n");
	System.out.print("                     | |  * * * *        * *         * *   * *                 | \n");
	System.out.print("                     | |  * *  *         * ** ** ** ** *   * *                 | \n");
	System.out.print("                     | |  * * * *        * ** ** ** ** *   * *                 | \n");
        System.out.print("                     | |  * *  * *       * *         * *   * *                 | \n");
        System.out.print("                     | |  * *   * *      * *         * *   * *                 | \n");
        System.out.print("                     | |  * *    * *     * ** ** ** ** *   * ** ** ** ** **    | \n");
	System.out.print("                     | |  * *     * *.   * ** ** ** ** * . * ** ** ** ** **    | \n");
	System.out.print("                     | |_______________________________________________________| \n");
	System.out.print("                     |/_______________________________________________________/\n"); 
            
        }
    
          
        
          System.out.print("\nCreated by:-");
          Thread.sleep(500);
          System.out.print("R");
          Thread.sleep(500);
          System.out.print("o");
          Thread.sleep(500);
          System.out.print("x");
          Thread.sleep(500);
          System.out.print(" S");
          Thread.sleep(500);
          System.out.print("t");
          Thread.sleep(500);
          System.out.print("u");
           Thread.sleep(500);
          System.out.print("d");
          Thread.sleep(500);
          System.out.print("i");
          Thread.sleep(500);
          System.out.print("o");
        
                    Thread.sleep(2500);
                    
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
          System.out.println("++++++++++++++++++++++++++");
          System.out.println("+   Enter Your choice    +");
          System.out.println("++++++++++++++++++++++++++");
          System.out.println("+ 1.Play                 +");
          System.out.println("++++++++++++++++++++++++++");
           for(int clr=1;clr<=25;clr++){
          System.out.println("");}          
          Thread.sleep(1100);
       
          System.out.println("++++++++++++++++++++++++++");
          System.out.println("+   Enter Your choice    +");
          System.out.println("++++++++++++++++++++++++++");
          System.out.println("+ 1.Play                 +");
          System.out.println("+ 2.Practise zone        +");
          System.out.println("++++++++++++++++++++++++++");
             for(int clr=1;clr<=24;clr++){
          System.out.println("");} 
                    Thread.sleep(1100);
           for(int clr=1;clr<=25;clr++){
          System.out.println("");} 
          System.out.println("++++++++++++++++++++++++++");
          System.out.println("+   Enter Your choice    +");
          System.out.println("++++++++++++++++++++++++++");
          System.out.println("+ 1.Play                 +");
          System.out.println("+ 2.Practise zone        +");
          System.out.println("+ 3.Your last Score      +");
          System.out.println("++++++++++++++++++++++++++");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");} 
          
          Thread.sleep(1100);
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
          System.out.println("++++++++++++++++++++++++++");
          System.out.println("+   Enter Your choice    +");
          System.out.println("++++++++++++++++++++++++++");
          System.out.println("+ 1.Play                 +");
          System.out.println("+ 2.Practise zone        +");
          System.out.println("+ 3.Your last Score      +");
          System.out.println("+ 4.High Score           +");
          System.out.println("++++++++++++++++++++++++++");
        
          for(int clr=1;clr<=22;clr++){
          System.out.println("");}
             Thread.sleep(1100);
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
          System.out.println("++++++++++++++++++++++++++");
          System.out.println("+   Enter Your choice    +");
          System.out.println("++++++++++++++++++++++++++");
          System.out.println("+ 1.Play                 +");
          System.out.println("+ 2.Practise zone        +");
          System.out.println("+ 3.Your last Score      +");
          System.out.println("+ 4.High Score           +");
          System.out.println("+ 5.Help                 +");
          System.out.println("++++++++++++++++++++++++++");
        
          for(int clr=1;clr<=21;clr++){
          System.out.println("");}
             Thread.sleep(1100);

          System.out.println("++++++++++++++++++++++++++");
          System.out.println("+   Enter Your choice    +");
          System.out.println("++++++++++++++++++++++++++");
          System.out.println("+ 1.Play                 +");
          System.out.println("+ 2.Practise zone        +");
          System.out.println("+ 3.Your last Score      +");
          System.out.println("+ 4.High Score           +");
          System.out.println("+ 5.Help                 +");
          System.out.println("+ 6.Exit                 +");
          System.out.println("++++++++++++++++++++++++++");
           for(int clr=1;clr<=19;clr++){
          System.out.println("");}
         System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n"); 
        int enter=m.nextInt();
                         
     
       if(enter==1){ 
      System.out.println("\nTo Register for the game full fill the requirement");
      System.out.println("\nEnter your name:-");
      sname=m.next();
       
      
 
      
      System.out.println("Enter your Age:-");
       age=m.nextInt();
      int rs=statement.executeUpdate("insert into score(name,age) values('"+sname+"',"+age+");");
    int sc=statement.executeUpdate("update score set score=0 where name like '"+sname+"' && age="+age+";");
    
    
      
      System.out.println("Hello "+sname+" welcome to K.B.C");
       
      {
          for(int b=1;b<=5;b++){
       for(int a=1;a<=22;a++){
        System.out.println();} 
    System.out.println("   •  ") ;  
    System.out.println("   •  ");
    System.out.println("   •  ");
for(int a=1;a<=26;a++){
        System.out.println();}
System.out.println("Loading");
Thread.sleep(250);
  System.out.println();
  System.out.println();
    System.out.println("    •  ") ;  
    System.out.println("   •  ");
    System.out.println("  •  ");   
    for(int a=1;a<=26;a++){
        System.out.println();}
    System.out.println("Loading..");
Thread.sleep(250);
System.out.println();
System.out.println();
    System.out.println("      ") ;  
    System.out.println("•  •  • ");
    System.out.println("    ");   
    for(int a=1;a<=26;a++){
        System.out.println();}
    System.out.println("Loading...");
Thread.sleep(250);
System.out.println();
System.out.println();
    System.out.println("  •   ") ;  
    System.out.println("   •  ");
    System.out.println("    •");   
    for(int a=1;a<=26;a++){
        System.out.println();}
        System.out.println("Loading...");
 }
 System.out.println();
 System.out.println("\n");
    System.out.println("   •  ") ;  
    System.out.println("   •  ");
    System.out.println("   •  ");
for(int a=1;a<=26;a++){
        System.out.println();}
System.out.println("Done.....");
    Thread.sleep(1000);}
      if(age<100){
          System.out.println("\n\n\n\n\t\t\tFastest Finger Question");
          long fq=System.currentTimeMillis();
          
          if(fq%3==1){
            System.out.println("Arrange these words in the correct order to form a Hindi Proverb–");
          System.out.println("A Dum                            B Karna \n");
          System.out.println("C Naak                           D Mein    ");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          String ffq=m.next();
          switch(ffq){
              case "CDAB":
              case "cdab":
              break;
              default :
                  return;
          }
          }
          else if(fq%3==2){     
          System.out.println("Arrange these words in the correct order to form the slogan of the Pulse Polio campaign in India ?");
          System.out.println("(A) Zindagi                       (B) Do  \n");
          System.out.println("(C) Boond                         (D) Ki    ");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          String ffq=m.next();
          switch(ffq){
              case "bcad":
              case "BCAD":
              break;
              default :
                  return;
          }
              
              
          }
          else{
          System.out.println("Starting with the earliest, arrange the following events in Narendra Modi’s life in chronological order.");
          System.out.println("(A) CM of Gujarat                 (B) Took oath as PM \n");
          System.out.println("(C) Joined BJP                    (D) Became RSS Pracharak    ");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          String ffq=m.next();
          switch(ffq){
              case "DCAB":
              case "dcab":
              break;
              default :
                  return;
          }
          
          }
      
 
          move :
      {
          long change=System.currentTimeMillis();
          if(change%2==0){
          
          System.out.println("\t\t\t\t\t\t _____________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 5000 is |");
          System.out.println("Which of the following name means “Person of long age “?                               \t\t|-----------Lifeline------------|");
          System.out.println("(A) Abhitabh                  (B) Arunodaya                                           \t\t| Type lifeline                 |");
          System.out.println("                                                                                      \t\t|-------------------------------|");
          System.out.println("(C) Abhishek                  (D) Ayushmaan");
          }
          else{
          System.out.println("\t\t\t\t\t\t _____________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 5000 is |");
          System.out.println("In the game of ludo the discs or tokens are of how many colours? “?                    \t\t|-----------Lifeline------------|");
          System.out.println("(A) Three                           (B) Two                                            \t\t| Type lifeline                 |");
          System.out.println("                                                                                       \t\t|-------------------------------|");
          System.out.println("(c) One                             (D) Four");
              
          }
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
           long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
          switch(sss)
          {
              case "d":
              case "D":
        
          System.out.println("yes you are right you won Rs.5,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.10,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(4);
            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "d":
              case "D":
     
          System.out.println("yes you are right you won Rs.5,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.10,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
            x.lifeline(4); 
            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "d":
              case "D":
          
        
          System.out.println("yes you are right you won Rs.5,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.10,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move;
           default :
            System.out.println("Sorry You are wrong today you won Nothing");
               return;
          }
           default :
            System.out.println("Sorry You are wrong today you won Nothing");
          return;
          }          
           default :
            System.out.println("Sorry You are wrong today you won Nothing");
         return; 
         }
         
      
          

                  
      }    
       //********************************************************************************************************************************************
       //********************************************************************************************************************************************   
    
          move1 :
      {
                    long change=System.currentTimeMillis();
  if(change%2==1){
          System.out.println("\t\t\t\t\t\t _____________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 10,000 is |");
          System.out.println("How is the call of a chicken usually expressed?                                       \t\t|-----------Lifeline------------|");
          System.out.println("(A) Denchu Dencu             (B) Kukro Koo                                            \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                      \t\t|-------------------------------|");
          System.out.println("(C) Peehu Peehu              (D) Guta Goo");
  }else{
          System.out.println("\t\t\t\t\t\t _____________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 10,000 is |");
          System.out.println("How many rings are there in an Olympic Flag?                                          \t\t|-----------Lifeline------------|");
          System.out.println("(A) 2              (B) 5                                                              \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                      \t\t|-------------------------------|");
          System.out.println("(C) 3              (D) 4");
  }
  
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                     long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "b":
              case "B":
         
                 
          System.out.println("yes you are right you won Rs.10,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.20,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move1;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
           System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");      
           x.lifeline(2);
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "b":
              case "B":
      
          System.out.println("yes you are right you won Rs.10,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.20,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move1;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=100;asd++){
          System.out.println("");
           }
           x.lifeline(2);
           System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "b":
              case "B":
       
          System.out.println("yes you are right you won Rs.10,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.20,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move1;
           default :
            System.out.println("Sorry You are wrong today you won nothing");
               return;
          }
           default :
            System.out.println("Sorry You are wrong today you won nothing");
          return;
          }          
           default :
            System.out.println("Sorry You are wrong today you won nothing");
         return; 
         }
         }
       
          
       //********************************************************************************************************************************************
       //******************************************************************************************************************************************** 
         
          move2 :
      {
          long change=System.currentTimeMillis();
          if(change%2==1){
          System.out.println("\t\t\t\t\t\t _____________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 20,000 is |");
          System.out.println("Seeds of which of these flowers are used to produce a edible oil ?                    \t\t|-----------Lifeline------------|");
          System.out.println("(A) Genda                            (B) Guldaudi                                     \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                      \t\t|-------------------------------|");
          System.out.println("(C) Arhul                            (D) Surajmukhi");
          }else{
          System.out.println("\t\t\t\t\t\t _____________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 20,000 is |");
          System.out.println("In which commonwealth games did flying Sikh Milkha Singh win the first gold medal for India?   \t\t|-----------Lifeline------------|");
          System.out.println("(A) 1934. London                     (B) 1938. Sidney                                          \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                               \t\t|-------------------------------|");
          System.out.println("(C) 1950. Auckland                   (D) 1958. Cardiff ");
              
          }
          
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
          long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "d":
              case "D":
         
          System.out.println("yes you are right you won Rs.20,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.40,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move2;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(4);
            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");    
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "d":
              case "D":
        
          System.out.println("yes you are right you won Rs.20,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.40,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move2;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(4);
            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");    
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "d":
              case "D":
       
          System.out.println("yes you are right you won Rs.20,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.40,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move2;
           default :
            System.out.println("Sorry You are wrong today you won nothing");
               return;
          }
           default :
            System.out.println("Sorry You are wrong today you won nothing");
          return;
          }          
           default :
            System.out.println("Sorry You are wrong today you won nothing");
         return; 
         }
         }
       //********************************************************************************************************************************************
       //******************************************************************************************************************************************** 
           
          move3 :
      {
          long change=System.currentTimeMillis();
          if(change%2==1){
          System.out.println("\t\t\t\t\t\t _______________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 40,000 is |");
          System.out.println("According to a TV ad, Which duo goes to the tailor and says ,“Masterji, pitaji ki patloon ek bilang chhoti kar do” ?\t\t|-----------Lifeline------------|");
          System.out.println("(A) Hari – Harish                             (B) Ramesh – Suresh                                                   \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                                                    \t\t|-------------------------------|");
          System.out.println("(C) Santa – Banta                             (D) Ajay – Vijay");
          }
          else{
          System.out.println("\t\t\t\t\t\t _______________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 40,000 is |");
          System.out.println("When and where will Nineteenth Commonwealth games be held ?                     \t\t|-----------Lifeline------------|");
          System.out.println("(A)2010 Melbourne                    (B) 2010 New Delhi                         \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                \t\t|-------------------------------|");
          System.out.println("(C) 2010 Canada                      (D) 2010 Pakistan ");
          }
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "b":
              case "B":
           int sc1=statement.executeUpdate("update score set score=80000 where name like '"+sname+"' && age="+age+";");     
          System.out.println("yes you are right you won Rs.40,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.80,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move3;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(2);
           System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");              
           first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "b":
              case "B":
                  
           sc1=statement.executeUpdate("update score set score=40000 where name like '"+sname+"' && age="+age+";");       
          System.out.println("yes you are right you won Rs.40,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.80,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move3;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(2);
            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                       first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "b":
              case "B":
           sc1=statement.executeUpdate("update score set score=40000 where name like '"+sname+"' && age="+age+";");     
          System.out.println("yes you are right you won Rs.40,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.80,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move3;
           default :
            System.out.println("Sorry You are wrong today you won nothing");
               return;
          }
           default :
            System.out.println("Sorry You are wrong today you won nothing");
          return;
          }          
           default :
            System.out.println("Sorry You are wrong today you won nothing");
         return; 
         }
         }
       //********************************************************************************************************************************************
       //******************************************************************************************************************************************** 
       
          move4 :
      {
          long change=System.currentTimeMillis();
          
          if(change%2==1){
          System.out.println("\t\t\t\t\t\t _____________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 80,000 is |");
          System.out.println("In which sport has Jwala Gutta been a 13-time National Champion?                      \t\t|-----------Lifeline------------|");
          System.out.println("(A) Badminton                       (B) Chess                                         \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                      \t\t|-------------------------------|");
          System.out.println("(C) Squash                          (D) Table Tennis");
          }
          else{
          System.out.println("\t\t\t\t\t\t _____________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 80,000 is |");
          System.out.println("On which date is Nobel Prize awarded?                                                 \t\t|-----------Lifeline------------|");
          System.out.println("(A) December 10                     (B) January 10                                    \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                      \t\t|-------------------------------|");
          System.out.println("(C) April 10                        (D) July 10");
          }
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "a":
              case "A":
          System.out.println("yes you are right you won Rs.80,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.1,60,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
           System.out.println("\b");}
                  x.lifeline(1);
           System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");   
             
              first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "a":
              case "A":
          System.out.println("yes you are right you won Rs.80,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.1,60,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
           System.out.println("\b");}
                  x.lifeline(1);
            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "a":
              case "A":
          System.out.println("yes you are right you won Rs.80,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.1,60,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
           default :
            System.out.println("You are wrong today you won Only 40,000");
               return;
          }
           default :
            System.out.println("You are wrong today you won Only 40,000");
          return;
          }          
           default :
            System.out.println("You are wrong today you won Only 40,000");
         return; 
         }
         }
       //********************************************************************************************************************************************
       //******************************************************************************************************************************************** 
         
          move5 :
      {
          long change=System.currentTimeMillis();
          if(change%2==1){
          System.out.println("\t\t\t\t\t\t _________________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 1,60,000 is |");
          System.out.println("Which of these organs helps in maintaining the sense of balance or equilibrium of our body\t\t|-----------Lifeline------------|");
          System.out.println("(A) Nose                                 (B) Ears                                         \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                          \t\t|-------------------------------|");
          System.out.println("(C) Tongue                               (D) Lungs");
          }
          else{
          System.out.println("\t\t\t\t\t\t _________________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 1,60,000 is |");
          System.out.println("Who was the Chairman of the Drafting committee of the Constituent of India?               \t\t|-----------Lifeline------------|");
          System.out.println("(A) Rajaendra Prasad                   (B) B. R. Ambedkar                                 \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                          \t\t|-------------------------------|");
          System.out.println("(C) Vallabhbhai Prasad                 (D) G. V. Mavalankar");
              
          }
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "b":
              case "B":
          System.out.println("yes you are right you won Rs.1,60,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.3,20,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move5;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(2);
             System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
                  
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "b":
              case "B":
          System.out.println("yes you are right you won Rs.1,60,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.3,20,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move5;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(2);
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "b":
              case "B":
          System.out.println("yes you are right you won Rs.1,60,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.3,20,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move5;
           default :
            System.out.println("You are wrong today you won Only 40,000");
               return;
          }
           default :
            System.out.println("You are wrong today you won Only 40,000");
          return;
          }          
           default :
            System.out.println("You are wrong today you won Only 40,000");
         return; 
         }
         }
            
       //********************************************************************************************************************************************
       //******************************************************************************************************************************************** 
    
          move4 :
      {
          long change=System.currentTimeMillis();
          if(change%2==1){
          System.out.println("\t\t\t\t\t\t _________________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 3,20,000 is |");
          System.out.println("People from which of these professions are most likely to use ‘aari’, ‘basula’ and ‘burma’ at their work?\t\t|-----------Lifeline------------|");
          System.out.println("(A) Tailor                                      (B) Washerman                                         \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                                      \t\t|-------------------------------|");
          System.out.println("(C) Carpenter                                   (D) Painter");
          }
          else{
          System.out.println("\t\t\t\t\t\t _________________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 3,20,000 is |");
          System.out.println("Which Bank is known as Banker of Bank(Provide support to the bank) ?                              \t\t|-----------Lifeline------------|");
          System.out.println("(A)State bank of india                  (B) Punjab National Bank                                   \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                                  \t\t|-------------------------------|");
          System.out.println("(C)Reserve Bank of India                (D) ICIC Bank");
              
          }
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
          long timer=second-first;
          if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "c":
              case "C":
          System.out.println("yes you are right you won Rs.3,20,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.6,40,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(3);
                           first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "c":
              case "C":
          System.out.println("yes you are right you won Rs.3,20,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.6,40,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(3);
             first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "c":
              case "C":
          System.out.println("yes you are right you won Rs.3,20,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.6,40,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
           default :
            System.out.println("You are wrong today you won Only 40,000");
               return;
          }
           default :
            System.out.println("You are wrong today you won Only 40,000");
          return;
          }          
           default :
            System.out.println("You are wrong today you won Only 40,000");
         return; 
         }
         }
       //********************************************************************************************************************************************
       //******************************************************************************************************************************************** 
       
          move4 :
      {
          long change=System.currentTimeMillis();
          if(change%2==1){
          System.out.println("\t\t\t\t\t\t _________________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 6,40,000 is |");
          System.out.println("Which of the following animals do not have external ears?                             \t\t|-----------Lifeline------------|");
          System.out.println("(A) Cat                               (B) Bat                                         \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                      \t\t|-------------------------------|");
          System.out.println("(C) Rat                               (D) Snake");
          }
          else{
          System.out.println("\t\t\t\t\t\t _________________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 6,40,000 is |");
          System.out.println("According to the song from ‘Sholay’, “Koi Haseena Jab Rooth Jaati Hai, Toh Aur Bhi_____________ ” ? \t\t|-----------Lifeline------------|");
          System.out.println("(A) Rangeen Ho Jaati Hai                    (B) Shareef Ho Jaati Hai                              \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                                  \t\t|-------------------------------|");
          System.out.println("(C) Namkeen Ho Jaati Hai                    (D) Haseen Ho Jaati Hai");
              
          }
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "d":
              case "D":
          int sc2=statement.executeUpdate("update score set score=640000 where name like '"+sname+"' && age="+age+";");         
          System.out.println("yes you are right you won Rs.6,40,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.12,50,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(4);
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "d":
              case "D":
          sc2=statement.executeUpdate("update score set score=640000 where name like '"+sname+"' && age="+age+";");        
          System.out.println("yes you are right you won Rs.6,40,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.12,50,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(4);
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "d":
              case "D":
          sc2=statement.executeUpdate("update score set score=640000 where name like '"+sname+"' && age="+age+";");        
          System.out.println("yes you are right you won Rs.6,40,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.12,50,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
           default :
            System.out.println("You are wrong today you won Only 40,000");
               return;
          }
           default :
            System.out.println("You are wrong today you won Only 40,000");
          return;
          }          
           default :
            System.out.println("You are wrong today you won Only 40,000");
         return; 
         }
         }
       //********************************************************************************************************************************************
       //******************************************************************************************************************************************** 
            
          move4 :
      {
          System.out.println("\t\t\t\t\t\t __________________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 12,50,000 is |");
          System.out.println("Which of these national parks, reserved for tigers, is named after a river?           \t\t|-----------Lifeline------------|");
          System.out.println("(A) Indrawati                         (B) Sunderbans                                  \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                      \t\t|-------------------------------|");
          System.out.println("(C) Dudhwa                            (D) Kanha");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "a":
              case "A":
                
          System.out.println("yes you are right you won Rs.12,50,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.25,00,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(1);
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "a":
              case "A":
               
          System.out.println("yes you are right you won Rs.12,50,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.25,00,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(1);
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "a":
              case "A":
             
          System.out.println("yes you are right you won Rs.12,50,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.25,00,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
           default :
            System.out.println("You are wrong today you won Only Rs.6,40,000/-");
               return;
          }
           default :
            System.out.println("You are wrong today you won Only 6,40,000/-");
          return;
          }          
           default :
            System.out.println("You are wrong today you won Only 6,40,000/-");
         return; 
         }
         }
       //********************************************************************************************************************************************
       //********************************************************************************************************************************************
       
          move4 :
      {
          System.out.println("\t\t\t\t\t\t __________________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 25,00,000 is |");
          System.out.println("Who was the Chairman of the Drafting committee of the Constituent of India?           \t\t|-----------Lifeline------------|");
          System.out.println("(A) Rajaendra Prasad                  (B) B. R. Ambedkar                              \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                      \t\t|-------------------------------|");
          System.out.println("(C) Vallabhbhai Prasad                (D) G. V. Mavalankar");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "b":
              case "B":
          System.out.println("yes you are right you won Rs.12,50,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.25,00,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(2);
                           first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "b":
              case "B":
          System.out.println("yes you are right you won Rs.12,50,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.25,00,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(2);
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "b":
              case "B":
          System.out.println("yes you are right you won Rs.12,50,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.25,00,000");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
           default :
            System.out.println("You are wrong today you won Only Rs.6,40,000/-");
               return;
          }
           default :
            System.out.println("You are wrong today you won Only 6,40,000/-");
          return;
          }          
           default :
            System.out.println("You are wrong today you won Only 6,40,000/-");
         return; 
         }
         }
       //********************************************************************************************************************************************
       //******************************************************************************************************************************************** 
  
   
       //********************************************************************************************************************************************
       //******************************************************************************************************************************************** 
     
          move4 :
      {
          System.out.println("\t\t\t\t\t\t _____________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 60,00,000 is |");
          System.out.println("The wife of which of these famous sportspersons was once captain of Indian volleyball team?   \t\t|-----------Lifeline------------|");
          System.out.println("(A) K.D.Jadav                             (B) Milkha Singh                                     \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                              \t\t|-------------------------------|");
          System.out.println("(C)Dhyan Chand                            (D) Prakash Padukone");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                     long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "b":
              case "B":
          System.out.println("yes you are right you won Rs.60,00,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.1 Crore");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(2);
                          first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "b":
              case "B":
          System.out.println("yes you are right you won Rs.60,00,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.1 Crore");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(2);
                       first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "b":
              case "B":
          System.out.println("yes you are right you won Rs.60,00,000");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.1 Crore");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
           default :
            System.out.println("You are wrong today you won Only Rs.6,40,000/-");
               return;
          }
           default :
            System.out.println("You are wrong today you won Only 6,40,000/-");
          return;
          }          
           default :
            System.out.println("You are wrong today you won Only 6,40,000/-");
         return; 
         }
         }
       //********************************************************************************************************************************************
       //******************************************************************************************************************************************** 
                   
          move4 :
      {
          System.out.println("\t\t\t\t\t\t _____________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 1 Crore is |");
          System.out.println("Who was the first Indian to be President of UN General assembly ?                     \t\t|-----------Lifeline------------|");
          System.out.println("(A) Mrs. Vijay Lakshmi Pandit          (B) Ramesh Bhandari                            \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                      \t\t|-------------------------------|");
          System.out.println("(C) Natwar Singh                       (D) Krishna Menon");
                    System.out.println("Who was the first Indian to be President of UN General assembly ?");
          System.out.println("A.Mrs. Vijay Lakshmi Pandit\t\t\tB. Ramesh Bhandari\n");
          System.out.println("C.Natwar Singh\t\t\tD.Krishna Menon");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "a":
              case "A":
          int sc3=statement.executeUpdate("update score set score=10000000 where name like '"+sname+"' && age="+age+";");        
          System.out.println("yes you are right you won Rs.1 Crore");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.3 Crore");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(1);
                          first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "a":
              case "A":
          sc3=statement.executeUpdate("update score set score=10000000 where name like '"+sname+"' && age="+age+";");          
          System.out.println("yes you are right you won Rs.1 Crore");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.3 Crore");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(1);
                        first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "a":
              case "A":
          sc3=statement.executeUpdate("update score set score=10000000 where name like '"+sname+"' && age="+age+";");          
          System.out.println("yes you are right you won Rs.1 Crore");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.3 Crore");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
           default :
            System.out.println("You are wrong today you won Only Rs.6,40,000/-");
               return;
          }
           default :
            System.out.println("You are wrong today you won Only 6,40,000/-");
          return;
          }          
           default :
            System.out.println("You are wrong today you won Only 6,40,000/-");
         return; 
         }
         }
       //********************************************************************************************************************************************
       //********************************************************************************************************************************************                                                                                 
     
          move4 :
      {
          System.out.println("\t\t\t\t\t\t _____________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 3 Crore is |");
          System.out.println("Which Indian Scientist has had the distinction of receiving not only the Nobel Prize, but also Bharat Ratna ?\t\t|-----------Lifeline------------|");
          System.out.println("(A) Dr. Mitali Mukherjee                       (B) A.P.J Abdul Kalam                                         \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                                             \t\t|-------------------------------|");
          System.out.println("(C) Narayan Murthy                             (D)Dr. C. V. Raman");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "d":
              case "D":
                
          System.out.println("yes you are right you won Rs.3 Crore");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.5 Crore");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(4);
                           first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "d":
              case "D":
                  
          System.out.println("yes you are right you won Rs.3 Crore");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.5 Crore");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(4);
                       first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
       switch(sss)
          {
              case "d":
              case "D":
               
          System.out.println("yes you are right you won Rs.3 Crore");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.5 Crore");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
           default :
            System.out.println("You are wrong today you won Only Rs.1 Crore/-");
               return;
          }
           default :
            System.out.println("You are wrong today you won Only Rs.1 Crore/-");
          return;
          }          
           default :
            System.out.println("You are wrong today you won Only Rs.1 Crore/-");
         return; 
         }
         }
       //********************************************************************************************************************************************
       //******************************************************************************************************************************************** 
 
    move4 :
      {
          System.out.println("\t\t\t\t\t\t _____________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 5 Crore is |");
          System.out.println(" Who was the Indian who won the gold medal for the first time in Olympic in shooting event.     \t\t|-----------Lifeline------------|");
          System.out.println("(A) K.D. Jadhav                        (B) Major Rajyawardhan Rathor                            \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                                \t\t|-------------------------------|");
          System.out.println("(C) Abhinav Bindra                     (D) Samser Jang ");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "c":
              case "C":
          System.out.println("yes you are right you won Rs.5 Crore");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.7 Crore");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(3);
                            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "c":
              case "C":
          System.out.println("yes you are right you won Rs.5 Crore");
          Thread.sleep(1600);
          System.out.println("\nYour Last question for Rs.7 Crore");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(3);
           sss=m.next();
       switch(sss)
          {
              case "c":
              case "C":
          System.out.println("yes you are right you won Rs.5 Crore");
          Thread.sleep(1600);
          System.out.println("\nYour next question for Rs.7 Crore");
          Thread.sleep(2000);
         for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");} 
             break move4;
           default :
            System.out.println("You are wrong today you won Only Rs.1 Crore");
               return;
          }
           default :
            System.out.println("You are wrong today you won Only Rs.1Crore");
          return;
          }          
           default :
            System.out.println("You are wrong today you won Only Rs.1 Crore/-");
         return; 
         }
         }
     /* */
         
       //********************************************************************************************************************************************
       //********************************************************************************************************************************************                            
      move4 :
      {
          System.out.println("\t\t\t\t\t\t ________________________________");
          System.out.println("\t\t\t\t\t\t|your Question for Rs 7 Crore is |");
          System.out.println("Who was the first Indian woman to take part in Olympic Games?                         \t\t|-----------Lifeline------------|");
          System.out.println("(A) Merry La RO                 (B) P.T.Usha                                          \t\t|Type lifeline\t\t\t|");
          System.out.println("                                                                                      \t\t|-------------------------------|");
          System.out.println("(B) Anju B.G.                   (D) K.Malleshwree ");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          long first=System.currentTimeMillis();
          String sss=m.next();
          long second=System.currentTimeMillis();
           long timer=second-first;
           if(timer>31000){                  
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                  Thread.sleep(1500);
           
                  return;
           }
         switch(sss)
          {
              case "a":
              case "A":
       int sc4=statement.executeUpdate("update score set score=70000000 where name like '"+sname+"' && age="+age+";");  
          System.out.println("yes you are right you won Rs.7 Crore\n");
          Thread.sleep(500);
          for(int asd=1;asd<=100;asd++){
          System.out.println("");}
          for(int win=1;win<=4;win++){
          
          System.out.println("\t\t\t\t************************************You Won*************************************");
          System.out.println("\t\t\t\t*                                                                              *");
          System.out.println("\t\t\t\t*   W       W   IIIIIIIIIIII   N       N   N       N   EEEEEEEE   RRRRRRRR     *  ");
          System.out.println("\t\t\t\t*   W       W        II        N N     N   N N     N   EE         R       R    *  ");
          System.out.println("\t\t\t\t*   W       W        II        N  N    N   N  N    N   EE         R       R    *  ");
          System.out.println("\t\t\t\t*   W   W   W        II        N   N   N   N   N   N   EEEEEEEE   RRRRRRRR     *  ");
          System.out.println("\t\t\t\t*   W  W W  W        II        N    N  N   N    N  N   EE         R R          *  ");
          System.out.println("\t\t\t\t*   W W   W W        II        N     N N   N     N N   EE         R   R        * ");
          System.out.println("\t\t\t\t*   WW     WW   IIIIIIIIIIII   N       N   N       N   EEEEEEEE   R     R      *  ");
          System.out.println("\t\t\t\t*                                                                              *");
          System.out.println("\t\t\t\t************************************You Won*************************************");
          for(int asd=1;asd<=18;asd++){
          System.out.println("");}
          Thread.sleep(500);
         for(int asd=1;asd<=18;asd++){
          System.out.println("");}
          System.out.println("\t\t\t\t++++++++++++++++++++++++++++++++++++You Won+++++++++++++++++++++++++++++++++++++");
          System.out.println("\t\t\t\t+                                                                              +");
          System.out.println("\t\t\t\t+   +       +   ++++++++++++   +       +   +       +   ++++++++   ++++++++     +  ");
          System.out.println("\t\t\t\t+   +       +        ++        + +     +   + +     +   ++         +       +    +  ");
          System.out.println("\t\t\t\t+   +       +        ++        +  +    +   +  +    +   ++         +       +    +  ");
          System.out.println("\t\t\t\t+   +   +   +        ++        +   +   +   +   +   +   ++++++++   ++++++++     +  ");
          System.out.println("\t\t\t\t+   +  + +  +        ++        +    +  +   +    +  +   ++         + +          +  ");
          System.out.println("\t\t\t\t+   + +   + +        ++        +     + +   +     + +   ++         +   +        + ");
          System.out.println("\t\t\t\t+   ++     ++   ++++++++++++   +       +   +       +   ++++++++   +     +      +  ");
          System.out.println("\t\t\t\t+                                                                              +");
          System.out.println("\t\t\t\t++++++++++++++++++++++++++++++++++++You Won+++++++++++++++++++++++++++++++++++++");
                   for(int asd=1;asd<=18;asd++){
          System.out.println("");} 
          Thread.sleep(500);
                   for(int asd=1;asd<=18;asd++){
          System.out.println("");}
          System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~You Won~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
          System.out.println("\t\t\t\t~                                                                              ~");
          System.out.println("\t\t\t\t~   ~       ~   ~~~~~~~~~~~~   ~       ~   ~       ~   ~~~~~~~~   ~~~~~~~~     ~  ");
          System.out.println("\t\t\t\t~   ~       ~        ~~        ~ ~     ~   ~ ~     ~   ~~         ~       ~    ~  ");
          System.out.println("\t\t\t\t~   ~       ~        ~~        ~  ~    ~   ~  ~    ~   ~~         ~       ~    ~  ");
          System.out.println("\t\t\t\t~   ~   ~   ~        ~~        ~   ~   ~   ~   ~   ~   ~~~~~~~~   ~~~~~~~~     ~  ");
          System.out.println("\t\t\t\t~   ~  ~ ~  ~        ~~        ~    ~  ~   ~    ~  ~   ~~         ~ ~          ~  ");
          System.out.println("\t\t\t\t~   ~ ~   ~ ~        ~~        ~     ~ ~   ~     ~ ~   ~~         ~   ~        ~ ");
          System.out.println("\t\t\t\t~   ~~     ~~   ~~~~~~~~~~~~   ~       ~   ~       ~   ~~~~~~~~   ~     ~      ~  ");
          System.out.println("\t\t\t\t~                                                                              ~");
          System.out.println("\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~You Won~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                   for(int asd=1;asd<=18;asd++){
          System.out.println("");}
          }
          Thread.sleep(3000);
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
                  x.lifeline(1);
                           first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
          switch(sss)
          {
              case "a":
              case "A":
          sc4=statement.executeUpdate("update score set score=70000000 where name like '"+sname+"' && age="+age+";");      
          System.out.println("yes you are right you won Rs.7 Crore\n");
          Thread.sleep(5000);
          for(int asd=1;asd<=100;asd++){
          System.out.println("");}
          for(int win=1;win<=4;win++){
          
          System.out.println("\t\t\t\t************************************You Won*************************************");
          System.out.println("\t\t\t\t*                                                                              *");
          System.out.println("\t\t\t\t*   W       W   IIIIIIIIIIII   N       N   N       N   EEEEEEEE   RRRRRRRR     *  ");
          System.out.println("\t\t\t\t*   W       W        II        N N     N   N N     N   EE         R       R    *  ");
          System.out.println("\t\t\t\t*   W       W        II        N  N    N   N  N    N   EE         R       R    *  ");
          System.out.println("\t\t\t\t*   W   W   W        II        N   N   N   N   N   N   EEEEEEEE   RRRRRRRR     *  ");
          System.out.println("\t\t\t\t*   W  W W  W        II        N    N  N   N    N  N   EE         R R          *  ");
          System.out.println("\t\t\t\t*   W W   W W        II        N     N N   N     N N   EE         R   R        * ");
          System.out.println("\t\t\t\t*   WW     WW   IIIIIIIIIIII   N       N   N       N   EEEEEEEE   R     R      *  ");
          System.out.println("\t\t\t\t*                                                                              *");
          System.out.println("\t\t\t\t************************************You Won*************************************");
          for(int asd=1;asd<=18;asd++){
          System.out.println("");}
          Thread.sleep(800);
         for(int asd=1;asd<=18;asd++){
          System.out.println("");}
          System.out.println("\t\t\t\t++++++++++++++++++++++++++++++++++++You Won+++++++++++++++++++++++++++++++++++++");
          System.out.println("\t\t\t\t+                                                                              +");
          System.out.println("\t\t\t\t+   +       +   ++++++++++++   +       +   +       +   ++++++++   ++++++++     +  ");
          System.out.println("\t\t\t\t+   +       +        ++        + +     +   + +     +   ++         +       +    +  ");
          System.out.println("\t\t\t\t+   +       +        ++        +  +    +   +  +    +   ++         +       +    +  ");
          System.out.println("\t\t\t\t+   +   +   +        ++        +   +   +   +   +   +   ++++++++   ++++++++     +  ");
          System.out.println("\t\t\t\t+   +  + +  +        ++        +    +  +   +    +  +   ++         + +          +  ");
          System.out.println("\t\t\t\t+   + +   + +        ++        +     + +   +     + +   ++         +   +        + ");
          System.out.println("\t\t\t\t+   ++     ++   ++++++++++++   +       +   +       +   ++++++++   +     +      +  ");
          System.out.println("\t\t\t\t+                                                                              +");
          System.out.println("\t\t\t\t++++++++++++++++++++++++++++++++++++You Won+++++++++++++++++++++++++++++++++++++");
                   for(int asd=1;asd<=18;asd++){
          System.out.println("");} 
          Thread.sleep(800);}
          Thread.sleep(5000);
             break move4;
              case "LIFELINE" :
              case "Lifeline" :
              case "lifeline" :
           for(int asd=1;asd<=1000;asd++){
          System.out.println("\b");}
           x.lifeline(1);
            first=System.currentTimeMillis();
            sss=m.next();
            second=System.currentTimeMillis();
            timer=second-first+timer;
            if(timer>31000){
               System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                return;
          }
           sss=m.next();
       switch(sss)
          {
              case "a":
              case "A":
          sc4=statement.executeUpdate("update score set score=70000000 where name like '"+sname+"' && age="+age+";");     
          System.out.println("yes you are right you won Rs.7 Crore\n");
          Thread.sleep(2000);
          for(int asd=1;asd<=100;asd++){
          System.out.println("");}
          for(int win=1;win<=4;win++){
          
          System.out.println("\t\t\t\t************************************You Won*************************************");
          System.out.println("\t\t\t\t*                                                                              *");
          System.out.println("\t\t\t\t*   W       W   IIIIIIIIIIII   N       N   N       N   EEEEEEEE   RRRRRRRR     *  ");
          System.out.println("\t\t\t\t*   W       W        II        N N     N   N N     N   EE         R       R    *  ");
          System.out.println("\t\t\t\t*   W       W        II        N  N    N   N  N    N   EE         R       R    *  ");
          System.out.println("\t\t\t\t*   W   W   W        II        N   N   N   N   N   N   EEEEEEEE   RRRRRRRR     *  ");
          System.out.println("\t\t\t\t*   W  W W  W        II        N    N  N   N    N  N   EE         R R          *  ");
          System.out.println("\t\t\t\t*   W W   W W        II        N     N N   N     N N   EE         R   R        * ");
          System.out.println("\t\t\t\t*   WW     WW   IIIIIIIIIIII   N       N   N       N   EEEEEEEE   R     R      *  ");
          System.out.println("\t\t\t\t*                                                                              *");
          System.out.println("\t\t\t\t************************************You Won*************************************");
          for(int asd=1;asd<=18;asd++){
          System.out.println("");}
          Thread.sleep(800);
         for(int asd=1;asd<=18;asd++){
          System.out.println("");}
          System.out.println("\t\t\t\t++++++++++++++++++++++++++++++++++++You Won+++++++++++++++++++++++++++++++++++++");
          System.out.println("\t\t\t\t+                                                                              +");
          System.out.println("\t\t\t\t+   +       +   ++++++++++++   +       +   +       +   ++++++++   ++++++++     +  ");
          System.out.println("\t\t\t\t+   +       +        ++        + +     +   + +     +   ++         +       +    +  ");
          System.out.println("\t\t\t\t+   +       +        ++        +  +    +   +  +    +   ++         +       +    +  ");
          System.out.println("\t\t\t\t+   +   +   +        ++        +   +   +   +   +   +   ++++++++   ++++++++     +  ");
          System.out.println("\t\t\t\t+   +  + +  +        ++        +    +  +   +    +  +   ++         + +          +  ");
          System.out.println("\t\t\t\t+   + +   + +        ++        +     + +   +     + +   ++         +   +        + ");
          System.out.println("\t\t\t\t+   ++     ++   ++++++++++++   +       +   +       +   ++++++++   +     +      +  ");
          System.out.println("\t\t\t\t+                                                                              +");
          System.out.println("\t\t\t\t++++++++++++++++++++++++++++++++++++You Won+++++++++++++++++++++++++++++++++++++");
                   for(int asd=1;asd<=18;asd++){
          System.out.println("");} 
          Thread.sleep(800);}
          Thread.sleep(5000);
         for(int asd=1;asd<=100;asd++){
          System.out.println("\b");} 
             break move4;
           default :
            System.out.println("You are wrong today you won Only Rs.1 Crore");
               return;
          }
           default :
            System.out.println("You are wrong today you won Only Rs.1 Crore");
          return;
          }          
           default :
            System.out.println("You are wrong today you won Only Rs.1 Crore/-");
         return; 
         }
         }
       //********************************************************************************************************************************************
       //********************************************************************************************************************************************     
           
     
      
      
      
      }
      else {
          System.out.println("Process under Development");
           }
      }
       else if(enter==2){
           long part=System.currentTimeMillis();
           if(part%2==0){
               
           
          for(int clr=1;clr<=45;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
          long perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("Which Bank is Banker of Bank ?");
          System.out.println("A.State bank of india\t\t\tB.RBI\n");
          System.out.println("C.Punjab National Bank\t\t\tD.ICIC Bank");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "B" :
              case "b" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("What is our national Animal ?");
          System.out.println("A.Zebra\t\t\tB.Lion\n");
          System.out.println("C.Tiger\t\t\tD.Elephant");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "B" :
              case "b" :
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
          }
          }
            else if(perm%3==2){
          System.out.println("What is our national bird ?");
          System.out.println("A.peacock\t\t\tB.crow\n");
          System.out.println("C.parrot\t\t\tD.eagle");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
                }
            }
      //--------------------------------------------------------------------------------------------------------------------------------------------------
      //--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("The language discovered by Gautam Bhuddha was ?");
          System.out.println("A.Bhojpuri\t\t\tB.magadhi\n");
          System.out.println("C.Pali\t\t\tD.Sanskrit");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "c" :
              case "C" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("which of the following English films was the first one to be dubbed in Hindi ?");
          System.out.println("A.Aladdin\t\t\tB.Universal Soldier\n");
          System.out.println("C.Speed\t\t\tD.iron man");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
          }
          }
            else if(perm%3==2){
          System.out.println("Name of the player of Indian cricket team who 4 january 2013 was named as CEAT International Cricketer of the year 2012 ?");
          System.out.println("A.Yuvraj Singh\t\t\tB.gautam gambhir\n");
          System.out.println("C.Sachin Tendulkar\t\t\tD.Virat Kohli");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "d" :
              case "D" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
                }
          
            }
       //33--------------------------------------------------------------------------------------------------------------------------------------------------
      //33--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("Largest continent in the world is ?");
          System.out.println("A.Africa \t\t\tB.Asia \n");
          System.out.println("C.Australia\t\t\tD.Antarctica");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "b" :
              case "B" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("The India's Largest Rainfall is reported at?");
          System.out.println("A.sikkim\t\t\tB.Rajasthan \n");
          System.out.println("C.Mawsynram\t\t\tD.chamba");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
          }
          }
            else if(perm%3==2){
          System.out.println("Who was the first Indian to be President of UN General assembly ?");
          System.out.println("A.Mrs. Vijay Lakshmi Pandit\t\t\tB. Ramesh Bhandari\n");
          System.out.println("C.Natwar Singh\t\t\tD.Krishna Menon");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
                }
          
            }
       //44--------------------------------------------------------------------------------------------------------------------------------------------------
      //44--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("which king belongs the Lion capital at sarnath?");
          System.out.println("A.Chandragupta\t\t\tB.Kanishka\n");
          System.out.println("C.Harsha\t\t\tD.Ashoka");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "d" :
              case "D" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("The member of the Rajya sabha are elected by?");
          System.out.println("A.People\t\t\tB.Elected members of the legislative council \n");
          System.out.println("C.Elected members of legislative assembly\t\t\tD.Lok sabha");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
          }
          }
            else if(perm%3==2){
          System.out.println("The first women in space was ?");
          System.out.println("A.Valentina tereshkova\t\t\tB.kalpana Chawla\n");
          System.out.println("C.Tamara Press\t\t\tD.Sally Ride");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "d" :
              case "D" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
                }
          
            }
       //55--------------------------------------------------------------------------------------------------------------------------------------------------
      //55--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("Plant bends towards the source of light on account of the movement of curvature known as?");
          System.out.println("A.Geotropism\t\t\tB.Thigmotropism\n");
          System.out.println("C.Chemotropism\t\t\tD.Phototropism");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "d" :
              case "D" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("The first recipient of Rajiv Gandhi's 'Khel Ratna' award was?");
          System.out.println("A. Vishwanathan Anand\t\t\tB.Leander Peas\n");
          System.out.println("C.Kapil Dev\t\t\tD.Limba Ram");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
          }
                
          
          
          
          }
          
            else if(perm%3==2){
          System.out.println("Name the Cricketer who has became the youngest Batsman to score  10000 Runs in test Cricket ?");
          System.out.println("A. Alastair Cook\t\t\tB.Sachin Tendulkar\n");
          System.out.println("C.Daniel Vettori\t\t\tD.Ricky Ponting");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
                }
          
            }
        //66--------------------------------------------------------------------------------------------------------------------------------------------------
      //66--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("The leading state in Producing Paper is");
          System.out.println("A.Bihar\t\t\tB.West bengal\n");
          System.out.println("C.Kerala\t\t\tD.orissa");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "b" :
              case "B" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("Central Drug research Institute is located at ");
          System.out.println("A.Delhi\t\t\tB.Nagpur\n");
          System.out.println("C.Mysore\t\t\tD.Lukhnow");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "d" :
              case "D" :
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
          }
                
          
          
          
          }
          
            else if(perm%3==2){
          System.out.println("The peroson who is also known as flying sikh of India ?");
          System.out.println("A.Mohinder singh\t\t\tB.Joginder singh\n");
          System.out.println("C.Milkha singh\t\t\tD.Ajit singh");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
                }
          
            }
       //77--------------------------------------------------------------------------------------------------------------------------------------------------
      //77--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("Which city is known as garden city of india");
          System.out.println("A.Chandigarh\t\t\tB.Imphal\n");
          System.out.println("C.Shimla\t\t\tD.Banglore");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "d" :
              case "D" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong D.Banglore is right"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("The first indian to recive the nobel prize in literature was");
          System.out.println("A.Rabindranath Tagore\t\t\tB.C.V Raman\n");
          System.out.println("C.Sarojni neidu\t\t\tD.Mother teresa");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :
                  System.out.println("You are right ");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A.RabinderNath Tagore");
                   Thread.sleep(1500);
          }
                
          
          
          
          }
          
            else if(perm%3==2){
          System.out.println("Who is the first Asian winner of nobel prize ?");
          System.out.println("A.Rajiv Gandi\t\t\tB.Mother teresa\n");
          System.out.println("C. C.V raman\t\t\tD.Rabindernath Tagore");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C. C.V Raman is right");
                   Thread.sleep(1500);
                }
          
            }
          
          
       
        //88--------------------------------------------------------------------------------------------------------------------------------------------------
      //88--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("Which city is known as Big Apple");
          System.out.println("A.Tokoyo\t\t\tB.London\n");
          System.out.println("C.New York\t\t\tD.Banglore");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "c" :
              case "C" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C.New York is right"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("which is the Largest Airport in the world ?");
          System.out.println("A.Dubbai International Airport\t\t\tB.King Khalid International\n");
          System.out.println("C.Sarojni neidu\t\t\tD.Mother teresa");
          for(int clr=1;clr<=23;clr++){
              System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "b" :
              case "B" :
                  System.out.println("You are right ");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A.RabinderNath Tagore");
                   Thread.sleep(1500);
          }
                
          
          
          
          }
          
            else if(perm%3==2){
          System.out.println("Who is the first Asian winner of nobel prize ?");
          System.out.println("A.Rajiv Gandi\t\t\tB.Mother teresa\n");
          System.out.println("C. C.V raman\t\t\tD.Rabindernath Tagore");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C. C.V Raman is right");
                   Thread.sleep(1500);
                }
            }
       //99--------------------------------------------------------------------------------------------------------------------------------------------------
      //99--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("How many languages and dialects are spoken by people all over the world? ");
          System.out.println("A. 6,000\t\t\tB. 9,000\n");
          System.out.println("C. 4,000\t\t\tD. 1,000 ");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "b" :
              case "B" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong B. 9000 is right"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("Approximately, how many people speak Chinese language? ");
          System.out.println("A. 1 billion\t\t\tB. 1 million\n");
          System.out.println("C. 1 lakh   \t\t\tD. 1 thousand");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :
                  System.out.println("You are right ");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A.1 Billion is true");
                   Thread.sleep(1500);
          }
                
          
          
          
          }
          
            else if(perm%3==2){
          System.out.println("The language with the richest vocabulary is: ");
          System.out.println("A. Hindi  \t\t\tB. French \n");
          System.out.println("C. English\t\t\tD. German");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C. English is right");
                   Thread.sleep(1500);
                }
          
            }
      //10--------------------------------------------------------------------------------------------------------------------------------------------------
      //10--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("Which book has been printed in the maximum number of languages and these scripts");
          System.out.println("A. The Bible\t\t\tB. Hiraka Sutra\n");
          System.out.println("C. The Super Book\t\t\tGuliver Travel");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "a" :
              case "A" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A.The Bible is true"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("The only religious book ever printed in a shorthand scripts is ");
          System.out.println("A. The Ramayana\t\t\tB. The Mahabharata\n");
          System.out.println("C. The bible   \t\t\tD. Guru Granth Sahib ");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :
                  System.out.println("You are right ");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C.The Bible is true");
                   Thread.sleep(1500);
          }
                
          
          
          
          }
          
        else if(perm%3==2){
          System.out.println("The oldest printed work in the world, which dates back to AD 868 is:");
          System.out.println("A. The Bible   \t\t\tB. The Hirake Sutra\n");
          System.out.println("C. The Ramayana\t\t\tD. The Mahabharata   ");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "b" :
              case "B" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong B.The Hirake Sutra is right");
                   Thread.sleep(1500);
                }
          
            }
           }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++           
  else if(part%2==1){
               
            for(int clr=1;clr<=45;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
          long perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("The American General who led the revolt against the British & declared American independence was");
          System.out.println("A. George Washington\t\t\tB. Bill Clinton \n");
          System.out.println("C. George Bush      \t\t\tD. Brack Obama");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "a" :
              case "A" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A.Gorge washington is true"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("Who is known as the father of English poetry? ");
          System.out.println("A. Geoffrey Chaucer\t\t\tB. John Milton\n");
          System.out.println("C. John Keats      \t\t\tD. James Jeans");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A. Geoffrey Chaucer is write answer");
                   Thread.sleep(1500);
          }
          }
            else if(perm%3==2){
          System.out.println("Who was first to reach the South Pole");
          System.out.println("A. Rear Admiral\t\t\tB. Capt. Amundsen  \n");
          System.out.println("C. J.J Thomas  \t\t\tD. Sir Edmund Hillary");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "b" :
              case "" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong B. Capt. Amundsen is write answer");
                   Thread.sleep(1500);
                }
            }
      //--------------------------------------------------------------------------------------------------------------------------------------------------
      //--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("The language discovered by Gautam Bhuddha was ?");
          System.out.println("A.Bhojpuri\t\t\tB.magadhi\n");
          System.out.println("C.Pali\t\t\tD.Sanskrit");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "c" :
              case "C" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C.pali is right Answer"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("which of the following English films was the first one to be dubbed in Hindi ?");
          System.out.println("A.Aladdin\t\t\tB.Universal Soldier\n");
          System.out.println("C.Speed\t\t\tD.iron man");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A.Aladdin is right Answer");
                   Thread.sleep(1500);
          }
          }
            else if(perm%3==2){
          System.out.println("Name of the player of Indian cricket team who 4 january 2013 was named as CEAT International Cricketer of the year 2012 ?");
          System.out.println("A.Yuvraj Singh\t\t\tB.gautam gambhir\n");
          System.out.println("C.Sachin Tendulkar\t\t\tD.Virat Kohli");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "d" :
              case "D" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong D.virat Kohli is wright Answer");
                   Thread.sleep(1500);
                }
          
            }
       //33--------------------------------------------------------------------------------------------------------------------------------------------------
      //33--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("Largest continent in the world is ?");
          System.out.println("A.Africa \t\t\tB.Asia \n");
          System.out.println("C.Australia\t\t\tD.Antarctica");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "b" :
              case "B" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong B.Asia is wright Answer"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("The India's Largest Rainfall is reported at?");
          System.out.println("A.sikkim\t\t\tB.Rajasthan \n");
          System.out.println("C.Mawsynram\t\t\tD.chamba");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C.Mawsynram is wright Answer");
                   Thread.sleep(1500);
          }
          }
            else if(perm%3==2){
          System.out.println("Who was the first Indian to be President of UN General assembly ?");
          System.out.println("A.Mr. Vijay Lakshmi Pandit\t\t\tB. Ramesh Bhandari\n");
          System.out.println("C.Natwar Singh\t\t\tD.Krishna Menon");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A.Mr.Vijay Lakshmi Pandit");
                   Thread.sleep(1500);
                }
          
            }
       //44--------------------------------------------------------------------------------------------------------------------------------------------------
      //44--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("which king belongs the Lion capital at sarnath?");
          System.out.println("A.Chandragupta\t\t\tB.Kanishka\n");
          System.out.println("C.Harsha\t\t\tD.Ashoka");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "d" :
              case "D" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong D.Ashoka is right answer"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("The member of the Rajya sabha are elected by?");
          System.out.println("A.People\t\t\tB.Elected members of the legislative council \n");
          System.out.println("C.Elected members of legislative assembly\t\t\tD.Lok sabha");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C.Elected member of legistative assembly is right Asnswer ");
                   Thread.sleep(1500);
          }
          }
            else if(perm%3==2){
          System.out.println("The first women in space was ?");
          System.out.println("A.Valentina tereshkova\t\t\tB.kalpana Chawla\n");
          System.out.println("C.Tamara Press\t\t\tD.Sally Ride");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "d" :
              case "D" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong d.Sally Ride is wright Answer");
                   Thread.sleep(1500);
                }
          
            }
       //55--------------------------------------------------------------------------------------------------------------------------------------------------
      //55--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("Plant bends towards the source of light on account of the movement of curvature known as?");
          System.out.println("A.Geotropism\t\t\tB.Thigmotropism\n");
          System.out.println("C.Chemotropism\t\t\tD.Phototropism");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "d" :
              case "D" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong D.phototropism is right Answer"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("The first recipient of Rajiv Gandhi's 'Khel Ratna' award was?");
          System.out.println("A. Vishwanathan Anand\t\t\tB.Leander Peas\n");
          System.out.println("C.Kapil Dev\t\t\tD.Limba Ram");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A.Vishwanathan Anand is right");
                   Thread.sleep(1500);
          }
                
          
          
          
          }
          
            else if(perm%3==2){
          System.out.println("Name the Cricketer who has became the youngest Batsman to score  10000 Runs in test Cricket ?");
          System.out.println("A. Alastair Cook\t\t\tB.Sachin Tendulkar\n");
          System.out.println("C.Daniel Vettori\t\t\tD.Ricky Ponting");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
                }
          
            }
        //66--------------------------------------------------------------------------------------------------------------------------------------------------
      //66--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("The leading state in Producing Paper is");
          System.out.println("A.Bihar\t\t\tB.West bengal\n");
          System.out.println("C.Kerala\t\t\tD.orissa");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "b" :
              case "B" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("Central Drug research Institute is located at ");
          System.out.println("A.Delhi\t\t\tB.Nagpur\n");
          System.out.println("C.Mysore\t\t\tD.Lukhnow");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "d" :
              case "D" :
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
          }
                
          
          
          
          }
          
            else if(perm%3==2){
          System.out.println("The peroson who is also known as flying sikh of India ?");
          System.out.println("A.Mohinder singh\t\t\tB.Joginder singh\n");
          System.out.println("C.Milkha singh\t\t\tD.Ajit singh");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong");
                   Thread.sleep(1500);
                }
          
            }
       //77--------------------------------------------------------------------------------------------------------------------------------------------------
      //77--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("Which city is known as garden city of india");
          System.out.println("A.Chandigarh\t\t\tB.Imphal\n");
          System.out.println("C.Shimla\t\t\tD.Banglore");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "d" :
              case "D" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong D.Banglore is right"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("The first indian to recive the nobel prize in literature was");
          System.out.println("A.Rabindranath Tagore\t\t\tB.C.V Raman\n");
          System.out.println("C.Sarojni neidu\t\t\tD.Mother teresa");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :
                  System.out.println("You are right ");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A.RabinderNath Tagore");
                   Thread.sleep(1500);
          }
                
          
          
          
          }
          
            else if(perm%3==2){
          System.out.println("Who is the first Asian winner of nobel prize ?");
          System.out.println("A.Rajiv Gandi\t\t\tB.Mother teresa\n");
          System.out.println("C. C.V raman\t\t\tD.Rabindernath Tagore");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C. C.V Raman is right");
                   Thread.sleep(1500);
                }
          
            }
          
          
       
        //88--------------------------------------------------------------------------------------------------------------------------------------------------
      //88--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("Which city is known as Big Apple");
          System.out.println("A.Tokoyo\t\t\tB.London\n");
          System.out.println("C.New York\t\t\tD.Banglore");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "c" :
              case "C" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C.New York is right"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("which is the Largest Airport in the world ?");
          System.out.println("A.Dubbai International Airport\t\t\tB.King Khalid International\n");
          System.out.println("C.Sarojni neidu\t\t\tD.Mother teresa");
          for(int clr=1;clr<=23;clr++){
              System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "b" :
              case "B" :
                  System.out.println("You are right ");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A.RabinderNath Tagore");
                   Thread.sleep(1500);
          }
                
          
          
          
          }
          
            else if(perm%3==2){
          System.out.println("Who is the first Asian winner of nobel prize ?");
          System.out.println("A.Rajiv Gandi\t\t\tB.Mother teresa\n");
          System.out.println("C. C.V raman\t\t\tD.Rabindernath Tagore");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C. C.V Raman is right");
                   Thread.sleep(1500);
                }
            }
       //99--------------------------------------------------------------------------------------------------------------------------------------------------
      //99--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("How many languages and dialects are spoken by people all over the world? ");
          System.out.println("A. 6,000\t\t\tB. 9,000\n");
          System.out.println("C. 4,000\t\t\tD. 1,000 ");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "b" :
              case "B" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong B. 9000 is right"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("Approximately, how many people speak Chinese language? ");
          System.out.println("A. 1 billion\t\t\tB. 1 million\n");
          System.out.println("C. 1 lakh   \t\t\tD. 1 thousand");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "a" :
              case "A" :
                  System.out.println("You are right ");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A.1 Billion is true");
                   Thread.sleep(1500);
          }
                
          
          
          
          }
          
            else if(perm%3==2){
          System.out.println("The language with the richest vocabulary is: ");
          System.out.println("A. Hindi  \t\t\tB. French \n");
          System.out.println("C. English\t\t\tD. German");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C. English is right");
                   Thread.sleep(1500);
                }
          
            }
      //10--------------------------------------------------------------------------------------------------------------------------------------------------
      //10--------------------------------------------------------------------------------------------------------------------------------------------------
            for(int clr=1;clr<=25;clr++){
          System.out.println("");}
           System.out.println("\t\t\t\t\t\t##################Practise zone######################\n\n");
 
           perm=System.currentTimeMillis();
          if(perm%3==0){
          System.out.println("Which book has been printed in the maximum number of languages and these scripts");
          System.out.println("A. The Bible\t\t\tB. Hiraka Sutra\n");
          System.out.println("C. The Super Book\t\t\tGuliver Travel");
            for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
          switch(prac){
              case "a" :
              case "A" :      
                  System.out.println("You are right");
                  Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong A.The Bible is true"); 
               Thread.sleep(1500);    
              }
                    
     
          }
          else if(perm%3==1){
          System.out.println("The only religious book ever printed in a shorthand scripts is ");
          System.out.println("A. The Ramayana\t\t\tB. The Mahabharata\n");
          System.out.println("C. The bible   \t\t\tD. Guru Granth Sahib ");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-"); 
          String prac=m.next();
                switch(prac){
              case "c" :
              case "C" :
                  System.out.println("You are right ");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong C.The Bible is true");
                   Thread.sleep(1500);
          }
                
          
          
          
          }
          
            else if(perm%3==2){
          System.out.println("The oldest printed work in the world, which dates back to AD 868 is:");
          System.out.println("A. The Bible   \t\t\tB. The Hirake Sutra\n");
          System.out.println("C. The Ramayana\t\t\tD. The Mahabharata   ");
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");       
          String prac=m.next();
                switch(prac){
              case "b" :
              case "B" :   
                  System.out.println("You are right");
                   Thread.sleep(1500);
              break;
              case "Exit" :
              case "exit" :
              return;
              default :
              System.out.println("you are wrong B.The Hirake Sutra is right");
                   Thread.sleep(1500);
                }
          
            }         

  
  }    
          
          
          
          
          
       }
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////             
       
       
       else if(enter==5)
    {
           for(int clr=1;clr<=25;clr++){
          System.out.println("");}
          System.out.println("\t\t\t\t\tHELP");
          System.out.println(" If you are Playing this game you have to know :-");
          System.out.println(" --------------------------------------------------------------------------------------");
          System.out.println("|1. First you have to solve Fastest finger question                                    |");
          System.out.println("|2. After solving the fastest finger question you will move to Hot Seat zone           |");
          System.out.println("|3. In Hot seat zone you will receive different questions one by one and               |");
          System.out.println("|you have to give right answer to recive next Question                                 |");
          System.out.println("|4. To Become Winner you have to give the right answer of 15 Question                  |");
          System.out.println("|5. You have 30 Second to give you answer but If you are using lifeline then           |");
          System.out.println("|timer will stop till the lifeline will complete after that time is automatically On   |");
          System.out.println("|6. You have 7 Lifeline but each Lifeline can works only one Time.                     |");
          System.out.println(" --------------------------------------------------------------------------------------\n");
          System.out.println("If you are using Practise zone ");
          System.out.println(" --------------------------------------------------------------------------------------");
          System.out.println("|1. Practise zone is same as play but the difference was that if you give wrong answer |");
          System.out.println("|then program does not stop .They will move to next question                           |");
          System.out.println("|2.You can give your answer any time(because timer is not present)                     |");
          System.out.println("|3.It contains different parts Each part contain 10 question                           |");
          System.out.println("|4.You have to give answer without using lifeline(lifeline is not added)               |");
          System.out.println("|5.It is created for practise work and inceasing knowledge                             |");
          System.out.println(" --------------------------------------------------------------------------------------\n");
          System.out.println(" If you want to check your score");
          System.out.println(" --------------------------------------------------------------------------------------");
          System.out.println("|1. In Menu option select Third option                                                  |");
          System.out.println("|2. Then Enter your name and age                                                        |");
          System.out.println("|3. If you have Played our game or your record is save in our database then             |");
          System.out.println("|you are can easily view your high score                                                |");
          System.out.println(" --------------------------------------------------------------------------------------\n");
          Thread.sleep(20000);
          System.out.println("If you want to check highscore");
          System.out.println(" --------------------------------------------------------------------------------------");
          System.out.println("|1. In Menu option select fourth option                                                 |");
          System.out.println("|2. Then you will easily able to view the name and age of the highscorer and            |");
          System.out.println("|you are can easily view high score                                                     |");
          System.out.println(" --------------------------------------------------------------------------------------\n");
          Thread.sleep(15000);
          System.out.println("If you want to Quit/Exit");
          System.out.println(" --------------------------------------------------------------------------------------");
          System.out.println("|1. In Menu option select Fifth option                                                  |");
          System.out.println("|2. Then the program will Exit                                                          |");
          System.out.println(" --------------------------------------------------------------------------------------");
         
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
          System.out.println();
          Thread.sleep(5500);
    }
       else if(enter==3){
          for(int clr=1;clr<=23;clr++){
          System.out.println("");}
           System.out.println("\t\t\t)))))))))))))))))))))))))))))))))))))))))Your high Score(((((((((((((((((((((((((((((((((((((((((((((");

          String yourname;
          
          int yourage,a=0;
          System.out.println("Enter your name ");
           for(int clr=1;clr<=26;clr++){
          System.out.println();}
           System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
          yourname=m.next();
         System.out.println("Enter you age");
         yourage=m.nextInt();
          for(int clr=1;clr<=25;clr++){
          System.out.println();}
          ResultSet Res=statement.executeQuery("select * from score where name like'"+yourname+"' && age="+yourage+";");
         System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        while(Res.next()){
             
             System.out.println(" Name =>"+Res.getString(2)+"    Age  =>"+Res.getInt(3)+" Total Earn=>"+Res.getInt(4));
             
             a++;
         }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"); 
          for(int clr=1;clr<=27-a;clr++){
          System.out.println();}
               
       }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++   
       else if(enter==4){
           int a=0;
                     for(int clr=1;clr<=25;clr++){
          System.out.println();}
          ResultSet Res=statement.executeQuery("select * from score order by score desc;");
          System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
          System.out.println("+                                High Score                                       +");
          System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        while(Res.next()){
             
             System.out.println(" Name =>"+Res.getString(2)    +" Age  =>"+Res.getInt(3)+" Total Earn=>"+Res.getInt(4));
             System.out.println();
             
             a+=2;
         }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"); 
          for(int clr=1;clr<=25-a;clr++){
          System.out.println();}
       }
      
      else if(enter==6){
          return;
      }
      
      }
      catch(InterruptedException exc)
      {
          System.out.println("sleep\\wait is not working");
      }
   
    }
    //+++++++++++++++++++++++++++++++++++++LIFELINE++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++    
    //+++++++++++++++++++++++++++++++++++++LIFELINE++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++   
    public void lifeline(int quesno){
        Scanner m=new Scanner(System.in);      
    if(quesno==1)
        {
        try{
              System.out.print("------------------------------------------------------");
              System.out.print("\n|\t\t    Lifeline\t\t\t     |\n");
              System.out.println("------------------------------------------------------");
              System.out.println("1.Audience poll \t\t2.Phone a friend");
              System.out.println("3.Fifty fifty   \t\t4.Flip The question");
              System.out.println("5.Power paplu   \t\t6.Ask an expert");
              System.out.println("7.Double Dip");
              for(int space=1;space<=23;space++){
                  System.out.println("");
              }
              int lifeline=m.nextInt();
              System.out.println();
              System.out.println();
            if(lifeline==1){
            try{
                ap=ap+1;
                 if(ap==1){
             System.out.print("Audience are voting");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".\n\n\n\n\n");
            System.out.println("          Audience Rating");
            System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|");        
            System.out.println(" |-|     A     B    C   D     |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|     __                   |-|");
            System.out.println(" |-|    |  |                  |-|");
            System.out.println(" |-|    |  |                  |-|");
            System.out.println(" |-|    |  |                  |-|");
            System.out.println(" |-|    |  |  __              |-|");
            System.out.println(" |-|    |60| |20|  __   __    |-|");
            System.out.println(" |-|    |  |_|  |_|10|_|10|   |-|");
            System.out.println(" |-|    |__|_|__|_|__|_|__|   |-|");
            System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|"); 
            for(int move=1;move<=16;move++){
               System.out.println();}
                 }
                 else{
                     System.out.println("you have used this lifeline");
                     lifeline(1);
                 }
           
                 }
        catch(InterruptedException exc){
            
        }
                 
        }
             
               
              else if(lifeline==2){
            for(int space=1;space<=25;space++){
                  System.out.println("");}
            ph=ph+1;
            if(ph==1){
            System.out.println("Choose any friend to call for help");
            System.out.println(" _________          _________            _________         _________  ");
            System.out.println("|         |\\       |         |\\         |         |\\      |         |\\");
            System.out.println("| RAM     | |      |  RAHIM  | |        |  RAJAN  | |     |  ROHIT  | |");
            System.out.println("|_________| |      |_________| |        |_________| |     |_________| |");
            System.out.println(" \\|________\\|      \\|_________\\|        \\|_________\\|     \\|_________\\|");
            System.out.println("Enter any one name for calling");
            
            
                         
                for(int space=1;space<=24;space++){
                  System.out.println("");  }         
              String call=m.next();
              switch(call){
                 
                  case "Ram" :
                  case "RAM" :   
                  case "ram" :
                  case "Rahim" :
                  case "rahim" :
                  case "RAHIM" :
                  case "Rajan" :
                  case "rajan" :
                  case "RAJAN" :    
                  case "Rohit" :
                  case "rohit" :
                  case "ROHIT" :   
                     
                  System.out.print("Call is Diverting to "+call);
                  
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print("."); 
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print("."); 
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.println("."); 
                  System.out.println("Hello");
                  String as=m.next();
                  
                  System.out.println("Enter your question");
                   String a=m.next();
                  System.out.println("give me option");
                  String asa=m.next(); 
                  System.out.println("I think A is True");
                      break;
              
              
              }
              
              
              
            }else{
            System.out.println("You have already used this lifeline");
            lifeline(1);
            }       }
              else if(lifeline==3){
                  for(int move=1;move<=30;move++){
                   System.out.println("");   
                  }
                  ff=ff+1;
                  if(ff==1){
                  System.out.println("Fifty fifty");
                  System.out.println("You Answer may be :-");
                  System.out.println("A.     ");
                  System.out.println("\t\tC.");
                   for(int move=1;move<=27;move++){
                   System.out.println("");   
                  }
              }
                  else{
                      System.out.println("You have already used this lifeline");
                      lifeline(1);
                  }
              }
              else if(lifeline==4){
                  fq=fq+1;
                  if(fq==1){
                  System.out.println("Flip the Question");
                  System.out.println("According to the Mahabharata, who made Gandiva, the famous bow of Arjuna?");
                  System.out.println("(A) Brahma                            (B) Indra ");
                  System.out.println("(C) Chandra                           (D) Prajapati");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");

          
                   
                  
              }else{
                      System.out.println("you have already used this lifeline");
                      lifeline(1);
                  }
              }
              else if(lifeline==5){
                  pp=pp+1;
                  if(pp==1){
              System.out.print("------------------------------------------------------");
              System.out.print("\n|\t\t    Lifeline\t\t\t     |\n");
              System.out.println("------------------------------------------------------");
              System.out.println("1.Audience poll \t\t2.Phone a friend");
              System.out.println("3.Fifty fifty   \t\t4.Flip The question");
              System.out.println("5.Power paplu   \t\t6.Ask an expert");
              System.out.println("7.Double Dip");
              for(int space=1;space<=23;space++){
                  System.out.println("");
              }
              int pp=m.nextInt();
                 for(int space=1;space<=23;space++){
               System.out.println("");
              }
              if(pp==1){
                  System.out.println("Audience poll is Renewed");
                  ap=0;
                  lifeline(1);
              }
              else if (pp==2){
              System.out.println("Phone a Friend is Renewed");
              ph=0;
              lifeline(1);
              }
              else if(pp==3){
              System.out.println("Fifty Fifty is Renewed");
              ff=0;
              lifeline(1);
              }
              else if(pp==4){
              System.out.println("Flip the Question is Renewed");
              ask=0;
              lifeline(1);
              }
              else if(pp==6){
                  System.out.println("Ask an expert is Renewed");
                  ask=0;
              lifeline(1);
              }
              else{
                  System.out.println("Double dip is Renewed"); 
                  dd=0;
              lifeline(1);
              }
              
                      
                      
                  
                  
                  System.out.println("Renew any lifeline");
                  }
                  else{
                      System.out.println("You have already used this lifeline");
                  lifeline(1);
                  }
              }
              else if(lifeline==6){
                  ask=ask+1;
                  if(ask==1){
                  System.out.println("Ask an Expert");
                  System.out.println("our today expert is Rohit joshi");
                  System.out.print("Redirecting to Rohit joshi");
                  Thread.sleep(1000);
                  System.out.println(".");
                  Thread.sleep(1000);
                  System.out.println(".");
                  Thread.sleep(1000);
                  System.out.println(".");
                  Thread.sleep(1000);
                  System.out.println(".");
                  Thread.sleep(1000);
                  System.out.println(".");
                  
              }else{
                      System.out.println("You have Already used this lifeline");
                      lifeline(1);
                  }
              }
              else if(lifeline==7){
                  dd=dd+1;
                  if(dd==1){
                            
                  
                  System.out.println("Double dip");
                  System.out.println("Enter Two Option 1 by 1");
                  for(int space=1;space<=23;space++){
                  System.out.println("");
              }
                 String as;
                 as=m.next();
                 switch(as){
                     case "a":
                     case "A":
                         System.out.println("A is right Enter once again");
                         break;
                    default :     
                     System.out.println("Answer is wrong try again");
                 }
              }else{
                      System.out.println("You have Already used this lifeline");
                      lifeline(1);
                  }
              }
              else{
                  System.out.println("you have enter wrong choice");
                  lifeline(1);
              }
             
             
    
    }
        catch(InterruptedException exc){ 
            System.out.println("!!!!!!!!!!!!!!!!!!!!RESTART!!!!!!!!!!!!!!!!!!!");
                    }
        
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
else if(quesno==2){
                {
        try{
              System.out.print("------------------------------------------------------");
              System.out.print("\n|\t\t    Lifeline\t\t\t     |\n");
              System.out.println("------------------------------------------------------");
              System.out.println("1.Audience poll \t\t2.Phone a friend");
              System.out.println("3.Fifty fifty   \t\t4.Flip The question");
              System.out.println("5.Power paplu   \t\t6.Ask an expert");
              System.out.println("7.Double Dip");
              for(int space=1;space<=23;space++){
                  System.out.println("");
              }
              int lifeline=m.nextInt();
              System.out.println();
              System.out.println();
            if(lifeline==1){
            try{
                ap=ap+1;
                 if(ap==1){
             System.out.print("Audience are voting");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".\n\n\n\n\n");
            System.out.println("          Audience Rating");
            System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|");        
            System.out.println(" |-|     A     B    C   D     |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|          __              |-|");
            System.out.println(" |-|         |  |             |-|");
            System.out.println(" |-|         |  |             |-|");
            System.out.println(" |-|         |  |             |-|");
            System.out.println(" |-|         |  |             |-|");
            System.out.println(" |-|         |  |             |-|");
            System.out.println(" |-|     __  |80|  __   __    |-|");
            System.out.println(" |-|    |10|_|  |_|10|_|10|   |-|");
            System.out.println(" |-|    |__|_|__|_|__|_|__|   |-|");
            System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|"); 
            for(int move=1;move<=16;move++){
               System.out.println();}
                 }
                 else{
                     System.out.println("you have used this lifeline");
                     lifeline(1);
                 }
           
                 }
        catch(InterruptedException exc){
            
        }
                 
        }
             
               
              else if(lifeline==2){
            for(int space=1;space<=25;space++){
                  System.out.println("");}
            ph=ph+1;
            if(ph==1){
            System.out.println("Choose any friend to call for help");
            System.out.println(" _________          _________            _________         _________  ");
            System.out.println("|         |\\       |         |\\         |         |\\      |         |\\");
            System.out.println("| RAM     | |      |  RAHIM  | |        |  RAJAN  | |     |  ROHIT  | |");
            System.out.println("|_________| |      |_________| |        |_________| |     |_________| |");
            System.out.println(" \\|________\\|      \\|_________\\|        \\|_________\\|     \\|_________\\|");
            System.out.println("Enter any one name for calling");
            
            
                         
                for(int space=1;space<=24;space++){
                  System.out.println("");  }         
              String call=m.next();
              switch(call){
                 
                  case "Ram" :
                  case "RAM" :   
                  case "ram" :
                  case "Rahim" :
                  case "rahim" :
                  case "RAHIM" :
                  case "Rajan" :
                  case "rajan" :
                  case "RAJAN" :    
                  case "Rohit" :
                  case "rohit" :
                  case "ROHIT" :   
                     
                  System.out.print("Call is Diverting to "+call);
                  
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print("."); 
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print("."); 
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.println("."); 
                  System.out.println("Hello");
                  String as=m.next();
                  
                  System.out.println("Enter your question");
                   String a=m.next();
                  System.out.println("give me option");
                  String asa=m.next(); 
                  System.out.println("I think B is True");
                      break;
              
              
              }
              
              
              
            }else{
            System.out.println("You have already used this lifeline");
            lifeline(2);
            }
              }
              else if(lifeline==3){
                  for(int move=1;move<=30;move++){
                   System.out.println("");   
                  }
                  ff=ff+1;
                  if(ff==1){
                  System.out.println("Fifty fifty");
                  System.out.println("You Answer may be :-");
                  System.out.println("\t\tB.");
                  System.out.println("C.");
                   for(int move=1;move<=27;move++){
                   System.out.println("");   
                  }
              }
                  else{
                      System.out.println("You have already used this lifeline");
                      lifeline(2);
                  }
              }
              else if(lifeline==4){
                  fq=fq+1;
                  if(fq==1){
                  System.out.println("Flip the Question");
                  System.out.println("In Cricket, “round the wicket” and “over the wicket” represent what ?");
                  System.out.println("(A) Wicket-keeping                    (B) Bowling ");
                  System.out.println("(C) Batting                           (D) Commentary");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");

          
                   
                  
              }else{
                      System.out.println("you have already used this lifeline");
                      lifeline(2);
                  }
              }
              else if(lifeline==5){
                  pp=pp+1;
                  if(pp==1){
              System.out.print("------------------------------------------------------");
              System.out.print("\n|\t\t    Lifeline\t\t\t     |\n");
              System.out.println("------------------------------------------------------");
              System.out.println("1.Audience poll \t\t2.Phone a friend");
              System.out.println("3.Fifty fifty   \t\t4.Flip The question");
              System.out.println("5.Power paplu   \t\t6.Ask an expert");
              System.out.println("7.Double Dip");
              for(int space=1;space<=23;space++){
                  System.out.println("");
              }
              int pp=m.nextInt();
                 for(int space=1;space<=23;space++){
               System.out.println("");
              }
              if(pp==1){
                  System.out.println("Audience poll is Renewed");
                  ap=0;
                  lifeline(2);
              }
              else if (pp==2){
              System.out.println("Phone a Friend is Renewed");
              ph=0;
              lifeline(2);
              }
              else if(pp==3){
              System.out.println("Fifty Fifty is Renewed");
              ff=0;
              lifeline(2);
              }
              else if(pp==4){
              System.out.println("Flip the Question is Renewed");
              ask=0;
              lifeline(2);
              }
              else if(pp==6){
                  System.out.println("Ask an expert is Renewed");
                  ask=0;
              lifeline(2);
              }
              else{
                  System.out.println("Double dip is Renewed"); 
                  dd=0;
              lifeline(2);
              }
              
                      
                      
                  
                  
                  System.out.println("Renew any lifeline");
                  }
                  else{
                      System.out.println("You have already used this lifeline");
                  lifeline(2);
                  }
              }
              else if(lifeline==6){
                  ask=ask+1;
                  if(ask==1){
                  System.out.println("Ask an Expert");
                  System.out.println("our today expert is Rohit joshi");
                  System.out.print("Redirecting to Rohit joshi");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  System.out.println("I think B is right");
              }else{
                      System.out.println("You have Already used this lifeline");
                      lifeline(2);
                  }
              }
              else if(lifeline==7){
                  dd=dd+1;
                  if(dd==1){
                      
                  
                  System.out.println("Double dip");
                  System.out.println("Enter Two Option 1 by 1");
                  for(int space=1;space<=23;space++){
                  System.out.println("");
              }
                 String as;
                 as=m.next();
                 switch(as){
                     case "b":
                     case "B":
                         System.out.println("B is right Enter once again");
                         break;
                    default :     
                     System.out.println("Answer is wrong try again");
                 }
              }else{
                      System.out.println("You have Already used this lifeline");
                      lifeline(2);
                  }
              }
              else{
                  System.out.println("you have enter wrong choice");
                  lifeline(2);
              }
             
             
    
    }
        catch(InterruptedException exc){ 
            System.out.println("!!!!!!!!!!!!!!!!!!!!RESTART!!!!!!!!!!!!!!!!!!!");
                    }
        
} 
 }

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    else if(quesno==3){
                {
        try{
              System.out.print("------------------------------------------------------");
              System.out.print("\n|\t\t    Lifeline\t\t\t     |\n");
              System.out.println("------------------------------------------------------");
              System.out.println("1.Audience poll \t\t2.Phone a friend");
              System.out.println("3.Fifty fifty   \t\t4.Flip The question");
              System.out.println("5.Power paplu   \t\t6.Ask an expert");
              System.out.println("7.Double Dip");
              for(int space=1;space<=23;space++){
                  System.out.println("");
              }
              int lifeline=m.nextInt();
              System.out.println();
              System.out.println();
            if(lifeline==1){
            try{
                ap=ap+1;
                 if(ap==1){
             System.out.print("Audience are voting");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".\n\n\n\n\n");
            System.out.println("          Audience Rating");
            System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|");        
            System.out.println(" |-|     A     B    C   D     |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|               __         |-|");
            System.out.println(" |-|     __       |  |        |-|");
            System.out.println(" |-|    |  |  __  |  |        |-|");
            System.out.println(" |-|    |30| |20| |  |  __    |-|");
            System.out.println(" |-|    |  |_|  |_|40|_|10|   |-|");
            System.out.println(" |-|    |__|_|__|_|__|_|__|   |-|");
            System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|"); 
            for(int move=1;move<=15;move++){
               System.out.println();}
                 }
                 else{
                     System.out.println("you have used this lifeline");
                     lifeline(3);
                 }
           
                 }
        catch(InterruptedException exc){
            
        }
                 
        }
             
               
              else if(lifeline==2){
            for(int space=1;space<=25;space++){
                  System.out.println("");}
            ph=ph+1;
            if(ph==1){
            System.out.println("Choose any friend to call for help");
            System.out.println(" _________          _________            _________         _________  ");
            System.out.println("|         |\\       |         |\\         |         |\\      |         |\\");
            System.out.println("| RAM     | |      |  RAHIM  | |        |  RAJAN  | |     |  ROHIT  | |");
            System.out.println("|_________| |      |_________| |        |_________| |     |_________| |");
            System.out.println(" \\|________\\|      \\|_________\\|        \\|_________\\|     \\|_________\\|");
            System.out.println("Enter any one name for calling");
            
            
                         
                for(int space=1;space<=24;space++){
                  System.out.println("");  }         
              String call=m.next();
              switch(call){
                 
                  case "Ram" :
                  case "RAM" :   
                  case "ram" :
                  case "Rahim" :
                  case "rahim" :
                  case "RAHIM" :
                  case "Rajan" :
                  case "rajan" :
                  case "RAJAN" :    
                  case "Rohit" :
                  case "rohit" :
                  case "ROHIT" :   
                     
                  System.out.print("Call is Diverting to "+call);
                  
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print("."); 
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print("."); 
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.println("."); 
                  System.out.println("Hello");
                  String as=m.next();
                  
                  System.out.println("Enter your question");
                   String a=m.next();
                  System.out.println("give me option");
                  String asa=m.next(); 
                  System.out.println("I think C is True");
break;              
              
              }
              
              
              
            }else{
            System.out.println("You have already used this lifeline");
            lifeline(3);
            }
              }
              else if(lifeline==3){
                  for(int move=1;move<=30;move++){
                   System.out.println("");   
                  }
                  ff=ff+1;
                  if(ff==1){
                  System.out.println("Fifty fifty");
                  System.out.println("You Answer may be :-");
                  System.out.println("\t\tB.     ");
                  System.out.println("C.");
                   for(int move=1;move<=26;move++){
                   System.out.println();   
                  }
              }
                  else{
                      System.out.println("You have already used this lifeline");
                      lifeline(3);
                  }
              }
              else if(lifeline==4){
                  fq=fq+1;
                  if(fq==1){
                  System.out.println("Flip the Question");
                  System.out.println("Which of these Indian cricketers made his Test Debut in 2012?");
                  System.out.println("(A) Abhinav Mukund                    (B) Ajankia Rahane ");
                  System.out.println("(C) Ravindra Jadeja                   (D) Rohit Sharma");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");

          
                   
                  
              }else{
                      System.out.println("you have already used this lifeline");
                      lifeline(3);
                  }
              }
              else if(lifeline==5){
                  pp=pp+1;
                  if(pp==1){
              System.out.println("Welcome To Power Paplu Lifeline");        
              System.out.print("------------------------------------------------------");
              System.out.print("\n|\t\t    Lifeline\t\t\t     |\n");
              System.out.println("------------------------------------------------------");
              System.out.println("1.Audience poll \t\t2.Phone a friend");
              System.out.println("3.Fifty fifty   \t\t4.Flip The question");
              System.out.println("5.Power paplu   \t\t6.Ask an expert");
              System.out.println("7.Double Dip");
              for(int space=1;space<=23;space++){
                  System.out.println("");
              }
              int pp=m.nextInt();
                 for(int space=1;space<=23;space++){
               System.out.println("");
              }
              if(pp==1){
                  System.out.println("Audience poll is Renewed");
                  ap=0;
                  lifeline(3);
              }
              else if (pp==2){
              System.out.println("Phone a Friend is Renewed");
              ph=0;
              lifeline(3);
              }
              else if(pp==3){
              System.out.println("Fifty Fifty is Renewed");
              ff=0;
              lifeline(3);
              }
              else if(pp==4){
              System.out.println("Flip the Question is Renewed");
              ask=0;
              lifeline(3);
              }
              else if(pp==6){
                  System.out.println("Ask an expert is Renewed");
                  ask=0;
              lifeline(3);
              }
              else{
                  System.out.println("Double dip is Renewed"); 
                  dd=0;
              lifeline(3);
              }
              
                      
                      
                  
                  
                  System.out.println("Renew any lifeline");
                  }
                  else{
                      System.out.println("You have already used this lifeline");
                  lifeline(3);
                  }
              }
              else if(lifeline==6){
                  ask=ask+1;
                  if(ask==1){
                  System.out.println("Ask an Expert");
                  System.out.println("our today expert is Rohit joshi");
                  System.out.print("Redirecting to Rohit joshi");
                  Thread.sleep(1000);
                  System.out.println(".");
                  Thread.sleep(1000);
                  System.out.println(".");
                  Thread.sleep(1000);
                  System.out.println(".");
                  Thread.sleep(1000);
                  System.out.println(".");
                  Thread.sleep(1000);
                  System.out.println(".");
                  System.out.println("I Think C is true");
                  
                  
              }else{
                      System.out.println("You have Already used this lifeline");
                      lifeline(3);
                  }
              }
              else if(lifeline==7){
                  dd=dd+1;
                  if(dd==1){
                                 
                  
                  System.out.println("Double dip");
                  System.out.println("Enter Two Option 1 by 1");
                  for(int space=1;space<=23;space++){
                  System.out.println("");
              }

                  
                 String as;
                 as=m.next();
                 switch(as){
                     case "c":
                     case "C":
                         System.out.println("C is right Enter once again");
                         break;
                    default :     
                     System.out.println("Answer is wrong try again");
                 }
                 
              }
                  else{
                      System.out.println("You have Already used this lifeline");
                      lifeline(3);
                  }
              }
              else{
                  System.out.println("you have enter wrong choice");
                  lifeline(3);
              }
             
             
    
    }
        catch(InterruptedException exc){ 
            System.out.println("!!!!!!!!!!!!!!!!!!!!RESTART!!!!!!!!!!!!!!!!!!!");
                    }
        
}
}
else{
                {
        try{
              System.out.print("------------------------------------------------------");
              System.out.print("\n|\t\t    Lifeline\t\t\t     |\n");
              System.out.println("------------------------------------------------------");
              System.out.println("1.Audience poll \t\t2.Phone a friend");
              System.out.println("3.Fifty fifty   \t\t4.Flip The question");
              System.out.println("5.Power paplu   \t\t6.Ask an expert");
              System.out.println("7.Double Dip");
              for(int space=1;space<=23;space++){
                  System.out.println("");
              }
              int lifeline=m.nextInt();
              System.out.println();
              System.out.println();
            if(lifeline==1){
            try{
                ap=ap+1;
                 if(ap==1){
             System.out.print("Audience are voting");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".");
             Thread.sleep(1000);
             System.out.print(".\n\n\n\n\n");
            System.out.println("          Audience Rating");
            System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|");        
            System.out.println(" |-|     A     B    C   D     |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|                          |-|");
            System.out.println(" |-|                    __    |-|");
            System.out.println(" |-|                   |  |   |-|");
            System.out.println(" |-|                   |  |   |-|");
            System.out.println(" |-|                   |  |   |-|");
            System.out.println(" |-|          __       |  |   |-|");
            System.out.println(" |-|     __  |20|  __  |  |   |-|");
            System.out.println(" |-|    |10|_|  |_|10|_|60|   |-|");
            System.out.println(" |-|    |__|_|__|_|__|_|__|   |-|");
            System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|"); 
            for(int move=1;move<=16;move++){
               System.out.println();}
                 }
                 else{
                     System.out.println("you have used this lifeline");
                     lifeline(4);
                 }
           
                 }
        catch(InterruptedException exc){
            
        }
                 
        }
             
               
              else if(lifeline==2){
            for(int space=1;space<=25;space++){
                  System.out.println("");}
            ph=ph+1;
            if(ph==1){
            System.out.println("Choose any friend to call for help");
            System.out.println(" _________          _________            _________         _________  ");
            System.out.println("|         |\\       |         |\\         |         |\\      |         |\\");
            System.out.println("| RAM     | |      |  RAHIM  | |        |  RAJAN  | |     |  ROHIT  | |");
            System.out.println("|_________| |      |_________| |        |_________| |     |_________| |");
            System.out.println(" \\|________\\|      \\|_________\\|        \\|_________\\|     \\|_________\\|");
            System.out.println("Enter any one name for calling");
            
            
                         
                for(int space=1;space<=24;space++){
                  System.out.println("");  }         
              String call=m.next();
              switch(call){
                 
                  case "Ram" :
                  case "RAM" :   
                  case "ram" :
                  case "Rahim" :
                  case "rahim" :
                  case "RAHIM" :
                  case "Rajan" :
                  case "rajan" :
                  case "RAJAN" :    
                  case "Rohit" :
                  case "rohit" :
                  case "ROHIT" :   
                     
                  System.out.print("Call is Diverting to "+call);
                  
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print("."); 
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print("."); 
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.print(".");
                  Thread.sleep(1000);
                  System.out.println("."); 
                  System.out.println("Hello");
                  String as=m.next();
                  
                  System.out.println("Enter your question");
                   String a=m.next();
                  System.out.println("give me option");
                  String asa=m.next(); 
                  System.out.println("I think D is True");
                      break;
              
              
              }
              
              
              
            }
            else{
            System.out.println("You have already used this lifeline");
            lifeline(4);
            }
              }
              else if(lifeline==3){
                  for(int move=1;move<=30;move++){
                   System.out.println("");   
                  }
                  ff=ff+1;
                  if(ff==1){
                  System.out.println("Fifty fifty");
                  System.out.println("You Answer may be :-");
                  System.out.println("A.     ");
                  System.out.println("\t\tC.");
                   for(int move=1;move<=27;move++){
                   System.out.println("");   
                  }
              }
                  else{
                      System.out.println("You have already used this lifeline");
                      lifeline(4);
                  }
              }
              else if(lifeline==4){
                  fq=fq+1;
                  if(fq==1){
                  System.out.println("Flip the Question");
                  System.out.println("Which of the only planet of our Solar System that rotates in a clockwise direction around its own axis?");
                  System.out.println("(A) Earth                             (B) Jupiter ");
                  System.out.println("(C) Mars                              (D) Venus");
          for(int clr=1;clr<=25;clr++){
          System.out.println("");}
        
          System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");

          
                   
                  
              }else{
                      System.out.println("you have already used this lifeline");
                      lifeline(4);
                  }
              }
              else if(lifeline==5){
                  pp=pp+1;
                  if(pp==1){
              System.out.println("Welcome to Power Paplu lifeline");        
              System.out.print("------------------------------------------------------");
              System.out.print("\n|\t\t    Lifeline\t\t\t     |\n");
              System.out.println("------------------------------------------------------");
              System.out.println("1.Audience poll \t\t2.Phone a friend");
              System.out.println("3.Fifty fifty   \t\t4.Flip The question");
              System.out.println("5.Power paplu   \t\t6.Ask an expert");
              System.out.println("7.Double Dip");
              for(int space=1;space<=23;space++){
                  System.out.println("");
              }
              int pp=m.nextInt();
                 for(int space=1;space<=23;space++){
               System.out.println("");
              }
              if(pp==1){
                  System.out.println("Audience poll is Renewed");
                  ap=0;
                  lifeline(4);
              }
              else if (pp==2){
              System.out.println("Phone a Friend is Renewed");
              ph=0;
              lifeline(4);
              }
              else if(pp==3){
              System.out.println("Fifty Fifty is Renewed");
              ff=0;
              lifeline(4);
              }
              else if(pp==4){
              System.out.println("Flip the Question is Renewed");
              ask=0;
              lifeline(4);
              }
              else if(pp==6){
                  System.out.println("Ask an expert is Renewed");
                  ask=0;
              lifeline(4);
              }
              else{
                  System.out.println("Double dip is Renewed"); 
                  dd=0;
              lifeline(4);
              }
              
                      
                      
                  
                  
                  
                  }
                  else{
                      System.out.println("You have already used this lifeline");
                  lifeline(4);
                  }
              }
              else if(lifeline==6){
                  ask=ask+1;
                  if(ask==1){
                  System.out.println("Ask an Expert");
                  System.out.println("our today expert is Rohit joshi");
                  System.out.print("Redirecting to Rohit joshi");
                  Thread.sleep(1000);
                  System.out.println(".");
                  Thread.sleep(1000);
                  System.out.println(".");
                  Thread.sleep(1000);
                  System.out.println(".");
                  Thread.sleep(1000);
                  System.out.println(".");
                  Thread.sleep(1000);
                  System.out.println(".");
                  System.out.println("I think D is right answer");
                  
              }else{
                      System.out.println("You have Already used this lifeline");
                      lifeline(4);
                  }
              }
              else if(lifeline==7){
                  dd=dd+1;
                  if(dd==1){
                      
                  
                  System.out.println("Double dip");
                 System.out.println("Enter Two Option 1 by 1");
                  for(int space=1;space<=23;space++){
                  System.out.println("");}
                  String as;
                  as=m.next();

              
                 switch(as){
                     case "d":
                     case "D":
                         System.out.println("D is right Enter once again");
                         break;
                    default :     
                     System.out.println("Answer is wrong try again");
                 }
              }else{
                      System.out.println("You have Already used this lifeline");
                      lifeline(4);
                  }
              }
              else{
                  System.out.println("you have enter wrong choice");
                  lifeline(4);
              }
             
             
    
    }
        catch(InterruptedException exc){ 
            System.out.println("!!!!!!!!!!!!!!!!!!!!RESTART!!!!!!!!!!!!!!!!!!!");
                    }
        
}
     
    
    
    
    }
            
            
}

    
  
    
}


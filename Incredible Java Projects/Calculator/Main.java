import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

class club
{
Scanner s=new Scanner(System.in);
      int n;
      int role;
    private int budget=0;
    String name;
    public void add(int a)
{     budget +=a;
      System.out.println("New overall budget is: "+ budget);
}
    public void view()
{
System.out.println("Current overall Budget : "+ budget);
}
    public void info(int a)
    {
      System.out.println("\nPlease Enter Your Role : \n 1- Committee Head \n 2- Club Sec or J.Sec \n 3- Member");
            int k=0;
            for(int err=0;err==0;)
              {
      k=s.nextInt();
                if(k>3||k<1)
                {
      System.out.println("OOPS wrong choice..\nChoose again");
      }
              else
                err=1;      
      }
            role=k;
            System.out.println("Please Enter Your Name : ");
            name=s.next();
            n=a;
    }
}


//extended class for Cultural Committee
class cultural extends club
{  int cultural_budget;
public void list()
    {
    System.out.println("1- Drama Club: Masquerade");
        System.out.println("2- Dance Club: MOD 5");
        System.out.println("3- Photography Club: Obscura");
        System.out.println("4- Art Club: Shades");
        System.out.println("5- Music Club: Encore");
}
public void addmem() throws IOException
{   Scanner s= new Scanner(System.in);
    System.out.println("Enter Name:");
    String a=s.next();
    System.out.println("Enter Club:");
    String string ;
    string=s.next();
    String b=String.format("%-" + 13 + "." + 13 + "s", string);//for alignment
    String c= b+a;
    try (FileWriter fw=new FileWriter("cultural.txt",true);
    BufferedWriter bw= new BufferedWriter(fw)){
    for (int i = 0; i < c.length(); i++)
            fw.write(c.charAt(i));
          bw.newLine();           
          }

}
public void add(int a)
{
cultural_budget=+a;
}
public void listmem() throws IOException
{   Scanner s= new Scanner(System.in);
     int ch;
    System.out.println("Members under this committee are ::");
            System.out.println("--------------------------");
            System.out.println("CLUB            NAME");
            System.out.println("--------------------------");
        // check if File exists or not
        FileReader fr=null;
        try
        {
            fr = new FileReader("cultural.txt");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }
 
        // read from FileReader till the end of file
        while ((ch=fr.read())!=-1)
            System.out.print((char)ch);
        fr.close();

}
public void remove() throws IOException
{     Scanner s= new Scanner(System.in);
      File ogFile = new File("cultural.txt");
      File temp = new File("Temp.txt");

BufferedReader read = new BufferedReader(new FileReader(ogFile));
BufferedWriter w = new BufferedWriter(new FileWriter(temp));
    System.out.println("Enter Name of the member to be removed:");
    String a=s.next();
    System.out.println("Enter the Club, "+a+" belongs to :");
    String string ;
    string=s.next();
    String b=String.format("%-" + 13 + "." + 13 + "s", string);//for making it same as the entered string in the file
    String c= b+a;

String mem_rem = c;
String current;

while((current = read.readLine()) != null) {
    // trim newline when comparing with lineToRemove
    String trimmed = current.trim();
    if(trimmed.equals(mem_rem)) continue;
    w.write(current + System.getProperty("line.separator"));
}
w.close(); 
read.close(); 
ogFile.delete();
boolean success = temp.renameTo(ogFile);
}
}


//extended class for Technical Committee
class technical extends club
{   int tech_budget;
public void list()
    {
        System.out.println("1- Coding Club");
        System.out.println("2- Design Club: DOT");
        System.out.println("3- Maths Club: Enigma");
        System.out.println("4- Gaming Club: Arcadia");
}
public void addmem() throws IOException
{   Scanner s= new Scanner(System.in);
    System.out.println("Enter Name:");
    String a=s.next();
    System.out.println("Enter Club:");
    String string ;
    string=s.next();
    String b=String.format("%-" + 13 + "." + 13 + "s", string);//for alignment
    String c= b+a;
    try (FileWriter fw=new FileWriter("technical.txt",true);
    BufferedWriter bw= new BufferedWriter(fw)){
    for (int i = 0; i < c.length(); i++)
            fw.write(c.charAt(i));
          bw.newLine();
    }
}
public void add(int a)
{
tech_budget=+a;
}
public void listmem() throws IOException
{   Scanner s= new Scanner(System.in);
     int ch;
    System.out.println("Members under this committee are ::");
            System.out.println("--------------------------");
            System.out.println("CLUB            NAME");
            System.out.println("--------------------------");
        // check if File exists or not
        FileReader fr=null;
        try
        {
            fr = new FileReader("technical.txt");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }
 
        // read from FileReader till the end of file
        while ((ch=fr.read())!=-1)
            System.out.print((char)ch);
 
        // close the file
        fr.close();

}
public void remove() throws IOException
{     Scanner s= new Scanner(System.in);
      File ogFile = new File("technical.txt");
      File temp = new File("Temp.txt");

BufferedReader read = new BufferedReader(new FileReader(ogFile));
BufferedWriter w = new BufferedWriter(new FileWriter(temp));
    System.out.println("Enter Name of the member to be removed:");
    String a=s.next();
    System.out.println("Enter the Club, "+a+" belongs to :");
    String string ;
    string=s.next();
    String b=String.format("%-" + 13 + "." + 13 + "s", string);//for making it same as the entered string in the file
    String c= b+a;

String mem_rem = c;
String current;

while((current = read.readLine()) != null) {
    // trim newline when comparing with lineToRemove
    String trimmed = current.trim();
    if(trimmed.equals(mem_rem)) continue;
    w.write(current + System.getProperty("line.separator"));
}
w.close(); 
read.close(); 
ogFile.delete();
boolean success = temp.renameTo(ogFile);
}
}


//extended class for Sports Committee
class sports extends club
{   int sport_budget;
public void list()
    {
System.out.println("There are no clubs within this Committee, it functions on it's own");
}
public void addmem() throws IOException
{   Scanner s= new Scanner(System.in);
    System.out.println("Enter Name:");
    String a=s.next();
    String c= a;
    try (FileWriter fw=new FileWriter("sports.txt",true);
    BufferedWriter bw= new BufferedWriter(fw)){
    for (int i = 0; i < c.length(); i++)
            fw.write(c.charAt(i));
          bw.newLine();           
    }
}
public void add(int a)
{
sport_budget=+a;
}
public void listmem() throws IOException
{   Scanner s= new Scanner(System.in);
     int ch;
    System.out.println("Members under this committee are ::");
            System.out.println("--------");
            System.out.println("  NAME  ");
            System.out.println("--------");
        // check if File exists or not
        FileReader fr=null;
        try
        {
            fr = new FileReader("sports.txt");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }
 
        // read from FileReader till the end of file
        while ((ch=fr.read())!=-1)
            System.out.print((char)ch);
 
        // close the file
        fr.close();

}
public void remove() throws IOException
{     Scanner s= new Scanner(System.in);
      File ogFile = new File("sports.txt");
      File temp = new File("Temp.txt");

BufferedReader read = new BufferedReader(new FileReader(ogFile));
BufferedWriter w = new BufferedWriter(new FileWriter(temp));
    System.out.println("Enter Name of the member to be removed:");
    String a=s.next();
    String c= a;
String mem_rem = c;
String current;
while((current = read.readLine()) != null) {
    // trim newline when comparing with lineToRemove
    String trimmed = current.trim();
    if(trimmed.equals(mem_rem)) continue;
    w.write(current + System.getProperty("line.separator"));
}
w.close(); 
read.close(); 
ogFile.delete();
boolean success = temp.renameTo(ogFile);
}
}


//extended class for Literature Committee
class literature extends club
{   int lit_budget;
public void list()
    {
System.out.println("There are no clubs within this Committee, it functions on it's own");
}
public void addmem() throws IOException
{   Scanner s= new Scanner(System.in);
    System.out.println("Enter Name:");
    String a=s.next();
    String c= a;
    try (FileWriter fw=new FileWriter("literature.txt",true);
    BufferedWriter bw= new BufferedWriter(fw)){
    for (int i = 0; i < c.length(); i++)
            fw.write(c.charAt(i));
          bw.newLine();
    }
}
public void add(int a)
{
lit_budget=+a;
}
public void listmem() throws IOException
{   Scanner s= new Scanner(System.in);
     int ch;
    System.out.println("Members under this committee are ::");
            System.out.println("--------");
            System.out.println("  NAME  ");
            System.out.println("--------");
        // check if File exists or not
        FileReader fr=null;
        try
        {
            fr = new FileReader("literature.txt");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }
 
        // read from FileReader till the end of file
        while ((ch=fr.read())!=-1)
            System.out.print((char)ch);
 
        // close the file
        fr.close();

}
public void remove() throws IOException
{     Scanner s= new Scanner(System.in);
      File ogFile = new File("literature.txt");
      File temp = new File("Temp.txt");

BufferedReader read = new BufferedReader(new FileReader(ogFile));
BufferedWriter w = new BufferedWriter(new FileWriter(temp));
    System.out.println("Enter Name of the member to be removed:");
    String a=s.next();
    String c= a;
String mem_rem = c;
String current;
while((current = read.readLine()) != null) {
    // trim newline when comparing with lineToRemove
    String trimmed = current.trim();
    if(trimmed.equals(mem_rem)) continue;
    w.write(current + System.getProperty("line.separator"));
}
w.close(); 
read.close(); 
ogFile.delete();
boolean success = temp.renameTo(ogFile);
}
}

class PasswordField {

   public static String readPassword (String prompt) {
      EraserThread et = new EraserThread(prompt);
      Thread mask = new Thread(et);
     

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String password = "";
      mask.start();
      try {
          password = in.readLine();
      } catch (IOException ioe) {
          ioe.printStackTrace();
      }
      et.stopMasking();
      return password;
   }
}  

class EraserThread implements Runnable {
   private boolean stop;

   public EraserThread(String prompt) {
       System.out.print(prompt);
   }

   public void run () {
      while (!stop){
         System.out.print("\010*");
         try {
            Thread.currentThread().sleep(1);
         } catch(InterruptedException ie) {
            ie.printStackTrace();
         }
      }
   }

   public void stopMasking() {
      this.stop = true;
   }
}


//Main
public class Main
{
public static void delay(int lk) 
{
  for(int i=0;i<=6;i++)
            {
                try
    {
        Thread.sleep(lk*100);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
    System.out.print(".");
            }
        clearScreen();
} 
public static void clearScreen()
{
//Clears Screen in java
try
{
if (System.getProperty("os.name").contains("Windows"))
new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
else
Runtime.getRuntime().exec("clear");

    } catch (IOException | InterruptedException ex) {}
}
public static void mainmenu() throws IOException
{
Scanner s= new Scanner(System.in);
        club A = new club();
        cultural B = new cultural();
        technical C = new technical();
        sports D = new sports();
        literature E = new literature();

for(int revert=0;revert==0;)
{        
System.out.println("--------------------------------------\n   CLUB MANAGEMENT SYSTEM - IIITV\n--------------------------------------");
        System.out.println("Please Select the Committee you wanna access :-");
        System.out.println("1- Cultural Committee");
        System.out.println("2- Technical Committee");
        System.out.println("3- Sports Committee");
        System.out.println("4- Literature Committee");
        int c=0;
        for(int err=0;err==0;)
        {
        c=s.nextInt();
        if(c>4||c<1)
        {
System.out.println("OOPS wrong choice..\nChoose again");
}
        else
        err=1;
        }
        clearScreen();
        //Saves basic info
        A.info(c);
        clearScreen();
        String nm= A.name;
        int loop=1;
      //for the type of action that has to be performed
        int Rl=A.role;
        for(;loop==1;)
{
        if(Rl==1)
        {
          System.out.println("Hello, "+nm+" What is it that you wanna do??");
                    System.out.println("1- Add budget");
                    System.out.println("2- List Clubs");
                    System.out.println("3- View Budget");
                    System.out.println("4- List Members");
                    System.out.println("5- Back");
                    System.out.println("6- Exit");
                    int k=0;
                    for(int err=0;err==0;)
                    {
                    k=s.nextInt();
                      if(k>6||k<1)
                      {
                    System.out.println("OOPS wrong choice..\nChoose again");
          }
                      else
                      err=1;      
          }
                    clearScreen();
                    if(k==1)
                    {
                    System.out.println("Please Mention The Amount you wanna add :");
                    int am=s.nextInt();
                    A.add(am);
                      if(A.n==1)
                        B.add(am);
                      else if(A.n==2)
                        C.add(am);
                      else if(A.n==3)
                        D.add(am);
                      else
                        E.add(am);
                     System.out.println("Adding");
                     delay(7); 
                    }
                    else if(k==5)
                        break;
                    else if(k==6)
                      {System.out.print("Thanks for Using\nBYE ");
                          for(int i=0;i<=6;i++)
                                  {
                                      try
                          {
                              Thread.sleep(400);
                          }
                          catch(InterruptedException ex)
                          {
                              Thread.currentThread().interrupt();
                          }
                          System.out.print(".");
                        }
                        clearScreen();
                        revert=1;
                        break;}
                    else if(k==3)
                    {A.view();
                      if(A.n==1)
                        System.out.println("Budget for Committee : "+ B.cultural_budget);
                      else if(A.n==2)
                        System.out.println("Budget for Committee : "+C.tech_budget);
                      else if(A.n==3)
                        System.out.println("Budget for Committee : "+D.sport_budget);
                      else
                    System.out.println("Budget for Committee : "+E.lit_budget);
                    delay(10);
                    }
                    else if(k==2)
                    {
                      if(A.n==1)
                        B.list();
                      else if(A.n==2)
                        C.list();
                      else if(A.n==3)
                        D.list();
                      else
                        E.list();
                      delay(10);
                    }
                    else if(k==4)
                    { 
                      if(A.n==1)
                      B.listmem();
                      else if(A.n==2)
                      C.listmem();
                      else if(A.n==3)
                      D.listmem();
                      else
                      E.listmem();
                    delay(20);
                    }
          }
        if(Rl==2)
        {
System.out.println("Hello, "+nm+" What is it that you wanna do??");
          System.out.println("1- View budget");
          System.out.println("2- List Members");
          System.out.println("3- Add Members");
          System.out.println("4- Remove Members");
          System.out.println("5- Back");
          System.out.println("6- Exit");
          int k=0;
          for(int err=0;err==0;)
          {
          k=s.nextInt();
          if(k>6||k<1)
          {
          System.out.println("OOPS wrong choice..\nChoose again");
          }
          else
          err=1;      
          }
          clearScreen();
          if(k==1)
          {A.view();
                      if(A.n==1)
                        System.out.println("Budget for Committee : "+ B.cultural_budget);
                      else if(A.n==2)
                        System.out.println("Budget for Committee : "+C.tech_budget);
                      else if(A.n==3)
                        System.out.println("Budget for Committee : "+D.sport_budget);
                      else
                    System.out.println("Budget for Committee : "+E.lit_budget);
                    delay(10);
          }
          else if(k==5)
          break;
          else if(k==6)
          {System.out.print("Thanks for Using\nBYE ");
              for(int i=0;i<=6;i++)
                      {
                          try
              {
                  Thread.sleep(400);
              }
              catch(InterruptedException ex)
              {
                  Thread.currentThread().interrupt();
              }
              System.out.print(".");
            }
            clearScreen();
            revert=1;
          break;}
          else if(k==3)
          {
            if(A.n==1)
              B.addmem();
           else if(A.n==2)
              C.addmem();
           else if(A.n==3)
              D.addmem();
           else
              E.addmem();

          System.out.println("Adding");
          delay(6);

          }
          else if(k==2)
          { 
            if(A.n==1)
            B.listmem();
            else if(A.n==2)
            C.listmem();
            else if(A.n==3)
            D.listmem();
            else
            E.listmem();
          delay(15);
          }
          else if(k==4)
          { 
            if(A.n==1)
            B.remove();
            else if(A.n==2)
            C.remove();
            else if(A.n==3)
            D.remove();
            else
            E.remove();
          System.out.println("Removing");
          delay(6);
          }
        }
        if(Rl==3)
        {
          System.out.println("What is it that you wanna do??");
          System.out.println("1- List Members");
          System.out.println("2- Back");
          System.out.println("3- Exit");
          int k=0;
          for(int err=0;err==0;)
          {
          k=s.nextInt();
          if(k>3||k<1)
          {
          System.out.println("OOPS wrong choice..\nChoose again");
          }
          else
          err=1;      
          }
          clearScreen();
          if(k==1)
          { 
            if(A.n==1)
            B.listmem();
            else if(A.n==2)
            C.listmem();
            else if(A.n==3)
            D.listmem();
            else
            E.listmem();
          delay(15);
          }
          else if(k==2)
          break;
          else if(k==3)
          {System.out.print("Thanks for Using\nBYE ");
              for(int i=0;i<=6;i++)
                      {
                          try
              {
                  Thread.sleep(400);
              }
              catch(InterruptedException ex)
              {
                  Thread.currentThread().interrupt();
              }
              System.out.print(".");
            }
            clearScreen();
            revert=1;
          break;}
        }
        //confirms exit status
        clearScreen();
}
}
}

public static void main( String[] args) throws IOException
{
  clearScreen();
  String password;
char pass[]=new char[5];
pass[0]='q';
pass[1]='w';
pass[2]='e';
pass[3]='r';
pass[4]='t';
String s=new String(pass);
do{
password = PasswordField.readPassword("Enter password (for safety input will be represented as) ");
System.out.println("Password entered was:" + password);
if(password.equals(s))
{
    System.out.println("Password Matched!!");
    System.out.print("Loading ");
    for(int i=0;i<=6;i++)
            {
                try
    {
        Thread.sleep(400);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
    System.out.print(".");
            }
    System.out.println();
    clearScreen();
                    mainmenu();
}
else
{
        System.out.println("Password is invalid!!");
        System.out.println("ENTER correct password");
    for(int i=0;i<=6;i++)
            {
                try
    {
        Thread.sleep(400);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
    System.out.print(".");
            }
        clearScreen();
}
}while(!password.equals(s));
}
}
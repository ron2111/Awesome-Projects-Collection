import java.util.*;
class btech
{
    public static void main()
    {
    Scanner sc=new Scanner(System.in);
    System.out.print("enter marks of 1st year");
    int a1=sc.nextInt();
    System.out.print("enter total marks of 1st year");
    int b1=sc.nextInt();
    System.out.print("enter marks of 2nd year");
    int a2=sc.nextInt();
    System.out.print("enter total marks of 2nd year");
    int b2=sc.nextInt();
    System.out.print("enter marks of 3rd year");
    int a3=sc.nextInt();
    System.out.print("enter total marks of 3rd year");
    int b3=sc.nextInt();
    System.out.print("enter marks of 4th year");
    int a4=sc.nextInt();
    System.out.print("enter total marks of 4th year");
    int b4=sc.nextInt();
    double c1=(a1*.25);
    double c11=(b1*.25);
    
    double c2=(a2*.50);
    double c22=(b2*.50);
    
    double c3=(a3*.75);
    double c33=(b3*.75);
    
    double c4=(a4*1);
    double c44=(b4*1);
    
    System.out.println("-----------------------------------------------------------------");
    double c= c1+c2+c3+c4;
    double d= c11+c22+c33+c44;
    System.out.println("total marks obtained in btech"+c);
    System.out.println("total marks in btech"+d);
    
    System.out.println("percentage= "+(c/d));
    
    }
}
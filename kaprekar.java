//coded by shreeyachatzz
//To check if number entered by the user is a Kaprekar number or not.
import java.util.*;
public class Kaprekar
{
    boolean check_even(double no)//Method to check if the number sent as parameter is an even number or not
    {
        if(no%2 == 0)//Condition for even
        {
            return true;            
        }
        else
        {
            return false;
        }
    }
   
    public static void main (String args[])
    {
        String p1="",p2="";int pn1,pn2;//intitializing variables
        Scanner sc= new Scanner (System.in);
        System.out.println("Enter the number to be squared and checked for Kaprekar");
        String n= sc.next()+sc.nextLine();//Accepting the number as input from the user as String
        double  ni= Double.valueOf(n);//Converting the number in String to double value
        double ns= Math.pow(ni,2.0);//Computing the square of the number
        System.out.println("The number squared = "+ns);//Displaying the square
        String nsd= Integer.toString((int)ns);//Convverting the integer to String type value
        int l= nsd.length();//To store the length of the String
        Kaprekar obj= new Kaprekar();//Creating object    
        if(obj.check_even(l))//When the number of digits in the square is even
        {            
            pn1= l/2;//The number gets split into equal halves
            for( int i=0; i<pn1; i++)
            {
                p1=p1+nsd.charAt(i);
            }
            for( int j=pn1; j<l; j++)
            {
                p2=p2+nsd.charAt(j);
            }
        }
        else//When the number of digits in the square is odd
        {            
            pn1= (l-1)/2;//The number gets split unequally
            for( int i=0; i<pn1; i++)
            {
                p1=p1+nsd.charAt(i);
            }
            for( int j=pn1; j<l; j++)
            {
                p2=p2+nsd.charAt(j);
            }
        }
        System.out.println("Part 1 = "+p1+"\nPart 2 = "+p2 );//Displaying the split parts of the square of the number entered
        double add= Double.valueOf(p1)+ Double.valueOf(p2);//Adding the two parts
        System.out.println("The Addition of the two parts = "+add);//Displaying the addition result
        //Checking if the addition result and the number entered are equal or not and thereby declaring number as Kaprekar or not
        if (add == ni)
        {
            System.out.println("The number entered is a Kaprekar NUMBER");
        }
        else
        {
            System.out.println("The number entered is NOT a KAPREKAR NUMBER");
        }
    }
}
/*OUTPUT(1):
Enter the number to be squared and checked for Kaprekar
45
The number squared = 2025.0
Part 1 = 20
Part 2 = 25
The Addition of the two parts = 45.0
The number entered is a KAPREKAR NUMBER

*OUTPUT(2):
Enter the number to be squared and checked for Kaprekar
297
The number squared = 88209.0
Part 1 = 88
Part 2 = 209
The Addition of the two parts = 297.0
The number entered is a KAPREKAR NUMBER
*/

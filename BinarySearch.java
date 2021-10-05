//Coded by shreeyachatzz
/* Accept a number of elements in a one dimensional array. Sort the elements in recursive manner by bubble sort method. After that search for existance of an element by using binary search method.*/
import java.util.*;
class BinarySearch
{
    //Declaring Global variables
    int arr[];
    int n;
    BinarySearch(int nn)//Constructor to initialise the Global Variables.
    {
        n=nn;
        arr=new int[n];
    }

    void readdata()//To accept the data from user.
    {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter data ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        
    }
    void sort(int i,int j)//Doing bubble sort using recursive function.
    {
        if(i<arr.length-1)
        {
            if (j<arr.length-1-i)
            {
                if (arr[j]>arr[j+1])
                {
                    int t=arr[j];arr[j]=arr[j+1];arr[j+1]=t;
                }
                sort(i,j+1);
             
              
            }
            else
            
            sort(i+1,0);
        }
    }

    int binary_search(int v,int l ,int u)//Method to carry out binary_search using binary_search technique.
    {
        {
            if(l<u)
            {
                int m =(l+u)/2;
                if(arr[m]==v)
                    return m;
                else if(arr[m]>v)
                    return binary_search(v,l,m-1);
                else
                    return binary_search(v,m+1,u);
            }
            return -1;
        }
    }
    void disp()//to dislpay the array.
    {
        for (int i=0;i<n;i++)
        {
        
            System.out.println(arr[i]);
        }
        }
    public static void main()//Method main.
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no. of elements in the array");//to accept the maximum number of elements from the user.
        int num=sc.nextInt();
        BinarySearch obj=new BinarySearch(num);//Creating object.
        obj.readdata();
        obj.sort(0,0);
        System.out.println("The Sorted Array:");
        obj.disp();
        System.out.println("Enter the Element that has to be searched:");
        int ele=sc.nextInt();
        int k=obj.binary_search(ele,0,num-1);
        if (k!=-1)//In case the element is found
        System.out.println(ele+" is found in position="+k);
        else//In case the element is not found
        System.out.println(ele+" is not present in the array");        
}
}
 /*output
 enter no. of elements in the array
5
Enter data 
12
32
11
89
9
display of sorted array
9
11
12
32
89
enter the element to search
12
12 is found in position=2

  * 

  */

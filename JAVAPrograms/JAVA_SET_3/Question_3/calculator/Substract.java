//SUBSTRACTION CLASS
package Question_3.calculator;
import java.util.*;

public class Substract
{
    Scanner in = new Scanner(System.in);

    public int substractTwoNumbers(int a,int b)
    {
        return a-b;
    }
    
    public void substractTwoArray()
    {
        int n1,n2;
        
        System.out.println("Enter Length of Array 1 -->");
        n1=in.nextInt();
        
        System.out.println("Enter Length of Array 2 -->");
        n2=in.nextInt();
        
        int A1[],A2[],A3[];
        
        A1=new int[n1];
        A2=new int[n2];
        A3=new int[n1>n2?n1:n2];
        
        System.out.println("Enter The Value of Array 1 -->");
        
        for(int i=0;i<n1;i++)
        A1[i]=in.nextInt();
        
        System.out.println("Enter The Value of Array 2 -->");
        
        for(int i=0;i<n2;i++)
        A2[i]=in.nextInt();
        
        
        for(int i=0;i<(n1>n2?n2:n1);i++)
        A3[i]=A1[i]-A2[i];
        
        if(n1>n2)
        for(int i=n2;i<n1;i++)
        A3[i]=A1[i];
        
        if(n1<n2)
        for(int i=n1;i<n2;i++)
        A3[i]=A2[i];
        
        System.out.println("Output Array After Substraction -->");
        
        for(int i:A3)
        System.out.print(i+" ");
        System.out.println();
    }
}
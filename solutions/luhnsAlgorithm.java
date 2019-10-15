import java.util.*;
public class Solution {
  public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner scan=new Scanner(System.in);
    String num1=new String(scan.nextLine());

    //Reverse inputted string
    String reversed = new String("");
    for(int i = num1.length() - 1; i >= 0; i--)
     {
      reversed = reversed + num1.charAt(i);
     }

    int sum=0;
    for(int i=0;i<=reversed.length()-1;i++)
    {
      int current = Character.getNumericValue(reversed.charAt(i));
      if(i%2!=0)
      {
        current*=2;
       }
       if(current>9)
        {
          current-=9;
        } 
        sum+=current;
      }
     if(sum%10==0)
       {
        System.out.println("VALID");
        }
     else
       {
        System.out.println("INVALID");
       }
    }
}

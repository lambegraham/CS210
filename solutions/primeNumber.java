import java.util.*;

public class Solution {
 public static void main(String args[] ) {
        
     Scanner sc = new Scanner(System.in);
     
    // System.out.println();
     
     int n = sc.nextInt();
     
     int num = 1; int count=0;
   //  int count=0;
     int i=0;
     
     while (count<n){
         num=num+1;
         for(i = 2; i<=num; i++){
             if(num%i==0)
             {
                 break;
             }
         }
         if(i==num){
             count = count+1;
         }
     }
     System.out.println(num);
     
 }
}

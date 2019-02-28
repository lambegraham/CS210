import java.util.*;

public class collatzLab2 {



    public static void main(String args[]) {

    	Scanner sc = new Scanner(System.in);
    	System.out.println("Insert Student Number: ");
    	int n = sc.nextInt();
    //	int n = 16432016;
    	int count = 0;

		System.out.println("Change a number in your student number by adding or subtracting a number, what is the number you would like to input?: ");
		int cnum = sc.nextInt();

		n = n+cnum;

    	while(n!=1){
    		if(n%2 == 0){
    			n = n/2;
    			count++;
    		}
    		else if(n%2 == 1){
    			n = n*3+1;
    			count++;
    		}
    	}
    //	System.out.println("Collatz Number = "+ count);
    	System.out.println("Steps taken: "+ count);
    }
}

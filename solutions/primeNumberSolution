import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int counter = 1;
		int prime = 3;
		boolean check = true;
		while (counter != x) {
			for (int i = 2; i < prime; i++) {
				if (prime % i == 0) {
					check = false;
				}
			}
			if (check == true) {
				counter++;
			}
			check = true;
			prime++;
		}
		System.out.println(prime - 1);
	}
}

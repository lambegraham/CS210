//Find the longest Collatz sequence which descends through your student number
public class lab2Collatz {
	public static void main(String args[]) {
		long number = 123456;
		long steps = 0;
		while (number > 1) {
			if (number % 2 == 0) {
				number = number / 2;
			} else {
				number = (number * 3) + 1;
			}
			steps++;
		}
		System.out.println(steps);
	}
}

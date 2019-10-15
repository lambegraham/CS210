import java.util.*;

public class sortWordsSolution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String tempString;
		String[] array = new String[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextLine();
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j].length() > array[j + 1].length()) {
					tempString = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tempString;
				}
				if (array[j].length() == array[j + 1].length() && array[j].compareToIgnoreCase(array[j + 1]) > 0) {
					tempString = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tempString;
				}
			}

		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}
}

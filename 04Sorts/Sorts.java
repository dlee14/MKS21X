public class Sorts {
	public static String name() {
		return "09.Lee.Peter";
	}

	public static void selectionSort(int[] data) {
		int helper = 0;
		int index = 0;
		boolean helperExists;
		for (int i = 0; i < data.length - 1; i++) {
			helperExists = false;
			helper = data[i];
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < helper) {
					helper = data[j];
					index = j;
					helperExists = true;
				}
			}
			if (helperExists) {
				data[index] = data[i];
				data[i] = helper;
			}
		}
	}

	public static void insertionSort(int[] data) {
		// First step is to find what is in order
		// Next is to find where I should put my next number
		int swap = 0;
		int index = 0;
		for (int i = 0; i < data.length - 1; i++) {
			//System.out.println("start of a for loop");
			if (data[i] > data[i + 1]) {
				index = i + 1;
				while (index >= 0 && data[index] < data[index - 1]) {
					//System.out.println("start of a while loop");
					swap = data[index];
					data[index] = data[index - 1];
					data[index - 1] = swap;
					index --;
				}
				// for (int j = i + 1; j > 0; j--) {
				// 	if (data[j] < data[j - 1]) {
				// 		swap = data[j];
				// 		data[j] = data[j - 1];
				// 		data[j - 1] = swap;
				// 	}
				// }
			}

		}
	}

	public static void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			if (i > 0) {
				System.out.print(", ");
			}
			System.out.print(data[i]);
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int[] data = {1,5,4,7,3,4,9,2,1,2};
		print(data);
		insertionSort(data);
		print(data);

	}
}
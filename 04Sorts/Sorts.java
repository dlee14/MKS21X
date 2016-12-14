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
		int[] data = {2,6,3,1,6,2,3,9,4,5,3,5,2,3,6,3,0};
		selectionSort(data);

		print(data);

	}
}
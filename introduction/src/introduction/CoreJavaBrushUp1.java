package introduction;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		int num = 5;
		String website = "Rahul Shetty Academy";
		char letter = 'r';
		float dec = 5.99f;
		boolean myCar = true;

		System.out.println(num + " is the value stored in the num variable");

		// Arrays
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;

		int[] arr2 = { 1, 2, 3, 4, 5 };
		System.out.println(arr2[0]);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		String[] names = { "rahul", "shetty", "selenium" };

		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + ", ");
		}
		System.out.println();

		for (String name : names) {
			System.out.println(name);
		}
	}

}

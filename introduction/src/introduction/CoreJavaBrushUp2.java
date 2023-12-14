package introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5, 6, 7, 8, 9, 10, 122 };
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.println(arr[i]);
				break;
			} else {
				System.out.println(arr[i] + " is not a multiple of 2");
			}
		}
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("rahul");
		a.add("shetty");
		a.add("academy");
		a.add("selenium");
		System.out.println(a.get(3));
		
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
		System.out.println("********************");
		
		for (String name: a) {
			System.out.println(name);
		}
		
		System.out.println(a.contains("selenium"));
		String[] names = { "rahul", "shetty", "selenium" };
		List<String> namesArrayList = Arrays.asList(names);
		namesArrayList.contains("rahul");
	}

}

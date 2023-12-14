package introduction;

public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		// String as an object
		// String literal
		String s = "Rahul Shetty Academy";
		String s1 = "Rahul Shetty Academy"; // same object
		
		// String with new keyword
		String s2 = new String("Welcome");
		String s3 = new String("Welcome"); // separate objects
		
		String[] splittedString = s.split("Shetty");
		for (String str: splittedString) System.out.println(str.trim());
		
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.println(s.charAt(i));
		}
	}

}

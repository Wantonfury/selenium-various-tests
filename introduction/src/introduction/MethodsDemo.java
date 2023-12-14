package introduction;

public class MethodsDemo {

	public static void main(String[] args) {
		MethodsDemo d = new MethodsDemo();
		MethodsDemo2 d2 = new MethodsDemo2();
		
		String name = d.getData();
		System.out.println(name);
		d2.getUserData();
	}
	
	public String getData() {
		System.out.println("Hello world!");
		return "rahul shetty";
	}

}

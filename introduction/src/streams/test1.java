package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {

	public static void main(String[] args) {
		//regular();
		//streamFilter();
		//streamMap();
		//streamCollect();
	}
	
	@Test
	public static void regular() {
		// count the number of names starting with alphabet a in list
		
				int count = 0;
				ArrayList<String> names = new ArrayList<String>();
				names.add("Abhijeet");
				names.add("Don");
				names.add("Alekhya");
				names.add("Adam");
				names.add("Ram");
				
				for (int i = 0; i < names.size(); i++) {
					String name = names.get(i);
					
					if (name.startsWith("A")) {
						count++;
					}
				}
				
				System.out.println("Count: " + count);
	}
	
	@Test
	public static void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		
		// There is no life for intermediate op if there is no terminal op
		// terminal op will execute only if intermediate op (filter) returns true
		// we can create stream with Stream
		// How to use filter in Stream API
		long count = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("Count: " + count);
		
		long c = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Ram").filter(s -> {
			return s.startsWith("A");
		}).count();
		
		System.out.println(c);
		
		// print all the names of ArrayList
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}
	
	@Test
	public static void streamMap() {
		// print the names with last letter 'a' with Uppercase
		Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		
		// print names which have first letter as 'a' with uppercase and sorted
		List<String> names1 = Arrays.asList("Azbhijeet", "Don", "Alekhya", "Adam", "Rama");
		names1.stream().filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).sorted().forEach(s -> System.out.println(s));
		
		List<String> names2 = Arrays.asList("man", "Don", "woman");
		
		// Merging two different lists
		Stream<String> namesStream = Stream.concat(names1.stream(), names2.stream());
		// namesStream.sorted().forEach(s -> System.out.println(s));
		
		boolean flag = namesStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect() {
		List<String> names = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println("TEST: " + names.get(0));
		
		// print unique number from this array
		// sort the array
		List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		values.stream().distinct().sorted((Integer a, Integer b) -> b - a).skip(2).limit(1).forEach(n -> System.out.println(n)); // or use collect and get(3)
		// List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList); then li.get(2);
	}
}

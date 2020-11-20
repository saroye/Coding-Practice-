package micellaneous;


import java.util.*;

/**
 *  This class is a potential solution for 2 problems asked on Java.
 * @author Saroye
 */
public class ACD {
	/**
	 * 
	 * 	Problem 1: I ran a loop for asked number of integers. 
	 * 	Which checks for the first condition. 
	 * 	If the given integer is multiple of 3, 
	 * 	which needs to be further doubled checked if that integer might be a multiple of 5 and 3.
	 * 	then did the similar with multiples fo 5 and 10.
	 * 
	 */
	public void FizzBuzz() {
		for(int i=1; i<=100; i++) {
			if(i%3==0) {
				if(i%3 ==0 && i%5==0) {
					System.out.println("FizzBuzz, ");
				}
				else {
					System.out.print("Fizz, ");
				}
			}
			else if(i%5==0) {
				System.out.print("Buzz, ");
			}
			else {
				System.out.print(i+", ");
			}
		}
	}

	/**
	 * @param people
	 * @return
	 * 
	 * given Problem 2
	 */
	String foundPerson(String[] people){
		for (int i = 0; i < people.length; i++) {
			if (people[i].equals("Lane")){
				return "Lane";
			}
			if (people[i].equals("Aubrey")){
				return "Aubrey";
			}
			if (people[i].equals("Casey")){
				return "Casey";
			}
		}
		return "";
	}
	
	/*
	 * if the given string array is sorted.
	 * I used binary search to located the person in the array and returned its index.
	 * I started with choosing the mid point of array.
	 * checked if the element is present on the mid point of array
	 * if the mid is the person asked for.
	 * I iterated by one towards the element (if the person's name in lexichronological order)
	 * which will be changed with start or end based on the position of mid point
	 * eventually the gap between start and end will point to same index if the person is not found already.
	 * Time complexity of binary search is O (log N)
	 */
	public int binarySearch(String[] ar, String n) {
		int start =0;
		int end=ar.length-1;
		while(start<=end) {
			int  mid= start+ (end-start)/2;
			if(n.compareTo(ar[mid])==0) {
				return mid;
			}
			else if(n.compareTo(ar[mid])>0) {
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		return -1;
	}
	
	/**
	 * @param people
	 * @return
	 * 
	 * used the binary search to locate the person. IF the given array is sorted
	 * I was not sure if the array is sorted or not.
	 * So, I implemented 2 solutions.
	 * 
	 * This is a better solution. As the time complexity for binary search is O (log N)
	 *  which is better than iterating through all of the array which is O(N)
	 *  Linear amount of calls to bianry search, 3 x O (Log N) will still be O (Log N)
	 */

	public String FindPeople(String[] people) {

		if(this.binarySearch(people, "Lane")!= -1) {
			System.out.println("Lane found at index    "+this.binarySearch(people, "Lane"));
		}
		if(this.binarySearch(people, "Aubrey")!= -1) {
			System.out.println(  "Aubrey found at index  "+this.binarySearch(people, "Aubrey"));
		}
		if(this.binarySearch(people, "Casey")!= -1) {
			System.out.println(  "Casey found at index   "+this.binarySearch(people, "Casey"));
		}
		return "";	
	}

	/**
	 * 
	 * @param people
	 * @return
	 * 
	 * here I made a hashmap for the the array of people 
	 * which does take O (N) time complexity to iterate throught the array.
	 * Anyhow, to search for an element in HashMap is O (1). 
	 */
	public String FindPeople2(String[] people) {

		Map<Integer, String> hMap = new HashMap<Integer, String>();

		for(int i=0; i<people.length; i++) {
			hMap.put(i, people[i]);
		}

		if(hMap.containsValue("Lane")) {
			System.out.println("Lane Found!");
		}
		if(hMap.containsValue("Aubrey")) {
			System.out.println("Aubrey Found!");
		}
		if(hMap.containsValue("Casey")) {
			System.out.println("Casey Found!");
		}
		return "";
	}

	public static void main(String args[]) {

		ACD s = new ACD();
		s.FizzBuzz();
		String[] people = {"Will","Luna","Mark","Mohit","Yash","Matt","Andy","Tony","Lane", "Aubrey", "Casey","Bryan","Evert","Jacob"};
		Arrays.sort(people);
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println("People: "+Arrays.toString(people));
		s.foundPerson(people);
		System.out.println("-----------------------");
		s.FindPeople(people);
		System.out.println("-----------------------");
		s.FindPeople2(people);
	}

}
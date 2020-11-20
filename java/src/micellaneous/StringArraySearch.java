package micellaneous;

import java.util.*;

public class StringArraySearch {

	void foundPerson(String[] people){
		for (int i = 0; i < people.length; i++) {
			if (people[i].equals("Lane")){
				System.out.println("Lane   in old");
			}
			if (people[i].equals("Aubrey")){
				System.out.println("Aubrey in old");
			}
			if (people[i].equals("Casey")){
				System.out.println("Casey  in old");
			}
		}
	}

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

	public static void main(String[] args) {
		StringArraySearch s = new StringArraySearch();
		String[] people = {"Will","Luna","Mark","Mohit","Yash","Matt","Andy","Tony","Lane", "Aubrey", "Casey","Bryan","Evert","Jacob"};
		Arrays.sort(people);
		System.out.println("Months: "+Arrays.toString(people));
		System.out.println("-----------------------");
		s.foundPerson(people);
		System.out.println("-----------------------");
		s.FindPeople(people);
		System.out.println("-----------------------");
		s.FindPeople2(people);
	}
}
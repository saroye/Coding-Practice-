package Interview;
import java.util.*;
import java.math.*;

public class antrea {
	
	
	
	public void m1() {
		
	}
	
	
	public static void main(String[] args) {
		antrea a = new antrea();
		int[] ar = new int[] {};
		a.m1();
		
		System.out.println();
	}
}

















class t1 extends Thread{
	
	public void run() {
        System.out.println("Hello from a thread!");	
	}
	
	public static void main(String[] agrs) {
		(new t1()).start();
	}
	
}

class runnable implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new Thread(new runnable())).start();
    }

}
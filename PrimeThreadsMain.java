package assignment2;

import java.util.Scanner;

class PrimeThread extends Thread{
	int num;
	boolean prime = false;
	public PrimeThread(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		if (num < 2) {
			System.out.println ("THREAD: Not Prime.");
			return;
		} else if (num == 2) {
			System.out.println ("THREAD: Prime.");
			return;
		}
		int sqrt = (int)Math.sqrt(num);
		
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) {
				System.out.println("THREAD: Not Prime");
				return;
			}
		}
		System.out.println("THREAD: Prime");
	}
}

class PrimeRunnable implements Runnable{
	
	int num;
	boolean prime = false;
	
	public PrimeRunnable(int num) {
		this.num = num;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (num < 2) {
			System.out.println ("RUNNABLE: Not Prime.");
			return;
		} else if (num == 2) {
			System.out.println ("RUNNABLE: Prime.");
			return;
		}
		int sqrt = (int)Math.sqrt(num);
		
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) {
				System.out.println("RUNNABLE: Not Prime");
				return;
			}
		}
		System.out.println("RUNNABLE: Prime");
	}
	
}

public class PrimeThreadsMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrimeThread pt;
		Thread pr;
		int num;
		try {
			System.out.print("Enter number: ");
			num = sc.nextInt();
			pt = new PrimeThread(num);
			pr = new Thread(new PrimeRunnable(num));
			pt.start();
			pr.start();
			
		} catch (Exception e) {
			System.out.println("Input must be a number.");
		} finally {
			sc.close();
		}
	}
}

package tsteda;

import java.util.Arrays;
import java.util.Scanner;

class CountingNegativos {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iptA = sc.nextLine();
		String[] a = iptA.split(" ");
		int[] arr = convertArray(a);
		int great = sc.nextInt();
		int less = sc.nextInt();
		countNeg(arr, less, great);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void countNeg(int[] a, int less, int great) {
		int[] counters = new int[great - less + 1];
		for (int i = 0; i < counters.length; i++) counters[i] = 0;
		
		for (int i = 0; i < a.length; i++) { 
			counters[a[i] - less]++;
			System.out.println(Arrays.toString(counters));
		}
		
		for (int i = 1; i < counters.length; i++) counters[i] += counters[i - 1];
		System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(counters));
		
		int[] sorted = new int[a.length];
		for (int i = 0; i < sorted.length; i++) sorted[i] = a[i];
		
		for (int i = 0; i < a.length; i++) {
			int e = sorted[i];
			int j = --counters[e - less];
			a[j] = e;
		}
		
		System.out.println(Arrays.toString(counters));
	}
	
	private static int[] convertArray(String[] a) {
		int[] intA = new int[a.length];
		for (int i = 0; i < a.length; i++) intA[i] = Integer.parseInt(a[i]);
		return intA;
	}
}

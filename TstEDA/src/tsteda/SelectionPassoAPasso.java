package tsteda;

import java.util.Arrays;
import java.util.Scanner;

class SelectionPassoAPasso {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iptA = sc.nextLine();
		String[] a = iptA.split(" ");
		selection(a);
	}
	
	public static void selection(String[] a) {
		int i = 0;
		boolean swap;
		do {
			swap = false;
			int posMenor = i;
			for (int j = i + 1; j < a.length; j++) {
				if (Integer.parseInt(a[j]) < Integer.parseInt(a[posMenor])) {
					swap = true;
					posMenor = j;
				}
			}
			swap(a, i, posMenor);
			if (swap) System.out.println(Arrays.toString(a));
			i++;
		} while (!isSorted(a) && i < a.length);
	}
	
	private static void swap(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static boolean isSorted(String[] a) {
		int i = 0;
		while(i < a.length - 1) {
			if (Integer.parseInt(a[i]) > Integer.parseInt(a[i+1]))
				return false;
			i++;
		}
		return true;
	}
}
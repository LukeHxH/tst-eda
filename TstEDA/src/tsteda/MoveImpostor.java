package tsteda;

import java.util.Arrays;
import java.util.Scanner;

class MoveImpostor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iptA = sc.nextLine();
		String[] a = iptA.split(" ");
		
		int[] b = new int[a.length];
		
		for (int i = 0; i < b.length; i++) {
			b[i] = Integer.parseInt(a[i]);
		}
		
		moveImpostor(b);
	}

	private static void moveImpostor(int[] a) {
		int i = 0;
		
		while(i < a.length - 1 && a[i] < a[i+1]) {
			i++;
		}
		
		do {
			swap(a, i, i+1);
			i--;
		} while(i >= 0 && a[i] > a[i+1]);
		
		System.out.println(Arrays.toString(a));
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
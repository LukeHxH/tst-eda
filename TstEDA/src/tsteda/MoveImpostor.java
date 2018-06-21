package tsteda;

import java.util.Arrays;
import java.util.Scanner;

class MoveImpostor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iptA = sc.nextLine();
		String[] a = iptA.split(" ");
		moveImpostor(a);
	}

	private static void moveImpostor(String[] a) {
		int i = 0;
		
		while (i < a.length - 1) {
			if (Integer.parseInt(a[i]) > Integer.parseInt(a[i+1])) {
				i = i+1;
				break;
			}
			i++;
		}
		
		do {
			swap(a, i - 1, i);
			i--;
		} while (i > 0 && Integer.parseInt(a[i]) < Integer.parseInt(a[i - 1]));
		
		System.out.println(Arrays.toString(a));
	}

	private static void swap(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class DoubleSelection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iptA = sc.nextLine();
		String[] a = iptA.split(" ");
		selection(a);
		
		System.out.println(Arrays.toString(a));
	}
	
	public static void selection(String[] a) {
		int i = 0;
		int j = a.length - 1;
		do {
			int posMenor = i;
			int posMaior = j;
			
			for (int k = i + 1; k < a.length; k++) {
				if (Integer.parseInt(a[k]) < Integer.parseInt(a[posMenor])) {
					posMenor = k;
				}
				
				if (Integer.parseInt(a[k]) > Integer.parseInt(a[posMaior])) {
					posMaior = k;
				}
			}
			
			swap(a, i, posMenor);
			i++;
			j--;
		} while (i < a.length && j >= 0);
	}
	
	private static void swap(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}

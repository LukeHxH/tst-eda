package sorting;

import java.util.Arrays;
import java.util.Scanner;

class MergeSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ipt = sc.nextLine();
		
		String[] splt = ipt.split(" ");
		int[] a = new int[splt.length];
		for (int i = 0; i < splt.length; i++) {
			a[i] = Integer.parseInt(splt[i]);
		}
		
		System.out.println(Arrays.toString(a));
		sort(a, 0, a.length - 1);
	}

	public static void sort(int[] a, int l, int r) {
		if (r > l) {
			int mid = (r + l) / 2;
			System.out.println(Arrays.toString(partOfArray(a, l, mid)));
			sort(a, l, mid);
			System.out.println(Arrays.toString(partOfArray(a, mid + 1, r)));
			sort(a, mid + 1, r);
			merge(a, l, mid, r);
		}
	}

	private static void merge(int[] array, int l, int mid, int r) {
		int[] aux = new int[array.length];
		for (int i = 0; i < array.length; i++) aux[i] = array[i];
		
		int i = l;
		int j = mid + 1;
		int k = l;
		
		while (i <= mid && j <= r) {
			int elementLeft = aux[i];
			int elementRight = aux[j];
			
			if (elementLeft <= elementRight) {
				array[k] = elementLeft;
				i++;
			} else {
				array[k] = elementRight;
				j++;
			}
			k++;
		}
		
		while (i <= mid)
			array[k++] = aux[i++];
		while (j <= r)
			array[k++] = aux[j++];

		System.out.println(Arrays.toString(partOfArray(array, l, r)));

	}

	public static int[] partOfArray(int[] array, int i, int j) {
		int[] a = new int[j - i + 1];

		for (int k = i; k <= j; k++) {
			a[k - i] = array[k];
		}
		return a;
	}
}

package tsteda;

import java.util.Arrays;
import java.util.Scanner;

class InsertRecursivo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iptA = sc.nextLine();
		String[] a = iptA.split(" ");
		insertionSort(a, a.length);
	}
	
	public static void insertionSort(String[] a, int n) {
        if (n > 1) {
        	insertionSort(a, n-1);
            
            String last = a[n-1];
            int i = n-2;

            while (i >= 0 && Integer.parseInt(a[i]) > Integer.parseInt(last)) {
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = last;
            
            System.out.println(Arrays.toString(a));
        }
    }

}
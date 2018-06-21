package tsteda;

import java.util.Scanner;

class StoogeSort {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String iptA = sc.nextLine();
		String[] a = iptA.split(" ");
		stooge(a, 0, a.length - 1);
		System.out.println(arrayToString(a));
	}
	
	public static void stooge(String a[], int l, int r) {
        if (r > l) {
        	if (Integer.parseInt(a[l]) > Integer.parseInt(a[r]))
        		swap(a, l, r);
     
            if (r - l + 1 > 2) {
                int t = (r - l + 1) / 3;
                
                stooge(a, l, r - t);
                stooge(a, l + t, r);
                stooge(a, l, r - t);
            }
        }
    }
	
	public static String arrayToString(String[] array) {
		String s = "";
		for (String a: array)
			s+=a + " ";
		return s.substring(0, s.length() - 1);
	}
	
	private static void swap(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

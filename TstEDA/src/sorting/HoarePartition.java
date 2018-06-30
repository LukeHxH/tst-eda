package sorting;

import java.util.Arrays;
import java.util.Scanner;

class HoarePartition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iptA = sc.nextLine();
		String[] a = iptA.split(" ");
		partition(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
		
	}

	private static int partition(String[] a, int l, int r) {
		int p = Integer.parseInt(a[l]);
	    int i = l - 1;
	    int j = r + 1;
	    
	    while (true) {
	    	do {
	    		j--;
	    	} while (Integer.parseInt(a[j]) > p);
	      
	    	do {
	    		i++;
	    	} while (Integer.parseInt(a[i]) < p);
	      
	    	if (i < j)
	    		swap(a, i, j);
	    	else return j;
	    }
	}

	private static void swap(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}

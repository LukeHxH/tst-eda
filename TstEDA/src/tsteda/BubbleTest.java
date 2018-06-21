package tsteda;

import java.util.Scanner;

class BubbleTest {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String iptA = sc.nextLine();
		String[] a = iptA.split(" ");
		bubble(a);
	}
	
	public static String arrayToString(String[] array) {
		String s = "";
		for (String a: array)
			s+=a + " ";
		return s.substring(0, s.length() - 1);
	}
	
	public static void bubble(String[] array) {
		do {
			for (int j = 0; j < array.length - 1; j++) {
				if (Integer.parseInt(array[j]) > Integer.parseInt(array[j+1])) {
					String temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			System.out.println(arrayToString(array));
		} while(!isSorted(array));
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
package tsteda;

import java.util.Scanner;

public class VetorCircular {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iptA = sc.nextLine();
		String[] a = iptA.split(" ");
		int n = sc.nextInt();
		System.out.println(circ(a, n));
	}
	
	public static String circ(String[] a, int n) {
		String s = "";
		
		for (int i = 0; i < n; i++) {
			s += a[i % (a.length)] + " ";
		}
		
		return s.substring(0, s.length() - 1);
	}

}

package tsteda;

import java.util.Scanner;

class DoisSomam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iptA = sc.nextLine();
		String[] a = iptA.split(" ");
		int n = sc.nextInt();
		System.out.println(doisSomam(a, n));
	}

	public static String doisSomam(String[] a, int n) {
		String s = "-1";
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (Integer.parseInt(a[i]) + Integer.parseInt(a[j]) == n
						&& i != j) {
					s = a[Math.min(i, j)] + " " + a[Math.max(i, j)];
				}
			}
		}
		
		return s;
	}
}

package tsteda;

import java.util.Arrays;
import java.util.Scanner;

public class Sobrando {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iptA = sc.nextLine();
		String[] a = iptA.split(" ");
		String iptB = sc.nextLine();
		String[] b = iptB.split(" ");
		
		System.out.println(sobrando(a, b));
	}
	
	public static String sobrando(String[] a, String[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		
		String n = "";
		int cont = 0;
		
		boolean achou = false;
		
		while (!achou && cont < (b.length - 1)) {
			if (!(a[cont].equals(b[cont]))) {
				achou = true;
				n = b[cont];
			}
			cont++;
		}
		if (!achou)
			n = b[b.length - 1];
		
		return n;
	}

}
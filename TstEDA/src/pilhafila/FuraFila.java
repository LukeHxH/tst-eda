package pilhafila;

import java.util.Arrays;
import java.util.Scanner;

public class FuraFila {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ipt = sc.nextLine();
		String[] f = ipt.split(" ");
		int i = sc.nextInt();
		fura(f, i);
	}
	
	public static void fura(String[] f, int i) {
		int pos = 0;
		for (int j = i; j < f.length; j++) {
			for (int k = j; k > pos; k--) {
				String temp = f[k - 1];
				f[k - 1] = f[k];
				f[k] = temp;
			}
			System.out.println(Arrays.toString(f));
			pos++;
		}
	}
}

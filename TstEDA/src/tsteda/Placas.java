package tsteda;

import java.util.Scanner;

class Placas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ipt = sc.nextLine();
		String[] iptArray = ipt.split(",");
		sort(iptArray);
		print(iptArray);
	}
	
	private static void print(String[] iptArray) {
		String output = "";
		
		for (int i = 0; i < iptArray.length; i++) {
			output += iptArray[i] + ", ";
		}
		
		System.out.println(output.substring(0, output.length() - 2));
	}

	private static void sort(String[] array) {
		int m = 0;
		
		if (array.length > 0 && !array[0].isEmpty())
			m = getMaximumValue(array);
		
		for (int i = 1; (m / i) > 0; i *= 10) count(array, array.length, i);
	}
	
	private static void count(String[] array, int length, int digitPlace) {
		int[] count = new int[10];
		for (int i = 0; i < 10; i++) count[i] = 0;
		
		for(int i = 0; i < length; i++) count[getDigit(array[i], digitPlace)]++;
		
		for (int i = 1; i < 10; i++) count[i] += count[i - 1];
		
		String[] sorted = new String[length];
		for (int i = length - 1; i >= 0; i--) {
			sorted[count[getDigit(array[i], digitPlace)] - 1] = array[i];
			count[getDigit(array[i], digitPlace)]--;
		}
		
		for (int i = 0; i < length; i++) array[i] = sorted[i];
	}

	private static int getDigit(String value, int place) {
		return (Integer.parseInt(value.substring(4, value.length())) / place) % 10;
	}

	private static int getMaximumValue(String[] array) {
		
		String m = array[0].substring(4, array[0].length());
		for (int i = 1; i < array.length; i++) {
			if (array[i].substring(4, array[i].length()).compareTo(m) > 0)
				m = array[i].substring(4, array[i].length());
		}
		return Integer.parseInt(m);
	}
}
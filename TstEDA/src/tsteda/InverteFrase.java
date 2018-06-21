package tsteda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class InverteFrase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(inverter(str));
	}

	private static String inverter(String str) {
		Stack<String> pilha = new Stack<>();
		List<String> split = mySplit(str);
		for (String s: split)
			pilha.push(s);
		
		String out = "";
		while (!pilha.isEmpty()){
			out += pilha.pop() + " ";
		}
		
		if (out.length() > 0)
			out = out.substring(0, out.length() - 1);
		
		return out;
	}
	
	private static List<String> mySplit(String str) {
		str = str.trim().toLowerCase();
		List<String> strings = new ArrayList<>();
		String aux = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				if (!aux.isEmpty())
					strings.add(aux);
				aux = "";
			} else {
				aux += str.charAt(i);
			}
		}
		
		if (!aux.isEmpty())
			strings.add(aux);
		
		return strings;
	}

}

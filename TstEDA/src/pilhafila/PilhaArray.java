package pilhafila;

import java.util.Scanner;

class PilhaArray {
	
	private static Integer[] array;
	private static int size;
	private static int top;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strTamanho = sc.nextLine();
		size = Integer.parseInt(strTamanho);
		array = new Integer[size];
		top = -1;
		menu(sc);
	}
	
	private static boolean isEmpty() {
		return top == -1;
	}
	
	private static boolean isFull() {
		return top == (size - 1);
	}
	
	private static Integer top() {
		if (!isEmpty())
			return array[top];
		return null;
	}
	
	private static void push(Integer n) {
		if (!isFull() && n != null)
			array[++top] = n;
	}
	
	private static Integer pop() {
		if (!isEmpty())
			return array[top--];
		return null;
	}
	
	private static String toStr() {
		String str = "";
		
		for (int i = 0; i <= top; i++)
			str += array[i] + " ";
		
		if (str.length() > 0)
			str = str.substring(0, str.length() - 1);
		
		return str;
	}
	
	private static void menu(Scanner sc) {
		String[] choice = sc.nextLine().split(" ");
		while (!choice[0].toLowerCase().equals("end")) {
			switch(choice[0].toLowerCase()) {
				case "print":
					print();
					break;
				case "push":
					if (choice.length == 2)
						add(Integer.parseInt(choice[1]));
					break;
				case "pop":
					remover();
					break;
				case "peek":
					peek();
					break;
			}
			choice = sc.nextLine().split(" ");
		}
	}

	private static void print() {
		if (isEmpty())
			System.out.println("empty");
		else
			System.out.println(toStr());
	}

	private static void remover() {
		if (pop() == null)
			System.out.println("empty");
	}

	private static void peek() {
		if (isEmpty())
			System.out.println("empty");
		else
			System.out.println(top().toString());
	}
	
	private static void add(Integer n) {
		if (isFull())
			System.out.println("full");
		else
			push(n);
	}

}

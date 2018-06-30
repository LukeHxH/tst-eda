package pilhafila;

import java.util.Scanner;

class FilaArray {
	private static int size;
	private static Integer[] array;
	private static int tail;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strTamanho = sc.nextLine();
		size = Integer.parseInt(strTamanho);
		array = new Integer[size];
		tail = -1;
		menu(sc);
	}
	
	private static boolean isEmpty() {
		return tail == -1;
	}
	
	private static boolean isFull() {
		return tail == (size - 1);
	}
	
	private static void shiftLeft() {
		for (int i = 0; i <= tail; i++)
			array[i] = array[(i + 1) % array.length];
	}
	
	private static void insert(Integer n) {
		if (!isFull() && n != null)
			array[++tail] = n;
	}
	
	private static Integer remove() {
		if (!isEmpty()) {
			Integer out = array[0];
			shiftLeft();
			tail--;
			return out;
		}
		return null;
	}
	
	private static Integer head() {
		if (isEmpty())
			return null;
		return array[0];
	}
	
	private static String toStr() {
		String str = "";
		
		for (int i = 0; i <= tail; i++)
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
				case "add":
					if (choice.length == 2)
						add(Integer.parseInt(choice[1]));
					break;
				case "remove":
					remover();
					break;
				case "element":
					element();
					break;
			}
			choice = sc.nextLine().split(" ");
		}
	}

	private static void element() {
		if (head() != null)
			System.out.println(Integer.toString(head()));
		else
			System.out.println("empty");
	}

	private static void remover() {
		if (remove() == null)
			System.out.println("empty");
	}

	private static void add(int n) {
		if (isFull())
			System.out.println("full");
		else
			insert(n);
	}

	private static void print() {
		if (isEmpty())
			System.out.println("empty");
		else
			System.out.println(toStr());
	}
}

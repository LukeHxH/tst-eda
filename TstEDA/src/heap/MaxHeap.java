package heap;

import java.util.Scanner;

class MaxHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputArray = input.split(" ");
		System.out.println(verifyHeap(inputArray));
	}
	
	private static boolean verifyHeap(String[] array) {
		boolean out = true;
		
		for (int i = 0; i < array.length; i++) {
			int curr = Integer.parseInt(array[i]);
			int leftPos = left(i);
			int rightPos = right(i);
			
			if (leftPos < array.length) {
				if (curr < Integer.parseInt(array[leftPos]))
					out = false;
			}
			
			if (rightPos < array.length) {
				if (curr < Integer.parseInt(array[rightPos]))
					out = false;
			}
		}
		
		return out;
	}
	
	private static int left (int pos) {
		return (pos * 2 + 1);
	}
	
	private static int right (int pos) {
		return (pos * 2 + 1) + 1;
	}

}

package heap;

import java.util.Scanner;

public class AlturaHeap {
	
	private static int[] heap;
	private static int index = -1;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputArray = input.split(" ");
		int[] array = new int[inputArray.length];
		for (int i = 0; i < array.length; i++)
			array[i] = Integer.parseInt(inputArray[i]);
		buildHeap(array);
		System.out.println(height());
	}
	
	private static int parent(int i) {
		return (i - 1) / 2;
	}

	private static int left(int i) {
		return 2*i + 1;
	}

	private static int right(int i) {
		return 2*(i + 1);
	}
	
	private static int indexMax(int position, int left, int right) {
		int pos = position;
		
		if (left < size()) 
			pos = (heap[position] > heap[left]) ? position : left;
		
		if (right < size())
			pos = (heap[pos] > heap[right]) ? pos : right;

		return pos;
	}

	private static void buildHeap(int[] array) {
		heap = array;
		index = array.length - 1;
		
		for (int i = parent(index); i >= 0; i--)
			heapify(i);
	}

	private static void heapify(int position) {
		int max = indexMax(position, left(position), right(position));
		
		if (max != position) {
			swap(position, max);
			heapify(max);
		}
		
	}

	private static void swap(int i, int j) {
		int aux = heap[i];
		heap[i] = heap[j];
		heap[j] = aux;
	}

	private static int height() {
		return (int) (Math.log(size()) / Math.log(2));
	}
	
	private static int size() {
		return index + 1;
	}

}
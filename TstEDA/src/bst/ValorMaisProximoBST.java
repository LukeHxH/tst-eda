package bst;

import java.util.Arrays;
import java.util.Scanner;

class ValorMaisProximoBST {

	private static NodeBST root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputArray = input.split(" ");
		
		String input2 = sc.nextLine();

		for (int i = 0; i < inputArray.length; i++)
			insert(Integer.parseInt(inputArray[i]));
		
		System.out.println(Arrays.toString(preOrder()));
		System.out.println(valorMaisProximo(Integer.parseInt(input2)));
	}

	private static Integer[] preOrder() {
		Integer[] array = new Integer[size()];
		preOrder(root, array);
		return array;
	}

	private static void preOrder(NodeBST node, Integer[] array) {
		if (node != null) {
			int i = 0;
			while(i < array.length && array[i] != null) i++;
			array[i] = node.getData();
		}
		
		if (node.getLeft() != null) preOrder(node.getLeft(), array);
		if (node.getRight() != null) preOrder(node.getRight(), array);
	}

	private static int valorMaisProximo(int value) {
		int out = Integer.MAX_VALUE;
		NodeBST aux = root;
		
		while (aux != null) {
			int data = aux.getData();
			if (Math.abs(data - value) < Math.abs(out - value))
				out = data;
			
			if (data < value) {
				aux = aux.getRight();
			} else if (data > value) {
				aux = aux.getLeft();
			} else if (data == value) {
				break;
			}
		}
		
		return out;
	}

	private static boolean isEmpty() {
		return root == null;
	}

	private static void insert(Integer e) {
		NodeBST newNode = new NodeBST(e, null, null, null);

		if (isEmpty()) {
			root = newNode;
		} else {
			insertNotEmpty(e, newNode);
		}
	}

	private static void insertNotEmpty(Integer e, NodeBST newNode) {
		NodeBST aux = root;

		while (aux != null) {
			if (e > aux.getData()) {
				if (aux.getRight() == null) {
					newNode.setParent(aux);
					aux.setRight(newNode);
					break;
				} else {
					aux = aux.getRight();
				}
			} else if (e < aux.getData()) {
				if (aux.getLeft() == null) {
					newNode.setParent(aux);
					aux.setLeft(newNode);
					break;
				} else {
					aux = aux.getLeft();
				}
			} else if (e == aux.getData())
				break;
		}
	}
	
	private static int size() {
		return size(root);
	}

	private static int size(NodeBST node) {
		int result = 0;
		if (node != null) {
			result = 1 + size(node.getLeft()) + size(node.getRight());
		}
		return result;
	}

}

/*class NodeBST {
	private Integer data;
	private NodeBST right;
	private NodeBST left;
	private NodeBST parent;

	public NodeBST(Integer data, NodeBST right, NodeBST left, NodeBST parent) {
		this.data = data;
		this.right = right;
		this.left = left;
		this.parent = parent;
	}

	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public NodeBST getRight() {
		return right;
	}

	public void setRight(NodeBST right) {
		this.right = right;
	}

	public NodeBST getLeft() {
		return left;
	}

	public void setLeft(NodeBST left) {
		this.left = left;
	}

	public NodeBST getParent() {
		return parent;
	}

	public void setParent(NodeBST parent) {
		this.parent = parent;
	}
}*/

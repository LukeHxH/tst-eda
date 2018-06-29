package tsteda;

import java.util.Arrays;
import java.util.Scanner;

class PredecessorBST {

	private static NodeBST root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputArray = input.split(" ");
		
		String input2 = sc.nextLine();

		for (int i = 0; i < inputArray.length; i++)
			insert(Integer.parseInt(inputArray[i]));

		System.out.println(Arrays.toString(predecessor(Integer.parseInt(input2))));
	}

	private static Integer[] predecessor(Integer element) {
		Integer[] auxOut = new Integer[size()];
		NodeBST aux = search(element);
		int i = 0;
		if (aux != null) {
			auxOut[i++] = aux.getData();
			if (aux.getLeft() == null) {
				aux = aux.getParent();
				while (aux != null) {
					auxOut[i++] = aux.getData();
					if (aux.getData() <= element)
						break;
					aux = aux.getParent();
				}
			} else {
				aux = aux.getLeft();
				while (aux != null) {
					auxOut[i++] = aux.getData();
					aux = aux.getRight();
				}
			}
		}
		Integer[] out = new Integer[i];
		for (int j = 0; j < out.length; j++) {
			out[j] = auxOut[j];
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

	public static NodeBST search(Integer element) {
		NodeBST aux = null;
		if (element != null && !isEmpty()) {
			aux = root;
			while (aux != null && aux.getData().compareTo(element) != 0) {
				if (element.compareTo(aux.getData()) > 0) {
					aux = aux.getRight();
				} else if (element.compareTo(aux.getData()) < 0) {
					aux = aux.getLeft();
				}
			}
		}

		return aux;
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
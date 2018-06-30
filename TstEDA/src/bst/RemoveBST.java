package bst;

import java.util.Arrays;
import java.util.Scanner;

class RemoveBST {

	private static NodeBST root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputArray = input.split(" ");
		
		String input2 = sc.nextLine();
		String[] inputArray2 = input2.split(" ");

		for (int i = 0; i < inputArray.length; i++)
			insert(Integer.parseInt(inputArray[i]));
		
		for (int i = 0; i < inputArray2.length; i++)
			remove(Integer.parseInt(inputArray2[i]));
	}
	
	private static void remove(Integer element) {
		root = remove(root, element);
		System.out.println(preOrder());
	}
	
	private static NodeBST remove(NodeBST node, Integer element) {
		if (node == null)
			return node;

		if (element.compareTo(node.getData()) < 0) {
			node.setLeft(remove(node.getLeft(), element));
		} else if (element.compareTo(node.getData()) > 0) {
			node.setRight(remove(node.getRight(), element));
		} else {
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			}

			Integer newData = minimumFromNode(node.getRight()).getData();
			node.setData(newData);

			NodeBST newRight = remove(node.getRight(), node.getData());
			node.setRight(newRight);
		}
		return node;
	}

	private static NodeBST minimumFromNode(NodeBST node) {
		if (node != null) {
			while (node.getLeft() != null) {
				node = node.getLeft();
			}
		}
		return node;
	}

	private static String preOrder() {
		Integer[] array = new Integer[size()];
		preOrder(root, array);
		
		String out = "";
		
		if (array.length > 0)
			out = Arrays.toString(array);
		else
			out = "null";
		
		return out;
	}

	private static void preOrder(NodeBST node, Integer[] array) {
		if (node != null) {
			int i = 0;
			while(i < array.length && array[i] != null) i++;
			array[i] = node.getData();
			
			if (node.getLeft() != null) preOrder(node.getLeft(), array);
			if (node.getRight() != null) preOrder(node.getRight(), array);
		}
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

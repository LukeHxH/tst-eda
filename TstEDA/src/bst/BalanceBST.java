package bst;

import java.util.Scanner;

class BalanceBST {

	private static NodeBST root;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputArray = input.split(" ");

		for (int i = 0; i < inputArray.length; i++)
			insert(Integer.parseInt(inputArray[i]));
		
		NodeBST[] preOrder = preOrderBalance();
		
		String out = "";
		
		for (int i = 0; i < preOrder.length; i++) {
			out += preOrder[i].getData() + "," + balance(preOrder[i]) + " ";
		}
		
		System.out.println(out.trim());
	}

	private static int balance(NodeBST node) {
		int out = -1;
		
		if (node != null) {
			int left = height(node.getLeft());
			int right = height(node.getRight());
			
			out = left - right;
		}
		
		return out;
	}
	
	private static NodeBST[] preOrderBalance() {
		NodeBST[] out = new NodeBST[size()];
		if (!isEmpty()) {
			preOrderBalance(root, out);
		}
		
		return out;
	}
	
	private static int size() {
		return size(root);
	}

	private static int size(NodeBST node) {
		int out = 0;
		
		if (node != null) {
			out = 1 + size(node.getLeft()) + size(node.getRight());
		}
		
		return out;
	}

	private static void preOrderBalance(NodeBST node, NodeBST[] array) {
		int i = 0;
		
		while (array[i] != null)
			i++;
		
		array[i] = node;
		
		if (node.getLeft() != null) {
			preOrderBalance(node.getLeft(), array);
		}
		
		if (node.getRight() != null) {
			preOrderBalance(node.getRight(), array);
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

	private static int height(NodeBST node) {
		int height = -1;

		if (node != null) {
			int lHeight = height(node.getLeft());
			int rHeight = height(node.getRight());

			if (lHeight > rHeight) {
				height = lHeight + 1;
			} else {
				height = rHeight + 1;
			}
		}

		return height;
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
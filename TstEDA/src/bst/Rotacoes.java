package bst;

import java.util.Arrays;
import java.util.Scanner;

class Rotacoes {

	private static NodeBST root;

	public static void main(String[] args) {
		root = new NodeBST(null, null, null, null);
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputArray = input.split(" ");

		for (int i = 0; i < inputArray.length; i++)
			insert(Integer.parseInt(inputArray[i]));
		
		rebalance(root);
	}

	private static boolean isEmpty() {
		return root.getData() == null;
	}

	private static void insert(Integer e) {
		if (e != null) {
			insert(root, null, e);
		}
	}

	private static void insert(NodeBST node, NodeBST parent, Integer e) {
		if (node.getData() == null) {
			node.setData(e);
			node.setLeft(new NodeBST(null, null, null, node));
			node.setRight(new NodeBST(null, null, null, node));
			node.setParent(parent);
		} else {
			if (node.getData().compareTo(e) > 0) {
				insert(node.getLeft(), node, e);
			} else if (node.getData().compareTo(e) < 0) {
				insert(node.getRight(), node, e);
			}
		}
	}
	
	private static NodeBST[] preOrder() {
		NodeBST[] out = new NodeBST[size()];
		if (!isEmpty()) {
			preOrder(root, out);
		}
		
		return out;
	}
	
	private static void preOrder(NodeBST node, NodeBST[] array) {
		int i = 0;
		
		while (array[i] != null)
			i++;
		
		array[i] = node;
		
		if (!node.getLeft().isEmpty()) {
			preOrder(node.getLeft(), array);
		}
		
		if (!node.getRight().isEmpty()) {
			preOrder(node.getRight(), array);
		}
	}
	
	private static int balance(NodeBST node) {
		int out = -1;
		
		if (!node.isEmpty()) {
			int left = height(node.getLeft());
			int right = height(node.getRight());
			
			out = left - right;
		}
		
		return out;
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
	
	private static void rebalance(NodeBST node) {
		if (!node.isEmpty()) {
			int balance = balance(node);
			
			if (Math.abs(balance) > 1) {
				if (balance > 0) {
					if (height(node.getLeft().getLeft()) < height(node.getLeft().getRight())) {
						System.out.println("rot_esq(" + node.getLeft() + ")");
						rotateLeft(node.getLeft());
						System.out.println(Arrays.toString(preOrder()));
					}
					System.out.println("rot_dir(" + node + ")");
					rotateRight(node);
					System.out.println(Arrays.toString(preOrder()));
				} else if (balance < 0) {
					if (height(node.getRight().getRight()) < height(node.getRight().getLeft())) {
						System.out.println("rot_dir(" + node.getRight() + ")");
						rotateRight(node.getRight());
						System.out.println(Arrays.toString(preOrder()));
					}
					System.out.println("rot_esq(" + node + ")");
					rotateLeft(node);
					System.out.println(Arrays.toString(preOrder()));
				}
			} else {
				System.out.println("balanceada");
			}
		}
	}
	
	private static void rotateLeft(NodeBST node) {
		NodeBST aux = leftRotation(node);
		
		if (node.equals(root)) {
			root = aux;
		} else {
			NodeBST parent = aux.getParent();
			if (parent != null) {
				if (parent.getLeft().equals(node)) {
					parent.setLeft(aux);
					aux.setParent(parent);
				} else {
					parent.setRight(aux);
					aux.setParent(parent);
				}
			}
		}
	}

	private static void rotateRight(NodeBST node) {
		NodeBST aux = rightRotation(node);

		if (node.equals(root)) {
			root = aux;
		} else {
			NodeBST parent = aux.getParent();
			if (parent != null) {
				if (parent.getLeft().equals(node)) {
					parent.setLeft(aux);
					aux.setParent(parent);
				} else {
					parent.setRight(aux);
					aux.setParent(parent);
				}
			}
		}
	}
	
	private static NodeBST leftRotation(NodeBST node) {
		NodeBST neighbour = node.getRight();

		neighbour.setParent(node.getParent());
		node.setParent(neighbour);

		node.setRight(neighbour.getLeft());
		neighbour.setLeft(node);

		return neighbour;
	}
	
	private static NodeBST rightRotation(NodeBST node) {
		NodeBST neighbour = node.getLeft();

		neighbour.setParent(node.getParent());
		node.setParent(neighbour);

		node.setLeft(neighbour.getRight());
		neighbour.setRight(node);

		return neighbour;
	}

	private static int size() {
		return size(root);
	}

	private static int size(NodeBST node) {
		int out = 0;
		
		if (!node.isEmpty()) {
			out = 1 + size(node.getLeft()) + size(node.getRight());
		}
		
		return out;
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
	
	public String toString() {
		return this.data + "";
	}

	public boolean isEmpty() {
		return this.data == null;
	}
}*/
package msit_5214;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * Available functions: insert delete inorder preorder postorder
 * 
 * @author olegtikhonov
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {
	private Node root;
	private int size;

	class Node {
		public T data;
		Node left;
		Node right;

		public Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public BinarySearchTree() {
		this.root = null;
	}

	public BinarySearchTree(T[] elements) {
		if (null == elements)
			throw new NullPointerException();

		for (int i = 0; elements.length > i; ++i) {
			if (null != elements[i]) {
				insert(elements[i]);
			}
		}
	}

	public BinarySearchTree(Iterable<T> elements) {
		if (null == elements) {
			throw new NullPointerException();
		}

		Iterator<T> itr = elements.iterator();
		while (itr.hasNext()) {
			T elem = itr.next();
			if (null != elem) {
				insert(elem);
			}
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return size;
	}

	public void insert(T value) {
		if (isEmpty()) {
			root = new Node(value);
		} else {
			insert(root, value);
		}
	}

	private void insert(Node node, T value) {

		if (value.compareTo(node.data) < 0) {
			if (node.left == null) {
				node.left = new Node(value);
			} else {
				insert(node.left, value);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(value);
			} else {
				insert(node.right, value);
			}
		}
	}

	public boolean delete(T element) {
		if (element == null) {
			throw new NullPointerException();
		}

		Node parent = null;
		Node curr = root;
		while (null != curr) {
			int cmp = element.compareTo(curr.data);
			if (0 > cmp) {
				parent = curr;
				curr = curr.left;
			} else if (0 < cmp) {
				parent = curr;
				curr = curr.right;
			} else {
				break;
			}
		}

		if (null == curr) {
			return false;
		}

		if (null == curr.left) {
			if (null == parent) {
				root = curr.right;
			} else {
				if (0 > element.compareTo(parent.data)) {
					parent.left = curr.right;
				} else {
					parent.right = curr.right;
				}
			}
		} else {
			Node parentRight = curr;
			Node mostRight = curr.left;
			while (null != mostRight.right) {
				parentRight = mostRight;
				mostRight = mostRight.right;
			}

			curr.data = mostRight.data;
			if (parentRight.right.equals(mostRight)) {
				parentRight.right = mostRight.left;
			} else {
				parentRight.left = mostRight.left;
			}
		}

		--size;
		return true;
	}

	public void clear() {
		root = null;
		size = 0;
	}

	public boolean contains(T element) {
		if (null == element) {
			throw new NullPointerException();
		}

		Node curr = root;
		while (null != curr) {
			int cmp = element.compareTo(curr.data);
			if (0 > cmp) {
				curr = curr.left;
			} else if (0 < cmp) {
				curr = curr.right;
			} else {
				return true;
			}
		}

		return false;
	}

	public void balance() {
		if (2 >= size)
			return;

		root = build(inorder(), 0, size - 1);
	}

	private Node build(List<T> elements, int low, int high) {
		if (low > high) {
			return null;
		}

		int mid = (high - low) / 2 + low;
		Node curr = new Node(elements.get(mid));
		curr.left = build(elements, low, mid - 1);
		curr.right = build(elements, mid + 1, high);
		return curr;
	}

	private void inorder(List<T> result, Node curr) {
		if (null == curr)
			return;

		inorder(result, curr.left);
		result.add(curr.data);
		inorder(result, curr.right);
	}

	public List<T> inorder() {
		List<T> result = new ArrayList<>(size);
		inorder(result, root);
		return result;
	}

	public List<T> preorder() {
		List<T> result = new ArrayList<>(size);
		preorder(result, root);
		return result;
	}

	private void preorder(List<T> result, Node curr) {
		if (null == curr) {
			return;
		}

		result.add(curr.data);
		preorder(result, curr.left);
		preorder(result, curr.right);
	}

	public List<T> postorder() {
		List<T> result = new ArrayList<>(size);
		postorder(result, root);
		return result;
	}

	private void postorder(List<T> result, Node curr) {
		if (null == curr) {
			return;
		}

		postorder(result, curr.left);
		postorder(result, curr.right);
		result.add(curr.data);
	}
	
	public void showTree(String message, List<Integer> result) {
		System.out.print(message + " ->\t");
		System.out.println(result);
	}

	public static void main(String[] args) {
		Integer[] data = { 27, 5, 12, 85, 6, 19, 1, 8, 95, 3 };
		BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>(data);
		List<Integer> inOrderResult = myTree.inorder();
		myTree.showTree("in-order", inOrderResult);
		
		
		List<Integer> preOrderResult = myTree.preorder();
		myTree.showTree("pre-order", preOrderResult);
		
		List<Integer> postOrderResult = myTree.postorder();
		myTree.showTree("post-order", postOrderResult);		
	}
}

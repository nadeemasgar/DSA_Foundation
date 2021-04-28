import java.util.*;

public class CreationOfTree {

	public static class Node {
		int data;
		Node left;
		Node right;
	}

	// public Node() {
	// 	data = 0;
	// 	left = null;
	// 	right = null;
	// }

	public static class Pair {
		Node node;
		int state;
	}

	public static Node construct(int[] arr) {

		Stack<Pair> st = new Stack<>();

		Node root = new Node();
		root.data = arr[0];

		Pair p1 = new Pair();
		p1.node = root;
		p1.state = 1;
		st.push(p1);

		for (int i = 1 ; i < arr.length; i++) {

			Pair temp = st.peek();

			if (temp.state == 1) {

				if (arr[i] != -1) {
					Node n = new Node();
					n.data = arr[i];
					temp.node.left = n;
					temp.state++;

					Pair p = new Pair();
					p.node = n;
					p.state = 1;
					st.push(p);
				} else {
					temp.node.left = null;
					temp.state++;
				}

			} else if (temp.state == 2) {

				if (arr[i] != -1) {
					Node n = new Node();
					n.data = arr[i];
					temp.node.right = n;
					temp.state++;

					Pair p = new Pair();
					p.node = n;
					p.state = 1;
					st.push(p);
				} else {
					temp.node.right = null;
					temp.state++;
				}

			} else {
				st.pop();
				i--;
			}
		}

		return root;
	}

	public static void display(Node node) {

		if (node == null) {
			return;
		}

		String str = node.data + " - ";

		if (node.left != null) {
			str += node.left.data + " , ";
		} else {
			str += ". , ";
		}

		if (node.right != null) {
			str += node.right.data + " , ";
		} else {
			str += ". , ";
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {

		int[] arr = {10, 12, 16, -1, -1, 18, -1, -1, 14, 20, 24, -1, -1, 26, -1, -1, 22, -1, -1};

		Node root = construct(arr);

		display(root);

	}
}
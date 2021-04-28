import java.util.*;

public class Creation {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public static Node creationTree(int[] arr) {

		Stack<Node> st = new Stack<>();
		Node root = null;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1)
				st.pop();
			else {
				Node nn = new Node();
				nn.data = arr[i];

				if (st.size() == 0) {
					st.push(nn);
					root = nn;
				} else {
					Node temp = st.peek();
					temp.children.add(nn);
					st.push(nn);
				}
			}
		}

		return root;
	}

	public static void display(Node node) {

		String str = node.data + " - ";

		for (int i = 0; i < node.children.size(); i++) {

			str += node.children.get(i).data + ", ";
		}

		System.out.println(str);

		for (int i = 0; i < node.children.size(); i++) {

			display(node.children.get(i));
		}

	}

	public static void main(String[] args) {

		int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

		Node root = creationTree(arr);

		display(root);

	}
}
package HW;

public class LLMain {

	public static void main(String[] args) {

		BE8Tree tree = new BE8Tree();
		BE8Node root = new BE8Node();
		root.value = 1;
		tree.root = root;

		BE8Node node = new BE8Node();
		node.value = 30;
		tree.root.children.add(node);

		node = new BE8Node();
		node.value = 40;
		tree.root.children.add(node);

		BE8Node node20 = new BE8Node();
		node20.value = 20;
		BE8Node findNode = tree.findNode(30);
		if (findNode != null) {
			findNode.children.add(node20);
		}

		BE8Node node10 = new BE8Node();
		node10.value = 10;
		BE8Node findNode40 = tree.findNode(40);
		if (findNode40 != null) {
			findNode40.children.add(node10);
		}

		System.out.println("Finding node 20: " + (tree.findNode(20) != null ? "Found" : "No exists"));
		System.out.println("Finding node 10: " + (tree.findNode(10) != null ? "Found" : "No exists"));
		System.out.println("Finding node 99: " + (tree.findNode(99) != null ? "Found" : "No exists"));

	}
}

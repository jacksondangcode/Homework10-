package HW;

import java.util.ArrayList;

public class BE8Tree {
	BE8Node root;

	public BE8Node findNode(int value) {
		if (root == null)
			return null;

		ArrayList<BE8Node> listChildren = new ArrayList<>();
		ArrayList<Integer> indexNode = new ArrayList<>();

		listChildren.add(root);
		indexNode.add(0);

		while (!listChildren.isEmpty()) {
			int top = listChildren.size() - 1;
			BE8Node currentNode = listChildren.get(top);
			int childIndex = indexNode.get(top);

			if (childIndex == 0) {
				if (currentNode.value != null && currentNode.value == value) {
					return currentNode;
				}
			}

			if (childIndex < currentNode.children.size()) {

				indexNode.set(top, childIndex + 1);

				BE8Node child = currentNode.children.get(childIndex);
				listChildren.add(child);
				indexNode.add(0);
			} else {
				listChildren.remove(top);
				indexNode.remove(top);
			}
		}

		return null;
	}
}

package HW;

import java.util.Stack;

public class BE8Tree {
	BE8Node root;
	
	public BE8Node findNode(int value) {
		
		if(root == null) {
			return null;
		}
		
		Stack<BE8Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BE8Node current = stack.pop();
            
            if (current.value == value) {
            	return current;
            }

            for (int i = current.children.size() - 1; i >= 0; i--) {
                stack.push(current.children.get(i));
            }
        }
        return null;
	}

	

}

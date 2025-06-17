package HW;

public class LLMain {

	public static void main(String[] args) {

		 BE8Tree tree = new BE8Tree();
	        
	     BE8Node rootNode = new BE8Node();
	     rootNode.value = 1;
	     tree.root = rootNode;
	      
	     BE8Node newNode = new BE8Node();
	     newNode.value = 30;
	     tree.root.children.add(newNode);
	  
	     newNode = new BE8Node();
	     newNode.value = 40;
	     tree.root.children.add(newNode);
	    
	     newNode = new BE8Node();
	     newNode.value = 20;
	     BE8Node targetNode = tree.findNode(30);
	     targetNode.children.add(newNode);

	     newNode = new BE8Node();
	     newNode.value = 10;
	     targetNode = tree.findNode(40);
	     targetNode.children.add(newNode);
	 
	     targetNode = tree.findNode(20);
	     System.out.println("Finding in node 20: " + (targetNode != null ? targetNode.value : "The value doesn't exist"));
	     targetNode = tree.findNode(40);
	     System.out.println("Finding in node 40: " + (targetNode != null ? targetNode.value : "The value doesn't exist"));
	    }
		
		
		
}


package HW;

import java.util.ArrayList;
import java.util.LinkedList;

public class main {
	public static void main(String[] args) {

		BE8LinkedList ll = new BE8LinkedList();

		LinkedListItem llItem = new LinkedListItem();
		llItem.value = 1;

		ll.head = llItem;

		llItem = new LinkedListItem();
		llItem.value = 18;

		ll.head.next = llItem;

		ll.insertNewItem(0, 5);
		ll.insertNewItem(2, 15);
		ll.insertNewItem(4, 20);
		ll.insertNewItem(1, 22);

		ll.delete(0);
		ll.delete(2);
		ll.delete(1);

	}

}


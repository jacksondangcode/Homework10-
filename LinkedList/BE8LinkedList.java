package HW;

import java.util.LinkedList;

public class BE8LinkedList {
	LinkedListItem head;

	public void delete(int index) {
		if (head == null) {
			System.out.println("LinkedList is empty, cannot delete.");
			return;
		}

		if (index < 0) {
			System.out.println("Invalid index: " + index);
			return;
		}

		if (index == 0) {
			head = head.next;
			System.out.println("Deleted element at index " + index);
			return;
		}

		LinkedListItem current = head;
		for (int i = 0; i < index - 1; i++) {
			if (current.next == null) {
				System.out.println("Index " + index + " exceeded the length of list.");
				return;
			}
			current = current.next;
		}

		if (current.next == null) {
			System.out.println("Index " + index + " exceeded the length of list.");
			return;
		}

		current.next = current.next.next;
		System.out.println("Deleted element at index " + index);
	}

	public void insertNewItem(int index, Integer value) {
		if (index < 0) {
			System.out.println("Invalid index: " + index);
			return;
		}

		LinkedListItem newItem = new LinkedListItem();
		newItem.value = value;

		if (index == 0) {
			newItem.next = head;
			head = newItem;
			System.out.println("Inserted value " + value + " at index " + index);
			return;
		}

		LinkedListItem current = head;
		for (int i = 0; i < index - 1; i++) {
			if (current == null) {
				System.out.println("Index " + index + " exceeded the length of list + 1.");
				return;
			}
			current = current.next;
		}

		if (current == null) {
			System.out.println("Index " + index + " exceeded the length of list + 1.");
			return;
		}

		newItem.next = current.next;
		current.next = newItem;
		System.out.println("Inserted value " + value + " at index " + index);
	}
}

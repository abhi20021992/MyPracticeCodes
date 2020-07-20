package solutions;

import libs.Node;

public class KthToLastElement {
	public static Node<String> list;
	public static Node<String> START = list;
	public static void main(String[] args) {
		add("abhi");
		add("harsha");
		add("ashu");
		add("abhi");
		print(list);
		Node<String> head = findElementsFrom(2);
		System.out.println("found elements");
		print(head);
	}

	
	private static Node<String> findElementsFrom(int from) {
		if(from<=0) {
			return null;
		}
		while(list.next!= null) {
			from--;
			list = list.next;
			if(from == 0) {
				return list;
			}
		}
		return null;
	}



	public static void add(String data) {
		if(list == null) {
			START = list = new Node<String>(data);
		}else {
			while(list.next != null) {
				list = list.next;
			}
			list.next = new Node<String>(data);
			list = START;
		}
	}
	
	public static void print(Node<String> head) {
		if(head == null) {
			System.out.println("Nothing to print");
			return;
		}
		Node<String> copy = head;
		while(head.next != null) {
			System.out.println(head.data);
			head = head.next;
		}
		System.out.println(head.data);
		head = copy;
	}
}

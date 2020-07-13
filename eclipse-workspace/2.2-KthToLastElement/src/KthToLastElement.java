
public class KthToLastElement {
	public static Node list;
	public static Node START = list;
	public static void main(String[] args) {
		add("abhi");
		add("harsha");
		add("ashu");
		add("abhi");
		print(list);
		Node head = findElementsFrom(2);
		System.out.println("found elements");
		print(head);
	}

	
	private static Node findElementsFrom(int from) {
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
			START = list = new Node(data);
		}else {
			while(list.next != null) {
				list = list.next;
			}
			list.next = new Node(data);
			list = START;
		}
	}
	
	public static void print(Node head) {
		if(head == null) {
			System.out.println("Nothing to print");
			return;
		}
		Node copy = head;
		while(head.next != null) {
			System.out.println(head.data);
			head = head.next;
		}
		System.out.println(head.data);
		head = copy;
	}
}

class Node {
	String data;
	Node next;
	public Node() {
	}
	public Node(String data) {
		this.data = data;
		this.next = null;
	}
}

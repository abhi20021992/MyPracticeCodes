
public class LoopDetection {

	public static Node list1;
	public static Node START1 = list1;
	public static void main(String[] args) {
		START1 =list1 = add(list1,3);
		list1 = add(list1,4);
		list1 = add(list1,5);
		list1 = add(list1,1);
		list1 = add(list1,2);
		System.out.println("List one ------");
		print(list1);
		makeCircular(list1);
		System.out.println("Circular list ------");
		print(list1);
		System.out.println("List is "+ (IsCircular(list1) ? "" : "not " )+"circular : ");
	}

	private static void makeCircular(Node list12) {
		Node repeatedNode = list12.next.next;
		list12.next.next.next.next.next = repeatedNode;
	}

	//isCircular need to be thinked again usng paper and pen
	public static boolean IsCircular(Node head) {
		Node list = head;
		while(list != null) {
			Node searchList = list.next;
			Node searchListHead= searchList;
			do {
				if(searchList == list) {
					return true;
				}
				searchList = searchList.next;
			}while(searchList != searchListHead);
			list = list.next;
		}
		return false;
	}
	
	
	public static int count(Node list) {
		int count = 1;
		while (list != null && list.next != null) {
			count++;
			list = list.next;
		}
		return count;
	}

	public static Node add(Node list, int data) {
		Node head = list;
		if (list == null) {
			list = new Node(data);
			return list;
		} else {
			while (list.next != null) {
				list = list.next;
			}
			list.next = new Node(data);
			return head;
		}
		
	}

	public static void print(Node head) {
		int count = 0;
		if (head == null) {
			System.out.println("Nothing to print");
			return;
		}
		Node copy = head;
		while (head.next != null && count !=5) {
			System.out.print("  "+head.data);
			head = head.next;
			count++;
		}
		System.out.println("  "+ head.data);
		head = copy;
	}
}

class Node {
	int data;
	Node next;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}

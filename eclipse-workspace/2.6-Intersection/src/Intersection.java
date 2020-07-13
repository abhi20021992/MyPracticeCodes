
public class Intersection {

	public static Node list1;
	public static Node list2;
	public static Node START1 = list1;
	public static Node START2 = list2;
	public static void main(String[] args) {
		START1 =list1 = add(list1,3);
		list1 = add(list1,4);
		list1 = add(list1,5);
		list1 = add(list1,1);
		list1 = add(list1,2);
		System.out.println("List one ------");
		print(list1);
		START2 = list2 = add(list2,30);
		list2 = add(list2,40);
		list2 = add(list2,50);
		list2 = add(list2,10);
		list2 = add(list2,20);
		System.out.println("List two ------");
		print(list2);
		matchNode(list1, list2);
		System.out.println("List two copy ------");
		print(list2);
		//print(list);
		//Partition on 5
		Node result = intersection(list1, list2);
		System.out.println("First intersection point on lists ------");
		print(result);
	}

	private static void matchNode(Node list12, Node list22) {
		Node commonNode = list12.next.next;
		commonNode.next = list22.next.next.next;
		list22.next.next = commonNode;
	}

	public static Node intersection(Node list12, Node list22) {
		while(list12 != null) {
			Node list22Copy = list22;
			while(list22Copy != null) {
				if(list22Copy == list12) {
					list12.next = null;
					return list12;
				}
				list22Copy = list22Copy.next;
			}
			list12 = list12.next;
		}
		return null;
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
		if (head == null) {
			System.out.println("Nothing to print");
			return;
		}
		Node copy = head;
		while (head.next != null) {
			System.out.print("  "+head.data);
			head = head.next;
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

package solutions;

import libs.Node;
public class DeleteMiddleNode {

	public static Node<String> list;
	public static Node<String> START = list;
	public static void main(String[] args) {
		add("abhi");
		add("harsha");
		add("ashu");
		add("abhi");
		print(list);
		deleteMiddleNode();
		print(list);
		deleteMiddleNode();
		print(list);
	}

	
	public static void deleteMiddleNode() 
	{ 
		int nodeCount = count(list);
		System.out.println(nodeCount);
		if(nodeCount<=2) {
			System.out.println("There is not middle node in list");
		}
		double middleNodeInde = Math.abs(Math.floor(nodeCount));
		System.out.println(middleNodeInde);
		while(list.next != null) {
			middleNodeInde--;
			if(middleNodeInde == 0) {
				list.next = list.next.next;
				break;
			}
			list = list.next;
		}
	} 
	
	public static int count(Node<String> list) {
		int count = 1;
		while (list!=null && list.next!= null) {
			count++;
			list = list.next;
		}
		return count;
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

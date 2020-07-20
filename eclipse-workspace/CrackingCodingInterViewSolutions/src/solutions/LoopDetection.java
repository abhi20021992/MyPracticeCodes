package solutions;

import libs.Node;

public class LoopDetection {

	public static Node<Integer> list1;
	public static Node<Integer> START1 = list1;
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

	private static void makeCircular(Node<Integer> list12) {
		Node<Integer> repeatedNode = list12.next.next;
		list12.next.next.next.next.next = repeatedNode;
	}

	//isCircular need to be thinked again usng paper and pen
	public static boolean IsCircular(Node<Integer> head) {
		Node<Integer> list = head;
		while(list != null) {
			Node<Integer> searchList = list.next;
			Node<Integer> searchListHead= searchList;
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
	
	
	public static int count(Node<Integer> list) {
		int count = 1;
		while (list != null && list.next != null) {
			count++;
			list = list.next;
		}
		return count;
	}

	public static Node<Integer> add(Node<Integer> list, int data) {
		Node<Integer> head = list;
		if (list == null) {
			list = new Node<Integer>(data);
			return list;
		} else {
			while (list.next != null) {
				list = list.next;
			}
			list.next = new Node<Integer>(data);
			return head;
		}
		
	}

	public static void print(Node<Integer> head) {
		int count = 0;
		if (head == null) {
			System.out.println("Nothing to print");
			return;
		}
		Node<Integer> copy = head;
		while (head.next != null && count !=5) {
			System.out.print("  "+head.data);
			head = head.next;
			count++;
		}
		System.out.println("  "+ head.data);
		head = copy;
	}
}

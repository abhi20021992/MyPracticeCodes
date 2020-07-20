package solutions;

import libs.Node;

public class SumList {

	public static Node<Integer> list;
	public static Node<Integer> START = list;

	public static void main(String[] args) {
		add(3);
		add(5);
		add(8);
		add(5);
		add(10);
		add(2);
		add(1);
		//print(list);
		//Partition on 5
		Node<Integer> result = partition(5);
		print(result);
	}

	public static Node<Integer> partition(int partitionKey) {
		Node<Integer> newList = new Node<Integer>(partitionKey);
		int repeatCount = 0;
		do{
			int data = list.data;
			Node<Integer> newListCopy = newList;
			if(data < partitionKey) {
				newList = new Node<Integer>(data);
				newList.next = newListCopy;
			}else {
				if(partitionKey == data && repeatCount == 0) {
					repeatCount = 1;
					list = list.next;
					continue;
				}
				while(newListCopy.next!= null) {
					newListCopy = newListCopy.next;
				}
				newListCopy.next = new Node<Integer>(data);
			}
			list = list.next;
		}while(list.next!= null); 
		return newList;
	}
	
	
	public static int count(Node<Integer> list) {
		int count = 1;
		while (list != null && list.next != null) {
			count++;
			list = list.next;
		}
		return count;
	}

	public static void add(int data) {
		if (list == null) {
			START = list = new Node<Integer>(data);
		} else {
			while (list.next != null) {
				list = list.next;
			}
			list.next = new Node<Integer>(data);
			list = START;
		}
	}

	public static void print(Node<Integer> head) {
		if (head == null) {
			System.out.println("Nothing to print");
			return;
		}
		Node<Integer> copy = head;
		while (head.next != null) {
			System.out.println(head.data);
			head = head.next;
		}
		System.out.println(head.data);
		head = copy;
	}

}

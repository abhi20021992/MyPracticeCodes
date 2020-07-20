package solutions;


//This solution is not exactly matching the question and is simply partition based on the value used for the partition
public class Partition {

	public static Node list;
	public static Node START = list;

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
		Node result = partition(5);
		print(result);
	}

	public static Node partition(int partitionKey) {
		Node newList = new Node(partitionKey);
		int repeatCount = 0;
		do{
			int data = list.data;
			Node newListCopy = newList;
			if(data < partitionKey) {
				newList = new Node(data);
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
				newListCopy.next = new Node(data);
			}
			list = list.next;
		}while(list.next!= null); 
		return newList;
	}
	
	
	public static int count(Node list) {
		int count = 1;
		while (list != null && list.next != null) {
			count++;
			list = list.next;
		}
		return count;
	}

	public static void add(int data) {
		if (list == null) {
			START = list = new Node(data);
		} else {
			while (list.next != null) {
				list = list.next;
			}
			list.next = new Node(data);
			list = START;
		}
	}

	public static void print(Node head) {
		if (head == null) {
			System.out.println("Nothing to print");
			return;
		}
		Node copy = head;
		while (head.next != null) {
			System.out.println(head.data);
			head = head.next;
		}
		System.out.println(head.data);
		head = copy;
	}
}

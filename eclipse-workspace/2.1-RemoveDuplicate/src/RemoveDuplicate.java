
public class RemoveDuplicate {

	public static Node list;
	public static Node START = list;
	public static void main(String[] args) {
		add("abhi");
		add("harsha");
		add("ashu");
		add("abhi");
		print();
		removeDuplicates();
		print();
	}

	
	public static void removeDuplicates() 
	{ 
		System.out.println("removing duplicate");
	    Node ptr1, ptr2; 
	    ptr1 = list; 
	    while (ptr1 != null && ptr1.next != null) 
	    { 
	        ptr2 = ptr1; 
	  
	 
	        while (ptr2.next != null) 
	        { 
	            
	            if (ptr1.data == ptr2.next.data) 
	            { 
	              
	                ptr2.next = ptr2.next.next; 
	            } 
	            else 
	                ptr2 = ptr2.next; 
	        } 
	        ptr1 = ptr1.next; 
	    } 
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
	
	public static void print() {
		while(list.next != null) {
			System.out.println(list.data);
			list = list.next;
		}
		System.out.println(list.data);
		list = START;
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
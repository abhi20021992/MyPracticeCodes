
public class AnimalShelter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new Queue<Integer>(3);
		q.dequeue();
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.print();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
	}

}

class AnimalQueue<T> {
	private int SIZE = 30;
	public AnimalQueue() {
		
	}
}

class Queue<T>{
	private int SIZE = 30;
	private T[] storage;
	private int head = -1;
	@SuppressWarnings("unchecked")
	public Queue() {
		this.storage = (T[])new Object[this.SIZE];
	}
	
	@SuppressWarnings("unchecked")
	public Queue( int size) {
		if(size<=0) {
			System.err.println("Invalid size!");
			return;
		}
		this.SIZE = size;
		this.storage = (T[])new Object[this.SIZE];
	}
	
	public T dequeue() {
		if(this.head <0) {
			System.err.println("Queue is empty");
			return null;
		}
		return this.storage[this.head--];
	}
	
	public void enqueue(T data) {
		if(this.head >= this.SIZE-1) {
			System.err.println("Queue is full!");
			return;
		}
		this.storage[++this.head]= data;
	}
	
	public void print() {
		System.out.println("");
		System.out.print("Your queue is : [ ");
		for(int index = this.head; index>=0; index--) {
			System.out.print(this.storage[index]+" ");
		}
		System.out.print("]");
		System.out.println("");
	}
}
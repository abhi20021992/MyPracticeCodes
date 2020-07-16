
public class QueueViaStack {

	public static void main(String[] args) {
		CustomQueue<Integer> cQueue = new CustomQueue<Integer>();
		cQueue.dequeue();
		cQueue.enqueue(2);
		cQueue.enqueue(4);
		cQueue.enqueue(9);
		cQueue.enqueue(7);
		cQueue.print();
		cQueue.dequeue();
		cQueue.dequeue();
		cQueue.dequeue();
		cQueue.dequeue();
		cQueue.dequeue();
	}

}

class CustomQueue<T> {
	private Stack<T> stack;
	private int SIZE = 10;
	
	public CustomQueue() {
		this.stack = new Stack<T>(SIZE);
	}
	
	public CustomQueue(int size) {
		this.stack = new Stack<T>(size);
		this.SIZE = size;
	}
	
	public void enqueue(T data) {
		if(this.stack.isFull()) {
			System.err.println("Queue is full!");
			return;
		}
		System.out.println("Element "+ data.toString()+" is queued!");
		this.stack.push(data);
	}
	
	public T dequeue() {
		if(this.stack.isEmpty()) {
			System.err.println("Queue is empty!");
			return null;
		}
		Stack<T> stackCopy = new Stack<T>();
		while(!stack.isEmpty()) {
			stackCopy.push(stack.pop());
		}
		T elementToBePopped = stackCopy.pop();
		while(!stackCopy.isEmpty()) {
			stack.push(stackCopy.pop());
		}
		System.out.println("Element "+ elementToBePopped.toString()+" is dequeued!");
		return elementToBePopped;
	}
	
	public void print() {
		System.out.println("");
		System.out.print("Your queue is : [ ");
		Stack<T> stackCopy = new Stack<T>();
		while(!stack.isEmpty()) {
			T data = stack.pop();
			System.out.print(data.toString()+ " ");
			stackCopy.push(data);
		}
		while(!stackCopy.isEmpty()) {
			stack.push(stackCopy.pop());
		}
		System.out.print(" ]");
		System.out.println("");
	}
}


class Stack<T>{
	
	private int SIZE = 30;
	private int TOP = -1;
	private T[] storage;
	
	@SuppressWarnings("unchecked")
	public Stack() {
		this.storage = (T[])new Object[this.SIZE];
	}
	
	@SuppressWarnings("unchecked")
	public Stack(int size) {
		if(size< 1) {
			System.err.println("Invalid size!");
			return;
		}
		this.SIZE = size;
		this.storage = (T[])new Object[size]; 
	}
	
	
	public void push(T data) {
		
		if(this.TOP >= this.SIZE) {
			System.err.println("Stack is full");
			return;
		}
		this.TOP++;
		this.storage[this.TOP] = data;
		//System.out.println("Element " + data.toString() + " is stored!");
	}
	
	public T pop() {
		if(this.TOP < 0) {
			//System.err.println("Stack is empty!");
			return null;
		}
		T data = this.storage[this.TOP];
		this.TOP--;
		//System.out.println("Element "+ data.toString() + " is popped!");
		return data;
	}
	
	
	public int size() {
		return this.storage.length;
	}
	
	public boolean isEmpty() {
		return this.TOP == -1;
	}
	
	public boolean isFull() {
		return this.TOP >= this.SIZE-1;
	}
	public void print() {
		//System.out.print("Your stack is : [ ");
		for(var index = 0; index< SIZE ; index ++) {
			if(this.storage[index] != null) {
				System.out.print(this.storage[index].toString()+ " ");
			}
		}
		
		//.out.print(" ]");
		//System.out.println("");
	}
}
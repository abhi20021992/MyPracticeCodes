package solutions;

import libs.Stack;

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

import java.util.ArrayList;


public class StackOfPlates {

	public static void main(String[] args) {
		DynamicStack<Integer> dStack = new DynamicStack<Integer>();
		dStack.push(3);
		dStack.push(4);
		dStack.push(5);
		dStack.push(6);
		dStack.print();
		dStack.pop();
		dStack.pop();
		dStack.pop();
		dStack.pop();
		dStack.pop();
		dStack.pop();
	}

}

class DynamicStack<T>{
	private ArrayList<Stack<T>> stacks = new ArrayList<Stack<T>>();
	public DynamicStack() {
		stacks.add(new Stack<T>());
	}
	
	public void push(T data) {
		Stack<T> currentStack = null;
		for (Stack<T> stack : stacks) {
			if(!stack.isFull()) {
				currentStack = stack;
			}
		}
		if(currentStack == null) {
			currentStack = new Stack<T>();
			stacks.add(currentStack);
			currentStack.push(data);
		}else {
			currentStack.push(data);
		}
	}
	
	public T pop() {
		Stack<T> currentStack = stacks.get(stacks.size()-1);
		
		if(currentStack == null) {
			System.err.println("Stack is empty!");
			return null;
		}else {
			if(currentStack.isEmpty()) {
				if(stacks.size()==1) {
					System.err.println("Stack is empty!");
					return null;
				}else {
					stacks.remove(stacks.size()-1);
					currentStack = stacks.get(stacks.size() -1);
					return currentStack.pop();
				}
				
			}else {
				return currentStack.pop();
			}
		}
	}
	
	public void print() {
		System.out.println("");
		System.out.print("Your stack is : [ ");
		for (Stack<T> stack : stacks) {
			stack.print();
		}
		System.out.print("]");
		System.out.println("");
	}
}

class Stack<T>{
	
	private int SIZE = 3;
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
		System.out.println("Element " + data.toString() + " is stored!");
	}
	
	public T pop() {
		if(this.TOP < 0) {
			System.err.println("Stack is empty!");
			return null;
		}
		T data = this.storage[this.TOP];
		this.TOP--;
		System.out.println("Element "+ data.toString() + " is popped!");
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
		
		//System.out.print(" ]");
		//System.out.println("");
	}
}
package solutions;


public class StackMin {

	public static void main(String[] args) {
		CustomStack<Integer> stack = new CustomStack<Integer>(50);
		stack.push(10);
		stack.push(3);
		stack.push(5);
		stack.push(9);
		stack.push(2);
		stack.push(1);
		stack.push(11);
		stack.print();
		stack.min();
		stack.pop();
		stack.min();
		stack.pop();
		stack.min();
		stack.pop();
		stack.min();
		stack.pop();
		stack.min();
	}

}

class CustomStack<T>{
	
	private int SIZE = 100;
	private int TOP = -1;
	private T[][] storage;
	
	@SuppressWarnings("unchecked")
	public CustomStack() {
		this.storage = (T[][])new Object[2][this.SIZE];
	}
	
	@SuppressWarnings("unchecked")
	public CustomStack(int size) {
		if(size< 1) {
			System.err.println("Invalid size!");
			return;
		}
		this.SIZE = size;
		this.storage = (T[][])new Object[2][size]; 
	}
	
	
	public T[] push(T data) {
		
		if(this.TOP >= this.SIZE) {
			System.err.println("Stack is full");
			return null;
		}
		this.TOP++;
		this.storage[0][this.TOP] = data;
		if(this.TOP == 0) {
			this.storage[1][this.TOP] = data;
		}else {
			Integer min = (Integer)this.storage[1][this.TOP-1];
			Integer currentData = (Integer)data;
			if( min > currentData ) {
				this.storage[1][this.TOP] = data;
			}else {
				this.storage[1][this.TOP] = this.storage[1][this.TOP-1];
			}
		}
		System.out.println("Element " + data.toString() + " is stored!");
		return this.storage[0];
	}
	
	public T pop() {
		if(this.TOP < 0) {
			System.err.println("Stack is empty!");
			return null;
		}
		T data = this.storage[0][this.TOP];
		this.TOP--;
		System.out.println("Element "+ data.toString() + " is popped!");
		return data;
	}
	
	public T min() {
		System.out.println("Minimum element in stack is : "+ this.storage[1][this.TOP]);
		T minimumElement = this.storage[1][this.TOP];
		if(minimumElement == null) {
			System.err.println("Stack is empty!");
			return null;
		}
		return minimumElement; 
	}
	
	public int size() {
		return this.SIZE;
	}
	
	public void print() {
		System.out.print("Your stack is : [ ");
		for(int index = 0; index< SIZE ; index ++) {
			if(this.storage[0][index] != null) {
				System.out.print(this.storage[0][index].toString()+ " ");
			}
		}
		
		System.out.print(" ]");
		System.out.println("");
	}
}

public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(7);
		stack.push(2);
		stack.push(1);
		stack.push(9);
		stack.print();
		stack.sort();
		stack.print();
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
		this.storage[this.TOP] = null;
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
		System.out.print("Your stack is : [ ");
		for(var index = 0; index< SIZE ; index ++) {
			if(this.storage[index] != null) {
				System.out.print(this.storage[index].toString()+ " ");
			}
		}
		
		System.out.print(" ]");
		System.out.println("");
	}
	
	
	public Stack<T> sort(){
		//only work with int for now
		if(this.isEmpty()) {
			System.err.println("Stack is empty!");
			return null;
		}
		if(this.TOP == 0) {
			return this;
		}
		Stack<T> copyStack = new Stack<T>(this.SIZE);
		int stackElementCount = this.TOP+1;
		int elementCount = this.TOP+1;
		do {
			T max = this.pop();
			int count = elementCount-1;
			do {
				T element = this.pop();
				if(element == null) {
					return this;
				}
				if((int)max< (int)element) {
					copyStack.push(max);
					max = element;
				}else {
					copyStack.push(element);
				}	
				count--;
			}while(count != 0);
			this.push(max);
			do {
				this.push(copyStack.pop());
			}while(!copyStack.isEmpty());
			stackElementCount--;
		}while(stackElementCount != 0);
		return this;
	}
}
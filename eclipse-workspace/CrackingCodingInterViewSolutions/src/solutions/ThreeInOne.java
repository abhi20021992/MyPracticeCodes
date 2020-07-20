package solutions;


public class ThreeInOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeStack<Integer> threeStack = new ThreeStack<Integer>();
		CustomStorageStack<Integer>[] stacks = threeStack.create(50);
		System.out.println(stacks.length);
		stacks[0].push(23);
		stacks[0].print();
		stacks[1].push(24);
		stacks[1].print();
		stacks[2].push(25);
		stacks[2].print();
		stacks[0].pop();
		stacks[0].pop();
	}

}

class ThreeStack<T> {
	
	
	T[] storage;
	
	public ThreeStack() {
		
	}
	
	@SuppressWarnings("unchecked")
	public CustomStorageStack<T>[] create(int size){
		storage = (T[]) new Object[size * 3];
		
		return new CustomStorageStack[] {
				new CustomStorageStack<T>(size, 0, storage),
				new CustomStorageStack<T>(size, size, storage),
				new CustomStorageStack<T>(size, 2*size, storage)
		};
	}
	
}

class CustomStorageStack<T>{
	
	private int SIZE = 100;
	private int START = 0;
	private int TOP = 0;
	private T[] storage;
	
	public CustomStorageStack(int size, int start, T[] storage) {
		this.SIZE = size;
		this.TOP = this.START - 1;
		this.START = start;
		this.storage = storage;
		System.out.println(storage);
	}
	public T[] push(T data) {
		
		if(this.Index() > (this.START + this.SIZE)) {
			System.err.println("Stack is full");
			return null;
		}
		this.TOP++;
		this.storage[this.Index()] = data;
		System.out.println("Element " + data.toString() + " is stored!");
		return this.storage;
	}
	
	private int Index() {
		return this.START + this.TOP;
	}
	public T pop() {
		if(this.Index() < this.START) {
			System.err.println("Stack is empty!");
			return null;
		}
		T data = this.storage[this.Index()];
		this.TOP--;
		System.out.println("Element "+ data.toString() + " is popped!");
		return data;
	}
	
	public int size() {
		return this.SIZE;
	}
	
	public void print() {
		System.out.println("Your stack is : [ ");
		for(int index = START; index< START + SIZE ; index ++) {
			if(this.storage[index] != null) {
				System.out.print(this.storage[index].toString());
			}
		}
		
		System.out.print(" ]");
		System.out.println("");
	}
}
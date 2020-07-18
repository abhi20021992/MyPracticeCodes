
public class AnimalShelter {

	public static void main(String[] args) {
//		Queue<Integer> q = new Queue<Integer>(3);
//		q.dequeue();
//		q.enqueue(3);
//		q.enqueue(5);
//		q.enqueue(6);
//		q.enqueue(7);
//		q.print();
//		q.dequeue();
//		q.dequeue();
//		q.dequeue();
//		q.dequeue();
		AnimalQueue<Object> animals = new AnimalQueue<Object>(100);
		animals.enqueue(new Cat("C1"));
		animals.enqueue(new Dog("D1"));
		animals.enqueue(new Cat("C2"));
		animals.enqueue(new Cat("C3"));
		animals.enqueue(new Dog("D2"));
		animals.enqueue(new Cat("C4"));
		animals.dequeueDog();
		animals.dequeueAny();
		animals.dequeueDog();
		animals.dequeueAny();
		animals.dequeueCat();
		animals.dequeueCat();
		animals.dequeueCat();
	}

}

class AnimalQueue<T> {
	private int SIZE = 30;
	private Queue<T> storage;
	public AnimalQueue() {
		this.storage = new Queue<T>(this.SIZE);
	}
	
	public AnimalQueue(int size) {
		this.SIZE = size;
		this.storage = new Queue<T>(this.SIZE);
	}
	
	public void enqueue(T data) {
		if(this.storage.isFull()) {
			System.err.println("Shelter is full!");
			return;
		}
		this.storage.enqueue(data);
		System.out.println("Animal registered to shelter!");
	}
	
	public T dequeueDog() {
		if(this.storage.isEmpty()) {
			System.err.println("Shelter is empty");
			return null;
		}
		Queue<T> copy = new Queue<T>();
		T dogToBeDequeued = null;
		while(!this.storage.isEmpty()) {
			T animal = this.storage.dequeue();
			if(animal instanceof Dog && dogToBeDequeued == null) {
				dogToBeDequeued = animal;
			}else {
				copy.enqueue(animal);
			}
		}
		
		while(!copy.isEmpty()) {
			this.storage.enqueue(copy.dequeue());
		}
		if(dogToBeDequeued == null) {
			System.err.println("Sorry no Dog available now!");
			return null;
		}
		System.out.println("You got dog : "+ dogToBeDequeued.toString());
		return dogToBeDequeued;
	}
	
	public T dequeueAny() {
		if(this.storage.isEmpty()) {
			System.err.println("Shelter is empty");
			return null;
		}
		T animal = this.storage.dequeue();
		if (animal instanceof Cat) {
			System.out.println("You got Cat : "+ animal);
		}else {
			System.out.println("You got Dog : "+ animal);	
		}
		return animal;
	}
	
	public T dequeueCat() {
		if(this.storage.isEmpty()) {
			System.err.println("Shelter is empty");
			return null;
		}
		Queue<T> copy = new Queue<T>();
		T catToBeDequeued = null;
		while(!this.storage.isEmpty()) {
			T animal = this.storage.dequeue();
			if(animal instanceof Cat&& catToBeDequeued== null) {
				catToBeDequeued = animal;
			}else {
				copy.enqueue(animal);
			}
		}
		
		while(!copy.isEmpty()) {
			this.storage.enqueue(copy.dequeue());
		}
		if(catToBeDequeued == null) {
			System.err.println("Sorry no Cat available now!");
			return null;
		}
		System.out.println("You got cat : "+ catToBeDequeued.toString());
		return catToBeDequeued;
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
			//System.err.println("Invalid size!");
			return;
		}
		this.SIZE = size;
		this.storage = (T[])new Object[this.SIZE];
	}
	
	public T dequeue() {
		if(this.head <0) {
			//System.err.println("Queue is empty");
			return null;
		}
		return this.storage[this.head--];
	}
	
	public void enqueue(T data) {
		if(this.head >= this.SIZE-1) {
			//System.err.println("Queue is full!");
			return;
		}
		this.storage[++this.head]= data;
	}
	
	public boolean isFull() {
		return this.head == this.SIZE-1;
	}
	
	public boolean isEmpty() {
		return this.head == -1;
	}
	
	public void print() {
		//System.out.println("");
		//System.out.print("Your queue is : [ ");
		for(int index = this.head; index>=0; index--) {
			//System.out.print(this.storage[index]+" ");
		}
		//System.out.print("]");
		//System.out.println("");
	}
}

class Cat{
	public String name;
	
	public Cat(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}

class Dog{
	public String name;
	
	public Dog(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
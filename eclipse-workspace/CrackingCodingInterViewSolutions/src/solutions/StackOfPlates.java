package solutions;

import java.util.ArrayList;
import libs.Stack;

public class StackOfPlates {

	public static void main(String[] args) {
		DynamicStack<Integer> dStack = new DynamicStack<Integer>(3);
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
	private ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	public DynamicStack() {
		stacks.add(new Stack<Integer>());
	}
	
	public DynamicStack(int size) {
		stacks.add(new Stack<Integer>(size));
	}
	
	public void push(Integer data) {
		Stack<Integer> currentStack = null;
		for (Stack<Integer> stack : stacks) {
			if(!stack.isFull()) {
				currentStack = stack;
			}
		}
		if(currentStack == null) {
			currentStack = new Stack<Integer>();
			stacks.add(currentStack);
			currentStack.push(data);
		}else {
			currentStack.push(data);
		}
	}
	
	public Integer pop() {
		Stack<Integer> currentStack = stacks.get(stacks.size()-1);
		
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
		for (Stack<Integer> stack : stacks) {
			stack.print();
		}
		System.out.print("]");
		System.out.println("");
	}
}


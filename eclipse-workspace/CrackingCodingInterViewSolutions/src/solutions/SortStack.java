package solutions;

import libs.Stack;

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


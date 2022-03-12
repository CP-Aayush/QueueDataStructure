import java.util.ArrayDeque;

public class StackUsingQueue {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
	}

}

class Stack {
	ArrayDeque<Integer> q1;
	ArrayDeque<Integer> q2;

	Stack() {
		this.q1 = new ArrayDeque<Integer>();
		this.q2 = new ArrayDeque<Integer>();
	}

	public void push(int val) {
		q1.add(val);
	}

	public void pop() {
		if (q1.isEmpty()) {
			return;
		}
		int n = q1.size();
		for (int i = 0; i < n - 1; i++) {
			q2.add(q1.remove());
		}
		q1.remove();
		q1 = new ArrayDeque<>(q2);
		q2.clear();
	}

	@Override
	public String toString() {
		return "Stack [q1=" + q1 + ", q2=" + q2 + "]";
	}

}

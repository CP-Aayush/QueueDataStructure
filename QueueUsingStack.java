import java.util.Stack;

public class QueueUsingStack {

	public static void main(String[] args) {
		Queue2 q =new Queue2();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.dequeue();
		System.out.println(q.toString());
	}

}

class Queue2 {
	@Override
	public String toString() {
		return "Queue2 [s1=" + s1 + ", s2=" + s2 + "]";
	}

	Stack<Integer> s1;
	Stack<Integer> s2;

	Queue2() {

		this.s1 = new Stack<Integer>();
		this.s2 = new Stack<Integer>();

	}

	public void enqueue(int val) {
		s1.push(val);
	}

	public void dequeue() {
		if (s1 == null) {
			return;
		}
		int n = s1.size();
		for (int i = 0; i < n; i++) {
			s2.push(s1.peek());
			s1.pop();
		}
		s2.pop();
		for (int i = 0; i < n-1; i++) {
			s1.push(s2.peek());
			s2.pop();
		}
	}
}

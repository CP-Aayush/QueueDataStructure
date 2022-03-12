
class Node {
	int val;
	Node next;

	Node() {
	}

	Node(int val) {
		this.val = val;
	}

	Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "val=" + val + ", " + next;
	}
}

public class QueueUsingLinkedList {

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.print();
		queue.dequeue();
		queue.dequeue();
		queue.print();
		System.out.println("Queue Front : " + queue.front.val);
		System.out.println("Queue Rear : " + queue.rear.val);
	}

}

class Queue {
	Node front;
	Node rear;

	Queue() {
		this.front = null;
		this.rear = null;
	}

	public void enqueue(int val) {
		Node node = new Node(val);
		if (rear == null) {
			front = rear = node;
			return;
		}
		rear.next = node;
		rear = rear.next;
	}

	public Node dequeue() {
		if (front == null) {
			return null;
		}
		Node node = front;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		node.next = null;
		return node;
	}

	public void print() {
		if (front == null) {
			System.out.println("Queue is empty");
		}
		Node node = front;
		System.out.println(node.toString() + " ");

	}
}

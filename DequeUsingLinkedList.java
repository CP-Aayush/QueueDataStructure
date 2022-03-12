class DoubleNode {
	int val;
	DoubleNode next;
	DoubleNode prev;

	DoubleNode() {
	}

	DoubleNode(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "val=" + val + ", " + next;
	}

}

public class DequeUsingLinkedList {

	public static void main(String[] args) {
		Dequeue dequeue = new Dequeue();
		dequeue.enqueueFromFront(1);
		System.out.println("Queue Rear : " + dequeue.rear.val);
		System.out.println("Queue Front : " + dequeue.front.val);
		dequeue.enqueueFromFront(2);
		System.out.println("Queue Rear : " + dequeue.rear.val);
		System.out.println("Queue Front : " + dequeue.front.val);
		dequeue.enqueueFromFront(3);
		System.out.println("Queue Rear : " + dequeue.rear.val);
		System.out.println("Queue Front : " + dequeue.front.val);
		dequeue.print();
		dequeue.dequeueFromFront();
		dequeue.print();
		System.out.println("Queue Rear : " + dequeue.rear.val);
		System.out.println("Queue Front : " + dequeue.front.val);
		dequeue.dequeueFromRear();
		dequeue.print();
		System.out.println("Queue Rear : " + dequeue.rear.val);
		System.out.println("Queue Front : " + dequeue.front.val);
		dequeue.enqueueFromRear(5);
		System.out.println("Queue Rear : " + dequeue.rear.val);
		System.out.println("Queue Front : " + dequeue.front.val);
	}

}

class Dequeue {
	DoubleNode front;
	DoubleNode rear;

	Dequeue() {
		this.front = null;
		this.rear = null;
	}

	public void enqueueFromFront(int val) {
		DoubleNode node = new DoubleNode(val);
		if (rear == null) {
			front = rear = node;
			return;
		}
		front.prev = node;
		node.next = front;
		front = front.prev;
	}

	public void enqueueFromRear(int val) {
		DoubleNode node = new DoubleNode(val);
		if (rear == null) {
			front = rear = node;
			return;
		}
		rear.next = node;
		node.prev = rear;
		rear = rear.next;
	}

	public void dequeueFromFront() {
		if (front == null) {
			return;
		}
		front = front.next;
		if (front == null) {
			rear = null;
		}
	}

	public void dequeueFromRear() {
		if (rear == null) {
			return;
		}
		rear = rear.prev;
		if (rear == null) {
			front = null;
		}
	}

	public void print() {
		if (front == null) {
			System.out.println("Queue is empty");
		}
		DoubleNode node = front;
		System.out.println(node.toString() + " ");

	}
}
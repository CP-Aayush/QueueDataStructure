import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMinimum {

	public static void main(String[] args) {
		int arr[] = maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
		
		for(int i=0;i<arr.length;i++) {			
			System.out.println(arr[i]);
		}

	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}
		int n = nums.length;
		int[] r = new int[n - k + 1];
		int index = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.remove();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && nums[q.peekLast()] > nums[i]) {
				q.removeLast();
			}
			// q contains index... r contains content
			q.addLast(i);
			if (i >= k - 1) {
				r[index++] = nums[q.peek()];
			}
		}
		return r;

	}

}

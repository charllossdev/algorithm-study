package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

public class t10828 {

	@ParameterizedTest
	@ValueSource(strings = {"14\npush 1\npush 2\ntop\nsize\nempty\npop\npop\npop\nsize\nempty\npop\npush 3\nempty\ntop",
		"7\npop\ntop\npush 123\ntop\npop\ntop\npop"})
	void streamTest(String input) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(Common.systemIn(input)));

		StackCus stack = new StackCus(Integer.parseInt(bf.readLine()));
		while (bf.ready()) {
			String message = bf.readLine();
			stack.play(message);
		}
	}

	@ParameterizedTest
	@ValueSource(strings = {"14\npush 1\npush 2\ntop\nsize\nempty\npop\npop\npop\nsize\nempty\npop\npush 3\nempty\ntop",
		"7\npop\ntop\npush 123\ntop\npop\ntop\npop"})
	void createStack(String input) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(Common.systemIn(input)));
		bf.readLine();

		Stack<Integer> stack = new Stack<>();
		while (bf.ready()) {
			String msg = bf.readLine();

			if (msg.contains("push")) {
				stack.push(Integer.parseInt(msg.replace("push ", "")));
			} else if (msg.contains("pop")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
			} else if (msg.contains("size")) {
				System.out.println(stack.size());
			} else if (msg.contains("empty")) {
				if (stack.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			} else if (msg.contains("top")) {
				if (stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
			}
		}

	}

	private static class StackCus {
		private final int[] arr;
		private int size;

		public StackCus(int size) {
			this.arr = new int[size];
			this.size = 0;
		}

		public void play(String message) {
			if (message.contains("push")) {
				this.push(message.replace("push ", ""));
			} else if (message.contains("pop")) {
				this.pop();
			} else if (message.contains("size")) {
				this.size();
			} else if (message.contains("empty")) {
				this.empty();
			} else if (message.contains("top")) {
				this.top();
			}
		}

		private void top() {
			if (isEmpty()) {
				System.out.println(-1);
			} else {
				System.out.println(arr[size - 1]);
			}
		}

		private void empty() {
			if (isEmpty()) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

		private boolean isEmpty() {
			return size == 0;
		}

		private void size() {
			System.out.println(this.size);
		}

		private void pop() {
			if (isEmpty()) {
				System.out.println(-1);
			} else {
				System.out.println(arr[--size]);
				arr[size] = 0;
			}
		}

		private void push(String message) {
			this.arr[size++] = Integer.parseInt(message);
		}
	}
}

package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

public class t10845 {

	@ParameterizedTest
	@ValueSource(strings = {"15\n"
		+ "push 1\n"
		+ "push 2\n"
		+ "front\n"
		+ "back\n"
		+ "size\n"
		+ "empty\n"
		+ "pop\n"
		+ "pop\n"
		+ "pop\n"
		+ "size\n"
		+ "empty\n"
		+ "pop\n"
		+ "push 3\n"
		+ "empty\n"
		+ "front"})
	void name(String input) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(Common.systemIn(input)));
		ManualQueue queue = new ManualQueue(Integer.parseInt(br.readLine()));
		while (br.ready()) {
			queue.play(br.readLine());
		}
	}

	private static class ManualQueue {

		private final int[] arr;
		private int begin;
		private int end;

		public ManualQueue(int size) {
			arr = new int[size];
			begin = 0;
			end = 0;
		}

		public void play(String msg) {
			/*
			 * push X: 정수 X를 큐에 넣는 연산이다.
			 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			 * size: 큐에 들어있는 정수의 개수를 출력한다.
			 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
			 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			 */
			if (msg.contains("push")) {
				arr[end++] = Integer.parseInt(msg.replace("push ", ""));
			} else if (msg.contains("pop")) {
				if (isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(arr[begin]);
					arr[begin++] = 0;
				}
			} else if (msg.contains("size")) {
				System.out.println(end - begin);
			} else if (msg.contains("empty")) {
				if (isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (msg.contains("front")) {
				if (isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(arr[begin]);
				}
			} else if (msg.contains("back")) {
				if (isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(arr[end - 1]);
				}
			}
		}

		private boolean isEmpty() {
			return end - begin == 0;

		}
	}
}

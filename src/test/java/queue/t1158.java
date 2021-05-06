package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

public class t1158 {

	@ParameterizedTest
	@ValueSource(strings = {"7 3"})
	void josephus(String input) {
		Scanner sc = new Scanner(Common.systemIn(input));
		String[] s = sc.nextLine().split(" ");
		int max = Integer.parseInt(s[0]);
		int point = Integer.parseInt(s[1]);

		solve(max, point);
	}

	private void solve(int max, int point) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		sb.append("<");

		for (int i = 1; i <= max; i++) {
			queue.add(i);
		}
		int count = 0;
		while (!queue.isEmpty()) {
			if (++count < point) {
				queue.add(queue.poll());
			} else {
				count = 0;
				sb.append(queue.poll()).append(", ");
			}
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.deleteCharAt(sb.lastIndexOf(" "));
		sb.append(">");
		System.out.println(sb);
	}
}

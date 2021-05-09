package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

public class t10799 {

	@ParameterizedTest
	@ValueSource(strings = {"()(((()())(())()))(())", "(((()(()()))(())()))(()())"})
	void test(String input) {
		Scanner sc = new Scanner(Common.systemIn(input));
		String msg = sc.nextLine();
		List<pipe> pipes = new ArrayList<>();
		Stack<Integer> temp = new Stack<>();
		Stack<Integer> cut = new Stack<>();
		int position = 0;
		for (String s : msg.split("")) {
			if (s.equals(")")) {
				if (temp.peek() == position - 1) {
					cut.push(position);
					temp.pop();
				} else {
					pipes.add(new pipe(temp.pop(), position));
				}
			} else {
				temp.push(position);
			}
			position++;
		}

		while (!cut.isEmpty()) {
			int point = cut.pop();
			List<pipe> result = new ArrayList<>();
			for (pipe p : pipes) {
				if (p.isCut(point)) {
					result.add(new pipe(p.start, point - 1));
					result.add(new pipe(point + 1, p.end));
				} else {
					result.add(p);
				}
			}
			pipes = result;
		}

		System.out.println(pipes.size());
	}

	private static class pipe {
		private final int start;
		private final int end;

		@Override
		public String toString() {
			return "[" + start + ", " + end + "]";
		}

		private pipe(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public boolean isCut(int point) {
			return this.start < point && end > point;
		}
	}
}

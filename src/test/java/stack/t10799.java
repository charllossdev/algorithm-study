package stack;

import java.util.Scanner;
import java.util.Stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

public class t10799 {

	@ParameterizedTest
	@ValueSource(strings = {"()(((()())(())()))(())"})
	void test(String input) {
		Scanner sc = new Scanner(Common.systemIn(input));
		String msg = sc.nextLine();
		Stack<work> stack = new Stack<>();
		int position = 0;
		for (String s : msg.split("")) {
			if (s.equals(")")) {
				
			} else {
				stack.push(new work(position, s));
			}
			position++;
		}
	}

	private class work {
		private final int position;
		private final String data;

		public work(int pos, String data) {
			this.position = pos;
			this.data = data;
		}

		public boolean isLager(int pos) {
			return pos - this.position == -1;
		}
	}
}

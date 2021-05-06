package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

public class t17413 {

	@ParameterizedTest
	@ValueSource(strings = {
		"<int><max>2147483647<long long><max>9223372036854775807",
		"<   space   >space space space<    spa   c e>"})
	void main(String input) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(Common.systemIn(input)));
		boolean flag = false;
		String msg = br.readLine();
		Stack<String> stack = new Stack<>();

		for (String s : msg.split("")) {
			if (s.equals("<")) {
				print(stack);
				flag = true;
			}

			if (flag) {
				System.out.print(s);
				if (s.equals(">")) {
					flag = false;
				}
			} else {
				if (s.equals(" ")) {
					print(stack);
					System.out.print(s);
				} else {
					stack.push(s);
				}
			}
		}

		print(stack);
		br.close();
	}

	private void print(Stack<String> s) {
		while (!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}
}

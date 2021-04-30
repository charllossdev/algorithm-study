package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

public class t9093 {

	@ParameterizedTest
	@ValueSource(strings = {"2\nI am happy today\nWe want to win the first prize"})
	void revertTest(String input) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(Common.systemIn(input)));
		int count = Integer.parseInt(br.readLine());
		while (br.ready()) {
			String result = Arrays.stream(br.readLine().split(" "))
				.map(t9093::revert)
				.collect(Collectors.joining()).trim();
			System.out.println(result);
		}
	}

	private static String revert(String msg) {
		Stack<Character> stack = new Stack<>();
		StringBuilder result = new StringBuilder();

		for (char c : msg.toCharArray()) {
			stack.push(c);
		}

		while (!stack.isEmpty()) {
			result.append(stack.pop().toString());
		}

		result.append(" ");

		return result.toString();
	}
}

package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

public class t9012 {

	@ParameterizedTest
	@ValueSource(strings = {
		"6\n(())())\n(((()())()\n(()())((()))\n((()()(()))(((())))()\n()()()()(()()())()\n(()((())()(",
		"3\n((\n))\n())(()"})
	void name(String input) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(Common.systemIn(input)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		br.readLine();

		while (br.ready()) {
			bw.write(vps(br.readLine()) + "\n");
		}
		bw.flush();
	}

	private String vps(String msg) {
		Stack<String> stack = new Stack<>();

		for (String s : msg.split("")) {
			if (s.equals("(")) {
				stack.push(s);
			} else {
				if (stack.isEmpty()) {
					return "NO";
				} else {
					stack.pop();
				}
			}
		}

		if (stack.isEmpty()) {
			return "YES";
		}

		return "NO";
	}

	@Test
	void stringTest() {
		String data = "salkdfjasldkf";
		String[] split = data.split("");
		System.out.println(split.length);
		System.out.println(Arrays.toString(split));
	}
}

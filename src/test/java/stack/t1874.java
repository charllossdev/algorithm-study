package stack;

import java.util.Scanner;
import java.util.Stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

public class t1874 {

	@ParameterizedTest
	@ValueSource(strings = {"8\n4\n3\n6\n8\n7\n5\n2\n1", "5\n1\n2\n5\n3\n4"})
	void stack(String input) {
		Scanner sc = new Scanner(Common.systemIn(input));
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		solve(a);
	}

	private static void solve(int[] a) {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int m = 0;
		for (int n : a) {
			while (m < n) {
				stack.push(++m);
				sb.append("+\n");
			}

			if (stack.peek() == n) {
				stack.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb);
	}
}

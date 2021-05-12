package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

public class t17298 {
	@ParameterizedTest
	@ValueSource(strings = {"4\n3 5 2 7", "4\n9 5 4 8"})
	void test(String input) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(Common.systemIn(input)));
		int count = Integer.parseInt(br.readLine());
		String msg = br.readLine();
		boolean flag = false;

		List<Integer> collect = Arrays.stream(msg.split(" "))
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		for (int i = 0; i < collect.size() - 1; i++) {
			flag = true;
			for (int j = i + 1; j < collect.size(); j++) {
				if (collect.get(i) < collect.get(j)) {
					System.out.print(collect.get(j) + " ");
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.print(-1 + " ");
			}
		}
		System.out.print(-1 + " ");
	}

	@ParameterizedTest
	@ValueSource(strings = {"4\n3 5 2 7", "4\n9 5 4 8"})
	void test2(String input) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(Common.systemIn(input)));
		int count = Integer.parseInt(br.readLine());
		String msg = br.readLine();
		int[] arr = new int[count];
		Stack<Integer> s = new Stack<>();
		s.push(0);
		List<Integer> collect = Arrays.stream(msg.split(" "))
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		for (int i = 1; i < collect.size(); i++) {
			if (s.isEmpty())
				s.push(i);

			while (!s.isEmpty() && collect.get(s.peek()) < collect.get(i)) {
				arr[s.pop()] = collect.get(i);
			}
			s.push(i);
		}
		while (!s.isEmpty()) {
			arr[s.pop()] = -1;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < count; i++) {
			bw.write(arr[i] + " ");
		}
		bw.write("\n");
		bw.flush();
	}
}

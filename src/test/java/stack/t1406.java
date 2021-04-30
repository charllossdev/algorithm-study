package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

public class t1406 {

	@ParameterizedTest
	@ValueSource(strings = {"abcd\n3\nP x\nL\nP y", "abc\n9\nL\nL\nL\nL\nL\nP x\nL\nB\nP y"})
	void t1406Test(String input) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(Common.systemIn(input)));
		Editor e = new Editor(br.readLine());
		while (br.ready()) {
			e.play(br.readLine());
		}
		System.out.println(e.join());
	}

	private static class Editor {
		private final Stack<String> text;
		private final Stack<String> temp = new Stack<>();

		public Editor(String str) {
			this.text = create(str);
		}

		private Stack<String> create(String str) {
			Stack<String> s = new Stack<>();
			Arrays.stream(str.split(""))
				.forEachOrdered(s::push);
			return s;
		}

		public void play(String msg) {
			if (msg.contains("L")) {
				if (!this.text.empty()) {
					this.temp.push(this.text.pop());
				}
			} else if (msg.contains("D")) {
				if (!this.temp.isEmpty()) {
					this.text.push(temp.pop());
				}
			} else if (msg.contains("B")) {
				if (!this.text.isEmpty()) {
					this.text.pop();
				}
			} else if (msg.contains("P")) {
				this.text.push(msg.replace("P ", ""));
			}
		}

		public String join() {
			while (!this.temp.isEmpty()) {
				this.text.push(this.temp.pop());
			}

			return String.join("", this.text);
		}
	}
}

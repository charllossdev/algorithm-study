package greedy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PmTest_01 {

	@ParameterizedTest
	@CsvSource(value = {"5:2,4:1,3,5:5", "5:2,4:3:4", "3:3:1:2"}, delimiter = ':')
	void test(int n, String losts, String reverses, int result) {
		int[] lost = Arrays.stream(losts.split(","))
				.mapToInt(s -> Integer.parseInt(s))
				.toArray();
		int[] reverse = Arrays.stream(reverses.split(","))
				.mapToInt(s -> Integer.parseInt(s))
				.toArray();
		int out = 0;
		int[] people = new int[n];

		Arrays.stream(lost)
				.forEach(s -> people[s-1]--);
		Arrays.stream(reverse)
				.forEach(s -> people[s-1]++);

		for (int i = 0; i < people.length; i++) {
			if (people[i] == -1) {
				if (i >= 1 && people[i-1] == 1) {
					people[i-1]--;
					people[i]++;
				} else if (i < people.length -1 && people[i+1] == 1) {
					people[i+1]--;
					people[i]++;
				} else {
					out++;
				}
			}
		}

		System.out.println(Arrays.toString(people));
		System.out.println(out);
		System.out.println(n-out);
	}
}

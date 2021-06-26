package math;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("나머지 해결 문제")
public class t10430 {

	@ParameterizedTest
	@ValueSource(strings = {"5 8 4"})
	void calculateTest(String input) {
		Scanner sc = new Scanner(System.in);
		List<Integer> collect = Arrays.stream(sc.nextLine().split(" "))
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		int a = collect.get(0);
		int b = collect.get(1);
		int c = collect.get(2);

		System.out.println((a + b) % c);
		System.out.println(((a % c) + (b % c)) % c);
		System.out.println((a * b) % c);
		System.out.println(((a % c) * (b % c) % c));
	}
}

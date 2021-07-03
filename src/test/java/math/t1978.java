package math;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

@DisplayName("소수 구하기 테스트")
public class t1978 {

	@DisplayName("소수")
	@ParameterizedTest
	@ValueSource(strings = {"4\n1 3 5 7"})
	void name(String input) {
		Scanner scanner = new Scanner(Common.systemIn(input));
		int count = scanner.nextInt();
		int[] arr = new int[count];
		for (int i =0; i < count; i++) {
			arr[i] = scanner.nextInt();
		}

		int result = primes(arr);
		System.out.println(result);
	}

	private int primes(int[] arr) {
		return Arrays.stream(arr)
			.map(n -> {
				return isPrime(n);
			})
			.sum();
	}

	private int isPrime(int n) {
		if (n < 2) {
			return 0;
		}
		for (int i = 2; i*i <= n; i++) {
			if (n % i == 0)
				return 0;
		}
		return 1;
	}
}

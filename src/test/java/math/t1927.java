package math;

import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

@DisplayName("에라토스테네스 체 알고리즘")
public class t1927 {

	@DisplayName("N개의 수들의 소수 구하기")
	@ParameterizedTest
	@ValueSource(strings = {"3 100000"})
	void countOfPrimeTest(String input) {
		Scanner s = new Scanner(Common.systemIn(input));
		int start = s.nextInt();
		int end = s.nextInt();

		boolean[] check = new boolean[end + 1];

		for (int i = 2; i <= end; i++) {
			if (!check[i]) {
				if (i >= start)
					System.out.println(i);
				for (int j = i * i; j <= end; j += i) {
					check[j] = true;
				}
			}
		}
	}
}

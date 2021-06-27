package math;

import static java.lang.Math.*;

import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import common.Common;

@DisplayName("최대공약수와 최소공배수")
public class t2609 {

	@DisplayName("GCD, LCM 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"24 18"})
	void createGcdLcmTest(String input) {
		Scanner scanner = new Scanner(Common.systemIn(input));
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		int gcd = getGcd(a, b);
		int lcm = getLcm(a, b);

		System.out.println(gcd);
		System.out.println(lcm);
	}

	private int getLcm(int a, int b) {
		int g = getGcd(a, b);

		return g * (a/g) * (b/g);
	}


	private int getGcd(int num1, int num2) {
		int max = max(num1, num2);
		int min = min(num1, num2);

		while (min != 0) {
			int temp = min;
			min = max%min;
			max = temp;
		}
		return max;
	}

	@DisplayName("최대 공약수 구하기")
	@Test
	void gcdTest() {
		int a = 24;
		int b = 36;
		int result1 = 0;
		int result2 = 0;

		System.out.println(min(a, b));

		for (int i = 2; i < min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				result1 = i;
			}
		}


		for (int i = min(a, b); i >= 2; i--) {
			if (a % i == 0 && b % i == 0) {
				result2 = i;
				break;
			}
		}

		System.out.println(result1);
		System.out.println(result2);
	}

	@DisplayName("유클리드 호제법")
	@ParameterizedTest
	@CsvSource(value = {"24,16", "24,12"}, delimiter = ',')
	void gcdEuclideanTest(int num1, int num2) {


		int a = max(num1, num2);
		int b = min(num1, num2);

		while(b != 0) {
			int temp = b;
			b = a%b;
			a = temp;
		}

		System.out.println(a);
	}

	@DisplayName("LCM 최대 공약수를 이용해 최소 공배수 구하기")
	@ParameterizedTest
	@CsvSource(value = {"24,16", "24,12"}, delimiter = ',')
	void getLcmAboutGcdTest(int num1, int num2) {

		int gcd = getGcd(num1, num2);
		int lcm = gcd * (num1/gcd) * (num2/gcd);

		System.out.println(lcm);
	}
}

package Map;

import java.util.ArrayList;
import java.util.Arrays;

public class SixDigit {
	public static void main(String[] args) {

		System.out.println(solution(1, 8, 3, 2, 6, 4));
		System.out.println(solution(0, 0, 0, 0, 0, 0));
		System.out.println(solution(0, 0, 0, 7, 8, 9));
		System.out.println(solution(2, 4, 5, 9, 5, 9));
	}

	public static String solution(int A, int B, int C, int D, int E, int F) {

		int[] digits = { A, B, C, D, E, F };
		String result = findEarliestValidTime(digits);

		if (result != null) {
			return result;
		} else {
			return "NOT POSSIBLE";
		}
	}

	public static String findEarliestValidTime(int[] digits) {
		int[] count = new int[10];
		for (int digit : digits) {
			count[digit]++;
		}

		for(int hour = 0; hour <= 23; hour++) {
			int h1 = hour / 10;
			int h2 = hour % 10;
			if (checkDigits(count, h1, h2)) {
				count[h1]--;
				count[h2]--;
				for (int minute = 0; minute <= 59; minute++) {
					int m1 = minute / 10;
					int m2 = minute % 10;

					if (checkDigits(count, m1, m2)) {
						count[m1]--;
						count[m2]--;
						for (int second = 0; second <= 59; second++) {
							int s1 = second / 10;
							int s2 = second % 10;

							if (checkDigits(count, s1, s2)) {
								return String.format("%02d:%02d:%02d", hour, minute, second);
							}
						}

						count[m1]++;
						count[m2]++;
					}
				}
				count[h1]++;
				count[h2]++;
			}
		}

		return null;
	}

	public static boolean checkDigits(int[] count, int digit1, int digit2) {
		if (digit1 == digit2) {
			return count[digit1] >= 2;
		} else {
			return count[digit1] >= 1 && count[digit2] >= 1;
		}
	}
}

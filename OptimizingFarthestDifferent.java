package HW;

import java.util.*;

public class OptimizingFarthestDifferent {

	public static int solution(int[] A) {
		int N = A.length;

		if (N <= 1) {
			return 0;
		}

		if (A[0] != A[N - 1]) {
			return N - 1;
		}

		int result = 0;

		for (int j = N - 1; j >= 1; j--) {
			if (A[j] != A[0]) {
				result = Math.max(result, j - 0);
				break;
			}
		}

		for (int i = 0; i < N - 1; i++) {
			if (A[i] != A[N - 1]) {
				result = Math.max(result, (N - 1) - i);
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		int[] arr1 = { 4, 6, 2, 2, 6, 6, 4 };
		System.out.println("The result of test case1: " + solution(arr1));

		int[] arr2 = new int[75001];
		for (int i = 0; i < 75001; i++) {
			arr2[i] = i;
		}

		System.out.println("The result of  test case2: " + solution(arr2));

	}

}

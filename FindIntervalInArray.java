package HW;

public class FindIntervalInArray {

	public static int solution(int[] A, int L, int R) {

		boolean[] isInArray = new boolean[R - L + 1];
		for (int i = 0; i < A.length; i++) {

			if (A[i] >= L && A[i] <= R) {
				int index = A[i] - L;
				isInArray[index] = true;
			}
		}

		for (int i = 0; i < (R - L + 1); i++) {

			if (isInArray[i] == false) {

				return -1;
			}
		}

		int[] count = new int[R - L + 1];
		int uniqueCount = 0;
		int left = 0;
		int shortestFragmentLength = A.length + 1;

		for (int right = 0; right < A.length; right++) {
			// Expand window
			if (A[right] >= L && A[right] <= R) {
				int idx = A[right] - L;
				if (count[idx] == 0) {
					uniqueCount++;
				}
				count[idx]++;
			}

			// Contract window
			for (; uniqueCount == R - L + 1; left++) {
				shortestFragmentLength = Math.min(shortestFragmentLength, right - left + 1);
				if (A[left] >= L && A[left] <= R) {
					int idx = A[left] - L;
					count[idx]--;
					if (count[idx] == 0) {
						uniqueCount--;
					}
				}
			}
		}

		if (shortestFragmentLength <= A.length) {
			return shortestFragmentLength;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {

		// Test case 1
		int[] A1 = { 2, 1, 4, 3, 2, 1, 1, 4 };
		int L1 = 2;
		int R1 = 4;
		System.out.println("The result of test case1: " + solution(A1, L1, R1));

		// Test case 2
		int[] A2 = { 109, 1, 1, 1, 1, 1, 108 };
		int L2 = 108;
		int R2 = 109;
		System.out.println("The result of test case2: " + solution(A2, L2, R2));

		// Test case 3
		int[] A3 = { 1, 3, 5, 7 };
		int L3 = 3;
		int R3 = 5;
		System.out.println("The result of test case3: " + solution(A3, L3, R3));
	}

}

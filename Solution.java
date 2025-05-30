package HW;

public class Solution {

	public static void main(String[] args) {

		Solution sol = new Solution();

		// Test case 1
		int[] A1 = { 5 };
		int[] B1 = { 1, 1, 6 };
		System.out.println("Test 1 - Expected: 1, Got: " + sol.solution(A1, B1));

		// Test case 2
		int[] A2 = { 2, 3, 1, 1, 2 };
		int[] B2 = { 5, 4, 6 };
		System.out.println("Test 2 - Expected: 2, Got: " + sol.solution(A2, B2));

		// Test case 3
		int[] A3 = { 5, 4, 1, 2, 6, 5 };
		int[] B3 = { 2 };
		System.out.println("Test 3 - Expected: 6, Got: " + sol.solution(A3, B3));

		// Test case 4
		int[] A4 = { 1, 2, 3, 4, 3, 2, 1 };
		int[] B4 = { 6 };
		System.out.println("Test 4 - Expected: -1, Got: " + sol.solution(A4, B4));
	}

	public int solution(int[] A, int[] B) {

		int sumA = 0;
		int sumB = 0;

		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
		}

		for (int i = 0; i < B.length; i++) {
			sumB += B[i];
		}

		if (sumA == sumB) {
			return 0;
		}

		int difference = Math.abs(sumA - sumB);

		if (difference % 2 != 0) {
			return -1;
		}

		int target = difference / 2;

		int[] benefitsFromA = new int[A.length];
		int[] benefitsFromB = new int[B.length];

		if (sumA > sumB) {
			for (int i = 0; i < A.length; i++) {
				benefitsFromA[i] = A[i] - 1;
			}
		} else {
			for (int i = 0; i < A.length; i++) {
				benefitsFromA[i] = 6 - A[i];
			}
		}

		if (sumB > sumA) {
			for (int i = 0; i < B.length; i++) {
				benefitsFromB[i] = B[i] - 1;
			}
		} else {
			for (int i = 0; i < B.length; i++) {
				benefitsFromB[i] = 6 - B[i];
			}
		}

		int[] bestDiceMoves = new int[A.length + B.length];
		for (int i = 0; i < A.length; i++) {

			bestDiceMoves[i] = benefitsFromA[i];

		}
		for (int i = 0; i < B.length; i++) {
			bestDiceMoves[A.length + i] = benefitsFromB[i];
		}

		java.util.Arrays.sort(bestDiceMoves);

		for (int i = 0; i < bestDiceMoves.length / 2; i++) {
			int temp = bestDiceMoves[i];
			bestDiceMoves[i] = bestDiceMoves[bestDiceMoves.length - 1 - i];
			bestDiceMoves[bestDiceMoves.length - 1 - i] = temp;
		}

		int totalBenefit = 0;
		int turns = 0;

		for (int i = 0; i < bestDiceMoves.length; i++) {
			if (totalBenefit >= target) {
				break;
			}
			totalBenefit += bestDiceMoves[i];
			turns++;
		}

		if (totalBenefit >= target) {
			return turns;
		} else {
			return -1;
		}
	}

}

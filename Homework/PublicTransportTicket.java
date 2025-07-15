package Map;

import java.util.HashMap;

public class PublicTransportTicket {
	public static void main(String[] args) {
		
		int[] arr1 = { 1, 2, 4, 5, 7, 29, 30 };
		int[] arr2 = { 1, 2, 3, 4, 20, 21, 22, 23 };
		int[] arr3 = { 1, 3, 5, 7, 8, 9, 10, 11, 12, 13 };
		int[] arr4 = { 1, 2, 3, 4, 5, 6, 7 };
		int[] arr5 = { 1, 30 };

		System.out.println("Minimum money:" + Solution(arr1));
		System.out.println("Minimum money:" + Solution(arr2));
		System.out.println("Minimum money:" + Solution(arr3));
		System.out.println("Minimum money:" + Solution(arr4));
		System.out.println("Minimum money:" + Solution(arr5));

	}

	public static int Solution(int[] A) {
		int n = A.length;
		if (n == 0)
			return 0;

		int[] minSpend = new int[n + 1];
		minSpend[n] = 0;

		for (int i = n - 1; i >= 0; i--) {
			int currentDay = A[i];

			// 1-day ticket
			int cost1Day = minSpend[i + 1] + 2;
			int index7 = i;

			while (index7 < n && A[index7] < currentDay + 7) {
				index7++;
			}

			// 7-day ticket
			int cost7Day = minSpend[index7] + 7;
			int index30 = i;

			while (index30 < n && A[index30] < currentDay + 30) {
				index30++;
			}

			// 30-day ticket
			int cost30Day = minSpend[index30] + 25;
			minSpend[i] = Math.min(cost1Day, Math.min(cost7Day, cost30Day));
		}

		return minSpend[0];
	}

}

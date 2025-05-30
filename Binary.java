package HW;

public class Binary {

	public static void main(String[] args) {
		Binary binary = new Binary();

		// Test case 1
		System.out.println("N = 9, Binary = " + binary.showBinary(9) + ", with max gap = " + binary.solution(9));

		// Test case 2
		System.out.println("N = 529, Binary = " + binary.showBinary(529) + ", with max gap = " + binary.solution(529));

		// Test case 3
		System.out.println("N = 20, Binary = " + binary.showBinary(20) + ", with max gap = " + binary.solution(20));

		// Test case 4
		System.out.println("N = 15, Binary = " + binary.showBinary(15) + ",with max gap = " + binary.solution(15));

		// Test case 5
		System.out.println("N = 32, Binary = " + binary.showBinary(32) + ", with max gap = " + binary.solution(32));

		// Test case 6
		System.out.println("N = 1041, Binary = " + binary.showBinary(1041) + ", with max gap = " + binary.solution(1041));
	}

	public int solution(int N) {
		int longestGap = 0;
		int currentGap = 0;
		boolean foundFirstOne = false;

		while (N > 0) {
			int bit = N % 2;
			N = N / 2;

			if (bit == 1) {
				if (foundFirstOne && currentGap > longestGap) {
					longestGap = currentGap;
				}
				foundFirstOne = true;
				currentGap = 0;
			}

			if (bit == 0 && foundFirstOne) {
				currentGap++;
			}
		}

		return longestGap;
	}

	public String showBinary(int N) {
		if (N == 0)
			return "0";

		String binary = "";
		int temp = N;
		while (temp > 0) {
			binary = (temp % 2) + binary;
			temp = temp / 2;
		}
		return binary;
	}

}
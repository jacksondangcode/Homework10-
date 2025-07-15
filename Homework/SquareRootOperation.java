package Map;

public class SquareRootOperation {

	public static void main(String[] args) {
		int result1 = solution(10, 20);
		int result2 = solution(6000, 7000);
		int result3 = solution(20, 1000);

		System.out.println("Result of (10 -> 20) = " + result1);
		System.out.println("Result of (6000 -> 7000) = " + result2);
		System.out.println("Result of (20 -> 1000) = " + result3);
	}

	public static int solution(int A, int B) {
		
		int maxOperation = 0;
		for (int num = A; num <= B; num++) {
			int operation = countSquareRootOperations(num);
			maxOperation = Math.max(maxOperation, operation);
		}

		return maxOperation;
	}

	public static int countSquareRootOperations(int num) {
		int count = 0;
		while (true) {

			double sqrt = Math.sqrt(num);
			if (sqrt == (int) sqrt) {
				num = (int) sqrt;
				count++;
			} else {
				break;
			}
		}

		return count;
	}

	public static boolean checkSquareRoot(int num) {
		int sqrt = (int) Math.sqrt(num);
		return sqrt * sqrt == num;
	}

}

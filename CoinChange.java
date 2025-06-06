package HW;

import java.util.Scanner;

public class CoinChange {

	public static int changeMoney(int money) {
		int[] value = { 500, 200, 100, 50, 20, 10, 5, 2, 1 };
		int result = 0;
		int index = 0;

		do {
			if (index >= value.length)
				break;

			int coin = value[index];
			if (money >= coin) {
				int count = money / coin;
				result += count;
				money = money - (count * coin);
			}
			index++;
			
		} while (money > 0);

		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("COIN CHANGE SOLUTION");
		System.out.println("======================");
		System.out.println("Available values: 500, 200, 100, 50, 20, 10, 5, 2, 1");
		System.out.println();

		while (true) {
			System.out.print("Enter the amount of money: ");
			int amount = scanner.nextInt();

			if (amount == 0) {
				System.out.println("Thank you for using Coin Change!");
				break;
			}

			if (amount < 0) {
				System.out.println("Please enter a positive number!");
				continue;
			}

			int result = changeMoney(amount);
			System.out.printf("Amount: %d -> Minimum bills needed: %d\n", amount, result);
			System.out.println();
		}

		scanner.close();
	}
}

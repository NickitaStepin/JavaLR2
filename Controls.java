import java.util.Locale;
import java.util.Scanner;

public class Controls {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

		// Цикл for: вывод 1..10 и суммирование
		int sum = 0;
		System.out.println("--- for: числа 1..10 ---");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			sum += i;
		}
		System.out.println("Сумма чисел 1..10: " + sum);

		// Цикл while: читаем строки пока не 'exit'
		System.out.println("--- Введите строки (для выхода введите 'exit') ---");
		int linesCount = 0;
		while (true) {
			String line = scanner.nextLine();
			if ("exit".equalsIgnoreCase(line.trim())) {
				break;
			}
			linesCount++;
		}
		System.out.println("Количество введённых строк (без 'exit'): " + linesCount);

		scanner.close();
	}
}



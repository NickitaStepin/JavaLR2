import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Введите целое число для вычисления факториала: ");
		long n;
		try {
			n = readLong(scanner);
		} catch (InputMismatchException ex) {
			System.out.println("Ошибка: ожидалось целое число. Завершение.");
			scanner.close();
			return;
		}

		if (n < 0) {
			System.out.println("Ошибка: факториал определён только для неотрицательных чисел.");
			scanner.close();
			return;
		}

		// Вычисление факториала. Для больших n может произойти переполнение long
		// Здесь мы оставляем простую реализацию и фиксируем возможное переполнение по условию задачи.
		long fact = 1L; // по определению 0! = 1
		for (long i = 2; i <= n; i++) {
			fact *= i;
		}

		try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("factorial.txt"), StandardCharsets.UTF_8))) {
			writer.println("Факториал числа " + n + " равен: " + fact);
			System.out.println("Результат записан в файл factorial.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Не удалось записать файл factorial.txt");
			e.printStackTrace();
		}

		scanner.close();
	}

	private static long readLong(Scanner scanner) {
		if (scanner.hasNextLong()) {
			return scanner.nextLong();
		}
		throw new InputMismatchException("Ожидалось целое число");
	}
}



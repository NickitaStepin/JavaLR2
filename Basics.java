import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Basics {
	public static void main(String[] args) {
		// Ensure Scanner parses dot as decimal separator regardless of OS locale
		Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

		// 1) Basic typed variables
		int age = 22;               // возраст
		double height = 1.78;        // рост (метры)
		String name = "Ivan";       // имя
		boolean isStudent = true;    // статус студента

		System.out.println("--- Переменные ---");
		System.out.println("Имя: " + name);
		System.out.println("Возраст: " + age);
		System.out.println("Рост: " + height);
		System.out.println("Студент: " + isStudent);

		// 2) Арифметика над int и double
		int intA = age;      // используем объявленные переменные
		int intB = 5;
		double doubleA = height; // метры
		double doubleB = 0.22;   // метры

		int intSum = intA + intB;
		int intDiff = intA - intB;
		int intProd = intA * intB;
		double intQuot = (double) intA / intB; // вещественное деление

		double doubleSum = doubleA + doubleB;
		double doubleDiff = doubleA - doubleB;
		double doubleProd = doubleA * doubleB;
		double doubleQuot = doubleA / doubleB; // double деление

		System.out.println("--- Арифметика (int) ---");
		System.out.println("sum: " + intSum);
		System.out.println("diff: " + intDiff);
		System.out.println("prod: " + intProd);
		System.out.println("quot: " + intQuot);

		System.out.println("--- Арифметика (double) ---");
		System.out.println("sum: " + doubleSum);
		System.out.println("diff: " + doubleDiff);
		System.out.println("prod: " + doubleProd);
		System.out.println("quot: " + doubleQuot);

		// 3) Работа со строками
		String firstName = name;
		String lastName = "Petrov";
		String fullName = firstName + " " + lastName; // конкатенация
		int fullNameLength = fullName.length();
		boolean eqCaseSensitive = "Java".equals("java");
		boolean eqIgnoreCase = "Java".equalsIgnoreCase("java");

		System.out.println("--- Строки ---");
		System.out.println("Полное имя: " + fullName);
		System.out.println("Длина полного имени: " + fullNameLength);
		System.out.println("equals (\"Java\", \"java\"): " + eqCaseSensitive);
		System.out.println("equalsIgnoreCase (\"Java\", \"java\"): " + eqIgnoreCase);

		// 5) Побитовые операции
		int p = 109;
		int q = 17;
		int binSum = p + q;
		System.out.println("--- Побитовые и двоичное представление ---");
		System.out.println("109 в двоичном: " + Integer.toBinaryString(p));
		System.out.println("17 в двоичном:  " + Integer.toBinaryString(q));
		System.out.println("Сумма 109+17 в двоичном: " + Integer.toBinaryString(binSum));

		int twoDigit = 42;
		int inverted = ~twoDigit; // побитовое НЕ
		long pow3 = (long) twoDigit * twoDigit * twoDigit; // 3 степень
		System.out.println("Число: " + twoDigit + ", ~число: " + inverted + ", число^3: " + pow3);

		// 4) Ввод двух чисел и запись результатов в файл basics_output.txt
		System.out.println("--- Ввод чисел и запись результатов в basics_output.txt ---");
		System.out.print("Введите первое число (int или double): ");
		double a;
		double b;
		try {
			a = readNumberAsDouble(scanner);
			System.out.print("Введите второе число (int или double): ");
			b = readNumberAsDouble(scanner);
		} catch (InputMismatchException ex) {
			System.out.println("Ошибка: некорректный формат числа. Завершение.");
			return;
		}

		double sum = a + b;
		double diff = a - b;
		double prod = a * b;
		String div;
		if (b == 0.0) {
			div = "деление на ноль не определено";
		} else {
			div = String.valueOf(a / b);
		}

		try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("basics_output.txt"), StandardCharsets.UTF_8))) {
			writer.println("Результат сложения: " + sum);
			writer.println("Результат вычитания: " + diff);
			writer.println("Результат умножения: " + prod);
			writer.println("Результат деления: " + div);
			System.out.println("Результаты записаны в файл basics_output.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Не удалось записать файл basics_output.txt");
			e.printStackTrace();
		}

		scanner.close();
	}

	private static double readNumberAsDouble(Scanner scanner) {
		// Пытаемся прочитать число как double, допускаем целые значения
		if (scanner.hasNextDouble()) {
			return scanner.nextDouble();
		}
		throw new InputMismatchException("Ожидалось число формата int/double");
	}
}



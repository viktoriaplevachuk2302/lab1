import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *Клас для чисел Фібоначчі з методами для перевірки на трикутність.
 */
class FibonacciNumber {
    private int index;
    private int value;

    /*
     * Конструктор класу, що створює число Фібоначчі за індексом. @param index індекс числа Фібоначчі.
     */
    public FibonacciNumber(int index) {
        this.index = index;
        this.value = calculateFibonacci(index);
    }

    /*
     * Метод для обчислення числа Фібоначчі за індексом.
     */
    private int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }

    /*
     *Метод для перевірки, чи є число трикутним.
     */

    public boolean isTriangular() {
        int sum = 0;
        for (int i = 1; sum <= value; i++) {
            sum += i;
            if (sum == value) {
                return true;
            }
        }
        return false;
    }

    /*
     * Метод для отримання значення числа Фібоначчі.
     */
    public int getValue() {
        return value;
    }

    /*
     * Метод для отримання індексу числа Фібоначчі.
     */
    public int getIndex() {
        return index;
    }

    /*
     *Перевизначений метод для виведення інформації про число.
     */
    @Override
    public String toString() {
        return "Fibonacci Number [index=" + index + ", value=" + value + "]";
    }
}


    public class Main {
        /*
         * Головна функція для виконання програми.
         */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть кількість чисел Фібоначчі для аналізу: ");
            int M = scanner.nextInt();

            /*
             * Масив об'єктів класу FibonacciNumber.
             */
            List<FibonacciNumber> fibonacciNumbers = new ArrayList<>();
            int sumOfSquares = 0; // Змінна для суми квадратів чисел Фібоначчі

            /*
             * Створюємо об'єкти класу FibonacciNumber і перевіряємо, які з них трикутні.
             */
            for (int i = 1; i <= M; i++) {
                FibonacciNumber fib = new FibonacciNumber(i);
                fibonacciNumbers.add(fib);
                System.out.println(fib);

                sumOfSquares += Math.pow(fib.getValue(), 2);

                if (fib.isTriangular()) {
                    System.out.println("Число Фібоначчі " + fib.getValue() + " є трикутним числом.");
                } else {
                    System.out.println("Число Фібоначчі " + fib.getValue() + " не є трикутним числом.");
                }
            }
            System.out.println("Сума квадратів чисел Фібоначчі: " + sumOfSquares);

            scanner.close();
        }
    }



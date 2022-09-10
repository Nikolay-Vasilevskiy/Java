//Домашнее задание № 2 Написать программу вычисления n-ого треугольного числа
import java.util.Scanner;

public class Treugolnik { public static void main(String[] args) {  

        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число n, для вычисления n-ого треугольного числа:");

        int n = iScanner.nextInt();

        if (n < 0) {
            System.out.println("Для отрицательных чисел треугольное число посчитать не получится.");
        } else {
            System.out.println("Для n = " + n + " треугольное число = " + triangularNumber(n));
        }
    }

    public static int triangularNumber(int n) {
        int result =   (n * (n + 1)) / 2;        
        
        return (result);
    }
}

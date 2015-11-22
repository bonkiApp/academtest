/**
 * Created by Администратор on 16.11.15.
 * 3.	Решите квадратное уравнение вида ax2 + bx + c = 0.
 Коэффициенты прочитать с консоли. Учесть, что a и b могут быть равны 0
 */
import java.util.Scanner;
import java.lang.Math;

public class AcademTest3 {
    public static void main(String[] args) {
        System.out.println("Введите три числовых коэффициента уравнения, через пробел или в новой строке консоли");
        Scanner in = new Scanner(System.in);
        try {
            Double a = in.nextDouble();
            Double b = in.nextDouble();
            Double c = in.nextDouble();
            Double x1;
            Double x2;
            Double D;

            if (a == 0 && b == 0) {
                System.out.println("Уравнение не является квадратным и корней не имеет");
            } else if (a != 0) {
                D = b * b - 4 * a * c; //Формула дискириминанта

                if (D == 0) {
                    x1 = x2 = (-b) / (2 * a);
                    System.out.println("Уравнение имеет два одинаковых корня:");
                    System.out.println("x1 = " + x1);
                    System.out.println("x2 = " + x2);
                } else if (D > 0) {
                    x1 = (-b + Math.pow(D, 1 / 2)) / (2 * a);
                    x2 = (-b - Math.pow(D, 1 / 2)) / (2 * a);
                    System.out.println("Уравнение имеет два корня:");
                    System.out.println("x1 = " + x1);
                    System.out.println("x2 = " + x2);
                } else {
                    System.out.println("Уравнение имеет два мнимых корня:");
                    System.out.println("x1= (" + -b + "+i*" + Math.pow(D, 1 / 2) + ")" + "/" + (2 * a));
                    System.out.println("x2= (" + -b + "-i*" + Math.pow(D, 1 / 2) + ")" + "/" + (2 * a));
                }
            } else {
                x1 = -c / b;
                System.out.println("Уравнение не является квадратным т.к. а = 0\nx = " + x1);

            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("Вы ввели не число, а какую-то ерунду. Попробуйте заново.");
        }
    }
}


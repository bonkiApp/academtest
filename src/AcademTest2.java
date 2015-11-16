/**
 * Created by Администратор on 16.11.2015.
 * 2.	Посчитайте среднее арифметическое четных чисел от 10 до 100
 */
public class AcademTest2 {
    public static void main(String[] args) {

        int j=0;
        int sum=0;

        for (int i=10; i<=100; i+=2){
            sum+=i;
            j++;
        }
        System.out.println("Cреднее арифметическое четных чисел от 10 до 100: " + sum/j);
    }
}

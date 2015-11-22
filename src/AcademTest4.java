/**
 * Created by Администратор on 19.11.15.
 * 4.	Реализовать алгоритм бинарного поиска. Описание алгоритма найти в интернете.
 * Легенда для реализации примера:
 * В новом гипермаркете 36 касс, в день открытия некоторые из них не работают (хотя исправны),
 * у тех что работают скопились огромные очереди, да и во всем магазине очень много покупателей.
 * Одна из работавших касс сломалась, очередь негодует, и к кассе срочно вызвали штатного ремонтника
 * (вместо того чтобы открыть другую рабочую кассу). Из-за большого скопления покупателей в свой первый рабочий день
 * ремонтник не может сразу найти нужную кассу и пробиваясь сквозь толпу оказывается то у одной кассы, то у другой,
 * безсистемно и хаотично. Напишем алгоритм бинарного поиска, чтобы помочь бедолаге. По рации, он запросил у нас номер кассы,
 * сообщим ему номер с консоли. А в результате получим номер очереди в сломанную кассу, так будет проще сориентироваться.
 * Например, в 7ю кассу стоит 4я очередь слева.
 * (для эксперимента можно попробовать разные номера).
 */
import java.util.Arrays;
import java.util.Scanner;

public class AcademTest4 {
    public static void main(String[] args) {
        int[] ar = {23, 15, 1, 3, 18, 28, 4, 12, 36, 29, 10, 11, 27, 33, 30, 7, 21, 26}; // номера работавших касс в хаотичном порядке
        Arrays.sort(ar);

        System.out.println("Хьюстон, у меня проблема! Сообщите номер сломавшейся кассы, а то я забыл...");

        Scanner in = new Scanner(System.in);
        try {
            long kassa = in.nextLong();
            if (kassa > 36 || kassa <= 0) {
                System.out.println("Сообщите правильный номер, он должен быть от 1 до 36!");
                return;
            }

            String str = in.nextLine();
            if (!str.isEmpty()) {
                System.out.println("Я услышал только первое число "+ kassa +", всё остальное лишнее.");
            }

                if (kassa == ar[0]) {
                    System.out.println("Касса №" + kassa + " найдена! Это первая очередь слева. Спасибо! :)");
                    return;
                }
                if (kassa == ar[ar.length - 1]) {
                    System.out.println("Касса №" + kassa + " найдена! Это последняя очередь слева. Спасибо! :)");
                    return;
                }

                if (searchKas(kassa, ar) > 0) {
                    System.out.println("Касса №" + kassa + " найдена! Это " + searchKas(kassa, ar) + " очередь слева. Спасибо! :)");
                } else {
                    System.out.println("Это не та касса, тут нет очереди, а значит эта касса и не работала. Сообщите другой номер.");
                }

        } catch (java.util.InputMismatchException e) {
            System.out.println("Что за шутки? Я знаю что номер кассы болжен быть двузначным целым числом от 1 до 36! Повторите номер кассы!");
        }
        return;
    }

    public static int searchKas(long kassa, int[] ar) {
        return searchKas(kassa, ar, 0, ar.length - 1);
    }


    private static int searchKas(long kassa, int[] ar, int first, int last) {
        try {
            int middle = first + (last - first) / 2;
            if (kassa > ar[middle]) {
                return searchKas(kassa, ar, middle, last);
            } else if (kassa < ar[middle]) {
                return searchKas(kassa, ar, first, middle);
            } else {
                return middle + 1;
            }
        } catch (java.lang.StackOverflowError e) {
          return -1;
        }
    }
}




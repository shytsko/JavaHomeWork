//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

package HomeWork3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество элементов списка: ");
        int count = input.nextInt();
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++)
            list.add(rnd.nextInt(100));
        System.out.println(list);

        int min = list.get(0);
        int max = list.get(0);
        double avg = 0;
        for (int item: list) {
            if(item < min)
                min = item;
            if(item>max)
                max = item;
            avg+=item;
        }
        avg /= list.size();

        System.out.printf("Минимальное значение: %d\n", min);
        System.out.printf("Максимальное значение: %d\n", max);
        System.out.printf("Среднее значение: %f\n", avg);
    }
}

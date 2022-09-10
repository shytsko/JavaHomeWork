//Пусть дан произвольный список целых чисел, удалить из него четные числа

package HomeWork3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество элементов списка: ");
        int count = input.nextInt();
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++)
            list.add(rnd.nextInt(100));
        System.out.println(list);
        int index = 0;
        while (index < list.size())
            if(list.get(index) % 2 == 0)
                list.remove(index);
            else
                index++;
        System.out.println(list);
    }
}

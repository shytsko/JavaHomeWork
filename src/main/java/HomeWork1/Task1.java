// Задан массив, например, nums = [1,7,3,6,5,6]. Написать программу, которая найдет индекс i
// для этого массива такой, что сумма элементов с индексами < i равна сумме элементов
// с индексами > i.

package HomeWork1;

public class Task1 {
    public static void main(String[] args) {
        int[] array = {1,7,3,6,5,6};
        System.out.println(FindSimetricSumIndex(array));
    }

    public static int FindSimetricSumIndex(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 1; i < array.length; i++) {
            sumRight+=array[i];
        }
        for (int i = 1; i < array.length; i++) {
            sumLeft += array[i-1];
            sumRight -= array[i];
            if(sumLeft==sumRight)
                return i;
            if(sumLeft>sumRight)
                return -1;
        }
        return -1;
    }
}

//Напишите функцию, для поиска наиболее длинного общего префикса, среди массива строк.
// Если общего префикса нет, то возвращать пустую строку.
// Пример ["aabb", "aabbb", "aaabb"] - ответ "aa"
package HomeWork1;

public class Task2 {
    public static void main(String[] args) {
        String[] testArray = {"aabggfgb", "aabbb", "aabb"};
        System.out.println(String.format("Prefix: %s", GetPrefix((testArray))));
    }

    public static String GetPrefix(String[] array) {
        int minLength = array[0].length();
        for (String item: array)
            if(item.length() < minLength)
                minLength = item.length();

        StringBuilder prefix = new StringBuilder("");
        for (int i = 0; i < minLength; i++) {
            char nextChar = array[0].charAt(i);
            for (int j = 1; j < array.length; j++) {
                if(array[j].charAt(i) != nextChar)
                    return prefix.toString();
            }
            prefix.append(nextChar);
        }
        return prefix.toString();
    }

}

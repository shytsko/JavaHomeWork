// Пусть дан список сотрудников
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

package HomeWork5;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class EmployeeNameCounter {

    public static void main(String[] args) {
        Map<String, Integer> employeeNameCount = new HashMap<>();
        List<String> employeeNames;
        try {
            employeeNames = Files.readAllLines(Path.of("employee_list.txt"));
        }
        catch (Exception ex) {
            System.out.println("Не удалось прочитать файл.");
            System.out.println(ex.getMessage());
            return;
        }

        for (String name: employeeNames) {
            String firstName = name.split(" ")[0];
            if(employeeNameCount.containsKey(firstName))
                employeeNameCount.put(firstName, employeeNameCount.get(firstName)+1);
            else
                employeeNameCount.put(firstName, 1);
        }
        System.out.println(employeeNameCount);

        List<Map.Entry<String, Integer>> nameCount = new ArrayList<>(employeeNameCount.entrySet());
        nameCount.removeIf(entry -> entry.getValue() < 2);
        nameCount.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.printf("Повторяющиеся имена: %s", nameCount);
    }
}

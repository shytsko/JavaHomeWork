// Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

package HomeWork2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Task3 {
    public static void main(String[] args) {
        String jsonData = null;
        try (BufferedReader  reader = new BufferedReader(new FileReader(new File("Task3.json")))) {
            jsonData = reader.readLine();
            System.out.println(String.join("\n", ParseJson(jsonData)));
        }
        catch (Exception ex) {
            System.out.println("Не удалось прочитать файл.");
            System.out.println(ex.getMessage());
        }
    }

    public static String[] ParseJson(String jsonData){
        String[] sourceData = jsonData
                .substring(2, jsonData.length()-2)
                .split("},\\{");
        String[] parsedData = new String[sourceData.length];
        for (int i = 0; i < sourceData.length; i++) {
            String[] keyValue = sourceData[i].split(",");
            parsedData[i] = new StringBuilder("Студент ")
                    .append(GetValue(keyValue[0]))
                    .append(" получил ")
                    .append(GetValue(keyValue[1]))
                    .append(" по предмету ")
                    .append(GetValue(keyValue[2]))
                    .toString();
        }
        return parsedData;
    }

    public static String GetValue(String keyValue) {
        String value =  keyValue.split(":")[1];
        return value.substring(1,value.length()-1);
    }
}

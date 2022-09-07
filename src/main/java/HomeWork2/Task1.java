// 1. Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль
// результат вида:
// 1 Расширение файла: txt
// 2 Расширение файла: pdf
// 3 Расширение файла:
// 4 Расширение файла: jpg

package HomeWork2;

import java.io.File;

public class Task1 {
    public static void main(String[] args) {
        File directory = new File(".");
        System.out.println(String.format("Текущий каталог: %s", directory.getAbsolutePath()));
        File[] files = directory.listFiles();
        int count =0;
        for (File file: files)
            if(file.isFile())
                System.out.println(String.format("%d Расширение файла: %s", ++count, GetFileExtension(file)));
    }

    public static String GetFileExtension(File file) {
        String fileName = file.getName();
        int dotPosition = fileName.lastIndexOf('.');
        if(dotPosition != -1 && dotPosition != 0)
            return fileName.substring(dotPosition+1);
        else
            return "";
    }
}

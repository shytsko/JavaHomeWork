// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

package HomeWork5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PhoneBook {
    private Map<String, Map<String, LinkedList<String>>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Map<String, LinkedList<String>>> item: phoneBook.entrySet()) {
            sb.append(item.getKey())
              .append(":\n");
            for (Map.Entry<String, LinkedList<String>> phoneType: item.getValue().entrySet()) {
                sb.append("\t")
                  .append(phoneType.getKey())
                  .append(": ")
                  .append(phoneType.getValue().toString())
                  .append("\n");
            }
        }
        return sb.toString();
    }

    public void addItem(String name, String phoneType, String phoneNumber) {
        Map<String, LinkedList<String>> item;
        if(this.phoneBook.containsKey(name))
            item = this.phoneBook.get(name);
        else {
            item = new HashMap<>();
            phoneBook.put(name, item);
        }

        if(!item.containsKey(phoneType))
            item.put(phoneType, new LinkedList<>());
        item.get(phoneType).add(phoneNumber);
    }

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        System.out.println(book);
        book.addItem("Василий", "Рабочий", "1235466");
        book.addItem("Василий", "Мобильный", "5547855");
        book.addItem("Иванов", "Домашний", "9854544");
        book.addItem("Иванов", "Рабочий", "64658966");
        book.addItem("Василий", "Мобильный", "745696565");
        book.addItem("Пупкин", "Мобильный", "45454");
        book.addItem("Пупкин", "Секретный", "46544879894");
        book.addItem("Пупкин", "Мобильный", "3148554785");
        book.addItem("Пупкин", "Рабочий", "67781565");
        System.out.println(book);
    }
}

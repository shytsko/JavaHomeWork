// Реализовать стэк с помощью массива. Нужно реализовать методы: size(), empty(), push(), peek(), pop().
// Добавить проверку граничных условий и выводить сообщения об ошибках, если мы пытаемся извлечь элемент
// из пустого стека, добавить элемент в полностью заполненный стек и тд

package HomeWork4;

import java.util.Objects;

public class Stack<T> {
    private T[] data;
    private int counter;

    public Stack(int len) {
        this.data = (T[]) new Object[len];
        counter = 0;
    }

    public int size()
    {
        return counter;
    }

    public boolean empty()
    {
        return size() == 0;
    }

    public boolean push(T item)
    {
        if(counter < data.length) {
            this.data[counter++] = item;
            return true;
        }
        else {
            return false;
        }

    }

    public T peek()
    {
        if(counter > 0) {
            return this.data[counter-1];
        }
        else {
            return null;
        }
    }

    public T pop()
    {
        if(counter > 0) {
            return this.data[--counter];
        }
        else {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i=this.counter-1; i>=0; i--)
        {
            sb.append(data[i].toString());
            if(i>0)
                sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack<String> st = new Stack<>(10);
        int i = 1;
        while(st.push("string"+(i++)));
        System.out.println(st);
        if(st.push("string"+(i++)))
            System.out.printf("Элемент %s добавлен в стек\n", st.peek());
        else
            System.out.println("Стек переполнен");

        System.out.println(st.size());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.size());
        System.out.println(st.pop());
        System.out.println(st);

        while(!st.empty())
            System.out.println(st.pop());

        System.out.println(st);
        String str = st.pop();
        System.out.println(Objects.requireNonNullElse(str, "Стек пуст"));
    }
}

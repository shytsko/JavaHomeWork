// Написать реализацию очереди на основе массива; Реализовать методы size(), empty(), offer(), poll(), peek()

package HomeWork4;

public class Queue <T> {
    private T[] data;
    private int head;
    private int tail;

    public Queue(int len) {
        this.data = (T[]) new Object[len];
        this.head = -1;
        this.tail = -1;
    }

    public int size() {
        if (this.empty())
            return 0;
        if (this.head >= this.tail)
            return this.head-this.tail+1;
        return this.data.length-this.tail+this.head+1;
    }


    public boolean empty() {
        return this.head == -1;
    }

    public boolean offer(T item) {
        if(this.empty()) {
            this.head = 0;
            data[this.head] = item;
            this.tail = this.head;
            return true;
        }
        int offerIndex = (this.head+1) % this.data.length;
        if(offerIndex!=this.tail) {
            this.head = offerIndex;
            data[this.head] = item;
            return true;
        }
        else
            return false;
    }

    public T poll() {
        if(this.empty()) {
            return null;
        }
        T item=this.data[tail];
        if(this.tail==this.head) {
            this.tail=-1;
            this.head=-1;
        }
        else
            this.tail = (this.tail+1) % this.data.length;
        return item;
    }

    public T peek() {
        return (this.empty()) ? null : this.data[tail];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if(!this.empty()){
            for(int i=this.tail; i != head; i=(i+1)%this.data.length) {
                sb.append(this.data[i].toString());
                sb.append(", ");
            }
            sb.append(this.data[this.head].toString());
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(10);
        System.out.println(queue);
        System.out.printf("size=%d\n", queue.size());
        int item = 0;
        queue.offer(++item);
        queue.offer(++item);
        queue.offer(++item);
        queue.offer(++item);
        queue.offer(++item);
        queue.offer(++item);;
        queue.offer(++item);
        System.out.println(queue);
        System.out.printf("size=%d\n", queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.printf("size=%d\n", queue.size());
        queue.offer(++item);
        queue.offer(++item);
        queue.offer(++item);;
        queue.offer(++item);
        queue.offer(++item);
        System.out.println(queue);
        System.out.printf("size=%d\n", queue.size());
        queue.offer(++item);
        queue.offer(++item);
        queue.offer(++item);;
        queue.offer(++item);
        queue.offer(++item);
        System.out.println(queue);
        System.out.printf("size=%d\n", queue.size());

        while(!queue.empty())
            System.out.println(queue.poll());
        System.out.println(queue);
        System.out.printf("size=%d\n", queue.size());

    }
}

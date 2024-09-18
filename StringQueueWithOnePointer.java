import java.io.PrintStream;
import java.util.NoSuchElementException;


public class StringQueueWithOnePointer<T> implements StringQueue<T> {
    int size;
    Nodee last;

    StringQueueWithOnePointer(){
        this.size = 0;
        this.last = null;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(T item) {
        if (this.isEmpty()) {
            Nodee n = new Nodee(item);
            last = n;
            n.next = last;
        } else {
            Nodee n = new Nodee(item);
            n.next = last.next;
            last.next = n;
            last = n;
        }
        size++;
    }

    @Override
    public T get() throws NoSuchElementException {
        if (this.isEmpty()){
            return null;
        }else {
            Nodee tempHead = last.next;
            last.next = last.next.next;
            T result = (T) tempHead.data;
            size--;
            return result;
        }

    }

    @Override
    public T peek() throws NoSuchElementException {
        if (this.isEmpty()){
            return null;
        } else {
            T data = (T) last.next.data;
            return data;
        }
    }

    @Override
    public void printQueue(PrintStream stream) {
        if(this.isEmpty()){
            stream.println("Queue is empty");
        } else {
            Nodee temp = last.next;
            while (temp != last){
                stream.println(temp.data);
                temp = temp.next;
            }
            stream.println(temp.data);
        }
    }

    @Override
    public int size() {
        return size;
    }
}

class Nodee<T>{
    Nodee next;
    T data;

    Nodee(T data){
        this.data = data;
    }
}


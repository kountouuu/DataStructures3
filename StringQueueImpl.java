import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringQueueImpl<T> implements StringQueue{

    // Class Variables one for keeping the size and a front and back pointer
    private int queueSize;
    private Node front,rear;

    // Node class for our Queue
    private class Node{
        T data;
        Node next;
    }

    public StringQueueImpl(){
        front = rear = null;
        queueSize = 0;
    }

    @Override
    public boolean isEmpty() {
        // returns if Queue is empty
        return queueSize == 0;
    }

    @Override
    public void put(Object item) {
        // putting an element in the back of the queue
        if (rear != null){
            // if this element is the first element on the queue
            Node tmp = new Node();
            tmp.data = (T) item;
            rear.next = tmp;
            rear = rear.next;
            // point to itself
        } else {
            // else if not the only element add it to the back of the queue
            Node tmp = new Node();
            tmp.data = (T) item;
            rear = tmp;
            front = rear;
        }
        queueSize++; // increment the size of the queue
    }

    @Override
    public T get() throws NoSuchElementException {
        if (this.isEmpty()){
            // if queue is empty throw exception
            throw new NoSuchElementException("No Such Element");
        }
        // else grab the head item and point to the next one as the head
        T item = front.data;
        front = front.next;
        queueSize--;

        return item;
    }

    @Override
    public T peek() throws NoSuchElementException {
        if(this.isEmpty()){
            // if queue is empty return exception
            throw new NoSuchElementException("No Such Element exception .");
        } else {
            // else return the data of head
            return front.data;
        }
    }

    @Override
    public void printQueue(PrintStream stream) {
        // printing the queue
        if(this.isEmpty()){
            stream.println("Nothing to print queue is empty");
        } else {
            Node t = front;
            while (t.next != null){
                stream.println(t.data);
                t = t.next;
            }
        }
    }

    @Override
    public int size() {
        // returning the size of the Queue
        return queueSize;
    }
}

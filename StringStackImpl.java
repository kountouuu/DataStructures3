import java.io.PrintStream;
import java.util.NoSuchElementException;


public class StringStackImpl<T> implements StringStack{
    // Class Variables
    private Node top;
    private int stackSize;

    private class Node{
        // Private class Node for items in stack
        T data;
        Node link;
    }
    // Basic Constructor
    public StringStackImpl(){
        this.top = null;
    }

    public boolean isEmpty(){
        return stackSize == 0; // if the index points outside of the stack then it's empty
    }

    @Override
    public void push(Object item) {
        Node tmp = new Node();
        stackSize++;
        // If stack is not full then link the top node with new node and push onto stack
        tmp.data = (T) item;
        tmp.link = top;
        top = tmp;
    }


    public int size(){
        // returns the size
        return stackSize;
    }


    public T peek() throws NoSuchElementException{
        // returns the data of the top element if stack is not empty
        try {
            if (!this.isEmpty()) {
                return top.data;
            } else {
                System.out.println("Stack's empty.");
                return null;
            }
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }

    public void printStack(PrintStream stream){
        // prints stack
        if (this.isEmpty()){
            stream.println("Stack is empty , nothing to print.");
            return;
        } else {
            Node tmp = top;
            while (tmp != null){
                stream.println(tmp.data);
                tmp = tmp.link;

            }
        }
    }

    public T pop() throws NoSuchElementException{
        Node tmp = null;
        try{
            if(this.isEmpty()){
                System.out.println("Nothing to pop from the stack .");
                return (T) tmp;
            }else {
                // decrement the stack size , switch links of nodes and return top element
                stackSize--;
                tmp = top;
                top = top.link;
                return (T) tmp;
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return (T) tmp;
    }


}
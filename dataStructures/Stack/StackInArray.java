package dataStructures.Stack;


public class StackInArray<E> implements Stack<E> {

    // Default amount of elements the stack holds.
    public static final int DEFAULT_CAPACITY = 1000;

    // Memory of the stack: an array.
    protected E[] array;

    // Index of the element on top of the stack.
    protected int top;

    @SuppressWarnings("unchecked")
    public StackInArray( int capacity ) {
        array = (E[]) new Object[capacity];
        top = -1;
    }

    public StackInArray(){
        this(DEFAULT_CAPACITY);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isFull() {
        return this.size() == array.length;
    }

    public E top() throws EmptyStackException {
        if(this.isEmpty())
            throw new EmptyStackException();
        return array[top];
    }

    public void push(E element) throws FullStackException{
        if(this.isFull())
            throw new FullStackException();
        top++;
        array[top] = element;
    }

    public E pop() throws EmptyStackException {
        if(this.isEmpty())
            throw new EmptyStackException();
        E element = array[top];
        array[top] = null; // Garbage collection.
        top--;
        return element;
    }
}

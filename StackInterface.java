/*
 Creating my own interface for GreeneStack:
 */
package stackexcercise;

//The interface that GreeneStack implements:
public interface StackInterface<E> {
    
    public void push(E data);
    public E pop() throws GreeneEmptyStackException;
    public E peek() throws GreeneEmptyStackException;
    public boolean isEmpty();
}

/*
My own implemented Stack Class using an ArrayList. The following methods are 
supported:

push()
pop()
peek()
isEmpty()
toString()

*/

package stackexcercise;

//need to use arraylist
import java.util.ArrayList;

//My Stack Class:
public class GreeneStack<E> implements StackInterface<E> {
    
    //data field(s):
    private ArrayList<E> stack;
   
    //constructor(s):
    public GreeneStack() {
        stack = new ArrayList<>();
    }
    
    //method(s):
    
    //push
    @Override
    public void push(E data) {
        stack.add(data);
    }
    
    //pop
    @Override
    public E pop() throws GreeneEmptyStackException {
        
        if(stack.isEmpty()) {
            throw new GreeneEmptyStackException("Exception was thrown:");
        }
        
        return stack.remove(stack.size()-1);
    }
    
    //peek
    @Override
    public E peek() throws GreeneEmptyStackException {
        
        if(stack.isEmpty()) {
            throw new GreeneEmptyStackException("Exception was thrown:");
        }

        return stack.get(stack.size()-1);
    }
    
    //isEmpty
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    //toString
    @Override
    public String toString() {
        String theList = "";
        for(int i = 0; i < stack.size(); i++) {
            theList = theList + stack.get(i) + " ";
        }
        
        return theList;
    }
}

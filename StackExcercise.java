/*
Author: Joshua Greene
Date: 9/8/2020
Class: COSC2203:Data Structures: Section 1
Operating System: Windows 10
Java version: 13.0.2

Description: This lab had us create our own "Stack" using an ArrayList.
             We also made our own interface and Exception class.
*/


package stackexcercise;

//Tester class for GreeneStack:
public class StackExcercise {

    
    public static void main(String[] args) throws GreeneEmptyStackException {
       
        GreeneStack<String> myStack = new GreeneStack<>();
        
        //try-catch block to catch the exception that will be thrown by pop():
        try {
            myStack.pop();
        }
        catch(GreeneEmptyStackException ex) {
            System.out.println(ex.getMessage());
        }
        
        //returns "true":
        System.out.println(myStack.isEmpty());
        
        //adding A - E to myStack:
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");
        myStack.push("E");
        
        //"E" is erased and returned:
        System.out.println(myStack.pop());
        
        //prints myStack:
        System.out.println(myStack);
        
        //returns "D":
        System.out.println(myStack.peek());
        
        //prints myStack:
        System.out.println(myStack);
        
        //"D" is erased and returned:
        System.out.println(myStack.pop());
        
        //prints myStack:
        System.out.println(myStack);
        
        //prints "false":
        System.out.println(myStack.isEmpty());
        
    }
    
}

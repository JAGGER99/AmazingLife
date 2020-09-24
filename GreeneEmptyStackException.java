/*
Creating my own Exception class for GreeneStack with an overridden
getMessage() method:
*/
package stackexcercise;

//An exception potentially thrown in pop and peek methods of GreeneStack:
public class GreeneEmptyStackException extends Exception {
    
    //constructor:
    public GreeneEmptyStackException(String msg) {
     System.out.println(msg);
    }
    
    //methods:
    @Override
    public String getMessage() {
        String report = "The stack was empty!";
        return report;
    }
}

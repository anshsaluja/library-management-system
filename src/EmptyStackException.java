package src;
/**
 * An exception thrown in the <CODE>Library Manager</CODE> class to indicate that
 * stack is empty and no book can be returned in the Library.
 */
public class EmptyStackException extends Exception {
    /**
     * Default constructor for a Library Manager which passes default value to the class.
     * @custom.Postcondition:
     *    The object is created and contains the default message.
     */
    public EmptyStackException() {
        super("Stack is empty");
    }
}

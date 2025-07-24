package src;
/**
 * An exception thrown in the <CODE>Library Manager</CODE> class to indicate that
 * ISBN number of the book is invalid.
 */
public class InvalidISBNException extends Exception{
    /**
     * Default constructor for a Library Manager which passes default value to the class.
     * @custom.Postcondition:
     *    The object is created and contains the default message.
     */
    public InvalidISBNException(){
        super("ISBN is invalid");
    }
}

package src;
/**
 * An exception thrown in the <CODE>Library Manager</CODE> class to indicate that
 * Book does not exist in the Library.
 */

public class BookDoesNotExistException extends Exception {
    /**
     * Default constructor for a Library Manager which passes default value to the class.
     * @custom.Postcondition:
     *    The object is created and contains the default message.
     */
    public BookDoesNotExistException() {
        super("Book does not exist");
    }
}
	



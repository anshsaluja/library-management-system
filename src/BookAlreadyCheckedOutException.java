package src;
/**
 * An exception thrown in the <CODE>Library Manager</CODE> class to indicate that
 * Book already checkedOut in the Library.
 */

public class BookAlreadyCheckedOutException extends Exception{
    /**
     * Default constructor for a Library Manager which passes default value to the class.
     * @custom.Postcondition:
     *    The object is created and contains the default message.
     */
    public BookAlreadyCheckedOutException() {
        super("Book has already been checked out");
    }
}



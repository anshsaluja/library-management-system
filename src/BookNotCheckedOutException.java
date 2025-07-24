package src;
/**
 * An exception thrown in the <CODE>Library Manager</CODE> class to indicate that
 * Book is not checkedOut from the Library.
 */
public class BookNotCheckedOutException extends Exception{
    /**
     * Default constructor for a Library Manager which passes default value to the class.
     * @custom.Postcondition:
     *    The object is created and contains the default message.
     */
    public BookNotCheckedOutException(){
        super("Book not checked out");
    }
}

	


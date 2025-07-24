package src;
/**
 * An exception thrown in the <CODE>Library Manager</CODE> class to indicate that
 * Book already checkedOut by someone in the Library.
 */

public class BookCheckedOutBySomeoneElseException extends Exception{
    /**
     * Default constructor for a Library Manager which passes default value to the class.
     * @custom.Postcondition:
     *    The object is created and contains the default message.
     */
    public BookCheckedOutBySomeoneElseException(){
        super("Book is checked out by someone else ");
    }
}



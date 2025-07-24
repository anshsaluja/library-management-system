package src;
/**
 * An exception thrown in the <CODE>Library Manager</CODE> class to indicate that
 * Book already exists in the Library.
 */
public class BookAlreadyExistsException extends Exception{
    /**
     * Default constructor for a Library Manager which passes default value to the class.
     * @custom.Postcondition:
     *    The object is created and contains the default message.
     */
    public BookAlreadyExistsException(){
        super("Book already exists");
    }
}


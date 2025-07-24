package src;
/**
 * An exception thrown in the <CODE>Library Manager</CODE> class to indicate that
 * userID of the book is invalid.
 */
public class InvalidUserIDException extends Exception{
    /**
     * Default constructor for a Library Manager which passes default value to the class.
     * @custom.Postcondition:
     *    The object is created and contains the default message.
     */
    public InvalidUserIDException(){
        super("User ID is invalid");
    }
}

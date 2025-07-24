package src;
/**
 * An exception thrown in the <CODE>Library Manager</CODE> class to indicate that
 * return date of the book is invalid in the Library.
 */
public class InvalidReturnDateException extends Exception{
    /**
     * Default constructor for a Library Manager which passes default value to the class.
     * @custom.Postcondition:
     *    The object is created and contains the default message.
     */
    public InvalidReturnDateException(){
        super("Date is invalid");
    }
}
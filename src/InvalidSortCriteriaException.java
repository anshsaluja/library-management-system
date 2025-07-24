package src;
/**
 * An exception thrown in the <CODE>Library Manager</CODE> class to indicate that
 * sort criteria of the book is invalid.
 */
public class InvalidSortCriteriaException extends Exception{
    /**
     * Default constructor for a Library Manager which passes default value to the class.
     * @custom.Postcondition:
     *    The object is created and contains the default message.
     */
    public InvalidSortCriteriaException(){
        super("Sort type is invalid");
    }
}
package src;
/**
 * An abstract data type meant to serve as a representation of a
 * Return Log of the book, containing the ISBN, userID, returnDate, nextLog in the stack.
 * and methods to manipulate these values.
 */
public class ReturnLog{
    private long ISBN;//ISBN of the book
    private int userID;//UserID of the book
    private Date returnDate;// return Date of the book
    public ReturnLog nextLog;// nextLog in the stack
    /**
     * No-Arg constructor
     * @custom.Postcondtion
     *      This object has been initialized to a default Log with date set to as default.
     */
    public ReturnLog()  {
     }
    /**
     * Default constructor
     * @custom.Postcondtion
     *      This object has been initialized with a book with ISBN, uderID, returnDate, nextLog in the stack.
     */
    public ReturnLog(long ISBN, int userID ,Date returnDate, ReturnLog nextLog) {
        this.ISBN=ISBN;
        this.userID=userID;
        this.nextLog=nextLog;
        this.returnDate=returnDate;
    }

    /**
     * Public getter method for the ISBN member variable.
     * @return
     *      The ISBN of the Book.
     */
    public long getISBN() {
        return ISBN;
    }
    /**
     * Public setter method for the ISBN member variable.
     * @param ISBN
     *      The new ISBN of this book. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new ISBN of the book. This parameter should not have any digits or shall not be empty
     */
    public void setISBN(int ISBN) {
        this.ISBN=ISBN;
    }

    /**
     * Public getter method for the UserID member variable.
     * @return
     *      The UserID of the Book.
     */
    public int getUserID(){
        return userID;
    }
    /**
     * Public setter method for the userID member variable.
     * @param userID
     *      The new userID of this book. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new userID of the book. This parameter should not have any digits or shall not be empty
     */
    public void setUserID(int userID){
        this.userID=userID;
    }
    /**
     * Public getter method for the Date member variable.
     * @return
     *      The Date of the Book.
     */
    public Date getDate(){
        return returnDate;
    }
    /**
     * Public setter method for the ReturnDate member variable.
     * @param returnDate
     *      The new ReturnDate of this book. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new ReturnDate of the book. This parameter should not have any digits or shall not be empty
     */
    public void setReturnDate(Date returnDate){
        this.returnDate=returnDate;
    }
    /**
     * Public getter method for the nextLog member variable.
     * @return
     *      The nextLog of the stack.
     */
    public ReturnLog getNextLog(){
        return nextLog;
    }
    /**
     * Public setter method for the nextLog member variable.
     * @param nextLog
     *      The new nextLog of this book. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new nextLog of the book. This parameter should not have any digits or shall not be empty
     */
    public void setNextLog(ReturnLog nextLog) {
        this.nextLog=nextLog;
    }

}

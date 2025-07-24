package src;
/**
 * An abstract data type meant to serve as a representation of a
 * Return stack of the book, containing the returnLog.
 * and methods to manipulate these values.
 */
public class ReturnStack{
    BookRepository BP = LibraryManager.getBookRepository();
    private ReturnLog topLog;//topLog of the stack
    /**
     * No-Arg constructor
     * @custom.Postcondtion
     *      This object has been initialized to a default Log with date set to as default.
     */
    public ReturnStack()
    {
    }
    /**
     * Public getter method for the topLog member variable.
     * @return
     *      The topLog which is published.
     */
    public ReturnLog gettopLog() {
        return topLog;
    }
    /**
     * pushes the log to the return stack.
     * @param returnISBN, returnUserID, returnDate
     * 		Pushes the return Book to the return stack
     * @return
     *      boolean value whether the log is pushed or not
     * @throws
     *      InvalidISBNException if the given ISBN is invalid
     *      InvalidUserIDException if the given user ID is invalid
     *      InvalidReturnDateException if the given return Date is invalid
     *      BookNotCheckedOutException if the given book is not checked out
     *      BookCheckedOutBySomeoneElseException if the book is checked out by someone else
     */
    public boolean pushLog(long returnISBN, int returnUserID, Date returnDate) throws InvalidISBNException, InvalidUserIDException, InvalidReturnDateException, BookNotCheckedOutException, BookCheckedOutBySomeoneElseException{
        //invalid isbn
        if(String.valueOf(returnISBN).length()!=13){
            throw new InvalidISBNException();
        }

        //invalid date
        if(returnDate.getMonth()<0 || returnDate.getDay()<0 || returnDate.getYear()<0){
            throw new InvalidReturnDateException();
        }
        //invalid userid
        if(String.valueOf(returnUserID).length()!=10){ //to check the length of user ID
            throw new InvalidUserIDException();
        }
        Book b = BP.returnBook(returnISBN);
        if(b.getCheckOutUserID()!=returnUserID){
        throw new BookCheckedOutBySomeoneElseException();
        }
        if(b.getCheckedOut()==false){
            throw new BookNotCheckedOutException();
        }

        if(topLog==null) {
            topLog = new ReturnLog(returnISBN, returnUserID, returnDate, null);
        }
        else {
            ReturnLog temp = new ReturnLog(returnISBN, returnUserID, returnDate, null);
            temp.setNextLog(topLog);
            topLog = temp;
        }
        return true;
    }
    /**
     * pushes the log to the return stack.
     * @return
     *      returns the topLog of the shelf and removes from the stack
     * @throws
     *      EmptyStackException if the stack is empty
     */
    public ReturnLog popLog() throws EmptyStackException{
        //check if the stack is empty or not
        if(topLog == null) {
            throw new EmptyStackException();
        }
        ReturnLog temp = topLog;
        topLog = topLog.getNextLog();
        return temp;
    }
    /**
     * pushes the log to the return stack.
     * @return
     *      returns the topLog of the shelf
     * @throws
     *      EmptyStackException if the stack is empty
     *      InvalidISBNException if the ISBN is invalid
     *      InvalidUserIDException if the userID invalid
     *      InvalidReturnDateException if the return date is invalid
     *      BookNotCheckedOutException if the book is not checked out
     *      BookCheckedOutBySomeoneElseException if the book is checked out by someone else
     */
    public ReturnLog peekLog() throws EmptyStackException, InvalidISBNException, InvalidUserIDException, InvalidReturnDateException, BookNotCheckedOutException, BookCheckedOutBySomeoneElseException{
        if(topLog == null){ //if there is no top log
            throw new EmptyStackException();
        }
        ReturnLog temp = popLog();
        ReturnLog temp2 = temp;
        pushLog(temp.getISBN(), temp.getUserID(), temp.getDate());
        return temp2;
    }
    /**
     * pushes the log to the return stack.
     * @return
     *      returns string representation of the stack
     */
    //ToString Method
    public String toString() {
        ReturnLog temp;
        if(topLog == null){
            return null;
        }
        System.out.println("|\tISBN\t|\tUserID\t|\tReturnDate\t");
        System.out.println("===================================================================");
        temp = topLog;
        while(temp!=null){ //loop to print whole stack
            System.out.println("|\t"+temp.getISBN()+"\t|\t" + temp.getUserID()+"\t|\t"+temp.getDate().toString()+"\t");
            temp = temp.getNextLog();
        }
        return "";
    }
}

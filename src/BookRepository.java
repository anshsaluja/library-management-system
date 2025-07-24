package src;
/**
 * An abstract data type meant to serve as a representation of a
 * Book, containing the shelves
 * and methods to manipulate these values.
 */

public class BookRepository {
	 Shelf[] shelves = new Shelf[10];//different shelves in library initialized to size 10
	    /**
	     * No-Arg constructor
	     * @custom.Postcondtion
	     *      This object has been initialized to a default shelves.
	     */
	    public BookRepository() {
	        for(int i=0;i<shelves.length;i++){//it initializes the loop to make the implementation easy
	            shelves[i] = new Shelf();
	        }
	    }
	    /**
	     * checks in the book to the library.
	     * @param checkedInISBN, checkInUserID
	     * 		Book to be checked In with the given checkedInISBN, checkInUserID
	     */
	    public void checkInBook(long checkedInISBN, int checkInUserID){
	        char x = String.valueOf(checkedInISBN).charAt(0);
	        int y = Character.getNumericValue(x);
	        shelves[y].setCursorBook(shelves[y].getHeadBook());
	        while(shelves[y].getCursorBook()!=null){//loop to go through the loop
	            if(shelves[y].getCursorBook().getISBNNumber()==checkedInISBN){
	                   shelves[y].getCursorBook().setCheckOutUserID(checkInUserID);
	                   shelves[y].getCursorBook().setCheckedOut(false);
	                   break;
	            }
	            else {
	           shelves[y].setCursorBook(shelves[y].getCursorBook().getNextBook());
	            }
	        }
	    }
	    /**
	     * returns the book to the library.
	     * @param returnISBN
	     * 		Book to be returned with the given returnISBN
	     * @throws
	     *      BookNotCheckedOutException if the book is not checked out and is tried to be returned
	     */
	    public Book returnBook(long returnISBN) throws BookNotCheckedOutException, BookCheckedOutBySomeoneElseException, InvalidISBNException, InvalidUserIDException{
	    	//a method to make implementation easy
	        Book temp = null;
	        int count=0;
	        while(count<10){//loop to check through all the shelves
	            shelves[count].setCursorBook(shelves[count].getHeadBook());
	            while(shelves[count].getCursorBook()!=null){
	                if(shelves[count].getCursorBook().getISBNNumber()==returnISBN) {
	                temp=shelves[count].getCursorBook();
	                    break;
	                }
	                else{
	                    shelves[count].setCursorBook(shelves[count].getCursorBook().getNextBook());
	                }
	            }
	            count++;
	        }
	        if(temp==null){//if the book becomes null it means it has traversed through the loop
	            throw new BookNotCheckedOutException();
	        }
	        if(String.valueOf(returnISBN).length()!=13){
	            throw new InvalidISBNException();
	        }
	        else if(temp.getCheckedOut()==false){
	            throw new BookNotCheckedOutException();
	        }
	        else {
	            return temp;
	        }
	    }
	    /**
	     * returns the book to the library.
	     * @param BookDoesNotExistException
	     * 		Book is not there
	     * @throws
	     *      Book does exists in the shelf
	     */
	    public Book ReturnBook(long returnISBN) throws BookDoesNotExistException{
	        Book check=null;
	        for(int i=0;i<shelves.length;i++){//traverses the shelf
	            for(Book b = shelves[i].getHeadBook(); b!=null; b = b.getNextBook()){//book to travel in the shelf
	                if (returnISBN == b.getISBNNumber()) {
	                    check = b;
	                    break;
	                }
	            }
	        }
	        if(check==null){
	            throw new BookDoesNotExistException();
	        }
	        else{
	            return check;
	        }
	    }

	    /**
	     * checks out the book from the library.
	     * @param checkedOutISBN, checkOutUserID, checkOutDate
	     * 		Book to be checked out with the given checkedOutISBN, checkOutUserID,checkOutDate
	     * @throws
	     *      InvalidISBNException if the given ISBN is invalid
	     *      InvalidUserIDException if the given user ID is invalid
	     *      BookAlreadyCheckedOutException if the given checkOutISBN book is been checked out
	     */
	    public void checkOutBook(long checkedOutISBN, int checkOutUserID, Date checkOutDate) throws InvalidISBNException, InvalidUserIDException, BookAlreadyCheckedOutException{
	        char x = String.valueOf(checkedOutISBN).charAt(0);
	        int y = Character.getNumericValue(x);//to get the first digit of the ISBN Number and see where the book needs to be added
	        if(y<=0){//to check if the ISBN is valid or not
	            throw new InvalidISBNException();
	        }
	        if(String.valueOf(checkOutUserID).length()!=10) {
	            throw new InvalidUserIDException();
	        }
	        shelves[y].setCursorBook(shelves[y].getHeadBook());
	        while(shelves[y].getCursorBook()!=null){//loop to travel through the shelf
	            if(shelves[y].getCursorBook().getISBNNumber()==checkedOutISBN){
	                if(shelves[y].getCursorBook().getCheckedOut()==true){
	                    throw new BookAlreadyCheckedOutException();
	                }
	                else {
	                    shelves[y].getCursorBook().setCheckOutUserID(checkOutUserID);
	                    shelves[y].getCursorBook().setCheckedOut(true);
	                    shelves[y].getCursorBook().setCheckOutDate(checkOutDate);
	                    break;
	                }
	            }
	            else{
	                shelves[y].setCursorBook(shelves[y].getCursorBook().getNextBook());
	            }
	        }
	        if(shelves[y].getCursorBook()==null){//if book is not found the ISBN is invalid
	            throw new InvalidISBNException();
	        }
	        System.out.println(shelves[y].getCursorBook().getName() + " has been checked out by " + shelves[y].getCursorBook().getISBNNumber() + " and must be returned on " + shelves[y].getCursorBook().getCheckedOutDatetoString());
	    }
	    /**
	     * add the book to the library.
	     * @param addISBN, addName, addAuthor, addGenre, addCondition
	     * 		Book to be added with the given addISBN, , addName, addAuthor, addGenre, addCondition
	     * @throws
	     *      InvalidISBNException if the given ISBN is invalid
	     *      InvalidUserIDException if the given user ID is invalid
	     *      BookAlreadyCheckedOutException if the given checkOutISBN book is been checked out
	     */
	    public void addBook(long addISBN, String addName, String addAuthor, String addGenre, Condition addCondition) throws InvalidISBNException, BookAlreadyExistsException{
	        char x = String.valueOf(addISBN).charAt(0);
	        int y = Character.getNumericValue(x);//to get the first digit of the ISBN Number and see where the book needs to be added
	        if(y<0){
	            throw new InvalidISBNException();
	        }
	        shelves[y].setCursorBook(shelves[y].getHeadBook());
	        while(shelves[y].getCursorBook()!=null){//loop to check if the book is there or not
	            if(shelves[y].getCursorBook().getISBNNumber()==addISBN){
	                throw new BookAlreadyExistsException();
	            }
	            else{
	                shelves[y].setCursorBook(shelves[y].getCursorBook().getNextBook());
	            }
	        }
	        Book addedbook = new Book();
	        addedbook.setName(addName);
	        addedbook.setAuthor(addAuthor);
	        addedbook.setGenre(addGenre);
	        addedbook.setISBNNumber(addISBN);
	        addedbook.setBookCondition(addCondition);
	        shelves[y].addBook(addedbook);//adds the book to the shelf
	    }
	    /**
	     * removes the book from the library.
	     * @param removeISBN
	     * 		Book to be removed with the given removeISBN
	     * @throws
	     *      InvalidISBNException if the given ISBN is invalid
	     *      BookDoesNotExistException if the book does not exists in the shelf
	     */
	    public void removeBook(long removeISBN) throws InvalidISBNException, BookDoesNotExistException {
	        char x = String.valueOf(removeISBN).charAt(0);
	        int y = Character.getNumericValue(x);
	        if(y<0){//to get the first digit of the ISBN Number and see where the book needs to be added
	            throw new InvalidISBNException();
	        }
	        shelves[y].setCursorBook(shelves[y].getHeadBook());
	        while(shelves[y].getCursorBook()!=null){//traverse through the loop to remove the book with the given ISBN Number
	        
	            if(shelves[y].getCursorBook().getISBNNumber()==removeISBN){
	                shelves[y].removeBook(String.valueOf(removeISBN));
	                break;
	            }
	            else {
	                shelves[y].setCursorBook(shelves[y].getCursorBook().getNextBook());
	            }
	        }
	        if(shelves[y].getCursorBook()==null){//if the cursorBook become null it means that book does not exists and exception is thrown
	            throw new BookDoesNotExistException();
	        }
	    }
	    /**
	     * sorts the shelf of the library.
	     * @param shelfInd, sortCriteria
	     * 		shelf to be sorted
	     * @throws
	     *      InvalidSortCriteraException if the sort criteria is invalid
	     */
	    public void sortShelf(int shelfInd, String sortCriteria) throws InvalidSortCriteriaException, CloneNotSupportedException {
	        if(sortCriteria.equals("Name") || sortCriteria.equals("Author") || sortCriteria.equals("Genre") || sortCriteria.equals("ISBNNumber") || sortCriteria.equals("Year") || sortCriteria.equals("Condition")){//sorts the book according to the condition asked
	            if(sortCriteria.equals("Name")){
	                shelves[shelfInd].setCriteria(SortCriteria.Name);
	            }
	            else if (sortCriteria.equals("Author")){
	                shelves[shelfInd].setCriteria(SortCriteria.Author);
	            }
	            else if (sortCriteria.equals("Year")){
	                shelves[shelfInd].setCriteria(SortCriteria.Year);
	            }
	            else if (sortCriteria.equals("ISBNNumber")){
	                shelves[shelfInd].setCriteria(SortCriteria.ISBNNumber);
	            }
	            else if (sortCriteria.equals("Genre")){
	                shelves[shelfInd].setCriteria(SortCriteria.Genre);
	            }
	            else{
	                shelves[shelfInd].setCriteria(SortCriteria.Condition);
	            }
	            shelves[shelfInd].sort(shelves[shelfInd].getCriteria());
	            System.out.println("Shelf " + shelfInd + "has been sorted by " + shelves[shelfInd].getCriteria());
	        }
	        else {
	            throw new InvalidSortCriteriaException();//thrown id the criteria is invalid
	        }
	    }
	    public void print(int shelf) throws IllegalArgumentException{
	        if(shelf<0 || shelf>9){//invalid
	            throw new IllegalArgumentException();
	        }
	        else{
	            if(shelves[shelf].getLength()==0){
	                System.out.println("          ISBN               |" + "         Checked Out           |" + "             Checked Out Date               |" + "         Checked Out UserID");
	                System.out.println("=====================================================================================================================================================");
	            }else{
	                System.out.println("          "+shelves[shelf].getCriteria() +"               |" + "         Checked Out           |" + "             Checked Out Date               |" + "         Checked Out UserID");
	                System.out.println("=====================================================================================================================================================");
	                shelves[shelf].setCursorBook(shelves[shelf].getHeadBook());
	                while(shelves[shelf].getCursorBook()!=null){
	                    String yn = "";
	                    if(shelves[shelf].getCursorBook().getCheckedOut()==true){
	                        yn="Y";
	                    }
	                    else {
	                        yn = "N";
	                    }
	                    String change="";
	                    if(shelves[shelf].getCriteria()==SortCriteria.Name) {
	                    	change=shelves[shelf].getCursorBook().getName();
	                    }
	                    else if(shelves[shelf].getCriteria()==SortCriteria.ISBNNumber) {
	                    	change=String.valueOf(shelves[shelf].getCursorBook().getISBNNumber());
	                    }
	                    else if(shelves[shelf].getCriteria()==SortCriteria.Year) {
	                    	change=String.valueOf(shelves[shelf].getCursorBook().getYearPublished());
	                    }
	                    else if(shelves[shelf].getCriteria()==SortCriteria.Author) {
	                    	change=shelves[shelf].getCursorBook().getAuthor();
	                    }
	                    else if(shelves[shelf].getCriteria()==SortCriteria.Genre) {
	                    	change=shelves[shelf].getCursorBook().getGenre();
	                    }
	                    else {
	                    	change = String.valueOf(shelves[shelf].getCursorBook().getBookCondition());
	                    }
	                    if(shelves[shelf].getCursorBook().getCheckedOutDatetoString().equals("0/0/0")) {
	                        System.out.print("          " + change + "                       |" + "           " + yn + "                   |" + "        " + "N/A" + "                                 |" + "           " + shelves[shelf].getCursorBook().getCheckOutUserID());
	                        System.out.println();
	                    }
	                    else {
	                        System.out.print("          " + change + "                       |" + "           " + yn + "                    |" + "        " + shelves[shelf].getCursorBook().getCheckedOutDatetoString() + "                       |" + "           " + shelves[shelf].getCursorBook().getCheckOutUserID());
	                        System.out.println();
	                    }
	                    shelves[shelf].setCursorBook(shelves[shelf].getCursorBook().getNextBook());
	                }
	            }
	        }
	    }

}

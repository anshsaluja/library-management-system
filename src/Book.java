package src;
/**
 * An abstract data type meant to serve as a representation of a
 * Book, containing the name, author, year Published, genre, book condition, ISBN number
 * checkedOut, nextBook, checkOutUserID, checkOutDate
 * and methods to manipulate these values.
 */
public class Book {
	 private String name;//name of the Book
	    private String author;//author of the book
	    private int yearPublished;//year the book was published
	    private String genre;//genre of the book
	    private Condition bookCondition;//condition of the book
	    private long ISBNNumber;//ISBN number of the book
	    private boolean checkedOut;//to checkout the book
	    private Book nextBook;//book after the cursor
	    private int checkOutUserID;//userID of the book
	    private Date checkOutDate;//date the book was checked out
	    /**
	     * No-Arg constructor
	     * @custom.Postcondtion
	     *      This object has been initialized to a default book with date set to as default.
	     */
	    public Book() {
	        checkOutDate= new Date();
	    }
	    /**
	     * Default constructor
	     * @custom.Postcondtion
	     *      This object has been initialized with a book with name,author,yearPublished,genre,bookCondition,ISBNNumber,checkedOut,checkOutUserID,nextBook.
	     */
	    public Book(String name, String author, int yearPublished, String genre, Condition bookCondition, long ISBNNumber, boolean checkedOut, int checkOutUserID, Date checkOutDate, Book nextBook) {
	        this.name=name;
	        this.author=author;
	        this.yearPublished=yearPublished;
	        this.genre=genre;
	        this.bookCondition=bookCondition;
	        this.ISBNNumber=ISBNNumber;
	        this.checkedOut=checkedOut;
	        this.checkOutUserID=checkOutUserID;
	        this.checkOutDate=checkOutDate;
	        this.nextBook=nextBook;
	    }
	    /**
	     * Public getter method for the name member variable.
	     * @return
	     *      The name of the Book.
	     */
	    public String getName() {
	        return name;
	    }
	    /**
	     * Public setter method for the name member variable.
	     * @param name
	     *      The new name of this book. This parameter should have any digit or shall not be empty
	     * @custom.Precondition
	     *      The new name of the book. This parameter should not have any digits or shall not be empty
	     */
	    public void setName(String name) {
	        this.name = name;
	    }
	    /**
	     * Public getter method for the author member variable.
	     * @return
	     *      The author of the Book.
	     */
	    public String getAuthor() {
	        return author;
	    }
	    /**
	     * Public setter method for the author member variable.
	     * @param author
	     *      The new author of this book. This parameter should have any digit or shall not be empty
	     * @custom.Precondition
	     *      The new author of the book. This parameter should not have any digits or shall not be empty
	     */
	    public void setAuthor(String author) {
	        this.author = author;
	    }
	    /**
	     * Public getter method for the yearPublished member variable.
	     * @return
	     *      The year Book was published.
	     */
	    public int getYearPublished() {
	        return yearPublished;
	    }
	    /**
	     * Public setter method for the yearPublished member variable.
	     * @param yearPublished
	     *      The new yearPublished of this book. This parameter should have any digit or shall not be empty
	     * @custom.Precondition
	     *      The new yearPublished of the book. This parameter should not have any digits or shall not be empty
	     */
	    public void setYearPublished(int yearPublished) {
	        this.yearPublished = yearPublished;
	    }
	    /**
	     * Public getter method for the Genre member variable.
	     * @return
	     *      The genre of the book.
	     */
	    public String getGenre() {
	        return genre;
	    }
	    /**
	     * Public setter method for the Genre member variable.
	     * @param genre
	     *      The new Genre of this book. This parameter should have any digit or shall not be empty
	     * @custom.Precondition
	     *      The new Genre of the book. This parameter should not have any digits or shall not be empty
	     */
	    public void setGenre(String genre) {
	        this.genre = genre;
	    }
	    /**
	     * Public getter method for the bookCondition member variable.
	     * @return
	     *      The condition of the book.
	     */
	    public Condition getBookCondition() {
	        return bookCondition;
	    }
	    /**
	     * Public setter method for the bookCondition member variable.
	     * @param bookCondition
	     *      The new bookCondition of this book. This parameter should have any digit or shall not be empty
	     * @custom.Precondition
	     *      The new bookCondition of the book. This parameter should not have any digits or shall not be empty
	     */
	    public void setBookCondition(Condition bookCondition) {
	        this.bookCondition = bookCondition;
	    }
	    /**
	     * Public getter method for the ISBNNumber member variable.
	     * @return
	     *      TheISBNNumber of the book which is published.
	     */
	    public long getISBNNumber() {
	        return ISBNNumber;
	    }
	    /**
	     * Public setter method for the ISBNNumber member variable.
	     * @param ISBNNumber
	     *      The new ISBNNumber of this book. This parameter should have any digit or shall not be empty
	     * @custom.Precondition
	     *      The new ISBNNumber of the book. This parameter should not have any digits or shall not be empty
	     * @throws
	     *      InvalidISBNException if the ISBN is invalid
	     */
	    public void setISBNNumber(long ISBNNumber) throws InvalidISBNException {
	        if(String.valueOf(ISBNNumber).length()!=13 || ISBNNumber<0)  {
	            throw new InvalidISBNException();
	        }
	        this.ISBNNumber = ISBNNumber;
	    }
	    /**
	     * Public getter method for the checkOut member variable.
	     * @return
	     *      The checkOut of the book which is published.
	     */
	    public boolean getCheckedOut() {
	        return checkedOut;
	    }
	    /**
	     * Public setter method for the checkedOut member variable.
	     * @param checkedOut
	     *      The new checkedOut of this book. This parameter should have any digit or shall not be empty
	     * @custom.Precondition
	     *      The new checkedOut of the book. This parameter should not have any digits or shall not be empty
	     */
	    public void setCheckedOut(boolean checkedOut) {
	        this.checkedOut = checkedOut;
	    }
	    /**
	     * Public getter method for the checkedOut member variable.
	     * @return
	     *      The nextBook which is published.
	     */
	    public Book getNextBook() {
	        return nextBook;
	    }
	    /**
	     * Public setter method for the nextBook member variable.
	     * @param nextBook
	     *      The new nextBook of this book. This parameter should have any digit or shall not be empty
	     * @custom.Precondition
	     *      The new nextBook of the book. This parameter should not have any digits or shall not be empty
	     */
	    public void setNextBook(Book nextBook) {
	        this.nextBook = nextBook;
	    }
	    /**
	     * Public getter method for the checkedOutUserID member variable.
	     * @return
	     *      The checkedOutUserID which is published.
	     */
	    public int getCheckOutUserID() {
	        return checkOutUserID;
	    }
	    /**
	     * Public setter method for the checkOutUserID member variable.
	     * @param checkOutUserID
	     *      The checkOutUserID of this book. This parameter should have any digit or shall not be empty
	     * @custom.Precondition
	     *      The new checkOutUserID of the book. This parameter should not have any digits or shall not be empty
	     */
	    public void setCheckOutUserID(int checkOutUserID) {
	        this.checkOutUserID = checkOutUserID;
	    }

	    /**
	     * Public getter method for the CheckOutDate member variable.
	     * @return
	     *      The CheckOutDate which is published.
	     */
	    public Date getCheckOutDate() {
	        return checkOutDate;
	    }

	    /**
	     * Public setter method for the checkOutDate member variable.
	     * @param checkOutDate
	     *      The checkOutUserID of this book. This parameter should have any digit or shall not be empty
	     * @custom.Precondition
	     *      The newcheckOutDate of the book. This parameter should not have any digits or shall not be empty
	     */
	    public void setCheckOutDate(Date checkOutDate) {
	        this.checkOutDate = checkOutDate;
	    }

	    /**
	     * A method to convert the information of the Book to be displayed neatly.
	     * @return
	     *      A string of information the book in proper format.
	     */
	    public String toString() {
	        return getName() + " " + getAuthor() + " " + getGenre() + " " + getBookCondition() + " " + getISBNNumber() + " " + getYearPublished() + " " + getCheckOutUserID() + " " + getNextBook() + getCheckedOut();
	    }

	    /**
	     * A method to convert the information of the Book to be displayed neatly.
	     * @return
	     *      A string of information the date in proper format.
	     */
	    public String getCheckedOutDatetoString() {
	        return getCheckOutDate().getMonth() + "/" + getCheckOutDate().getDay() + "/" + getCheckOutDate().getYear();
	    }
}

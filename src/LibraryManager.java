package src;
/**
 * An driver program used to test out the <CODE>BookRepository and ReturnStack</CODE>
 * written as part of this assignment.  The user can use the commands below
 * to perform operations on <CODE>SecurityCheck</CODE> objects.
 * <dt><b>Commands:</b><dd>
 * 		(B) – Manage Book Repository
 *          (C) – Checkout Book
 *          (N) – Add New Book
 *          (R) – Remove Book
 *          (P) – Print Repository
 *          (S) – Sort Shelf:
 *              (I) – ISBN Number o (N) – Name
 *              (A) – Author
 *              (G) – Genre
 *              (Y) – Year
 *              (C) – Condition
 *          (R) – Manage Return Stack
 *              (R) – Return Book
 *              (L) – See Last Return
 *              (C) – Check In Last Return
 *              (P) Print Return Stack
 */
import java.util.*;
//import java.util.Date;
//import java.util.EmptyStackException;

public class LibraryManager{
    static BookRepository BP = new BookRepository();
    static ReturnStack RS = new ReturnStack();
    public static BookRepository getBookRepository(){
        return BP;
    }
    /**
     * Main function that calls the function based on the user's input.
     */
    public static void main(String[] args) throws BookNotCheckedOutException, EmptyStackException, InvalidISBNException, InvalidUserIDException, BookAlreadyCheckedOutException, InvalidISBNException, BookAlreadyExistsException, BookDoesNotExistException, IllegalArgumentException, InvalidSortCriteriaException, EmptyStackException, EmptyStackException {
        while(true) {
            System.out.println("(B) – Manage Book Repository");
            System.out.println("\t" + " (C) – Checkout Book");
            System.out.println("\t" + " (N) – Add New Book");
            System.out.println("\t" + " (R) – Remove Book");
            System.out.println("\t" + " (P) – Print Repository");
            System.out.println("\t" + " (S) – Sort Shelf:");
            System.out.println("\t\t " + " (I) – ISBN Number");
            System.out.println("\t\t " + " (N) – Name");
            System.out.println("\t\t " + " (A) – Author");
            System.out.println("\t\t " + " (G) – Genre");
            System.out.println("\t\t " + " (Y) – Year");
            System.out.println("\t\t " + " (C) – Condition");
            System.out.println("(R) – Manage Return Stack");
            System.out.println("\t" + " (R) – Return Book");
            System.out.println("\t" + " (L) – See Last Return");
            System.out.println("\t" + " (C) – Check In Last Return");
            System.out.println("\t" + " (P) Print Return Stack");
            System.out.println("(Q) – Quit");
            Scanner input = new Scanner(System.in);
            System.out.println("Please select what to manage:");
            String input1 = input.nextLine();
            if(input1.equalsIgnoreCase("Q")){
                break;
            }
            else if(input1.equalsIgnoreCase("B")){
                System.out.println("Please select an option:");
                String input2 = input.nextLine();
                if(input1.equalsIgnoreCase("B") && input2.equalsIgnoreCase("C")){
                    System.out.println("Please provide a library user ID:");
                    int userID = input.nextInt();
                    if(String.valueOf(userID).length()!=10){
                        System.out.println("Invalid userID");
                        continue;
                    }
                    System.out.println("Please provide an ISBN Number:");
                    long ISBNNumber = input.nextLong();
                    input.nextLine();
                    System.out.println("Please provide a return date:");
                    String date = input.nextLine();
                    int month = Integer.parseInt(date.substring(0,2));
                    int day = Integer.parseInt(date.substring(3,5));
                    int year = Integer.parseInt(date.substring(6,date.length()));
                    Date d =new Date(day,month,year);
                    try{
                        BP.checkOutBook(ISBNNumber,userID,d);
                        System.out.println("Loading...");
                    }
                    catch(InvalidISBNException| InvalidUserIDException| BookAlreadyCheckedOutException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if(input1.equalsIgnoreCase("B") && input2.equalsIgnoreCase("N")) {
                    System.out.println("Please provide an ISBN number:");
                    long ISBN = input.nextLong();
                    input.nextLine();
                    System.out.println("Please provide a name:");
                    String name = input.nextLine();
                    System.out.println("Please provide an author: ");
                    String author = input.nextLine();
                    System.out.println("Please provide a genre:");
                    String genre = input.nextLine();
                    System.out.println("Please provide a condition: ");
                    String condition = input.nextLine();
                    Condition x;
                    if(condition.equals("New")) {
                        x=Condition.New;
                    }
                    else if(condition.equals("Bad")) {
                        x=Condition.Bad;
                    }
                    else if(condition.equals("Good")) {
                        x=Condition.Good;
                    }
                    else if(condition.equals("Replace")) {
                        x=Condition.Replace;
                    }
                    else {
                        System.out.println("Enter a valid Condition");
                        continue;
                    }
                    try{
                        BP.addBook(ISBN,name,author,genre,x);
                        System.out.println(name + " has been successfully added to the book repository!");
                    }
                    catch(InvalidISBNException | BookAlreadyExistsException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if(input1.equalsIgnoreCase("B") && input2.equalsIgnoreCase("R")) {
                    System.out.println("Please provide an ISBN Number:");
                    long ISBN = input.nextLong();
                    input.nextLine();
                    try {
                        BP.removeBook(ISBN);
                    }
                    catch(InvalidISBNException| BookDoesNotExistException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if(input1.equalsIgnoreCase("B") && input2.equalsIgnoreCase("P")) {
                    System.out.println("Please select a shelf:");
                    int shelf = input.nextInt();
                    input.nextLine();
                    try {
                        BP.print(shelf);
                    }
                    catch(IllegalArgumentException e) {
                        System.out.println("Enter a valid shelf number ");
                        continue;
                    }
                }
                else if(input1.equalsIgnoreCase("B") && input2.equalsIgnoreCase("S")) {
                    System.out.println("Please select a shelf:");
                    int shelf = input.nextInt();
                    input.nextLine();
                    System.out.println("Please select a sorting criteria:");
                    String sort = input.nextLine();
                    if(sort.equalsIgnoreCase("I")) {
                        sort="ISBNNumber";
                    }
                    else if(sort.equalsIgnoreCase("N")) {
                        sort="Name";
                    }
                    else if(sort.equalsIgnoreCase("A")) {
                        sort="Author";
                    }
                    else if(sort.equalsIgnoreCase("G")) {
                        sort="Genre";
                    }
                    else if(sort.equalsIgnoreCase("Y")) {
                        sort="Year";
                    }
                    else if(sort.equalsIgnoreCase("C")) {
                        sort="Condition";
                    }
                    else {
                        System.out.println("Invalid input");
                        continue;
                    }
                    try{
                        BP.sortShelf(shelf,sort);
                    }
                    catch(InvalidSortCriteriaException|CloneNotSupportedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else if(input1.equalsIgnoreCase("R")) {
                System.out.println("Please select an option:");
                String input3 = input.nextLine();
                if(input3.equalsIgnoreCase("R")) {
                    System.out.println("Please provide the ISBN of the book you’re returning: ");
                    long ISBN = input.nextLong();
                    System.out.println("Please your Library UserID: ");
                    int UserID = input.nextInt();
                    System.out.println("Please your current date: ");
                    String date = input.next();
                    int month = Integer.parseInt(date.substring(0,2));
                    int day = Integer.parseInt(date.substring(3,5));
                    int year = Integer.parseInt(date.substring(6,10));
                    Date d =new Date(day,month,year);
                    try {
                        Book tempBook = BP.returnBook(ISBN);
                        RS.pushLog(ISBN, UserID, d);
                        if((d.getYear()>tempBook.getCheckOutDate().getYear()) || (d.getMonth()>tempBook.getCheckOutDate().getYear() && d.getYear()==tempBook.getCheckOutDate().getYear()) || (d.getDay()>tempBook.getCheckOutDate().getDay() && d.getMonth() == tempBook.getCheckOutDate().getMonth() && d.getYear() == tempBook.getCheckOutDate().getYear())) {
                           System.out.println(tempBook.getName()+" was returned Late. Checking everything in...");
                            while(RS.gettopLog()!=null) {
                                ReturnLog temp = RS.popLog();
                                BP.checkInBook(temp.getISBN(), temp.getUserID());
                            }
                            continue;
                        }
                        else {
                            System.out.println(tempBook.getName()+" has been returned on time!");
                        }      
                    }
                    catch(InvalidISBNException | InvalidUserIDException | InvalidReturnDateException | BookNotCheckedOutException | BookCheckedOutBySomeoneElseException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if(input3.equalsIgnoreCase("L")) {
                    try {
                        ReturnLog temp = RS.peekLog();
                        Book tempBook = BP.returnBook(temp.getISBN());
                        BP.checkInBook(tempBook.getISBNNumber(), tempBook.getCheckOutUserID());
                        System.out.println(tempBook.getName() + " is the next book to be checked in.");
                    }
                    catch(EmptyStackException |InvalidISBNException | InvalidUserIDException | InvalidReturnDateException | BookNotCheckedOutException | BookCheckedOutBySomeoneElseException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if(input3.equalsIgnoreCase("C")) {
                    try {
                        ReturnLog temp = RS.popLog();
                        BP.checkInBook(temp.getISBN(), temp.getUserID());
                        Book tempBook = BP.ReturnBook(temp.getISBN());
                        System.out.println(tempBook.getName()+" has been checked in!");
                    }
                    catch(EmptyStackException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if(input3.equalsIgnoreCase("P")) {
                    RS.toString();
                }
                else {
                    System.out.println("Invalid input");
                    continue;
                }
            }
            else {
                System.out.println("Invalid input");
                continue;
            }
        }
    }
}

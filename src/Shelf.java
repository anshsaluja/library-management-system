package src;
/**
 * An abstract data type meant to serve as a representation of a
 * Shelf of the book, containing the headBook, tailBook, length
 * and methods to manipulate these values.
 */
public class Shelf{
    private Book headBook;//headBook of the shelf
    private Book tailBook;//tailBook of the shelf
    private int length;//length of the shelf
    private SortCriteria shelfSortCriteria;//sort criteria of the shelf
    private Book cursorBook;//cursorBook to traverse through the shelf
    private SortCriteria criteria;//criteria of the shelf
    /**
     * No-Arg constructor
     * @custom.Postcondtion
     *      This object has been initialized to a default shelf and with a default sortCriteria as ISBN Number.
     */
    public Shelf() {
        criteria = criteria.ISBNNumber;
    }
    /**
     * Public getter method for the headBook member variable.
     * @return
     *      The headBook of the shelf.
     */
    public Book getHeadBook() {
        return headBook;
    }
    /**
     * Public setter method for the headBook member variable.
     * @param headBook
     *      The new headBook of this shelf. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new headBook of the shelf. This parameter should not have any digits or shall not be empty
     */
    public void setHeadBook(Book headBook) {
        this.headBook = headBook;
    }
    /**
     * Public getter method for the tailBook member variable.
     * @return
     *      The tailBook of the shelf.
     */
    public Book getTailBook() {
        return tailBook;
    }
    /**
     * Public setter method for the headBook member variable.
     * @param tailBook
     *      The new tailBook of this shelf. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new tailBook of the shelf. This parameter should not have any digits or shall not be empty
     */
    public void setTailBook(Book tailBook) {
        this.tailBook = tailBook;
    }
    /**
     * Public getter method for the length member variable.
     * @return
     *      The length of the shelf.
     */
    public int getLength() {
        return length;
    }
    /**
     * Public setter method for the length member variable.
     * @param length
     *      The new length of this shelf. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new length of the shelf. This parameter should not have any digits or shall not be empty
     */
    public void setLength(int length) {
        this.length = length;
    }
    /**
     * Public getter method for the shelfSortCriteria member variable.
     * @return
     *      The shelfSortCriteria of the shelf.
     */
    public SortCriteria getShelfSortCriteria() {
        return shelfSortCriteria;
    }
    /**
     * Public setter method for the shelfSortCriteria member variable.
     * @param shelfSortCriteria
     *      The new shelfSortCriteria of this shelf. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new shelfSortCriteria of the shelf. This parameter should not have any digits or shall not be empty
     */
    public void setShelfSortCriteria(SortCriteria shelfSortCriteria) {
        this.shelfSortCriteria = shelfSortCriteria;
    }
    /**
     * Public getter method for the CursorBook member variable.
     * @return
     *      The CursorBook of the shelf.
     */
    public Book getCursorBook() {
        return cursorBook;
    }
    /**
     * Public setter method for the CursorBook member variable.
     * @param cursorBook
     *      The new CursorBook of this shelf. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new CursorBook of the shelf. This parameter should not have any digits or shall not be empty
     */
    public void setCursorBook(Book cursorBook){
        this.cursorBook=cursorBook;
    }
    /**
     * Public getter method for the Criteria member variable.
     * @return
     *      The Criteria of the shelf.
     */
    public SortCriteria getCriteria(){
        return criteria;
    }
    /**
     * Public setter method for the criteria member variable.
     * @param criteria
     *      The new criteria of this shelf. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new criteria of the shelf. This parameter should not have any digits or shall not be empty
     */
    public void setCriteria(SortCriteria criteria){
        this.criteria=criteria;
    }
    /**
     * Sorts the shelf according to the ISBN Number.
     * @custom.Postcondition
     *      Sorts the shelf according to the ISBN Number.
     */
    public void sortISBNNumber(){
        if(getLength()==0 || getLength()==1){//does not do anything if the length is 0 or 1
            return;
        }
        Book current = headBook;//a book to make implementation easier
        Book index = null;//to make implementation easier
        long min=headBook.getISBNNumber();

        if (headBook == null) {
            return;
        }
        else {
            Book currentPrev=headBook;
            while(current!=null){//loop to traverse through the shelf
                index=current.getNextBook();
                Book prevBook=current;
                boolean c=false;
                min=current.getISBNNumber();
                while(index!=null){//loop to find book with minimum ISBN
                    if(index.getISBNNumber()<min){
                        min= index.getISBNNumber();
                        prevBook=index;
                        c=true;
                    }
                    index=index.getNextBook();
                }
                Book checkerBook=headBook;
                while(checkerBook!=tailBook){//stops before the book which minimum
                    if(checkerBook.getNextBook()==prevBook){
                        break;
                    }
                    checkerBook=checkerBook.getNextBook();
                }
                Book temp;
                if(c==false){//case where book first is minimum
                    currentPrev=current;
                    current=current.getNextBook();
                    continue;
                }
                else if(prevBook==tailBook && getLength()==2){
                    temp = prevBook;
                    tailBook=headBook;
                    tailBook.setNextBook(null);
                    temp.setNextBook(headBook);
                    headBook=temp;
                }
                else if(prevBook==tailBook){//sets link accordingly
                    tailBook=checkerBook;
                    temp = prevBook;
                    checkerBook.setNextBook(null);
                    if(current==headBook){
                        temp.setNextBook(current);
                        headBook=temp;
                    }
                    else{
                        temp.setNextBook(current);
                        currentPrev.setNextBook(temp);
                    }
                }
                else{
                    temp = prevBook;
                    checkerBook.setNextBook(prevBook.getNextBook());
                    if(current==headBook){
                        temp.setNextBook(current);
                        headBook=temp;
                    }
                    else{
                        temp.setNextBook(current);
                        currentPrev.setNextBook(temp);
                    }
                }
                currentPrev=checkerBook;
                current=temp;
            }
        }
    }
    /**
     * Sorts the shelf according to the Name.
     * @custom.Postcondition
     *      Sorts the shelf according to the Name.
     */
    public void sortName(){
        if(getLength()==0 || getLength()==1){
            return;
        }
        Book current = headBook;//to make implementation easier
        Book index = null;//to make implementation easier
        String min=headBook.getName();
        if (headBook == null) {
            return;
        }
        else{
            Book currentPrev=headBook;
            while(current!=null){//to travel through the shelf
                index=current.getNextBook();
                Book prevBook=current;
                boolean c=false;
                min=current.getName();
                while(index!=null){//to find the minimum name of the shelf
                    if(index.getName().compareToIgnoreCase(min)<0){
                        min= index.getName();
                        prevBook=index;
                        c=true;
                    }
                    index=index.getNextBook();
                }
                Book checkerBook=headBook;
                while(checkerBook!=tailBook){
                    if(checkerBook.getNextBook()==prevBook){
                        break;
                    }
                    checkerBook=checkerBook.getNextBook();
                }
                Book temp;
                if(c==false){
                    currentPrev=current;
                    current=current.getNextBook();
                    continue;
                }
                else if(prevBook==tailBook && getLength()==2){//sets link accordingly
                    temp = prevBook;
                    tailBook=headBook;
                    tailBook.setNextBook(null);
                    temp.setNextBook(headBook);
                    headBook=temp;
                }
                else if(prevBook==tailBook){
                    tailBook=checkerBook;
                    temp = prevBook;
                    checkerBook.setNextBook(null);
                    if(current==headBook) {
                        temp.setNextBook(current);
                        headBook=temp;
                    }
                    else {
                        temp.setNextBook(current);
                        currentPrev.setNextBook(temp);
                    }
                }
                else {
                    temp = prevBook;
                    checkerBook.setNextBook(prevBook.getNextBook());
                    if(current==headBook){
                        temp.setNextBook(current);
                        headBook=temp;
                    }
                    else{
                        temp.setNextBook(current);
                        currentPrev.setNextBook(temp);
                    }
                }
                currentPrev=checkerBook;
                current=temp;
            }
        }
    }
    /**
     * Sorts the shelf according to the Author.
     * @custom.Postcondition
     *      Sorts the shelf according to the Author.
     */
    public void sortAuthor(){
        if(getLength()==0 || getLength()==1){
            return;
        }
        Book current = headBook;//to make implementation easier
        Book index = null;//to make implementation easier
        String min=headBook.getAuthor();
        if (headBook == null){
            return;
        }
        else {
            Book currentPrev=headBook;
            while(current!=null){//to travel through the shelf
                index=current.getNextBook();
                Book prevBook=current;
                boolean c=false;
                min=current.getAuthor();
                while(index!=null){//finds minimum author
                    if(index.getAuthor().compareToIgnoreCase(min)<0){
                        min= index.getAuthor();
                        prevBook=index;
                        c=true;
                    }
                    index=index.getNextBook();
                }
                Book checkerBook=headBook;
                while(checkerBook!=tailBook){//stops before the minimum book
                    if(checkerBook.getNextBook()==prevBook){
                        break;
                    }
                    checkerBook=checkerBook.getNextBook();
                }
                Book temp;
                if(c==false){
                    currentPrev=current;
                    current=current.getNextBook();
                    continue;
                }
                else if(prevBook==tailBook && getLength()==2){//sets book accordingly
                    temp = prevBook;
                    tailBook=headBook;
                    tailBook.setNextBook(null);
                    temp.setNextBook(headBook);
                    headBook=temp;
                }
                else if(prevBook==tailBook){
                    tailBook=checkerBook;
                    temp = prevBook;
                    checkerBook.setNextBook(null);
                    if(current==headBook){
                        temp.setNextBook(current);
                        headBook=temp;
                    }
                    else {
                        temp.setNextBook(current);
                        currentPrev.setNextBook(temp);
                    }
                }
                else {
                    temp = prevBook;
                    checkerBook.setNextBook(prevBook.getNextBook());
                    if(current==headBook) {
                        temp.setNextBook(current);
                        headBook=temp;
                    }
                    else {
                        temp.setNextBook(current);
                        currentPrev.setNextBook(temp);
                    }
                }
                currentPrev=checkerBook;
                current=temp;
            }
        }
    }
    /**
     * Sorts the shelf according to the Genre.
     * @custom.Postcondition
     *      Sorts the shelf according to the Genre.
     */
    public void sortGenre(){
        if(getLength()==0 || getLength()==1){
            return;
        }
        Book current = headBook;//to make implementation easier
        Book index = null;//to make implementation easier
        String min=headBook.getGenre();
        if (headBook == null){
            return;
        }
        else{
            Book currentPrev=headBook;
            while(current!=null){//traverse through the shelf
                index=current.getNextBook();
                Book prevBook=current;
                boolean c=false;
                min=current.getGenre();
                while(index!=null){//finds the minimum author
                    if(index.getGenre().compareToIgnoreCase(min)<0){
                        min= index.getGenre();
                        prevBook=index;
                        c=true;
                    }
                    index=index.getNextBook();
                }
                Book checkerBook=headBook;
                while(checkerBook!=tailBook){//stops before the minimum author
                    if(checkerBook.getNextBook()==prevBook){
                        break;
                    }
                    checkerBook=checkerBook.getNextBook();
                }
                Book temp;
                if(c==false){
                    currentPrev=current;
                    current=current.getNextBook();
                    continue;
                }
                else if(prevBook==tailBook && getLength()==2){//sets link accordingly
                    temp = prevBook;
                    tailBook=headBook;
                    tailBook.setNextBook(null);
                    temp.setNextBook(headBook);
                    headBook=temp;
                }
                else if(prevBook==tailBook){
                    tailBook=checkerBook;
                    temp = prevBook;
                    checkerBook.setNextBook(null);
                    if(current==headBook){
                        temp.setNextBook(current);
                        headBook=temp;
                    }
                    else{
                        temp.setNextBook(current);
                        currentPrev.setNextBook(temp);
                    }
                }
                else{
                    temp = prevBook;
                    checkerBook.setNextBook(prevBook.getNextBook());
                    if(current==headBook) {
                        temp.setNextBook(current);
                        headBook=temp;
                    }
                    else {
                        temp.setNextBook(current);
                        currentPrev.setNextBook(temp);
                    }
                }
                currentPrev=checkerBook;
                current=temp;
            }
        }
    }
    /**
     * Sorts the shelf according to the Year.
     * @custom.Postcondition
     *      Sorts the shelf according to the Year.
     */
    public void sortYear() {
        if(getLength()==0 || getLength()==1) {
            return;
        }

        Book current = headBook;
        Book index = null;
        int min=headBook.getYearPublished();

        if (headBook == null) {
            return;
        }
        else {
            Book currentPrev=headBook;
            while(current!=null){//to traverse through the shelf
                index=current.getNextBook();
                Book prevBook=current;
                boolean c=false;
                min=current.getYearPublished();
                while(index!=null){//find the minimum year book
                    if(index.getYearPublished()<min) {
                        min= index.getYearPublished();
                        prevBook=index;
                        c=true;
                    }
                    index=index.getNextBook();
                }
                Book checkerBook=headBook;
                while(checkerBook!=tailBook){//to stop before the minimum year book
                    if(checkerBook.getNextBook()==prevBook) {
                        break;
                    }
                    checkerBook=checkerBook.getNextBook();
                }
                Book temp;
                if(c==false) {
                    currentPrev=current;
                    current=current.getNextBook();
                    continue;
                }
                else if(prevBook==tailBook && getLength()==2){//sets link accoridngly
                    temp = prevBook;
                    tailBook=headBook;
                    tailBook.setNextBook(null);
                    temp.setNextBook(headBook);
                    headBook=temp;
                }
                else if(prevBook==tailBook) {
                    tailBook=checkerBook;
                    temp = prevBook;
                    checkerBook.setNextBook(null);
                    if(current==headBook) {
                        temp.setNextBook(current);
                        headBook=temp;
                    }
                    else {
                        temp.setNextBook(current);
                        currentPrev.setNextBook(temp);
                    }
                }
                else {
                    temp = prevBook;
                    checkerBook.setNextBook(prevBook.getNextBook());
                    if(current==headBook) {
                        temp.setNextBook(current);
                        headBook=temp;
                    }
                    else {
                        temp.setNextBook(current);
                        currentPrev.setNextBook(temp);
                    }
                }
                currentPrev=checkerBook;
                current=temp;
            }
        }
    }
    /**
     * gives a heirachy according to the book.
     * @param x
     * 		Person to be added in the line with a give name and seatNumber
     */
    public int conditionManager(Book x){//gives the book a heirachy according to the condition
        if(x.getBookCondition()==Condition.New) {
            return 4;
        }
        else if(x.getBookCondition()==Condition.Good) {
            return 3;
        }
        else if(x.getBookCondition()==Condition.Bad) {
            return 2;
        }
        else{
            return 1;
        }
    }
    /**
     * Sorts the shelf according to the Condition.
     * @custom.Postcondition
     *      Sorts the shelf according to the Condition.
     */
    public void sortCondition(){
        if(getLength()==0 || getLength()==1) {
            return;
        }

        Book current = headBook;//to make implementation easier
        Book index = null;//to make implementation easier
        int min=conditionManager(headBook);
        int y;
        if (headBook == null) {
            return;
        }
        else {
            Book currentPrev=headBook;
            while(current!=null) {
                index=current.getNextBook();
                Book prevBook=current;
                boolean c=false;
                min=conditionManager(current);
                while(index!=null){//traverse through the loo[
                    y=conditionManager(index);//gets the heirachy
                    if(y<min) {
                        min=y;
                        prevBook=index;
                        c=true;
                    }
                    index=index.getNextBook();
                }
                Book checkerBook=headBook;
                while(checkerBook!=tailBook){//stops before the minimum heirachy
                    if(checkerBook.getNextBook()==prevBook) {
                        break;
                    }
                    checkerBook=checkerBook.getNextBook();
                }
                Book temp;
                if(c==false) {
                    currentPrev=current;
                    current=current.getNextBook();
                    continue;
                }
                else if(prevBook==tailBook && getLength()==2) {
                    temp = prevBook;
                    tailBook=headBook;
                    tailBook.setNextBook(null);
                    temp.setNextBook(headBook);
                    headBook=temp;
                }
                else if(prevBook==tailBook) {
                    tailBook=checkerBook;
                    temp = prevBook;
                    checkerBook.setNextBook(null);
                    if(current==headBook) {
                        temp.setNextBook(current);
                        headBook=temp;
                    }
                    else {
                        temp.setNextBook(current);
                        currentPrev.setNextBook(temp);
                    }
                }
                else {
                    temp = prevBook;
                    checkerBook.setNextBook(prevBook.getNextBook());
                    if(current==headBook) {
                        temp.setNextBook(current);
                        headBook=temp;
                    }
                    else {
                        temp.setNextBook(current);
                        currentPrev.setNextBook(temp);
                    }
                }
                currentPrev=checkerBook;
                current=temp;
            }
        }
    }
    /**
     * adds the book to the shelf.
     * @param addedBook
     * 		Book to be added to the shelf.
     * @throws
     *      BookAlreadyExistsException if the book already exists in the shelf
     */
    public void addBook(Book addedBook) throws BookAlreadyExistsException{
        if (getLength() != 0) {
            cursorBook = headBook;
            while (cursorBook != null){ //to check if the book already exists in the shelf or not
                if (cursorBook.getISBNNumber() == addedBook.getISBNNumber()) {
                    throw new BookAlreadyExistsException();
                } 
                else {
                    cursorBook = cursorBook.getNextBook();
                }
            }
        }
        if (criteria == criteria.ISBNNumber){//adds book according to the ISBN Number
            if (getLength() == 0) {
                headBook = addedBook;
                tailBook = addedBook;
            }
            else if (getLength() == 1) {
                if (headBook.getISBNNumber() > addedBook.getISBNNumber()) {
                    addedBook.setNextBook(headBook);
                    tailBook = headBook;
                    headBook = addedBook;
                }
                else {
                    headBook.setNextBook(addedBook);
                    tailBook = addedBook;
                }
            }
            else {
                cursorBook = headBook;
                Book prevBook = null;
                while (cursorBook != null){//loop to traverse through the shelf and find a location appropriate to add the book
                    if (cursorBook == headBook && cursorBook.getISBNNumber() > addedBook.getISBNNumber()) {
                        addedBook.setNextBook(cursorBook);
                        headBook = addedBook;
                        break;
                    } 
                    else if (cursorBook == tailBook && cursorBook.getISBNNumber() < addedBook.getISBNNumber()) {
                        cursorBook.setNextBook(addedBook);
                        tailBook = addedBook;
                        break;
                    }
                    else if (cursorBook.getISBNNumber() > addedBook.getISBNNumber()) {
                        addedBook.setNextBook(cursorBook);
                        prevBook.setNextBook(addedBook);
                        break;
                    } 
                    else {
                        prevBook=cursorBook;
                        cursorBook = cursorBook.getNextBook();
                    }
                }
            }
        } 
        else if (criteria == criteria.Name) {

            if (getLength() == 0) {
                headBook = addedBook;
                tailBook = addedBook;
            } 
            else if (getLength() == 1) {
                if (headBook.getName().compareToIgnoreCase(addedBook.getName()) > 0) {
                    addedBook.setNextBook(headBook);
                    tailBook = headBook;
                    headBook = addedBook;
                } 
                else {
                    headBook.setNextBook(addedBook);
                    tailBook = addedBook;
                }
            } 
            else {
                cursorBook = headBook;
                Book prevBook = null;
                while (cursorBook != null){ //loop to traverse through the shelf and find a location appropriate to add the book
                    if (cursorBook == headBook && cursorBook.getName().compareToIgnoreCase(addedBook.getName()) > 0) {
                        addedBook.setNextBook(cursorBook);
                        headBook = addedBook;
                        break;
                    } 
                    else if (cursorBook == tailBook && cursorBook.getName().compareToIgnoreCase(addedBook.getName()) < 0) {
                        cursorBook.setNextBook(addedBook);
                        tailBook = addedBook;
                        break;
                    } 
                    else if (cursorBook.getName().compareToIgnoreCase(addedBook.getName()) > 0) {
                        addedBook.setNextBook(cursorBook);
                        prevBook.setNextBook(addedBook);
                        break;
                    } 
                    else {
                        prevBook=cursorBook;
                        cursorBook = cursorBook.getNextBook();
                    }
                }
            }
        }
        else if (criteria == criteria.Author) {
            if (getLength() == 0) {
                headBook = addedBook;
                tailBook = addedBook;
            } 
            else if (getLength() == 1) {
                if (headBook.getAuthor().compareToIgnoreCase(addedBook.getAuthor()) > 0) {
                    addedBook.setNextBook(headBook);
                    tailBook = headBook;
                    headBook = addedBook;
                } 
                else {
                    headBook.setNextBook(addedBook);
                    tailBook = addedBook;
                }
            } 
            else {
                cursorBook = headBook;
                Book prevBook = null;
                while (cursorBook != null) { //loop to traverse through the shelf and find a location appropriate to add the book
                    if (cursorBook == headBook && cursorBook.getAuthor().compareToIgnoreCase(addedBook.getAuthor()) > 0) {
                        addedBook.setNextBook(cursorBook);
                        headBook = addedBook;
                        break;
                    } 
                    else if (cursorBook == tailBook && cursorBook.getAuthor().compareToIgnoreCase(addedBook.getAuthor()) < 0) {
                        cursorBook.setNextBook(addedBook);
                        tailBook = addedBook;
                        break;
                    } 
                    else if (cursorBook.getAuthor().compareToIgnoreCase(addedBook.getAuthor()) > 0) {
                        addedBook.setNextBook(cursorBook);
                        prevBook.setNextBook(addedBook);
                        break;
                    } 
                    else {
                        prevBook = cursorBook;
                        cursorBook = cursorBook.getNextBook();
                    }
                }
            }
        }
        else if (criteria == criteria.Genre) {
            if (getLength() == 0) {
                headBook = addedBook;
                tailBook = addedBook;
            } else if (getLength() == 1) {
                if (headBook.getGenre().compareToIgnoreCase(addedBook.getGenre()) > 0) {
                    addedBook.setNextBook(headBook);
                    tailBook = headBook;
                    headBook = addedBook;
                } 
                else {
                    headBook.setNextBook(addedBook);
                    tailBook = addedBook;
                }
            } 
            else {
                cursorBook = headBook;
                Book prevBook = null;
                while (cursorBook != null){ //loop to traverse through the shelf and find a location appropriate to add the book
                    if (cursorBook == headBook && cursorBook.getGenre().compareToIgnoreCase(addedBook.getGenre()) > 0) {
                        addedBook.setNextBook(cursorBook);
                        headBook = addedBook;
                        break;
                    } 
                    else if (cursorBook == tailBook && cursorBook.getGenre().compareToIgnoreCase(addedBook.getGenre()) < 0) {
                        cursorBook.setNextBook(addedBook);
                        tailBook = addedBook;
                        break;
                    } 
                    else if (cursorBook.getGenre().compareToIgnoreCase(addedBook.getGenre()) > 0) {
                        addedBook.setNextBook(cursorBook);
                        prevBook.setNextBook(addedBook);
                        break;
                    } 
                    else {
                        prevBook = cursorBook;
                        cursorBook = cursorBook.getNextBook();
                    }
                }
            }
        }
        else if (criteria == criteria.Year) {
            if (getLength() == 0) {
                headBook = addedBook;
                tailBook = addedBook;
            } 
            else if (getLength() == 1) {
                if (headBook.getYearPublished() > addedBook.getYearPublished()) {
                    addedBook.setNextBook(headBook);
                    tailBook = headBook;
                    headBook = addedBook;
                } 
                else {
                    headBook.setNextBook(addedBook);
                    tailBook = addedBook;
                }
            } 
            else {
                cursorBook = headBook;
                Book prevBook = null;
                while (cursorBook != null){ //loop to traverse through the shelf and find a location appropriate to add the book
                    if (cursorBook == headBook && cursorBook.getYearPublished() > addedBook.getYearPublished()) {
                        addedBook.setNextBook(cursorBook);
                        headBook = addedBook;
                        break;
                    } 
                    else if (cursorBook == tailBook && cursorBook.getYearPublished() < addedBook.getYearPublished()) {
                        cursorBook.setNextBook(addedBook);
                        tailBook = addedBook;
                        break;
                    } 
                    else if (cursorBook.getNextBook().getYearPublished() > addedBook.getYearPublished()) {
                        addedBook.setNextBook(cursorBook);
                        prevBook.setNextBook(addedBook);
                        break;
                    } 
                    else {
                        prevBook = cursorBook;
                        cursorBook = cursorBook.getNextBook();
                    }
                }
            }
        }
        else {
            if (getLength() == 0){
                headBook = addedBook;
                tailBook = addedBook;
            }
            else if (getLength() == 1) {
                int x = conditionManager(headBook);
                int y=conditionManager(addedBook);
                if (x > y) {
                    addedBook.setNextBook(headBook);
                    tailBook = headBook;
                    headBook = addedBook;
                }
                else {
                    headBook.setNextBook(addedBook);
                    tailBook = addedBook;
                }
            }
            else {
                cursorBook = headBook;
                Book prevBook = null;
                while (cursorBook != null){ //loop to traverse through the shelf and find a location appropriate to add the book
                    int x = conditionManager(headBook);//gets the heirachy of the book according to the condition
                    int y=conditionManager(addedBook);//gets the heirachy of the book according to the condition
                    int m = conditionManager(cursorBook);//gets the heirachy of the book according to the condition
                    int n=conditionManager(addedBook);//gets the heirachy of the book according to the condition
                    if (cursorBook == headBook && x > y){
                        addedBook.setNextBook(cursorBook);
                        headBook = addedBook;
                        break;
                    }
                    else if (cursorBook == tailBook && m < n){
                        cursorBook.setNextBook(addedBook);
                        tailBook = addedBook;
                        break;
                    }
                    else if (m > n) {
                        addedBook.setNextBook(cursorBook);
                        prevBook.setNextBook(addedBook);
                        break;
                    }
                    else {
                        prevBook = cursorBook;
                        cursorBook = cursorBook.getNextBook();
                        if(cursorBook==null) {
                            prevBook.setNextBook(addedBook);
                            tailBook=addedBook;
                            break;
                        }
                    }
                }
            }
        }
        length++;
    }
    /**
     * removes the book from the shelf.
     * @param removedISBN
     * 		Book to be removed from the shelf.
     * @throws
     *      BookDoesNotExistException if the book does not exists in the shelf
     */
    public void removeBook(String removedISBN) throws BookDoesNotExistException{
        String name="";
        if(getLength()==0){
            throw new BookDoesNotExistException();
        }
        else if(getLength()==1){//to check if the book exists and if exists it removes the book
            if(headBook.getISBNNumber()==(Long.parseLong(removedISBN))){
                name=headBook.getName();
                headBook=null;
                tailBook=null;
            }
            else {
                throw new BookDoesNotExistException();
            }
            length--;
        }
        else if(getLength()==2) {
            if(headBook.getISBNNumber()==(Integer.parseInt(removedISBN))) {
                name= headBook.getName();
                headBook.setNextBook(null);
                headBook=tailBook;
            }
            else if(tailBook.getISBNNumber()==(Integer.parseInt(removedISBN))) {
                name= tailBook.getName();
                headBook.setNextBook(null);
                tailBook=headBook;
            }
            else {
                throw new BookDoesNotExistException();
            }
            length--;
        }
        else {
            cursorBook=null;//previous book to set the link accordingly and make implementation easier
            Book forwardBook = headBook;//book to be removed and makes implementation easy
            while(forwardBook!=null){//traverses through the loop to remove the book
                if(forwardBook.getISBNNumber()==(Long.parseLong(removedISBN))){
                    if(forwardBook==headBook) {
                        name= forwardBook.getName();
                        headBook=forwardBook.getNextBook();
                        length--;
                        break;
                    }
                    else if(forwardBook==tailBook) {
                        name= forwardBook.getName();
                        tailBook=cursorBook;
                        tailBook.setNextBook(null);
                        length--;
                        break;
                    }
                    else {
                        name= forwardBook.getName();
                        cursorBook.setNextBook(forwardBook.getNextBook());
                        length--;
                        break;
                    }
                }
                else {
                    cursorBook=forwardBook;
                    forwardBook=forwardBook.getNextBook();
                }
            }
            if(forwardBook==null) {
                throw new BookDoesNotExistException();
            }
        }
        System.out.println(name + " has been successfully removed from the Book repository!");
    }
    /**
     * sorts the shelf.
     * @param sortCriteria
     * 		Sort the shelf according to the sortCriteria.
     */
    public void sort(SortCriteria sortCriteria) throws CloneNotSupportedException{
        if(sortCriteria==criteria.ISBNNumber) {
            setCriteria(sortCriteria);
            sortISBNNumber();
        }
        else if(sortCriteria==criteria.Name) {
            setCriteria(sortCriteria);
            sortName();
        }
        else if(sortCriteria==criteria.Author) {
            setCriteria(sortCriteria);
            sortAuthor();
        }
        else if(sortCriteria==criteria.Genre) {
            setCriteria(sortCriteria);
            sortGenre();
        }
        else if(sortCriteria==criteria.Year) {
            setCriteria(sortCriteria);
            sortYear();
        }
        else {
            setCriteria(sortCriteria);
            sortCondition();
        }
    }
}
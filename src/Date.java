package src;
/**
 * An abstract data type meant to serve as a representation date of a
 * Book, containing the day, month, year
 * and methods to manipulate these values.
 */
public class Date {
    private int day;//day 
    private int month;//month 
    private int year;//year

    /**
     * No-Arg constructor
     * @custom.Postcondtion
     *      This object has been initialized to a default Date with date set to as default.
     */
    public Date() {
        day=0;
        month=0;
        year=0;
    }
    /**
     * Default constructor
     * @custom.Postcondtion
     *      This object has been initialized with a book date with day,month,year.
     */
    public Date(int day, int month, int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }
    /**
     * Public getter method for the day member variable.
     * @return
     *      The day of the Book.
     */
    public int getDay() {
        return day;
    }
    /**
     * Public setter method for the day member variable.
     * @param day
     *      The new day of this book. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new day of the book. This parameter should not have any digits or shall not be empty
     */
    public void setDay(int day){
        this.day = day;
    }
    /**
     * Public getter method for the month member variable.
     * @return
     *      The month of the Book.
     */
    public int getMonth(){
        return month;
    }
    /**
     * Public setter method for the day member variable.
     * @param month
     *      The new month of this book. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new month of the book. This parameter should not have any digits or shall not be empty
     */
    public void setMonth(int month){
        this.month = month;
    }
    /**
     * Public getter method for the year member variable.
     * @return
     *      The year of the Book.
     */
    public int getYear() {
        return year;
    }
    /**
     * Public setter method for the year member variable.
     * @param year
     *      The new year of this book. This parameter should have any digit or shall not be empty
     * @custom.Precondition
     *      The new year of the book. This parameter should not have any digits or shall not be empty
     */
    public void setYear(int year){
        this.year = year;
    }

    /**
     * A method to compare the date of the Book.
     * @return
     *      A integer to depict whether the date is greater or less the second date.
     */
    public static int compare(Date x, Date y){
        if(x.getYear()>y.getYear()){//compare years
            return 1;
        }
        else if((x.getYear()==y.getYear()) && (x.getMonth()>y.getMonth())){//compare month
            return 1;
        }
        else if((x.getYear()==y.getYear()) && (x.getMonth()==y.getMonth()) && (x.getDay()>y.getDay())){//compare month
            return 1;
        }
        else if(x.getYear()<y.getYear()){//compare year
         return -1;
        }
        else if((x.getYear()==y.getYear()) && (x.getMonth()<y.getMonth())){//compare month
            return -1;
        }
        else if((x.getYear()==y.getYear()) && (x.getMonth()==y.getMonth()) && (x.getDay()<y.getDay())){//compare day
            return -1;
        }
        else{
            return 0;//equality
        }
    }
    /**
     * A method to print date of the book.
     * @return
     *      A string representation of the date.
     */
    public String toString() {
        return month+"/"+day+"/"+year;
    }
}


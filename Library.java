
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Enumeration;

/**
 * Library class extends Building class
 */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator = false;

  /**
   * default constructor
   */
  public Library () {
    super();
  }

  /**
   * constructor with name address and nFloors
   * @param name building name
   * @param address building address
   * @param nFloors number of floors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
  }

  /**
   * construct a library with elevator
   * @param name building name
   * @param address building address
   * @param nFloors number of floors
   * @param hasElevator whether has elevator
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
    this.hasElevator = hasElevator;
  }

  /**
   * add a book to the collection
   * @param title info of the book
   */
  public void addTitle(String title) {
    this.collection.put(title, true);
  }

  /**
   * remove a book from the collection
   * @param title the book to be removed
   * @return the book to be removed
   */
  public String removeTitle(String title) {
    this.collection.remove(title);
    return title;
  } // return the title that we removed

  /**
   * borrow a book
   * @param title the book to be borrowed
   */
  public void checkOut(String title) {
    this.collection.replace(title, false);
  }

  /**
   * return a book
   * @param title the book returned
   */
  public void returnBook(String title) {
    this.collection.replace(title, true);
  }

  /**
   * check if the collection contains the book
   * @param title the book's info
   * @return true if contains
   */
  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  } // returns true if the title appears as a key in the Libary's collection, false otherwise

  /**
   * check if the book is available
   * @param title the book's info
   * @return true if is available
   */
  public boolean isAvailable(String title) {
    return this.collection.get(title);
  } // returns true if the title is currently available, false otherwise

  /**
   * Print out the collection
   */
  public void printCollection() {
    Enumeration<String> keyEmun = this.collection.keys();
    Enumeration<Boolean> valueEmun = this.collection.elements();
    while (keyEmun.hasMoreElements() && valueEmun.hasMoreElements()) {
      System.out.println("Title and Author: " + keyEmun.nextElement()+ ", " + "Checkout Status: " + valueEmun.nextElement());
    }
  } // prints out the entire collection in an easy-to-read way (including checkout status)

  /**
   * Go to a designated floor
   * @param floorNum the floor number want to go
   */
  public void goToFloor(int floorNum) {
    if (this.hasElevator) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are at floor " + super.activeFloor + "using elevator");
        super.activeFloor = floorNum;
    } else {
        super.goToFloor(floorNum);
    }
}

  /**
   * print possible method 
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + printCollection() + goToFloor()");
  }
  public static void main(String[] args) {

  }

}
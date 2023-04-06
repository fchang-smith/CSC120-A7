/* This is a stub for the Library class */
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Enumeration;

import javax.sound.sampled.SourceDataLine;

public class Library extends Building{

  private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

    public void addTitle(String title) {
      this.collection.put(title, true);
    }

    public String removeTitle(String title) {
      this.collection.remove(title);
      return title;
    } // return the title that we removed

    public void checkOut(String title) {
      this.collection.replace(title, false);
    }

    public void returnBook(String title) {
      this.collection.replace(title, true);
    }

    public boolean containsTitle(String title) {
      return this.collection.containsKey(title);
    } // returns true if the title appears as a key in the Libary's collection, false otherwise

    public boolean isAvailable(String title) {
      return this.collection.get(title);
    } // returns true if the title is currently available, false otherwise

    public void printCollection() {
      Enumeration<String> keyEmun = this.collection.keys();
      Enumeration<Boolean> valueEmun = this.collection.elements();
      while (keyEmun.hasMoreElements() && valueEmun.hasMoreElements()) {
        System.out.println("Title and Author: " + keyEmun.nextElement()+ ", " + "Checkout Status: " + valueEmun.nextElement());
      }
    } // prints out the entire collection in an easy-to-read way (including checkout status)

    public void showOptions() {
      super.showOptions();
      System.out.println(" + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + printCollection()");
    }
    public static void main(String[] args) {
      Library myLibrary = new Library("This library", "Library address", 2);
      myLibrary.showOptions();
    }
  
  }
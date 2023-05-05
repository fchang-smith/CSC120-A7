import java.util.ArrayList;
/**
 * House class extends Building class
 */
public class House extends Building {
  private ArrayList<String> residents = new ArrayList<String>();
  private boolean hasDiningRoom;
  private boolean hasElevator = false;

  /**
   * construct a house with only name address and nFloor
   * @param name house name
   * @param address house address
   * @param nFloors number of floor
   */
  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
  }

  /**
   * constructor a house without elevator
   * @param name building name
   * @param address building address
   * @param nFloors building floor
   * @param residents building residents
   * @param hasDiningRoom whether has dining hall
   */
  public House(String name, String address, int nFloors, 
              ArrayList<String> residents, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = residents;
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * construct a house with elevator
   * @param name building name
   * @param address building address
   * @param nFloors number of floors
   * @param residents building residents
   * @param hasDiningRoom whether has dining hall 
   * @param hasElevator whether has elevator
   */
  public House(String name, String address, int nFloors, 
              ArrayList<String> residents, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = residents;
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * check if has dining hall
   * @return true if has dining hall
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * get the number of residents
   * @return number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * move in a resident
   * @param name name of the resident
   */
  public void moveIn(String name) {
    // int len = this.nResidents();
    // ArrayList<String> newResidents = new ArrayList<String>(len+1);
    // for (int i = 0; i < len+1; i++){
    //   newResidents.add(this.residents[i]);
    // }
    this.residents.add(name);
  }

  /**
   * move out a resident
   * @param name name of the resident
   * @return name of the resident
   */
  public String moveOut(String name) {
    this.residents.remove(name);
    return name;
  }

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
   * check if has elevator
   * @return true if has elevator
   */
  public boolean hasElevator() {
    return this.hasElevator;
  }

  /**
   * check if the person is resident
   * @param person name of the person
   * @return true if is resident
   */
  public boolean isResidents(String person) {
    return this.residents.contains(person);
  }

  /**
   * print possible options
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + moveIn() \n + moveOut()" );
  }
  public static void main(String[] args) {
    
  }

}
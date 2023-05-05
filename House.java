import java.util.ArrayList;
/**
 * House class extends Building class
 */
public class House extends Building {
  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, 
              ArrayList<String> residents, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = residents;
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  public int nResidents() {
    return this.residents.size();
  }

  public void moveIn(String name) {
    // int len = this.nResidents();
    // ArrayList<String> newResidents = new ArrayList<String>(len+1);
    // for (int i = 0; i < len+1; i++){
    //   newResidents.add(this.residents[i]);
    // }
    this.residents.add(name);
  }

  public String moveOut(String name) {
    this.residents.remove(name);
    return name;
  }

  public boolean isResidents(String person) {
    return this.residents.contains(person);
  }

  public void showOptions() {
    super.showOptions();
    System.out.println(" + moveIn() \n + moveOut()" );
  }
  public static void main(String[] args) {
    House myHouse = new House("This House", "whatever address", 3, null, false);
    myHouse.showOptions();
  }

}
/**
 * Building class with basic methods
 */
public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building

    /**
     * Default constructor
     */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /**
     * Overloaded constructor with address only
     * @param address String building address
     */
    public Building(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /**
     * Overloaded constructor with name, address
     * @param name name of the building
     * @param address address of the building
     */
    public Building(String name, String address) {
        this(name, address, 1); // Call full constructor with hard-coded # floors
    }

    /**
     * Full constructor
     * @param name building name
     * @param address building address
     * @param nFloors total number of floors
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Accessors 
     * @return building name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessors 
     * @return building address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Accessors 
     * @return total number of floors
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * Enter the building
     * @return return the building entered
     */
    public Building enter() {
        if (activeFloor != -1) {
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
    }

    /**
     * Exit the building
     * @return return the building left
     */
    public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
        return null; // We're outside now, so the building is null
    }

    /**
     * Go to a specific floor
     * @param floorNum The floor number want to go to
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
     * Go up one floor
     */
    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }

    /**
     * Go down one floor
     */
    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

    /**
     * Show a list of methods
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /**
     * Overrided toString method
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goToFloor(3);
        fordHall.goDown();
        fordHall.goDown();
        fordHall.exit();

    }

}

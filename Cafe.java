/**
 * Cafe class extends Building class
 */
public class Cafe extends Building{

    private int nCoffeeOunces = 10; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets = 10; // The number of sugar packets remaining in inventory
    private int nCreams = 10; // The number of "splashes" of cream remaining in inventory
    private int nCups = 10; // The number of cups remaining in inventory
    private boolean hasElevator = false;

    /**
     * default constructor
     */
    public Cafe() {
        super();
    }

    /**
     * construct a cafe with name address and nFloors
     * @param name cafe name
     * @param address cafe address
     * @param nFloors number of floors 
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
    }

    /**
     * full constructor
     * @param name cafe name
     * @param address cafe address
     * @param nFloors number of floors
     * @param nCoffeeOunces number of coffee
     * @param nSugarPackets number of sugar packets
     * @param nCreams number of creams
     * @param nCups number of cups
     * @param hasElevator whether has elevator
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator) {
        super(name, address, nFloors);
        if (nCoffeeOunces != -1) { this.nCoffeeOunces = nCoffeeOunces; }
        if (nSugarPackets != -1) { this.nSugarPackets = nSugarPackets; }
        if (nCreams != -1) { this.nCreams = nCreams; }
        if (nCups != -1) { this.nCups = nCups; }
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * sell coffee
     * @param size coffee required
     * @param nSugarPackets sugar packets required
     * @param nCreams creams required
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < nCoffeeOunces) {throw new RuntimeException("Need " + nCoffeeOunces + "coffee ounces, but only have " + this.nCoffeeOunces); }
        if (this.nSugarPackets < nSugarPackets) {throw new RuntimeException("Need " + nSugarPackets + "sugar packets, but only have " + this.nSugarPackets); }
        if (this.nCreams < nCreams) {throw new RuntimeException("Need " + nCreams + "Creams, but only have " + this.nCreams); }
        if (this.nCups < 1) {throw new RuntimeException("No more cups!"); }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    /**
     * restock
     * @param nCoffeeOunces coffee restocked
     * @param nSugarPackets sugar packets restocked
     * @param nCreams cream restocked
     * @param nCups cups restocked
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restock! \nCoffeeOuwnces: " + this.nCoffeeOunces + "\nSugarPacket: " + this.nSugarPackets + "\nCreams: "+ this.nCreams + "\nCups: " + this.nCups);
    }

    /**
     * show possible methods
     */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee() \n + restock() \n + goToFloor()" );
    }

    /**
     * Go to a designated floor
     * @param floorNum the number of floor want to go
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

    public static void main(String[] args) {
        Cafe myCafe = new Cafe("null", "null", 4, 0, 0, 0, 0, false);
        myCafe.showOptions();
        myCafe.enter();
        myCafe.restock(10, 10, 10, 10);
    }
    
    
}

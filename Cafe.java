/**
 * Cafe class extends Building class
 */
public class Cafe extends Building{

    private String name;
    private String address;
    private int nFloors;
    private int activeFloor = -1;
    private int nCoffeeOunces = 10; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets = 10; // The number of sugar packets remaining in inventory
    private int nCreams = 10; // The number of "splashes" of cream remaining in inventory
    private int nCups = 10; // The number of cups remaining in inventory
    private boolean hasElevator = false;


    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator) {
        super(name, address, nFloors);
        if (nCoffeeOunces != -1) { this.nCoffeeOunces = nCoffeeOunces; }
        if (nSugarPackets != -1) { this.nSugarPackets = nSugarPackets; }
        if (nCreams != -1) { this.nCreams = nCreams; }
        if (nCups != -1) { this.nCups = nCups; }
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe: ☕");
    }

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

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restock! \nCoffeeOuwnces: " + this.nCoffeeOunces + "\nSugarPacket: " + this.nSugarPackets + "\nCreams: "+ this.nCreams + "\nCups: " + this.nCups);
    }

    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee() \n + restock()" );
    }

    public void goUp(int nFloors) {
        if (nFloors < this.activeFloor || nFloors > this.nFloors) {
            throw new RuntimeException("The floor number should be greater than " + this.activeFloor + " and less than " + this.nFloors);
        }
        if (nFloors - this.activeFloor >1 && this.hasElevator) {
            System.out.println("Using the elevator!");
            this.goToFloor(nFloors);
        } else if (nFloors - this.activeFloor == 1) {
            this.goUp();
        } else {
            for (int i = 0; i < (nFloors-this.activeFloor); i++) {
                this.goUp();
            }
        }
    }

    public void goToFloor(int floorNum) {
        if (this.hasElevator) {
            if (this.activeFloor == -1) {
                throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
            }
            if (floorNum < 1 || floorNum > this.nFloors) {
                throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
            }
            System.out.println("You are at floor " + );
        } else {
            super.goToFloor(floorNum);
        }
    }

    public static void main(String[] args) {
        Cafe myCafe = new Cafe("null", "null", 4, 0, 0, 0, 0, false);
        myCafe.showOptions();
        myCafe.enter();
        myCafe.goUp(4);
        myCafe.restock(10, 10, 10, 10);
    }
    
    
}

//Polymorphism - As it refers back to the Superclass. IS-A relationship
public final class Potion extends Item{
    //A potion can have its own amount of healing power.
    private int hpIncrease;
    //Here we can create our own potions by inserting the data that makes up a potion.
    public Potion(String itemName, int itemQuantity, int hpIncrease){
        super(itemName, itemQuantity);
        this.hpIncrease = hpIncrease;
    }
    //Returns the healing power of the potion.
    public int getHPIncrease(){
        return this.hpIncrease;
    }
    //Returns the healing power of the potion.
    public int setHPIncrease(int hpIncrease){
        return this.hpIncrease = hpIncrease;
    }
}
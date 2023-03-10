//Polymorphism - As it refers back to the Superclass. IS-A relationship
public final class Armour extends Item{
    private int armourResistance;
    public Armour(String itemName, int itemQuantity, int armourResistance){
        super(itemName, itemQuantity);
        this.armourResistance = armourResistance;
    }
    public int getArmourResistance(){
        return armourResistance;
    }
    public void setArmourResistance(int armourResistance){
        this.armourResistance = armourResistance;
    }
}
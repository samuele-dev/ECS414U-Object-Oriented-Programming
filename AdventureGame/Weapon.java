//Polymorphism - As it refers back to the Superclass. IS-A relationship
public final class Weapon extends Item{
    //A weapon can do its own damage.
    private int weaponDamage;
    //Here we can create our own weapons by inserting the data that makes up a weapon.
    public Weapon(String itemName, int itemQuantity, int weaponDamage){
        super(itemName, itemQuantity);
        this.weaponDamage = weaponDamage;
    }
    //Returns the damage of the weapon.
    public int getWeaponDamage(){
        return weaponDamage;
    }
    //Sets the damage of the weapon.
    public void setWeaponDamage(int weaponDamage){
        this.weaponDamage = weaponDamage;
    }
}
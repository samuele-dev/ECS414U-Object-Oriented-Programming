//Use of inheritance by using extends.
public class Player extends Character{
    //Instance varibles - Attributes that make a Player.
    //Player can equip potion to increase health.
    private Potion potion = null;
    //Player can hold items using inventory.
    public Inventory inventory;
    //Player can gain XP which will then affect game battle.
    private int storeXP;
    //Constructor - 
    public Player(String name, int health, int attackDamage){
        super(name, health, attackDamage);
        this.inventory = new Inventory();
    }
    //Player behaviour methods
    //@Override
    //Allows the player to attack the enemy.
    protected void attack(Enemy enemy){
        int damageTaken;
        //If player reaches a certain amount of XP, then there attack increases
        if(getStoreXP() > 30){
            System.out.println("You have reached more than 30xp.\nEvery attack made gets added by 2 only if player decides not to equip any weapon items throughout the game.");
            damageTaken = getAttackDamage() + 3;
        }
        else{
            damageTaken = getAttackDamage();
        }
        System.out.println("You attacked the " + enemy.getName() + " by " + damageTaken + ".");
        enemy.decreaseHealth(damageTaken);
    }
    //Player can see there statistics.
    protected void statistics(){
        System.out.println("------|PLAYER STATS|------");
        System.out.println("Name: " + getName());
        System.out.println("HP: " + getHealth() + "/100");
        //If player XP is greater than 30 it will show user that they have a bonous amount of attack damage.
        if(getStoreXP() > 30){
            System.out.println("Attack: " + getAttackDamage() + " + 3.");
        }
        else{
            System.out.println("Attack: " + getAttackDamage());
        }
        System.out.println("--------------------------");
    }
    //Overide
    protected void selfIncreaseHP(){}
    protected void increaseAD(){}
    //Encapsulation - GET & SET - For Player
    //Allows the player to equip the potion.
    public void setPotion(Potion potion){
        this.potion = potion;
        if(increaseHealth(potion.getHPIncrease()) == true){
            System.out.println("Potion has been equipped.");
        }
    }
    //Shows what potion is being used.
    public Potion getPotion(){
        return potion;
    }
    //Returns the amount of player XP.
    public int getStoreXP(){
        return storeXP;
    }
    //Player xp can be increased using this method.
    public void setStoreXP(int xpValueGiven){
        this.storeXP += xpValueGiven;
    }

}
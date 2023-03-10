//Abstract as some methods are not concrete.
public abstract class Character{
    //State - Instance variables - Attributes that make a character.
    private String name;
    private int health;
    private int attackDamage;
    //Constructor allows me to set data to character.
    public Character(String name, int health, int attackDamage){
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
    }
    //Behaviour - Operation methods
    //Protected - Only accessed superclass and subclass.
    //Check if character is alive or dead.
    //Final method used as it cannot be overridden.
    protected final boolean isAlive(){
        return this.health > 0;
    }
    protected final boolean isDead(){
        return !isAlive();
    }
    //@Override
    //Character can attack. Not abstract but overrided in player class & enemy.
    protected void attack(Character character){
        int damageTaken = getAttackDamage();
        if(this instanceof Player){
            System.out.println("You attacked " + character.getName() + " by " + damageTaken + ".");
        } 
        else{
            System.out.println(this.getName() + " hits you for " + damageTaken + ".");
        }
        character.decreaseHealth(damageTaken);
    }
    //Character statistics - No code as it is an abstract method. i.e. dummy method
    protected abstract void statistics();
    //Character health can be increased based on events that occur within the game.
    //If character health is not less than 100 then they cannot increase health.
    protected final boolean increaseHealth(int healthIncreased){
        if(this.health < 100){
            this.health += healthIncreased;
            System.out.println("Health increased by " + healthIncreased + ".");
            return true;
        }
        else{
            System.out.println("Invalid move. Your health is " + this.health + "/100.");
        }
        return false;
    }
    //Character health is decreased by the amount of damage they have taken.
    protected final void decreaseHealth(int damageTaken){
        this.health -= damageTaken;
    }
    //Encapsulation - GET & SET - For Character
    //Gets the character name
    public String getName(){
        return this.name;
    }
    //Gets the health of the character
    public int getHealth(){
        return this.health;
    }
    //Gets the attack damage of the character.
    public int getAttackDamage(){
        return this.attackDamage;
    }
    //Sets the name of the character
    public void setName(String name){
        this.name = name;
    }
    //Sets the health of the character
    public void setHealth(int health){
        this.health = health;
    }
    //Sets the attack damage of the character.
    public void setAttackDamage(int attackDamage){
        this.attackDamage += attackDamage;
    }
}

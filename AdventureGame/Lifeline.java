public final class Lifeline extends Player{
    //State - Instance variable
    //This character can increase there health.
    private int selfHPIncrease;
    //Constructor - Data which makes the character lifeline.
    public Lifeline(String name, int health, int attackDamage){
        super("Lifeline", 100, 5);
        this.selfHPIncrease = 3;
    }
    //Check is Lifeline has the ability or not.
    //Must be greater than 0 for Lifeline to have the ability.
    private final boolean hasAbility(){
        return this.selfHPIncrease > 0;
    }
    //Special Ability
    //Here the character can heal themselves. - override
    protected final void selfIncreaseHP(){
        //Checks if they have the ability
        if(hasAbility()){
            //If they do have the ability...
            //but there health is equal to 100, then they cannot use it as they have the maxium health.
            if(this.getHealth() == 100){
                System.out.println("Invalid move. Your health is " + this.getHealth() + "/100.");
            }
            //but if the health is between  1 or 99 then they can use the ability.
            if(this.getHealth() > 0 && this.getHealth() < 100){
                //Method which increases the health of the character the user plays.
                increaseHealth(3);
                //Removes the ability if it has been used.
                removeSpecialAbility();
                System.out.println("Health increased to " + this.getHealth() + "/100.");
            }
            System.out.println("Special Ability left: " + getSelfHPIncrease() + "/3.");
        }
        //if they do not have the ability, nothing happens just that they are informed that they do not have the ability.
        else{
            System.out.println("You ran out of your special ability.");
        }
    }
    //Method reduces the instance variable by 1 if user uses ability.
    private final void removeSpecialAbility(){
        this.selfHPIncrease--;
    }
    //Returns the value of the amout of self increase they have.
    public int getSelfHPIncrease(){
        return this.selfHPIncrease;
    }
}
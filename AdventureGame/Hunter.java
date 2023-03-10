public final class Hunter extends Player{
    //State - Instance Variables
    //This character can increase there damage.
    private int selfIncreaseAttack;
    //Constructor - Data which makes the character hunter.
    public Hunter(String name, int health, int attackDamage){
        super("Hunter", 100, 3);
        this.selfIncreaseAttack = 1;
    }
    //Overide
    //Here the character can increase damage.
    protected void increaseAD(){
        //Checks if they have the ability
        if(hasAbility()){
            //If they do have the ability, then increase the attack damage by 2.
            this.setAttackDamage(2);
            System.out.println("Special ability used.\nAttack increased by 2.");
            //Remove the ability as they can only use it once in battle.
            removeSpecialAbility();
        }
        //Player has no increase damage ability left.
        else{
            System.out.println("You ran out of your special ability.");
        }
    }
    //Check is Hunter has the ability or not.
    //Must be greater than 0 for Hunter to have the ability.
    private final boolean hasAbility(){
        return this.selfIncreaseAttack > 0;
    }
    //Method reduces the instance variable by 1 if user uses ability.
    private final void removeSpecialAbility(){
        this.selfIncreaseAttack--;
    }
}
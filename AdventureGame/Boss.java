import java.util.Random;
public class Boss extends Enemy{
   //Bosses can have weapons. Therefore we must equip a weapon to the boss.
   private Weapon weapon = equipWeapon();
   //Constructor - Data which makes up the boss.
   public Boss(String name, int health, int attackDamage, int level){
       super("Big Boss", 30, 15, 3);
   }
   //Check if boss has weapon or not.
   protected boolean hasWeapon(){
       return this.weapon != null;
   }
    //Not used at the moment
   protected boolean noWeapon(){
       return !hasWeapon();
   }
   //Allows the Boss to equip a weapon which is randomly generated.
   private final Weapon equipWeapon(){
       Random rand = new Random();
       Weapon[] gameItems = new Weapon[] {
            new Weapon("Wooden Sword", 1, 10), 
            new Weapon("Iron Sword", 1, 15),
            new Weapon("Diamond Sword", 1, 20)};
            //Based on these swords, this is what the boss will have.
       return weapon = (gameItems[rand.nextInt(gameItems.length)]);
   }
   //@Override
   protected void attack(Player player){
        int damageTaken;
        if(hasWeapon()){
            damageTaken = weapon.getWeaponDamage();
        }
        else{
            damageTaken = getAttackDamage();
        }
        System.out.println(getName() + " hit you by " + damageTaken + ".");
        player.decreaseHealth(damageTaken);
   }
   //Statistics of the enemy to show what there stats are.
   protected void statistics(){
        System.out.println("------|BOSS STATS|------");
        System.out.println("Name: " + getName());
        System.out.println("HP: " + getHealth() + "/100");
        //If the boss as a weapon then it will show the user what weapon they have and the ttack damage of the weapon.
        if(hasWeapon()){
            System.out.println(weapon.getItemName() + " Attack: " + weapon.getWeaponDamage());
        }
        //Or if they do not have a weapon, then it will just show the the normal attacking damage.
        else{
            System.out.println("Attack: " + getAttackDamage());
        }
        System.out.println("Level: " + getLevel());
        System.out.println("--------------------------");
   }
   //Equips the weapon to the boss.
   public void setWeapon(Weapon weapon){
        this.weapon = weapon;
   }
   //Returns what weapon is being used by the boss.
   public Weapon getWeapon(){
       return weapon;
   }
}
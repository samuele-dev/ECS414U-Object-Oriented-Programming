import java.util.Random;
public class Enemy extends Character{
    //Instance varibles - Attributes that make a Enemy.
    //Generates the name, health and attack damage of the enemy.
    private static final String[] enemies = {"Radscorpion","Warrior","Zombie","Deathclaw","Beebomb","Goomba"};
    private static int maxHealth = 25;
    private static int minHealth = 15;
    private static int maxDamage = 15;
    private static int minDamage = 5;
    //Enemies can have diffrent levels and xp. Which affects the game play when in battle.
    private int level;
    private int xp;
    //Constructor - Here enemy data is enetered.
    public Enemy(String name, int health, int attackDamage, int level){
        super(name, health, attackDamage);
        this.level = level;
    }
    //Based on the enemy level, if the enemy level is at a certain amount, that affects the players amount of xp they gain.
    public void giveXP(Enemy enemy, Player player){
        //If enemy is level 1 then player gets 4 xp. etc.
        if(enemy.getLevel() == 1){
            enemy.setXP(4);
            player.setStoreXP(enemy.getXP());
            System.out.println("You gained 4xp.");
        }
        if(enemy.getLevel() == 2){
            enemy.setXP(6);
            player.setStoreXP(enemy.getXP());
            System.out.println("You gained 6xp.");
        }
        if(enemy.getLevel() == 3){
            enemy.setXP(8);
            player.setStoreXP(enemy.getXP());
            System.out.println("You gained 8xp.");
        }
    }
    
    //Enemy behaviour methods
    //Enemy data is generated randomly and the data is passed to the constructor.
    public static Enemy randomEnemySpawn(){
        Random rand = new Random();
        return new Enemy(enemies[rand.nextInt(enemies.length)], rand.nextInt((maxHealth - minDamage) + minDamage), rand.nextInt((maxDamage - minDamage)+ minDamage), rand.nextInt(3)+1);
    }
    //@Override
    //Enemy can attack the player.
    protected void attack(Character player){
        int damageTaken = getAttackDamage();
        System.out.println(getName() + " hit you by " + damageTaken + ".");
        //Method that decreases the health of the player when enemy attacks.
        player.decreaseHealth(damageTaken);
    }
    //Player can see the statistics of the enemy. 
    protected void statistics(){
        System.out.println("------|ENEMY STATS|------");
        System.out.println("Name: " + getName());
        System.out.println("HP: " + getHealth() + "/100");
        System.out.println("Attack: " + getAttackDamage());
        System.out.println("Level: " + getLevel());
        System.out.println("--------------------------");
    }
    
    //Encapsulation - GET & SET - For Enemy
    //Returns the enemy level
    public int getLevel(){
        return level;
    }
    //Sets the enemy level
    public void setLevel(){
        this.level = level;
    }
    //Returns the enemy XP.
    public int getXP(){
        return xp;
    }
    //Sets the enemy XP
    public void setXP(int levelXp){
        this.xp = levelXp;
    }
}

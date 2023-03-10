
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class TestGame{
    //Allows us to access the inventory of the player.
    public static Inventory inventory;
    //Here is where the code runs.
    public static void TestGame(){ 
        //We need a randomiser to randomly select things.
        Random rand = new Random();
        //Shows the user a welcome message and the characters the player can choose from.
        welcome();
        hunterInfo();
        lifelineInfo();
        System.out.println("");
        //Depending on what character the player chooses, that constructor will be used.  
        Player player = (selectPlayer().equals("Lifeline"))? new Lifeline("Lifeline", 10, 5) : new Hunter("Hunter", 10, 5);
        //Enemy enemy;
        //Gives a story line.
        System.out.println("You are trapped in a cave. Your objective is to get out."); 
        System.out.println("There are 9 rooms to be explored before you can get out.");
        System.out.println("Some rooms may contain items or enemies.\nYou must go forward to continue your adventure.");
        //While the player is alive they can do the following.
        while(player.isAlive()){
            //Count is to shorten code. 9 rooms can be decreased to 3 rooms but looped 3 times to get 9 rooms.
            int count = 1; 
            while(count <= 3){
                //Player decides if they want to go forward or not.
                System.out.println("[1] Go Forward.");
                int movement = inputInt("Where do you want to go?");
                if(movement == 1){
                    //Player is put into a battle where they have to defeat the enemy.
                    battle(player);
                    System.out.println("[2] Go Forward.");
                    movement = inputInt("Where do you want to go?");
                    if(movement == 2){
                        //In the next room, they can get an item that will help them in the adventure.
                        itemDrop(player);
                        System.out.println("[3] Go Forward.");
                        movement = inputInt("Where do you want to go?");
                        if(movement == 3){
                            //Thrid room, there is a boss which the player has to defeat the boss. 
                            //Player goes into a battle boss method and are restricted on what they can do to make the game more tatical. 
                            battleBoss(player);
                            count++;
                        }
                    }
                }
            }
            //If player defeats all enemies and gets to the last room, they have escaped the cave.
            //Terminating the program.
            System.out.println("You escaped the cave!");
            System.exit(0);
        }
    }
    //Here the player can fight the enemy.
    public static void battle(Player player){
        //Enemy is randomly created and is the opponent for this round.
        Enemy enemy = Enemy.randomEnemySpawn();
        //Tells the user that an enemy has appered.
        System.out.println("A " + enemy.getName() + " has appered!");
        System.out.println("What do you want to do?");
        //Shows the statistics once for better visual understanding.
        int status = 0;
        //While the enemy is alive...
        while(enemy.isAlive()){
            //If status is zero then show the stats of the player and enemy once.
            if(status == 0){
                enemy.statistics();
                player.statistics();
                status = 1;
            }
            //Player options are shown.
            playerOptions();
            int playerSelects = inputInt("Enter Option: ");
            //If player selects the attack option then...
            if(playerSelects == 1){
                //Player attacks the enemy
                player.attack(enemy);
                //Enemy stats are shown to see how much damage has been done.
                enemy.statistics();
                //If the enemy is dead, then 
                if(enemy.isDead()) {
                    //show the user that they have defeated the enemy.
                    battleWon(enemy);
                    //give XP to the player.
                    enemy.giveXP(enemy, player);
                    //possibly drop an item and put that item into the player inventory.
                    itemBattleDrop(player,enemy);
                    break;
                }
                //Enemy then attacks the player.
                enemy.attack(player);
                //Player stats are shown to see how much damage the enemy has done.
                player.statistics();
                //If player dies then enemy wins and the game ends.
                if(player.isDead()) {
                    battleLost(enemy);
                }
            }
            //here the player can use the charcater special ability.
            else if(playerSelects == 2){
                //If player is an instance of lifeline then use this ability.
                if(player instanceof Lifeline){
                    player.selfIncreaseHP();
                }
                //If player is an instance of hunter then use this ability.
                if(player instanceof Hunter){
                    player.increaseAD();
                }
            }
            //View Inventory
            else if(playerSelects == 3){
                //Prints out player inventory.
                player.inventory.printInventory();
                inventoryOptions();
                int pOpSelects = inputInt("Option Selected: ");
                //If player decides they would like to equip an item
                if(pOpSelects == 4){
                    String itemSearch = input("Enter item name: ");
                    //Player need to add the name of item they wish to equip and then the player can equip item.
                    player.inventory.equipItem(itemSearch, player);
                }
                /*Return back to player options.
                else if(playerSelects == 5){
                    continue;
                }
                else{
                    System.out.println("Invalid inp.");
                }*/
            }
            //Run - Player may not want to defeat this enemy and move forward.
            else if(playerSelects == 6){
                System.out.println("You run away from the " + enemy.getName() + "!");
                break;
            }
            //If player enters an invalid move.
            else{
                System.out.println("\t>Invalid input.");
            }
        }
    }
    //Method which allows the player to select the character.
    private static String selectPlayer(){
        boolean selectPlayer = true;
        String characterName = "";
        //While this is true...
        while(selectPlayer){
            characterName = input("Enter character to play:");
            //If lifeline or hunter is entered then the while loop breaks allowing and the program knows which charcater
            //the user wants.
            if(characterName.equals("Lifeline")){
                break;
            }
            else if(characterName.equals("Hunter")){
                break;
            }
            //User inputs an incorrect value.
            else{
                System.out.println("Not a player in the game. Try again.");
            }
        }
        //Returns the name of the character the player has entered.
        return characterName;
    }
    //Game possibilites
    //If player wins battle then this method will show them who they defeated.
    private static void battleWon(Enemy enemy){
        System.out.println("You defeated the " + enemy.getName() + ".");
    }
    //If player dies, then it is game over for them.
    private static void battleLost(Enemy enemy){
        System.out.println(enemy.getName() + " ended you.");
        System.out.println("GAME OVER!");
        System.exit(0);
    }
    //Once the enemy is defeated, player is rewarded. 
    public static void itemBattleDrop(Player player,Enemy enemy){
        Random rand = new Random();
        //Possible items they can get.
        Item[] gameItems = new Item[] {
            new Potion("Light Potion", 1, 10), 
            new Potion("Standard Potion", 1, 20),
            new Potion("Heavy Potion", 1, 30)
        };
        //Has to greater than 65 to be able to get the item.
        int itemChance = rand.nextInt(100) + 1;
        if(itemChance > 65){
            //Enemy drops the item.
            System.out.println(enemy.getName() + " dropped an item!");
            //Item is then added to the inventory of the player.
            player.inventory.addItem(gameItems[rand.nextInt(gameItems.length)]);
        }
        //Else the enemy never had any items.
        else{
            System.out.println(enemy.getName() + " did not carry any items.");
        }
    }
    //Introduction of the game.
    private static void welcome(){
        System.out.println("|----------------------------|");
        System.out.println("|       ADVENTURE GAME       |");
        System.out.println("|----------------------------|");
        System.out.println(" --- Character Description --- ");
    }
    //Displays information about each character 
    private static void hunterInfo(){
        System.out.println("Name: Hunter");
        System.out.println("Attack: 3");
        System.out.println("Special Ability: Can increase\ndamage by 2 in battle once.");
    }
    private static void lifelineInfo(){
        System.out.println("");
        System.out.println("Name: Lifeline");
        System.out.println("Attack: 5");
        System.out.println("Special Ability: Can increase\nhealth by 3 in battle three times.");
    }
    //Item drop in game and not in battle.
    private static void itemDrop(Player player){
        Random rand = new Random();
        Item[] gameItems = new Item[] {
            new Potion("Light Potion", 1, 10), 
            new Potion("Standard Potion", 1, 20),
            new Potion("Heavy Potion", 1, 30)
        };
        //Item is added to player inventory.
        player.inventory.addItem(gameItems[rand.nextInt(gameItems.length)]);
    }
    //Player options when in normal battle.
    private static void playerOptions(){
        System.out.println("-------|PLAYER OPTIONS|-------");
        System.out.println("[1] Attack");
        System.out.println("[2] Use Special Ability");
        System.out.println("[3] View Inventory");
        System.out.println("[6] Run!");
        System.out.println("------------------------------");
    }
    //Player inventory options when in battle.
    private static void inventoryOptions(){
        System.out.println("------|INVENTORY OPTIONS|-----");
        System.out.println("[4] Equip Item");
        System.out.println("[5] Back to player options");
        System.out.println("------------------------------");
    }
    //Method that allows the user to input data.
    //Only for string inputs
    private static String input(String message){
        Scanner userInput = new Scanner(System.in);
        System.out.println(message);
        String answer = userInput.nextLine();
        return answer;
    }
    //Only for integer inputs.
    private static int inputInt(String message){
        return Integer.parseInt(input(message));
    }
    //Player options when in boss battle.
    private static void playerBossOptions(){
        System.out.println("-------|PLAYER OPTIONS|-------");
        System.out.println("[1] Attack");
        System.out.println("[2] View Inventory");
        System.out.println("------------------------------");
    }
    //Player takes on the boss of the game.
    public static void battleBoss(Player player){
        //A boss is created with specific data that makes up the boss.
        Boss boss = new Boss("Big Boss", 30, 15, 3);
        System.out.println("A boss " + boss.getName() + " has appered!");
        System.out.println("What do you want to do?");
        //Shows the statistics once for better visual understanding.
        int status = 0;
        //While the boss is alive...
        while(boss.isAlive()){
            //If status is zero then show the stats of the player and enemy once.
            if(status == 0){
                boss.statistics();
                player.statistics();
                status = 1;
            } 
            //Player options are shown.
            playerBossOptions();
            int playerSelects = inputInt("Enter Option: ");
            //If player selects the attack option then...
            if(playerSelects == 1){
                //Player attacks the enemy
                player.attack(boss);
                //Enemy stats are shown to see how much damage has been done.
                boss.statistics();
                //If the enemy is dead, then 
                if(boss.isDead()) {
                    //show the user that they have defeated the enemy.
                    battleWon(boss);
                    //give XP to the player.
                    boss.giveXP(boss, player);
                    //possibly drop an item and put that item into the player inventory.
                    itemBattleDrop(player,boss);
                    break;
                }
                //Enemy then attacks the player.
                boss.attack(player);
                //Player stats are shown to see how much damage the enemy has done.
                player.statistics();
                //If player dies then enemy wins and the game ends.
                if(player.isDead()) {
                    battleLost(boss);
                }
            }
            //View Inventory
            else if(playerSelects == 2){
                //Prints out player inventory.
                player.inventory.printInventory();
                inventoryOptions();
                int pOpSelects = inputInt("Option Selected: ");
                //If player decides they would like to equip an item
                if(pOpSelects == 4){
                    String itemSearch = input("Enter item name: ");
                    //Player need to add the name of item they wish to equip and then the player can equip item.
                    player.inventory.equipItem(itemSearch, player);
                }
                /*Return back to player options.
                else if(playerSelects == 5){
                    continue;
                }
                else{
                    System.out.println("Invalid inp.");
                }*/
            }
            //If player enters an invalid move.
            else{
                System.out.println("\t>Invalid input.");
            }
        }
    }
}
import java.util.ArrayList;
public class Inventory{
    //Here is where the actual items are stored in this arraylist.
    public ArrayList<Item> items;
    //Player Inventory - Start off with nothing. Player must progress.
    public Inventory(){
        //placed the arraylist so that it is initialised.
        this.items = new ArrayList<Item>();
        //this.items.add(new Potion("Light Potion", 1, 10));
    }
    //Player can equip item granting extra abilities.
    public final void equipItem(String itemSearch, Player player){
        //Goes through the items in the arraylist.    
        for(Item item : new ArrayList<>(items)){
            //if the item quantity is greater than 0 it means that the item exists.
            //If the player searches for that specific item by entering the name only then will the code execute.
                if(itemSearch.equals(item.getItemName()) && item.getQuantity() > 0){
                    //If item is an instance of the class Potion then...
                    if(item instanceof Potion){
                        //Player can set the potion which will allow them to increase health.
                        player.setPotion((Potion)item);
                    }
                    //Once used, it will be removed.
                    System.out.println(item.getItemName() + " has been removed from your inventory.");
                    items.remove(item);
                    //and the program breaks.
                    break;
                }
                //Else the item doesnt exist or is less than 0.
                else{
                    System.out.println("Not available.");
                }
            }
    }
    //Method allows items to be added.
    public void addItem(Item items){
        this.items.add(items);
        System.out.println(items.getItemName() + " has been added to your inventory.");
    }
    //Method allows items to be removed.
    public void removeItem(Item items){
        this.items.remove(items);
        System.out.println(items.getItemName() + " has been removed from your inventory.");
    }
    //Prints inventory of player.
    public final void printInventory(){
        System.out.println("Player Inventory:");
        for(int i=0; i < this.items.size(); i++){
            System.out.println("-------Item Details-------");
            System.out.println("Name: " + items.get(i).getItemName());
            System.out.println("Quantity: " + items.get(i).getQuantity());
            System.out.println("--------------------------");
        }
    }
}
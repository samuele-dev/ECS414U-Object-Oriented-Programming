//Use of inheritance with at least one superclass and three subclasses
public class Item{
    //States that make up an item.
    //Item must have a name and a quantity.
    private String itemName;
    private int quantity;
    
    public Item(String itemName, int quantity){
        this.itemName = itemName;
        this.quantity = quantity;
        //this.itemType = itemType;
    }
    //Increase/decrease item quantity.
    public void addQ(){
        this.quantity++;
    }
    public void removeQ(){
        this.quantity--;
    }
    //Gets the item name.
    public String getItemName(){
        return this.itemName;
    }
    //Gets the amount of items the player has.
    public int getQuantity(){
        return this.quantity;
    }   
}
package Items;


import java.util.ArrayList;

/**
 * An abstract class used for creating items
 */
public abstract class Item {
    protected String name;
    protected ArrayList<Integer> rooms;
    protected int id;

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
        rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Abstract method used for getting the description of the item
     * @return - returns String value of item's description
     */
    public abstract String getDescription();

    /**
     * Abstract method used for getting an effect if it has one
     * @return - returns String value of an effect if the item has one
     */
    public abstract String getEffect();

    /**
     * Abstract method which tells if the item has an effect or not
     * @return - true if item has an effect, otherwise false
     */
    public abstract boolean effect();

    /**
     * Abstract method which tells if the item is grabbable or not
     * @return - true if grabbable, otherwise false
     */
    public abstract boolean grabbable();
    /**
     * Abstract method which tells if the item is moveable or not
     * @return - true if moveable, otherwise false
     */
    public abstract boolean moveable();

    /**
     * A factory method used in MansionMap when adding items from a file to a room
     * @param itemName - name of the item which is being added
     * @return - returns a switch which creates an item depending on itemName
     */
    public static Item factory(String itemName, int id){
        return switch(itemName){
            case "Book" -> new Book(itemName, id);
            case "Gift" -> new Gift(itemName, id);
            case "Key" -> new Key(itemName, id);
            case "Lantern" -> new Lantern(itemName, id);
            case "NightVis" -> new NightVisPotion(itemName, id);
            case "Note" -> new Note(itemName, id);
            case "Statue" -> new Statue(itemName, id);
            case "TpPotion" -> new TpPotion(itemName, id);
            default -> null;
        };
    }
}

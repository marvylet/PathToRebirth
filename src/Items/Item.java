package Items;


import java.util.ArrayList;

public abstract class Item {
    private String name;
    private ArrayList<Integer> rooms;

    public Item(String name) {
        this.name = name;
        rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public abstract String getDescription();

    public abstract String getEffect();

    public abstract boolean effect();

    public abstract boolean grabbable();

    public abstract boolean moveable();

    public static Item factory(String itemName){
        return switch(itemName){
            case "Book" -> new Book(itemName);
            case "Gift" -> new Gift(itemName);
            case "Key" -> new Key(itemName);
            case "Lantern" -> new Lantern(itemName);
            case "NightVis" -> new NightVisPotion(itemName);
            case "Note" -> new Note(itemName);
            case "Statue" -> new Statue(itemName);
            case "TpPotion" -> new TpPotion(itemName);
            default -> null;
        };
    }
}

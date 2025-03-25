package Commands;

import Items.Item;
import Items.Note;
import Map.Inventory;
import Map.MansionMap;

import java.util.Scanner;

public class Grab extends Command{
    private Inventory inv;
    private Item item;
    private MansionMap map;
    private Scanner sc;

    public Grab(Inventory inv, MansionMap map) {
        this.inv = inv;
        this.map = map;
        this.sc = new Scanner(System.in);
    }

    //searched up "instanceof" on https://stackoverflow.com/questions/541749/how-to-determine-an-objects-class
    //as I have forgotten how exactly we wrote it
    @Override
    public String execute() {
        if(map.getLocations().get(map.getCurrentLoc()).getItems() == null){
            return "No items";
        }
        System.out.println("Items in this room:");
        System.out.print(map.getLocations().get(map.getCurrentLoc()).viewItems());
        String s = sc.next();

        return inv.addItem(map.getLocations().get(map.getCurrentLoc()).viewItem(s));

    }

    @Override
    public boolean exit() {
        return false;
    }
}

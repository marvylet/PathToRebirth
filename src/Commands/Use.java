package Commands;

import Items.Item;
import Map.Inventory;
import Map.MansionMap;

import java.util.Random;
import java.util.Scanner;

/**
 * A command used for when player wants to use an item
 */
public class Use extends Command {
    private Scanner sc;
    private Inventory inv;
    private MansionMap map;
    private Random rd;

    public Use(Inventory inv, MansionMap map, Scanner sc) {
        this.inv = inv;
        this.map = map;
        this.sc = sc;
        rd = new Random();
    }

    /**
     * If there are no items in inventory, notifies the player.
     * Views inventory and lets player choose, if it's a teleportation potion, applies its effect.
     * @return - returns the effect of the item used or if it doesn't have one.
     */
    @Override
    public String execute() {
        if (inv.getItems().isEmpty()) {
            return "No items to use.";
        } else {
            System.out.println("Your inventory:" + inv.viewInventory());
            String item = sc.next();
            String pot = "";

            if (item.equals("TpPotion") && inv.containsItem("TpPotion")) {
                map.setCurrentLoc(rd.nextInt(20) + 1);
                pot = inv.effect("TpPotion");
                inv.removeItem("TpPotion");
            }

            return pot;
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}

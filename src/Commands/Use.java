package Commands;

import Map.Inventory;
import Map.MansionMap;

import java.util.Random;
import java.util.Scanner;

public class Use extends Command {
    private Scanner sc;
    private Inventory inv;
    private MansionMap map;
    private Random rd;

    public Use(Inventory inv, MansionMap map) {
        this.inv = inv;
        this.map = map;
        sc = new Scanner(System.in);
        rd = new Random();
    }

    @Override
    public String execute() {
        if (inv.getItems().isEmpty()) {
            return "No items to use.";
        } else {
            System.out.println("Your inventory:" + inv.viewInventory());
            String item = sc.next();

            if (item.equals("TpPotion") && inv.containsItem("TpPotion")) {
                map.setCurrentLoc(rd.nextInt(20) + 1);
                inv.removeItem("TpPotion");
            }

            return inv.effect(item);
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}

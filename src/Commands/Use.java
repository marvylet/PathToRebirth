package Commands;

import Map.Inventory;

import java.util.Scanner;

public class Use extends Command {
    private Scanner sc;
    private Inventory inv;

    public Use(Inventory inv) {
        this.inv = inv;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {
        if(inv.getItems().isEmpty()){
            return "No items to use.";
        }else {
            System.out.println("Your inventory:" + inv.viewInventory());
            String item = sc.next();

            return inv.effect(item);
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}

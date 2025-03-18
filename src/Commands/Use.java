package Commands;

import Map.Inventory;

import java.util.Scanner;

public class Use extends Command {
    private Scanner sc;
    private Inventory inv;
    @Override
    public String execute() {
        sc = new Scanner(System.in);
        String item = sc.nextLine();
        return inv.effect(item);
    }

    @Override
    public boolean exit() {
        return false;
    }
}

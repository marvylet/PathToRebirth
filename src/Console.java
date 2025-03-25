import Commands.*;
import Map.Inventory;
import Map.MansionMap;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> commands;
    private Scanner sc;
    private MansionMap map;
    private Inventory inv;

    public Console() {
        inv = new Inventory();
        map = new MansionMap(inv);
        map.spawnRooms();
        start();
    }

    private void inicialize(){
        commands = new HashMap<>();
        sc = new Scanner(System.in);

        commands.put("go", new GoTo(map));
        commands.put("grab", new Grab(inv, map));
        commands.put("interact", new Interact(inv, map));
        commands.put("move", new MoveItem(inv, map));
        commands.put("diary", new OpenDiary(inv));
        commands.put("inventory", new OpenInventory(inv));
        commands.put("talk", new TalkTo(map));
        commands.put("use", new Use());
        commands.put("exit", new CloseGame());
        commands.put("help", new Help());

    }

    private void doCommand(){
        System.out.println("What would you like to do?");
        System.out.print("> ");
        String command = sc.next();
        if(commands.containsKey(command)){
            System.out.println(commands.get(command).execute());
            exit = commands.get(command).exit();
        }else{
            System.out.println("Not one of the commands.");
        }
    }

    public void start(){

        inicialize();

        do{
            doCommand();
        }while(!exit);

    }
}

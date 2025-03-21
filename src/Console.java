import Commands.*;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> commands;
    private Scanner sc;

    private void inicialize(){
        commands = new HashMap<>();
        sc = new Scanner(System.in);

        commands.put("go", new GoTo());
        commands.put("grab", new Grab());
        commands.put("interact", new Interact());
        commands.put("move", new MoveItem());
        commands.put("diary", new OpenDiary());
        commands.put("inventory", new OpenInventory());
        commands.put("talk", new TalkTo());
        commands.put("use", new Use());
    }

    private void doCommand(){
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

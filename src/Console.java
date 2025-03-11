import Commands.*;

import java.util.HashMap;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> commands;

    private void inicialize(){
        commands = new HashMap<>();

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

    }

    private void start(){}
}

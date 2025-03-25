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

    private void inicialize() {
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

    private void doCommand() {
        System.out.println("What would you like to do?");
        System.out.print("> ");
        String command = sc.next();
        if (commands.containsKey(command)) {
            System.out.println(commands.get(command).execute());
            exit = commands.get(command).exit();
        } else {
            System.out.println("Not one of the commands.");
        }
    }

    public void start() {

        inicialize();

        System.out.println("""
                You wake up, dizzy, in an unknown room. As you look around, you quite can't seem to remember anything.
                What is this place? How did I get here? Who... am I?
                The only thing you can remember is your nickname, Connie.
                You don't know what this place is, but the feeling from it is very... unpleasing. You should try to leave as soon as possible.
                
                Type "help" to list all available commands.
                """);

        do {
            doCommand();

            if (ending()) {
                System.out.println("""
                        "After discovering the mysteries of the realm, you managed to find your true self...
                        Orson... you knew he was always distant, but to think this is why...
                        Your name... is Constance Levine. You used to be Orson's wife, before he murdered you.
                        Are you able to truly forget and forgive all of this? Will you be able to take up the second chance in life?
                        Even if you now know the truth?"
                        
                            yes/no
                        """);
                while (!exit) {
                    String finalAnswer = sc.next();
                    switch (finalAnswer) {
                        case "yes":
                            System.out.println("""
                                    "Very well so... I knew my beliefs about you wouldn't be in vain.
                                    So go on, enjoy your second chance at life, and walk right out that door!"
                                    
                                    You looked back at the house, at the hallway, before finally opening the door.
                                    It was so bright outside, you haven't seen that in a long time.
                                    It is time to bid this place farewell, and say hello to Life.
                                    """);
                            exit = true;
                            break;
                        case "no":
                            System.out.println("""
                                    "... Well, alright then. It is understandable, really, but... can't say I'm not disappointed.
                                    Oh well. It is your decision after all, to be suffering here forever, while your body is long gone, rotting in a grave.
                                    I hope you're happy with your decision."
                                    
                                    You watched, as the door immediately closed shut, locking itself on its own again.
                                    Was this truly the right choice? You don't know, but what you do know is that you can't forgive him or yourself for what had happened.
                                    """);
                            exit = true;
                            break;
                        default:
                            System.out.println("""
                                    "... Couldn't quite understand that. I'll ask again, are you truly able to move on?"
                                    """);
                    }

                }
            }

        }while(!exit);
    }

    //Didn't try going through the full game and finding all the keys, but when I changed the number of notes needed and attempted it, it worked.
    public boolean ending() {
        if (inv.getNotes().size() == 6) {
            return true;
        }
        return false;
    }
}


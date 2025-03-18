package Commands;

import Map.MansionMap;

import java.util.Scanner;

public class TalkTo extends Command {
    private Scanner sc;
    private MansionMap map;
    private Character character;
    @Override
    public String execute() {
        sc = new Scanner(System.in);

        System.out.println("You can talk to:");
        System.out.println(map.getLocations().get(map.getCurrentLoc()).viewChararacters());
        String s = sc.next();

        if(map.getLocations().get(map.getCurrentLoc()).getCharacters().contains(character)) {
            return map.getLocations().get(map.getCurrentLoc()).getCharacters().get(Integer.parseInt(s)).getDialogue();
        }
        return "No such character";
    }

    @Override
    public boolean exit() {
        return false;
    }
}

package Commands;

import Map.MansionMap;
import Characters.Character;

import java.util.Scanner;

public class TalkTo extends Command {
    private Scanner sc;
    private MansionMap map;

    public TalkTo(MansionMap map) {
        this.map = map;
        sc = new Scanner(System.in);
    }

    @Override
    public String execute() {
        if(map.getLocations().get(map.getCurrentLoc()).getCharacters().size() == 0){
            return "Nobody to talk to";
        }
        System.out.println("You can talk to:");
        System.out.print(map.getLocations().get(map.getCurrentLoc()).viewChararacters());
        String s = sc.next();

        return map.getLocations().get(map.getCurrentLoc()).talkToChar(s);
    }

    @Override
    public boolean exit() {
        return false;
    }
}

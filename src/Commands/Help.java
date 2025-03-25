package Commands;

public class Help extends Command{
    @Override
    public String execute() {
        return """
                Here's a list of available commands:
                    go - allows you to move rooms
                    grab - allows you to grab an item
                    interact - allows you to attempt to unlock a door
                    move - allows you to move an item if able to
                    diary - opens your diary to see the number of notes you currently have
                    invetory - opens your inventory
                    talk - allows you to talk to someone if anyone is in the room
                    use - allows you to use a potion if you have any
                    exit - allows you to exit and end the game
                """;
    }

    @Override
    public boolean exit() {
        return false;
    }
}

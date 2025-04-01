package Commands;

/**
 * An abstract Command class pattern, thanks to which the player is able to do anything while also replacing a switch
 */
public abstract class Command {

    /**
     * The execute method which returns what the specific command does
     * @return - returns String value of what the specific command does
     */
    public abstract String execute();

    /**
     * An exit method which checks if thanks to this command the player can exit the game
     * @return - returns true if they can exit, false if not
     */
    public abstract boolean exit();
}

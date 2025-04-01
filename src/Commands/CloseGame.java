package Commands;

import java.util.Scanner;

/**
 * A command which works for when the player wants to close the game.
 */
public class CloseGame extends Command {
    private boolean exit;

    /**
     * A method which asks the player if they really want to exit, afterwards lets them choose if yes, or no.
     * @return - returns either confirmation of exiting or failure to answer depending on the player's option.
     */
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you sure you want to exit?");
        String answer = sc.next();

        if(answer.equalsIgnoreCase("yes")){
            exit = true;
            return "Closing program...";
        }else{
            exit = false;
            return "Failed to answer.";
        }
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    /**
     *
     * @return - returns the exit value depending on what the player chose in execute
     */
    @Override
    public boolean exit() {
        return exit;
    }
}

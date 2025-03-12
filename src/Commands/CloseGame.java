package Commands;

import java.util.Scanner;

public class CloseGame extends Command {
    private boolean exit;

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

    @Override
    public boolean exit() {
        return exit;
    }
}

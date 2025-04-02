package Tests;

import Commands.CloseGame;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CloseGameTest {
    Scanner sc = new Scanner(System.in);
    CloseGame closeGame = new CloseGame(sc);

    @Test
    void execute() {
        //assertEquals("Closing program...", closeGame.execute());
    }

    @Test
    void exit() {
        closeGame.setExit(true);
        assertEquals(true, closeGame.exit());
    }
}
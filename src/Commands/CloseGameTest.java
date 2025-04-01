package Commands;

import Map.Inventory;
import Map.MansionMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloseGameTest {
    CloseGame closeGame = new CloseGame();

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
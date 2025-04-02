package Tests;

import Commands.TalkTo;
import Map.Inventory;
import Map.MansionMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TalkToTest {
    Inventory inv = new Inventory();
    MansionMap map = new MansionMap(inv);
    TalkTo t = new TalkTo(map);

    @Test
    void execute() {
        map.spawnRooms();
        assertEquals("Nobody to talk to.", t.execute());
    }
}
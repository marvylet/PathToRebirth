package Tests;

import Commands.TalkTo;
import Map.Inventory;
import Map.MansionMap;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TalkToTest {
    Inventory inv = new Inventory();
    MansionMap map = new MansionMap(inv);
    Scanner sc = new Scanner(System.in);
    TalkTo t = new TalkTo(map, sc);

    @Test
    void execute() {
        map.spawnRooms();
        assertEquals("Nobody to talk to.", t.execute());
    }
}
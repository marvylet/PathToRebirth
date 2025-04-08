package Tests;

import Items.Key;
import Items.Statue;
import Map.Inventory;
import Map.Location;
import Map.MansionMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    Inventory inv = new Inventory();
    MansionMap map = new MansionMap(inv);
    Location loc;

    @Test
    void findItem() {
        map.spawnRooms();
        loc = map.getLocations().get(map.getCurrentLoc());
        assertEquals(loc.getItems().get(0), loc.findItem(loc.getItems().get(0).getName()));

    }

    @Test
    void moveItem() {
        map.spawnRooms();
        loc = map.getLocations().get(14);
        Statue statue = new Statue("Statue", 14);
        assertEquals("Item successfully moved!", loc.moveItem(statue));

    }

    @Test
    void talkToChar() {
        map.spawnRooms();
        assertEquals("No such character", loc.talkToChar("Aiysha"));
        loc = map.getLocations().get(17);
        assertEquals(loc.getCharacters().getFirst().getDialogue(), loc.talkToChar("Aiysha"));
    }
}
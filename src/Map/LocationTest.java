package Map;

import Items.Key;
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
        Key key = new Key("Key");
        assertEquals(key, loc.findItem(key.getName()));

    }

    @Test
    void moveItem() {
        map.spawnRooms();
    }

    @Test
    void talkToChar() {
        map.spawnRooms();
        assertEquals("No such character", loc.talkToChar("Aiysha"));
        loc = map.getLocations().get(17);
    }
}
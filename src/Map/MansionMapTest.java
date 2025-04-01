package Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MansionMapTest {
    Inventory inv = new Inventory();
    MansionMap map = new MansionMap(inv);

    @Test
    void spawnRooms() {
        map.spawnRooms();
        assertEquals(true, map.spawnRooms());
    }


    @Test
    void interactNeighbours() {
        map.spawnRooms();
        assertEquals(false, map.interactNeighbours());
    }

    @Test
    void moveToLocation() {
        map.spawnRooms();
        assertEquals(true, map.moveToLocation(10));
        assertEquals(false,map.moveToLocation(20));
        map.getLocations().get(map.getCurrentLoc()).setKeyLocked(false);
        assertEquals(false, map.moveToLocation(10));
    }



}
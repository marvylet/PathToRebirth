package Tests;

import Map.Inventory;
import Map.MansionMap;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MansionMapTest {
    Inventory inv = new Inventory();
    Scanner sc = new Scanner(System.in);
    MansionMap map = new MansionMap(inv, sc);

    @Test
    void spawnRooms() {
        map.spawnRooms();
        assertEquals(true, map.spawnRooms());
    }


    @Test
    void interactNeighbours() {
        map.spawnRooms();
        assertEquals(false, map.interactNeighboursKeyLoc());
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
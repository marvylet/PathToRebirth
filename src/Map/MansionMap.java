package Map;

import Characters.Character;
import Items.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MansionMap {
    private HashMap<Integer, Location> locations;
    private int startingLoc;
    private int currentLoc;
    private boolean lockedDoor;
    private Inventory inv;

    public MansionMap(Inventory inv) {
        this.locations = new HashMap<>();
        this.startingLoc = 1;
        this.currentLoc = startingLoc;
        this.lockedDoor = true;
        this.inv = inv;
    }

    /**
     * Method for spawning rooms and all their information from designated file.
     * @return - true if everything loaded correctly, false if something went wrong
     */
    public boolean spawnRooms() {
        try {
            BufferedReader buff = new BufferedReader(new FileReader("MansionLocations"));

            int ID;
            String name;
            ArrayList<Integer> rooms;
            boolean keyLocked;
            boolean moveLocked;
            ArrayList<Character> people;
            ArrayList<Item> items;

            String line;
            while ((line = buff.readLine()) != null) {
                String[] lines = line.split(";");
                ID = Integer.parseInt(lines[0]);
                name = lines[1];
                rooms = new ArrayList<>();
                people = new ArrayList<>();
                items = new ArrayList<>();

                String[] connectedRooms = lines[2].split("-");
                for (int i = 0; i < connectedRooms.length; i++) {
                    rooms.add(Integer.parseInt(connectedRooms[i]));
                }

                keyLocked = Boolean.parseBoolean(lines[3]);
                moveLocked = Boolean.parseBoolean(lines[4]);

                String[] characters = lines[5].split("-");
                for (int i = 0; i < characters.length; i++) {
                    Characters.Character character = Character.factory(characters[i]);
                    people.add(character);
                }

                String[] item = lines[6].split("-");
                for (int i = 0; i < item.length; i++) {
                    Items.Item it = Item.factory(item[i]);
                    items.add(it);
                }

                Location location = new Location(ID, name, rooms, keyLocked, moveLocked, people, items, inv);

                locations.put(ID, location);

            }

            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public HashMap<Integer, Location> getLocations() {
        return locations;
    }

    public void setLocations(HashMap<Integer, Location> locations) {
        this.locations = locations;
    }

    public int getCurrentLoc() {
        return currentLoc;
    }

    public void setCurrentLoc(int currentLoc) {
        this.currentLoc = currentLoc;
    }

    public int getStartingLoc() {
        return startingLoc;
    }

    public void setStartingLoc(int startingLoc) {
        this.startingLoc = startingLoc;
    }

    /**
     * Finds out if any of the neighbouring rooms are locked with a key.
     * @return - true if any of them are locked, false if otherwise
     */
    public boolean interactNeighbours(){
        for(int i = 0; i < locations.get(currentLoc).getConnectedRooms().size(); i++){
            if(locations.get(locations.get(currentLoc).getConnectedRooms().get(i)).isKeyLocked()){
                return true;
            }
        }
        return false;
    }

    /**
     * Used for listing all the connected rooms that are locked.
     * @return - List of rooms, or information about there being no locked rooms
     */
    public String listLockedNeighbours(){
        ArrayList<Integer> locationss = locations.get(currentLoc).getConnectedRooms();
        String s = "";

        for(int i = 0; i < locations.get(currentLoc).getConnectedRooms().size(); i++){
            if(locations.get(locations.get(currentLoc).getConnectedRooms().get(i)).isKeyLocked()){
                s += "\n   " + locations.get(locationss.get(i)).getID() + " " + locations.get(locationss.get(i)).getName();
            }
        }
        if(s.isEmpty()){
            return "No rooms locked";
        }
        return s;
    }

    /**
     * Used for moving to different rooms.
     * @param ID - id of room the player wants to move to
     * @return - true if moved to room successfuly, false if something went wrong or door is locked
     */
    public boolean moveToLocation(int ID) {
        if(locations.get(ID).isMoveLocked() || locations.get(ID).isKeyLocked()){
            return false;
        }

        if (locations.get(currentLoc).getConnectedRooms().contains(ID)) {
            currentLoc = ID;
            return true;
        }
        return false;
    }

    public Location currentRoom() {
        return locations.get(currentLoc);
    }

    /**
     * Used for listing all the connected rooms
     * @return - returns list of connected rooms the player can move to
     */
    public String locationNames() {
        ArrayList<Integer> locationss = locations.get(currentLoc).getConnectedRooms();
        String text = "";

        for (int i = 0; i < locationss.size(); i++) {
            text += "\n   " + locations.get(locationss.get(i)).getID() + " " + locations.get(locationss.get(i)).getName();
        }

        return text;
    }

    public boolean isLockedDoor() {
        return lockedDoor;
    }

    public void setLockedDoor(boolean lockedDoor) {
        this.lockedDoor = lockedDoor;
    }
}

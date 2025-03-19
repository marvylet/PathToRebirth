package Map;

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

    public MansionMap() {
        this.locations = new HashMap<>();
        this.startingLoc = 1;
        this.currentLoc = startingLoc;
        this.lockedDoor = true;
    }

    public boolean spawnRooms(){
        try{
            BufferedReader buff = new BufferedReader(new FileReader("MansionLocations"));

            int ID;
            String name;
            ArrayList<Integer> rooms;

            String line;
            while((line = buff.readLine()) != null){
                String[] lines = line.split(";");
                ID = Integer.parseInt(lines[0]);
                name = lines[1];
                rooms = new ArrayList<>();

                String[] connectedRooms = lines[2].split("-");
                for(int i = 0; i < connectedRooms.length; i++){
                    rooms.add(Integer.parseInt(connectedRooms[i]));
                }

                Location location = new Location(ID, name, rooms);

                locations.put(ID, location);

            }

            return true;

        }catch(IOException e){
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

    public boolean moveToLocation(int ID){
        if(locations.get(currentLoc).getConnectedRooms().contains(ID)){
            currentLoc = ID;
            return true;
        }
        return false;
    }

    public String locationNames(){
        ArrayList<Integer> locationss = locations.get(currentLoc).getConnectedRooms();
        ArrayList<String> locationNames = new ArrayList<>();
        String text = "";


        for(int i = 0; i < locationss.size(); i++){
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

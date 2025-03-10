import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MansionMap {
    private HashMap<Integer, Location> locations;
    private int startingLoc;
    private int currentLoc;

    public MansionMap() {
        this.locations = new HashMap<>();
        this.startingLoc = 1;
        this.currentLoc = startingLoc;
    }

    public boolean spawnRooms(){
        try{
            BufferedReader buff = new BufferedReader(new FileReader("MansionLocations"));

            int ID;
            String name;
            ArrayList<Integer> rooms;

            String line = buff.readLine();
            while(line != null){
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

    public boolean moveToLocation(int ID){
        if(locations.get(currentLoc).getConnectedRooms().contains(ID)){
            currentLoc = ID;
            return true;
        }
        return false;
    }

    public ArrayList<String> locationNames(){
        ArrayList<Integer> locationss = locations.get(currentLoc).getConnectedRooms();
        ArrayList<String> locationNames = new ArrayList<>();
        for(int i = 0; i < locationss.size(); i++){
            locationNames.add(locations.get(i).getName());
        }
        return locationNames;
    }


}

import java.util.ArrayList;

public class Location {
    private int ID;
    private String name;
    private ArrayList<Integer> connectedRooms;

    public Location(int ID, String name, ArrayList<Integer> connectedRooms) {
        this.ID = ID;
        this.name = name;
        this.connectedRooms = connectedRooms;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getConnectedRooms() {
        return connectedRooms;
    }

    public void setConnectedRooms(ArrayList<Integer> connectedRooms) {
        this.connectedRooms = connectedRooms;
    }

    @Override
    public String toString() {
        return "Location{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", connectedRooms=" + connectedRooms +
                '}';
    }
}

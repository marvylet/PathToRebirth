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
}

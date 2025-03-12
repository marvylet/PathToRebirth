package Items;

public class Lantern extends Item{
    public Lantern(String name, boolean grabbable, boolean moveable) {
        super(name, grabbable, moveable);
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getEffect() {
        return "";
    }
}

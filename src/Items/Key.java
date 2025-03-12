package Items;

public class Key extends Item{
    public Key(String name, boolean grabbable, boolean moveable) {
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

package Items;

public class Gift extends Item{
    public Gift(String name, boolean grabbable, boolean moveable) {
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

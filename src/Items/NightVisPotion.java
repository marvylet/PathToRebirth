package Items;

public class NightVisPotion extends Item{
    public NightVisPotion(String name, boolean grabbable, boolean moveable) {
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

package Items;

public class TpPotion extends Item{
    public TpPotion(String name, boolean grabbable, boolean moveable) {
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

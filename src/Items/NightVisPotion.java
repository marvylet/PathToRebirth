package Items;

public class NightVisPotion extends Item{
    public NightVisPotion(String name, int id) {
        super(name, id);
    }

    @Override
    public String getDescription() {
        return "A potion that allows you to see in night without lantern.";
    }

    @Override
    public String getEffect() {
        return "night vision";
    }

    @Override
    public boolean effect() {
        return true;
    }

    @Override
    public boolean grabbable() {
        return true;
    }

    @Override
    public boolean moveable() {
        return false;
    }
}

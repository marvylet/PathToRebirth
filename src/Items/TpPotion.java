package Items;

public class TpPotion extends Item{
    public TpPotion(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "A potion that allows you to teleport.";
    }

    @Override
    public String getEffect() {
        return "teleportation";
    }

    @Override
    public boolean effect() {
        return true;
    }

    @Override
    public boolean grabbable() {
        return false;
    }

    @Override
    public boolean moveable() {
        return false;
    }
}

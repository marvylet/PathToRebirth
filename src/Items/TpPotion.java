package Items;

public class TpPotion extends Item{
    public TpPotion(String name, int id) {
        super(name, id);
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
        return true;
    }

    @Override
    public boolean moveable() {
        return false;
    }
}

package Items;

public class Key extends Item{
    public Key(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "A key that may unlock a door.";
    }

    @Override
    public String getEffect() {
        return "unlock door";
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

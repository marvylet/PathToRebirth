package Items;

public class Lantern extends Item{
    public Lantern(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "Your light source, very helpful when exploring.";
    }

    @Override
    public String getEffect() {
        return "light";
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

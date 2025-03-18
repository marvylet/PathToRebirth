package Items;

public class Statue extends Item{
    public Statue(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getEffect() {
        return "";
    }

    @Override
    public boolean effect() {
        return false;
    }

    @Override
    public boolean grabbable() {
        return false;
    }

    @Override
    public boolean moveable() {
        return true;
    }
}

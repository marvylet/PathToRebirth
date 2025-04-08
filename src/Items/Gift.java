package Items;

public class Gift extends Item{
    public Gift(String name, int id) {
        super(name, id);
    }

    @Override
    public String getDescription() {
        return "Somebody else might make some use of this.";
    }

    @Override
    public String getEffect() {
        return "improve relationship";
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

package Items;

public class Note extends Item{
    public Note(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "A note that may contain some clues or stuff about this place.";
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
        return true;
    }

    @Override
    public boolean moveable() {
        return false;
    }
}

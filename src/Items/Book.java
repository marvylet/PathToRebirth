package Items;

public class Book extends Item{
    public Book(String name, int id) {
        super(name, id);
    }

    @Override
    public String getDescription() {
        return "A book, there may be something about this place.";
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

package lantern.cat;

public class RectangularStaticObject implements StaticObject {

    private StaticObjectType type;

    public RectangularStaticObject(StaticObjectType type) {
        this.type = type;
    }

    //TODO: implement addTile();

    @Override
    public void addTile(Tile tile) {

    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}

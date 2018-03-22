package lantern.cat;

public class Tile {

    private TileType tileType;
    private StaticObject parentObject;

    public Tile(TileType tileType, StaticObject parentObject) {
        this.tileType = tileType;
        this.parentObject = parentObject;
    }

    public TileType getTileType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    public StaticObject getParentObject() {
        return parentObject;
    }

    public void setParentObject(StaticObject parentObject) {
        this.parentObject = parentObject;
    }

/*    @Override
    public String toString() {
        return "(" + this.tileType.toString() + ", " + this.parentObject.toString() + ")";
    }
    */

    @Override
    public String toString() {
        return this.tileType.toString();
    }
}

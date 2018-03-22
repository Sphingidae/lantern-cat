package lantern.cat;

import java.util.ArrayList;

public class MegaTile {

    private int tilePosX;
    private int tilePosY;
    private int sizeX;
    private int sizeY;
    private Tile[][] tiles;
    private ArrayList<StaticObject> parentObjects;

    public MegaTile(int tilePosX, int tilePosY, int sizeX, int sizeY) {
        this.tilePosX = tilePosX;
        this.tilePosY = tilePosY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        this.parentObjects = new ArrayList<>();
        RectangularStaticObject ground = new RectangularStaticObject(StaticObjectType.PASSABLE);
        this.tiles = new Tile[sizeY][sizeX];

        for (int y = 0; y < this.sizeY; y++) {
            for (int x = 0; x < this.sizeX; x++) {
                tiles[y][x] = new Tile(TileType.SOIL, ground);
                ground.addTile(tiles[y][x]);
            }
        }
        ;
    }

    public int getTilePosX() {
        return tilePosX;
    }

    public void setTilePosX(int tilePosX) {
        this.tilePosX = tilePosX;
    }

    public int getTilePosY() {
        return this.tilePosY;
    }

    public void setTilePosY(int tilePosY) {
        this.tilePosY = tilePosY;
    }

    public int getSizeX() {
        return this.sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return this.sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public Tile getLocalTile(int x, int y) throws ArrayIndexOutOfBoundsException {
        if ((x < this.sizeX) && (y < this.sizeY))
            return this.tiles[y][x];
        throw new ArrayIndexOutOfBoundsException("lantern.lantern.cat.Tile index is out of bound.");
    }

    public Tile getGlobalTile(int globalX, int globalY) {
        if ((globalX < this.tilePosX * this.sizeX + this.sizeX) && (globalY < this.tilePosY * this.sizeY + this.sizeY)) {
            return tiles[globalY - this.tilePosY * this.sizeY][globalX - this.tilePosX * sizeX];
        }
        throw new ArrayIndexOutOfBoundsException("Global tile index is out of bound.");
    }

    public void setTile(int x, int y, Tile tile) {
        if ((x < this.sizeX) && (y < this.sizeY)) {
            this.tiles[y][x] = tile;
        } else {
            throw new ArrayIndexOutOfBoundsException("lantern.lantern.cat.Tile index is out of bound.");
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int y = 0; y < this.sizeY; y++) {
            for (int x = 0; x < this.sizeX; x++) {
                res.append(this.tiles[y][x]);
            }
            res.append("\n");
        }
        return res.toString();
    }

    public void addParentObject(RectangularStaticObject parentObject) {
        this.parentObjects.add(parentObject);
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}

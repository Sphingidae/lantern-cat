package lantern.cat;

public class LocalMap {

    private Tile[][] tiles;


    public LocalMap(int localMapSizeX, int localMapSizeY) {
        this.tiles = new Tile[localMapSizeY][localMapSizeX];
    }

    public void coverSector(int startX, int startY, int sizeX, int sizeY, Tile[][] tiles) {
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                this.tiles[startY+y][startX+x] = tiles[y][x];
            }
        }

    }

    public Tile getTile(int x, int y) {
        return tiles[y][x];
    }
}

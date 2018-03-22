package lantern.cat;

public class GlobalMap {

    //TODO: tiles cache for a global map (recently/frequently used are cached)
    private Object cache;
    //Thing that generates MegaTiles if you ask to; asks for an PRNG seed
    private TileGenerator tileGenerator;

    public GlobalMap(TileGenerator generator) {
        this.tileGenerator = generator;
    }

    public LocalMap getLocalMap(int globalX, int globalY, int localMapSizeX, int localMapSizeY) {
        LocalMap localMap = new LocalMap(localMapSizeX, localMapSizeY);
        Dimension megaTileSize = this.tileGenerator.getMegaTileSize();

        //TODO: all tiles, not THIS!!11
        localMap.coverSector(0, 0, megaTileSize.x, megaTileSize.y,
                tileGenerator.getMegaTile(globalX/megaTileSize.x, globalY/megaTileSize.y).getTiles());

        //return new LocalMap(this.tileGenerator.getMegaTile(0, 0, TILE_SIZE_X, TILE_SIZE_Y));
        return localMap;
    }

}

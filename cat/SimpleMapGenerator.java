package lantern.cat;

public class SimpleMapGenerator implements TileGenerator {

    public static final int TILE_SIZE_X = 100;
    public static final int TILE_SIZE_Y = 100;


    @Override
    public MegaTile getMegaTile(int globalX, int globalY) {
        MegaTile megaTile = new MegaTile(globalX, globalY, TILE_SIZE_X, TILE_SIZE_Y);
        if ((globalX == 0) && (globalY == 0)) {
            RectangularStaticObject house = new RectangularStaticObject(StaticObjectType.HOUSE);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    megaTile.setTile(50+i, 50+j, new Tile(TileType.WALL, house));
                }
            }
            megaTile.addParentObject(house);

        }
        return megaTile;
    }

    @Override
    public Dimension getMegaTileSize() {
        return new Dimension(SimpleMapGenerator.TILE_SIZE_X, SimpleMapGenerator.TILE_SIZE_Y);
    }

}

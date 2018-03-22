package lantern.cat;

public interface TileGenerator {

    MegaTile getMegaTile(int globalX, int globalY);

    Dimension getMegaTileSize();
}

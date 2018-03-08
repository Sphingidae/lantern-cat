package lantern.cat;

public enum TileType {

    GRASS, SOIL, FLOOR, WATER, BUSH, TREE, WALL, STONE, ROAD;

    @Override
    public String toString() {
        switch (this) {
            case SOIL: return "#";
            case WALL: return "H";
            case BUSH: return "Ж";
            case ROAD: return "=";
            case TREE: return "Y";
            case FLOOR: return "F";
            case GRASS: return "Ш";
            case STONE: return "*";
            case WATER: return "W";
            default: return "";
        }
    }
}

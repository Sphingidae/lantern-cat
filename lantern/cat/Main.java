package lantern.cat;

import lantern.cat.visualization.GraphicalViewer;

public class Main {

    public static void main(String[] args) {
        SimpleMapGenerator generator = new SimpleMapGenerator();
        MegaTile mTile = generator.getMegaTile(0, 0);
        System.out.println(mTile);

        GraphicalViewer viewer = new GraphicalViewer(new GlobalMap(generator));
        viewer.start();

    }
}
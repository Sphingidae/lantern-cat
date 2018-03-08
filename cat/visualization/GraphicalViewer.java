package lantern.cat.visualization;

import lantern.cat.GlobalMap;
import lantern.cat.LocalMap;
import lantern.cat.TileType;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GraphicalViewer {

    private Canvas canvas;

    public GraphicalViewer(GlobalMap globalMap) {
        this.canvas = new Canvas(globalMap);

    }

    public void start() {

        JFrame frame = new JFrame("The Lantern Cat");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane(this.canvas);
        this.canvas.setPreferredSize(screenSize
        );
        frame.add(scrollPane);

        frame.setMinimumSize(new Dimension(screenSize.width/2, screenSize.height/2));
        frame.setLocation(screenSize.width/4, screenSize.height/4);

        frame.setVisible(true);

    }

    private class Canvas extends JPanel {

        private GlobalMap globalMap;
        private int viewX;
        private int viewY;
        private static final int SCALE = 10;

        public Canvas(GlobalMap globalMap) {
            this.globalMap = globalMap;
            this.viewX = 0;
            this.viewY = 0;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            LocalMap lMap = this.globalMap.getLocalMap(this.viewX, this.viewY, 100, 100);
            Graphics2D g2d = (Graphics2D) g;
            for (int y = 0; y < 100; y++) {
                for (int x = 0; x < 100; x++) {
                    g2d.setColor(getTileColor(lMap.getTile(x, y).getTileType()));
                    g2d.fillRect(x*SCALE, y*SCALE, SCALE, SCALE);
                }
            }

        }

        private Color getTileColor(TileType tileType) {
            switch (tileType) {
                case WATER: return Color.blue;
                case STONE: return Color.DARK_GRAY;
                case GRASS: return Color.GREEN;
                case FLOOR: return Color.white;
                case TREE: return Color.ORANGE;
                case ROAD: return Color.BLACK;
                case BUSH: return new Color(0, 180, 0);
                case SOIL: return Color.GRAY;
                case WALL: return Color.RED;
                default: return Color.MAGENTA;
            }
        }
    }

}

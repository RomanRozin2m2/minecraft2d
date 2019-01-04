package server.blocks;

import java.awt.*;

public class Grass extends Block {

    public final static Color color = new Color(0x007614);
    public final static String id = "grass";

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String getId() {
        return id;
    }

    public Grass(){

    }
}

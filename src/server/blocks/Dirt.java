package server.blocks;

import java.awt.*;

public class Dirt extends Block{

    public final static Color color = new Color(0x653200);
    public final static String id = "dirt";

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String getId() {
        return id;
    }

    public Dirt(){

    }
}

package server.blocks;

import java.awt.*;

public class Stone extends Block{

    public final static Color color = new Color(0x5A5A5A);
    public final static String id = "stone";

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String getId() {
        return id;
    }


    public Stone(){

    }
}

package server.blocks;

import java.awt.*;

public class Air extends Block {

    public final static Color color = new Color(0x2FA1CB);
    public final static String id = "air";

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    public Air(){

    }
}

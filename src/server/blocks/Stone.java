package server.blocks;

import java.awt.*;

public class Stone extends Block{

    public final static Color color = new Color(0x5A5A5A);
    public final static String id = "stone";
    public final static Image texture = getTextureImage("data/textures/stone.png");

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Image getTexture() {
        return texture;
    }

    public Stone(){

    }
}

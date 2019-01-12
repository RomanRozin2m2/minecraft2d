package server.blocks;

import java.awt.*;

public class Grass extends Block {

    public final static Color color = new Color(0x007614);
    public final static String id = "grass";
    public final static Image texture = getTextureImage("data/textures/grass.png");

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

    public Grass(){

    }
}

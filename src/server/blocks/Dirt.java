package server.blocks;

import java.awt.*;

public class Dirt extends Block{

    public final static Color color = new Color(0x653200);
    public final static String id = "dirt";
    public final static Image texture = getTextureImage("data/textures/dirt.png");

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

    public Dirt(){

    }
}

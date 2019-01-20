package client;

import client.gui.RenderMode;

public class Settings {

    private static Settings obj = new Settings();

    private Settings(){

    }

    public static Settings get() {
        return obj;
    }

    public int blockSize = 10;
    public int framesPerSecond = 25;
    public RenderMode renderMode = RenderMode.Textures;
    public Keybinds keybinds = new Keybinds();
}

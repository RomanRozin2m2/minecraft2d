package client;

public class Settings {

    private static Settings obj = new Settings();

    private Settings(){

    }

    public static Settings get() {
        return obj;
    }

}

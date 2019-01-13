package server;

public class Settings {

    private static Settings obj = new Settings();

    private Settings(){

    }

    public static Settings get() {
        return obj;
    }

    public float maxLeftRunSpeed = -0.25f;
    public float maxLeftWalkSpeed = -0.1f;
    public float maxRightWalkSpeed = 0.1f;
    public float maxRightRunSpeed = 0.25f;
    public float jumpAcceleration = 0.3f;
    public float runAcceleration = 0.025f;
    public float walkAcceleration = 0.01f;
    public int playerHealth = 20;
    public float playerHeight = 1.75f;
    public float playerWidth = 0.8f;

    public int ticksPerSecond = 20;
}

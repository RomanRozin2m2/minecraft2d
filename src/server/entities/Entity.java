package server.entities;

public abstract class Entity {
    boolean isFloating;
    int health;
    float x;
    float y;
    float ySpeed;
    float xSpeed;
    float width;
    float height;

    static float maxLeftRunSpeed = -0.25f;
    static float maxLeftWalkSpeed = -0.1f;
    static float maxRightWalkSpeed = 0.1f;
    static float maxRightRunSpeed = 0.25f;
    static float jumpAcceleration = 0.1f;
    static float runAcceleration = 0.025f;
    static float walkAcceleration = 0.01f;
    static float maxYSpeed = 0.25f;

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        if (Math.abs(ySpeed) < 0.0001) {
            ySpeed = 0;
        }
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        if (Math.abs(xSpeed) < 0.0001) {
            xSpeed = 0;
        }
        this.xSpeed = xSpeed;
    }
}

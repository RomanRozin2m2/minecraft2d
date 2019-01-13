package server.entities;

public abstract class Entity {
    int health;
    float x;
    float y;
    float ySpeed;
    float xSpeed;
    float width;
    float height;
    float maxRightWalkSpeed;
    float maxRightRunSpeed;
    float maxLeftWalkSpeed;
    float maxLeftRunSpeed;

    public float getMaxRightWalkSpeed() {
        return maxRightWalkSpeed;
    }

    public void setMaxRightWalkSpeed(float maxRightWalkSpeed) {
        this.maxRightWalkSpeed = maxRightWalkSpeed;
    }

    public float getMaxRightRunSpeed() {
        return maxRightRunSpeed;
    }

    public void setMaxRightRunSpeed(float maxRightRunSpeed) {
        this.maxRightRunSpeed = maxRightRunSpeed;
    }

    public float getMaxLeftWalkSpeed() {
        return maxLeftWalkSpeed;
    }

    public void setMaxLeftWalkSpeed(float maxLeftWalkSpeed) {
        this.maxLeftWalkSpeed = maxLeftWalkSpeed;
    }

    public float getMaxLeftRunSpeed() {
        return maxLeftRunSpeed;
    }

    public void setMaxLeftRunSpeed(float maxLeftRunSpeed) {
        this.maxLeftRunSpeed = maxLeftRunSpeed;
    }

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
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }
}

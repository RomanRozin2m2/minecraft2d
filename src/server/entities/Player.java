package server.entities;

import server.Settings;

public class Player extends Entity {

    public Player(float spawnx, float spawny){
        health = Settings.get().playerHealth;
        xSpeed = 0;
        ySpeed = 0;
        x = spawnx;
        y = spawny;
        height = Settings.get().playerHeight;
        width = Settings.get().playerWidth;
        maxLeftWalkSpeed = Settings.get().maxLeftWalkSpeed;
        maxLeftRunSpeed = Settings.get().maxLeftRunSpeed;
        maxRightWalkSpeed = Settings.get().maxRightWalkSpeed;
        maxRightRunSpeed = Settings.get().maxRightRunSpeed;
    }

    public void walkRight(){
        if (xSpeed < maxRightWalkSpeed){
            if (xSpeed > maxRightWalkSpeed){
                xSpeed = maxRightWalkSpeed;
            }
            else {
                xSpeed += Settings.get().walkAcceleration;
            }
        }
    }

    public void walkLeft(){
        if (xSpeed > maxLeftWalkSpeed){
            if (xSpeed < maxLeftWalkSpeed){
                xSpeed = maxLeftWalkSpeed;
            }
            else {
                xSpeed -= Settings.get().walkAcceleration;
            }
        }
    }

    public void runRight(){
        if (xSpeed < maxRightRunSpeed){
            if (xSpeed > maxRightRunSpeed){
                xSpeed = maxRightRunSpeed;
            }
            else {
                xSpeed += Settings.get().walkAcceleration;
            }
        }
    }

    public void runLeft(){
        if (xSpeed > maxLeftRunSpeed){
            if (xSpeed < maxLeftRunSpeed){
                xSpeed = maxLeftRunSpeed;
            }
            else {
                xSpeed -= Settings.get().walkAcceleration;
            }
        }
    }



}

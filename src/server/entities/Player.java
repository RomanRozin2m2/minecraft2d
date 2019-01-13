package server.entities;

import server.Settings;

public class Player extends Entity {

    public Player(float spawnx, float spawny){
        x = spawnx;
        y = spawny;
        xSpeed = 0;
        ySpeed = 0;
        health = Settings.get().playerHealth;
        height = Settings.get().playerHeight;
        width = Settings.get().playerWidth;
    }

    public void walkRight(){
        if (xSpeed < maxRightWalkSpeed){
            if (xSpeed > maxRightWalkSpeed){
                xSpeed = maxRightWalkSpeed;
            }
            else {
                xSpeed += walkAcceleration;
            }
        }
    }

    public void walkLeft(){
        if (xSpeed > maxLeftWalkSpeed){
            if (xSpeed < maxLeftWalkSpeed){
                xSpeed = maxLeftWalkSpeed;
            }
            else {
                xSpeed -= walkAcceleration;
            }
        }
    }

    public void runRight(){
        if (xSpeed < maxRightRunSpeed){
            if (xSpeed > maxRightRunSpeed){
                xSpeed = maxRightRunSpeed;
            }
            else {
                xSpeed += walkAcceleration;
            }
        }
    }

    public void runLeft(){
        if (xSpeed > maxLeftRunSpeed){
            if (xSpeed < maxLeftRunSpeed){
                xSpeed = maxLeftRunSpeed;
            }
            else {
                xSpeed -= walkAcceleration;
            }
        }
    }

}

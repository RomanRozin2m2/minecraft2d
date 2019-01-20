package server.entities;

import server.Constants;

public class Player extends Entity {

    public Player(float spawnx, float spawny){
        x = spawnx;
        y = spawny;
        xSpeed = 0;
        ySpeed = 0;
        health = Constants.get().playerHealth;
        height = Constants.get().playerHeight;
        width = Constants.get().playerWidth;
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

    public void jump(){
        if (ySpeed < maxYSpeed){
            ySpeed += jumpAcceleration;
        }
    }

}

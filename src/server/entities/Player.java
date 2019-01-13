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
    }



}

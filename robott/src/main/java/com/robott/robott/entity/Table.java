package com.robott.robott.entity;

import org.springframework.stereotype.Component;

@Component
public class Table implements Platform {
    private  int xCord = 10;
    private  int yCord = 10;
    @Override
    public boolean validCoordinates(int xCord, int yCord) {
        return xCord>=0 && xCord <= this.xCord && yCord >=0 && yCord <= this.yCord;
    }

    public void setCoordinates(int x, int y){
        this.xCord = x;
        this.yCord = y;
    }

    public int getWidth(){
        return this.xCord;
    }

    public int getHeight(){
        return this.yCord;
    }
}

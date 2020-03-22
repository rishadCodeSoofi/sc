package com.robott.robott.service;


import com.robott.robott.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RobotImplementation implements Robot {

    public static int xCord = 10;
    public static int yCord = 10;

    @Autowired
    private Table table;
    @Override
    public String move(Commands command, Directions directions, int movementPositions) {

        int x = this.getXCoordinate();
        int y = this.getYCoordinate();
        switch(directions){
            case UP:
                // do something - increases Y
                y = y + movementPositions;
                //table.setCoordinates(table.getXCoordinate(),table.getYCoordinate() + movementPositions);
                break;
            case DOWN:
                // do something - decreases Y
                y = y - movementPositions;
                //table.setCoordinates(table.getXCoordinate(),table.getYCoordinate() - movementPositions);
                break;
            case LEFT:
                // do something - decreases X
                x = x - movementPositions;
                //table.setCoordinates(table.getXCoordinate() - movementPositions ,table.getYCoordinate());
                break;
            case RIGHT:
                // do something - icrease X
                x = x + movementPositions;
                //table.setCoordinates(table.getXCoordinate() + movementPositions ,table.getYCoordinate());
                break;
        }
        if(table.validCoordinates(x,y)){
            this.setCoordinates(x,y);
            return   UserMessages.ROBOT_MOVED_MESSAGE  + " [ " + x + " , " + y + "]";
        }else{
            return UserMessages.ROBOT_MOVEMENT_FAILURE;
        }
    }

    @Override
    public String initialize(int xWidth , int yHeight) {
        this.setCoordinates(xWidth,xWidth);
        return "Robot has set up and initialized !!!";
    }


    @Override
    public void setCoordinates(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    @Override
    public int getXCoordinate() {
        return this.xCord;
    }

    @Override
    public int getYCoordinate() {
        return this.yCord;
    }

}

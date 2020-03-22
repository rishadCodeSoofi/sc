package com.robott.robott.entity;

public interface Robot {
    public String move(Commands command, Directions directions, int movementPositions);
    public String initialize(int xWidth, int yHeight);
    public int xCoordinate = 0;
    public int yCoordinate = 0;
    void setCoordinates(int xCord, int yCord);
    int getXCoordinate();
    int getYCoordinate();
}

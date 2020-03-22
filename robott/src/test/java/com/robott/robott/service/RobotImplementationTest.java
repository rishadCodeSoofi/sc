package com.robott.robott.service;

import com.robott.robott.entity.Commands;
import com.robott.robott.entity.Directions;
import com.robott.robott.entity.Table;
import com.robott.robott.entity.UserMessages;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class RobotImplementationTest {

    @InjectMocks
    RobotImplementation robotImplementation;

    @Mock
    Table table;

    @org.junit.Test
    public void moveTest() {
        Commands instruction = Commands.MOVE;
        Directions direction = Directions.UP;
        int movementPositions =1;

        Mockito.doReturn(true).when(table).validCoordinates(5,6);


        robotImplementation.initialize(5,5);
        robotImplementation.getXCoordinate();
        robotImplementation.getYCoordinate();
        assertTrue(robotImplementation.move(instruction, direction, movementPositions).contains(UserMessages.ROBOT_MOVED_MESSAGE));


    }

    @org.junit.Test
    public void moveTestFail(){

        Commands instruction = Commands.MOVE;
        Directions direction = Directions.UP;
        int movementPositions =6;

        Mockito.doReturn(false).when(table).validCoordinates(5,11);


        robotImplementation.initialize(5,5);
        robotImplementation.getXCoordinate();
        robotImplementation.getYCoordinate();
        assertTrue(robotImplementation.move(instruction, direction, movementPositions).contains(UserMessages.ROBOT_MOVEMENT_FAILURE));

    }


}
package com.robott.robott.service;

import com.robott.robott.entity.Table;
import com.robott.robott.entity.UserMessages;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InstructionsParserTest {

    @InjectMocks
    InstructionsParser instructionsParser;

    @Mock
    RobotImplementation robotImplementation;

    @Mock
    Table table;



    @org.junit.Test
    public void processCommandStart() {
        instructionsParser.start = false;
        when(robotImplementation.initialize(5,5)).thenCallRealMethod();
        assertEquals("The Robot has Started !!!", instructionsParser.process("START"));
    }

    @org.junit.Test
    public void processCommandStartAgain() {
        instructionsParser.start();
        assertEquals("The Robot already started!!!", instructionsParser.process("START"));
    }

    @org.junit.Test
    public void processCommandMoveWhenNotStarted(){
        instructionsParser.start = false;
        assertEquals("The Robot has not Started !!!!", instructionsParser.process("MOVE UP 1"));
    }

    @org.junit.Test
    public void parsedInstructionsTest(){
        assertEquals(true, instructionsParser.parsedInstructions("MOVE UP 1"));
    }


    @org.junit.Test
    public void setUpTest(){
        assertEquals(UserMessages.ROBOT_SETUP_SUCCESSFUL, instructionsParser.process("SETUP 200 200"));
    }

    @org.junit.Test
    public void helpTest(){
        assertEquals(UserMessages.COMMAND_REFERENCE.toString(), instructionsParser.process("HELP"));
    }


   /* @org.junit.Test
    public void processCommandMoveUPSuccess(){
        when(robotImplementation.initialize(5,5)).thenCallRealMethod();
        instructionsParser.start();
        instructionsParser.parsedInstructions("MOVE UP 1");
        when(robotImplementation.getXCoordinate()).thenCallRealMethod();
        when(robotImplementation.getYCoordinate()).thenCallRealMethod();

       // when(robotImplementation.setCoordinates(5,5)).thenCallRealMethod();

        assertEquals(containsString("Robot moved to the position"), instructionsParser.process("MOVE UP 1"));


       /* Commands instruction = Commands.MOVE;
        Directions direction = Directions.UP;
        int movementPositions =1;

        when(robotImplementation.move(instruction, direction, movementPositions)).thenCallRealMethod();
        assertEquals(containsString("Robot moved to the position"), instructionsParser.process("MOVE UP 1"));
    }*/



}
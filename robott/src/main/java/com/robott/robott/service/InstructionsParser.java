package com.robott.robott.service;

import com.robott.robott.entity.Commands;
import com.robott.robott.entity.Directions;
import com.robott.robott.entity.Table;
import com.robott.robott.entity.UserMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstructionsParser {

    @Autowired
    private RobotImplementation robotImplementation;

    @Autowired
    private Table table;

    public static boolean start = false;
    public static String response = UserMessages.INVALID_INSTRUCTION;;

    private Commands instruction = null;
    private Directions direction = null;
    private int movementPositions =0, tableXCord = 0, tableYCord = 0;

    public void start(){
        start = true;
        robotImplementation.initialize(table.getWidth()/2, table.getHeight()/2);
    }


    public boolean parsedInstructions(String commands){

        String[] command = commands.split(" ");
        int commandLength = command.length;
        boolean isParsed = true;

        try {
            instruction = Commands.valueOf(command[0]);

            if (instruction.toString().equals("SETUP")) {
                tableXCord = (Integer.parseInt(command[1]) <= 0 ? -1 : Integer.parseInt(command[1]));
                tableYCord = (Integer.parseInt(command[2]) <= 0 ? -1 : Integer.parseInt(command[2]));
            }else{
                direction = Directions.valueOf(command[1]);
                movementPositions = (Integer.parseInt(command[2]) <= 0 ? -1 : Integer.parseInt(command[2]));
            }
        } catch (ArrayIndexOutOfBoundsException e){
            e.getMessage();
        } catch (Exception e) {
            e.getMessage();
            isParsed = false;
        }
        if (movementPositions == -1 || tableXCord == -1 || tableYCord == -1 ) {
            isParsed = false;
        }
        return isParsed;
    }

    public String process(String commands){

        if(parsedInstructions(commands)){
            switch(instruction) {
                case SETUP:
                    table.setCoordinates(tableXCord,tableYCord);
                    start = false;
                    response = UserMessages.ROBOT_SETUP_SUCCESSFUL;
                    break;
                case START:
                    if(start){
                        response =  UserMessages.ROBOT_ALREADY_STARTED;;
                    } else {
                        start();
                        response =  UserMessages.ROBOT_STARTED;;
                    }
                    break;
                case MOVE:
                    if(start){
                         response = robotImplementation.move(instruction, direction,movementPositions);
                    } else {
                        response =  UserMessages.ROBOT_NOT_STARTED;
                    }
                    break;
                case HELP:
                    response = UserMessages.COMMAND_REFERENCE.toString();
                    break;
                case EXIT:
                    System.out.println(UserMessages.THANK_YOU);
                    System.exit(0);
                    break;
            }
        }else{
            response = UserMessages.INVALID_INSTRUCTIONS;
        }
        return response;
    }
}



package com.robott.robott.entity;

public class UserMessages {
    public static String INVALID_INSTRUCTIONS = "Invalid Instructions";
    public static String ROBOT_ALREADY_STARTED = "The Robot already started!!!";
    public static String ROBOT_STARTED = "The Robot has Started !!!";
    public static String ROBOT_NOT_STARTED = "The Robot has not Started !!!!";
    public static String THANK_YOU = "Thank you !!! ";
    public static String INVALID_INSTRUCTION = "Invalid Instructions!";
    public static String ROBOT_MOVED_MESSAGE = "Robot moved successfully to the position ";
    public static String ROBOT_MOVEMENT_FAILURE = "Movement cannot be done - Invalid positions";
    public static String ROBOT_INITILIZED =   "Robot has set up and initialized !!!";

    public static String WELCOME_MESSAGE =    "***************************Welcome to Robot Application***************************************************** \r\n";
    public static StringBuilder COMMAND_REFERENCE = new StringBuilder("***********************************************COMMAND-HELP***************************************************** \r\n")
                                                              .append("START - To start the Robot [ By defualt , The table in of 10 X 10, and the Robot will be placed at [5,5] ] Example : START \r\n")
                                                              .append("SETUP - To setup the Table size explicitly - Example:  SETUP 100 100 , Enter START after setup\r\n")
                                                              .append("MOVE -  To Move the Robot to UP, DOWN, LEFT, RIGHT example : MOVE UP 1 \r\n")
                                                              .append("HELP -  COMMAND REFERENCES \r\n")
                                                              .append("EXIT -  To Exit Robot Application\r\n")
                                                              .append("****************************************************************************************************************  ");
    public static String ENTER_COMMAND = "Please enter your command>>";
}

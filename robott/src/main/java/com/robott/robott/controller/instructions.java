package com.robott.robott.controller;

import com.robott.robott.entity.UserMessages;
import com.robott.robott.service.InstructionsParser;
import com.robott.robott.service.RobotImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class instructions implements ApplicationRunner {
    @Autowired
    private RobotImplementation robo;

    @Autowired
    private InstructionsParser instructionsParser;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // this.move();
        Scanner scanner = new Scanner(System.in);
        System.out.println(UserMessages.WELCOME_MESSAGE);
        System.out.println(UserMessages.COMMAND_REFERENCE);

        try {
            do {
                String command = scanner.nextLine();
                System.out.println(instructionsParser.process(command));
            } while (true);
        }catch(Exception e){
           e.getMessage();
        } finally {
            scanner.close();
        }
    }
}
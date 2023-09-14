package com.rover;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        // retrieve filepath argument
        String filepath = null;

        if (null != args && args.length > 0 ){
            filepath = args[0];
        }
        
        if (null != filepath){
            try {
                Scanner scanner = new Scanner(new File(filepath));
                
                String[] coordinates = scanner.nextLine().split(" ");
                Plateau plateau = new Plateau(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
                
                while (scanner.hasNextLine()) {
                    String[] paramsArray = scanner.nextLine().split(" ");
                    int xCoordinate = Integer.parseInt(paramsArray[0]);
                    int yCoordinate = Integer.parseInt(paramsArray[1]);
                    char direction = paramsArray[2].charAt(0);
                    Rover rover = new Rover(plateau, new Position(xCoordinate, yCoordinate),direction);
                    rover.processInstructions(scanner.nextLine());
                    System.out.println(rover);
			    }

			    scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalStateException("pathfile argument not found");
        }
        
    }
}

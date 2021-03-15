package com.handlers;

import com.entities.*;

import java.util.ArrayList;
import java.util.List;

public class LineFormatter {

    public static Mower mowerLineFormat(String line){
        String[] elements = line.split(Constants.SPACE);
        Coordinates coordinates = new Coordinates(Integer.valueOf(elements[0]), Integer.valueOf(elements[1]));
        Orientation orientation = getOrientation(elements[2].charAt(0));
        return new Mower(coordinates, orientation);
    }

    public static Orientation getOrientation(char mOrientation){
        for(Orientation orientation : Orientation.values()) {
            if (orientation.getOrientation() == mOrientation){
                return orientation;
            }
        }
        return null;
    }

    public static Coordinates coordinatesMaxFormat(String lawnLine){
        String[] elements = lawnLine.split(Constants.SPACE);
        return new Coordinates(Integer.valueOf(elements[0]), Integer.valueOf(elements[1]));
    }

    public static List<Instructions> instructionsFormat(String instructionLine){
        List<Instructions> listInstruction = new ArrayList<>();
        for(char instruction : instructionLine.toCharArray()){
            listInstruction.add(getInstruction(instruction));
        }
        return listInstruction;
    }

    public static Instructions getInstruction(char cInstruction){
        for(Instructions instruction : Instructions.values()) {
            if (instruction.getInstruction() == cInstruction) {
                return instruction;
            }
        }
        return null;
    }
}

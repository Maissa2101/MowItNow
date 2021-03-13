package com.parser;

import com.entities.Instructions;
import com.entities.Orientation;

public class MowerParser {

    private String mower;
    private String coordinateMax;
    private String instructions;

    public static boolean mowerParse(String mower){
        String orientation= Orientation.NORTH.getOrientation() +
                "|" + Orientation.SOUTH.getOrientation() +
                "|" + Orientation.EAST.getOrientation() +
                "|" + Orientation.WEST.getOrientation();
        return mower.matches("(\\d+) (\\d+) (" + orientation +")");
    }

    public static boolean instructionParse(String instructions){
        String instruction = "(" + Instructions.AVANCE.getInstruction() +
                "|" + Instructions.DROITE.getInstruction() +
                "|" + Instructions.GAUCHE.getInstruction() +
                ")+";
        return instructions.matches(instruction);
    }

    public static boolean coordinateMaxParse(String coordinateMax){
        return coordinateMax.matches("(\\d+) (\\d+)");
    }

    public boolean executeParse(){
        return mowerParse(mower)
                && coordinateMaxParse(coordinateMax)
                && instructionParse(instructions);
    }

    public String getMower() {
        return mower;
    }

    public void setMower(String mower) {
        this.mower = mower;
    }

    public String getCoordinateMax() {
        return coordinateMax;
    }

    public void setCoordinateMax(String coordinateMax) {
        this.coordinateMax = coordinateMax;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}

package com.parser;

import com.entities.*;

public class MowerParser {

    private String mower;
    private String coordinateMax;
    private String instructions;

    /**
     * Parse de la position de la tondeuse (2 chiffres et une lettre séparés par un espace)
     * @param mower
     * @return true si la ligne est correcte, false sinon
     */
    public static boolean mowerParse(String mower){
        String orientation= Orientation.NORTH.getOrientation() +
                "|" + Orientation.SOUTH.getOrientation() +
                "|" + Orientation.EAST.getOrientation() +
                "|" + Orientation.WEST.getOrientation();
        return mower.matches("(\\d+) (\\d+) (" + orientation +")");
    }

    /**
     * Parse de la ligne des instructions qui est une suite de caractères
     * @param instructions
     * @return true si la ligne est correcte, false sinon
     */
    public static boolean instructionParse(String instructions){
        String instruction = "(" + Instructions.AVANCE.getInstruction() +
                "|" + Instructions.DROITE.getInstruction() +
                "|" + Instructions.GAUCHE.getInstruction() +
                ")+";
        return instructions.matches(instruction);
    }

    /**
     * Parse des coordonnées max de la pelouse (2 chiffres séparés par un espace)
     * @param coordinateMax
     * @return true si la ligne est correcte, false sinon
     */
    public static boolean coordinateMaxParse(String coordinateMax){
        return coordinateMax.matches("(\\d+) (\\d+)");
    }

    /**
     * vérification des informations de la tondeuse
     * @return true si les informations de la tondeuse sont correctes, false sinon
     */
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

package com.handlers;


import com.entities.Coordinates;
import com.entities.Instructions;
import com.entities.Mower;
import com.exceptions.MowerException;

import java.util.List;

public class MowerHandler {

    private Coordinates coordinatesMax;
    private Mower mower;
    private List<Instructions> instructionsList;

    public void setCoordinatesMax(Coordinates coordinatesMax) {
        this.coordinatesMax = coordinatesMax;
    }

    public void setMower(Mower mower) {
        this.mower = mower;
    }

    public void setInstructionsList(List<Instructions> instructionsList) {
        this.instructionsList = instructionsList;
    }

    public Coordinates getCoordinatesMax() {
        return coordinatesMax;
    }

    public Mower getMower() {
        return mower;
    }

    public void executeInstructions() throws MowerException {
        for(Instructions instruction : instructionsList){
            InstructionsHandler.executerInstruction(getMower(),
                    instruction, getCoordinatesMax());
        }
    }

    public String toString(){
        return 	getMower().getCoordinates().getX()
                + " "
                + getMower().getCoordinates().getY()
                + " "
                + getMower().getOrientation().getOrientation();
    }
}

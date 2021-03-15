package com.handlers;

import com.entities.*;
import com.exceptions.MowerException;

public class InstructionsHandler {

    /**
     * Exécuter l'instruction "avance" de la tondeuse
     * @param mower
     * @param coordinatesMax
     * @return les nouvelles coordonnées de la tondeuse après l'instruction "avance" si celles-ci ne dépassent pas la pelouse,
     * sinon les anciennes coordonnées de la tondeuse
     * @throws MowerException
     */
    public static Coordinates moveForward(Mower mower, Coordinates coordinatesMax) throws MowerException {
        Coordinates newCoordinates;
        int x, y;

        switch (mower.getOrientation()) {
            case NORTH:
                x = mower.getCoordinates().getX();
                y = mower.getCoordinates().getY() + 1;
                break;
            case EAST:
                x = mower.getCoordinates().getX() + 1;
                y = mower.getCoordinates().getY();
                break;
            case SOUTH:
                x = mower.getCoordinates().getX();
                y = mower.getCoordinates().getY() - 1;
                break;
            case WEST:
                x = mower.getCoordinates().getX() - 1;
                y = mower.getCoordinates().getY();
                break;
            default:
                throw new MowerException(Constants.ERROR_INCORRECT_POSITION);
        }

        newCoordinates = new Coordinates(x, y);
        if (coordinatesMax.isInsideLawn(newCoordinates)) {
            return newCoordinates;
        } else {
            return mower.getCoordinates();
        }
    }

    /**
     * Pivoter la tondeuse à droite
     * @param orientation
     * @return la nouvelle orientation de la tondeuse
     * @throws MowerException
     */
    public static Orientation swingRight(Orientation orientation) throws MowerException {
        Orientation newOrientation;
        switch (orientation){
            case NORTH :
                newOrientation =  Orientation.EAST;
                break;
            case EAST :
                newOrientation =  Orientation.SOUTH;
                break;
            case SOUTH :
                newOrientation =  Orientation.WEST;
                break;
            case WEST :
                newOrientation =  Orientation.NORTH;
                break;
            default :
                throw new MowerException(Constants.ERROR_INCORRECT_ORIENTATION);
        }
        return newOrientation;
    }

    /**
     * Pivoter la tondeuse à gauche
     * @param orientation
     * @return la nouvelle orientation de la tondeuse
     * @throws MowerException
     */
    public static Orientation swingLeft(Orientation orientation) throws MowerException {
        Orientation newOrientation;
        switch (orientation){
            case NORTH :
                newOrientation =  Orientation.WEST;
                break;
            case EAST :
                newOrientation =  Orientation.NORTH;
                break;
            case SOUTH :
                newOrientation =  Orientation.EAST;
                break;
            case WEST :
                newOrientation =  Orientation.SOUTH;
                break;
            default :
                throw new MowerException(Constants.ERROR_INCORRECT_ORIENTATION);
        }
        return newOrientation;
    }

    /**
     * Exécuter le traitement de la tondeuse selon l'instruction donnée
     * @param mower
     * @param instruction
     * @param coordinatesMax
     * @throws MowerException
     */
    public static void executerInstruction(Mower mower, Instructions instruction, Coordinates coordinatesMax) throws MowerException {
        switch (instruction){
            case AVANCE :
                mower.setCoordinates(moveForward(mower, coordinatesMax));
                break;
            case DROITE :
                mower.setOrientation(swingRight(mower.getOrientation()));
                break;
            case GAUCHE :
                mower.setOrientation(swingLeft(mower.getOrientation()));
                break;
            default: throw new MowerException(Constants.ERROR_INCORRECT_INSTRUCTION);
        }
    }
}

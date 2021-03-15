package com.handlers;

import com.entities.Constants;
import com.exceptions.MowerException;
import com.parser.MowerParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    /**
     * Traitement de la première ligne du fichier
     * @param parser
     * @param scanner
     * @throws MowerException
     */
    public static void handleFirstLine(MowerParser parser, Scanner scanner) throws MowerException {
        if (scanner.hasNext()) {
            parser.setCoordinateMax(scanner.nextLine());
        } else {
            throw new MowerException(Constants.ERROR_INCORRECT_DATA);
        }
    }

    /**
     * Traitement des lignes suivants la première ligne du fichier
     * @param parser
     * @param scanner
     * @return la liste des positions des tondeuses
     * @throws MowerException
     */
    public static List<String> handleNextLine(MowerParser parser, Scanner scanner) throws MowerException {
        List<String> positionList = new ArrayList<>();
        while (scanner.hasNext()) {
            parser.setMower(scanner.nextLine());
            if (scanner.hasNext()) {
                parser.setInstructions(scanner.nextLine());
                positionList.add(parseLaunchMower(parser));
            } else {
                throw new MowerException(Constants.ERROR_INCORRECT_DATA);
            }
        }
        return positionList;
    }

    /**
     * Parse et exécution du traitement de la tondeuse
     * @param parser
     * @return la position de la tondeuse
     * @throws MowerException
     */
    private static String parseLaunchMower(MowerParser parser) throws MowerException {
        if (!parser.executeParse()) {
            throw new MowerException(Constants.ERROR_INCORRECT_DATA);
        } else {
            MowerHandler mowerHandler = new MowerHandler();
            mowerHandler.setCoordinatesMax(
                    LineFormatter.coordinatesMaxFormat(parser.getCoordinateMax()));
            mowerHandler.setMower(LineFormatter.mowerLineFormat(parser.getMower()));
            mowerHandler.setInstructionsList(LineFormatter.instructionsFormat(parser.getInstructions()));
            mowerHandler.executeInstructions();
            System.out.println(mowerHandler);
            return mowerHandler.toString();
        }
    }
}

package com.handlers;

import com.entities.Constants;
import com.exceptions.MowerException;
import com.parser.MowerParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    public static void handleFirstLine(MowerParser parser, Scanner scanner) throws MowerException {
        if (scanner.hasNext()) {
            parser.setCoordinateMax(scanner.nextLine());
        } else {
            throw new MowerException(Constants.ERROR_INCORRECT_DATA);
        }
    }

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

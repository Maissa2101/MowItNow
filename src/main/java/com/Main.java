package com;


import com.entities.Constants;
import com.exceptions.MowerException;
import com.handlers.FileHandler;
import com.parser.MowerParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<String> results;

    public static void main(String... args) throws MowerException, IOException {
        if (args.length == 1) {
            File file = new File(args[0]);
            Main instance = new Main();
            results = instance.launchMower(file);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private List<String> launchMower(File file) throws MowerException, FileNotFoundException {
		if (!file.isFile()) {
            throw new MowerException(Constants.ERROR_UNFOUND_FILE);
        } else {
            MowerParser parser = new MowerParser();
            try(Scanner scanner = new Scanner(file)){
                FileHandler.handleFirstLine(parser, scanner);
                return FileHandler.handleNextLine(parser, scanner);
            }
		}
    }
}

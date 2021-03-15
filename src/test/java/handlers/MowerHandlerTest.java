package handlers;

import com.entities.Coordinates;
import com.entities.Instructions;
import com.entities.Mower;
import com.entities.Orientation;
import com.exceptions.MowerException;
import com.handlers.InstructionsHandler;
import com.handlers.MowerHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MowerHandlerTest {

    Coordinates coordinatesMax = new Coordinates(5, 5);

    @Test
    public void no_instruction_test() throws MowerException {
        Coordinates coordinates = new Coordinates(0, 0);
        Mower mower = new Mower(coordinates, Orientation.NORTH);
        MowerHandler mowerHandler = new MowerHandler();
        mowerHandler.setCoordinatesMax(coordinatesMax);
        mowerHandler.setMower(mower);
        mowerHandler.setInstructionsList(new ArrayList<>());
        mowerHandler.executeInstructions();
        assertEquals(mowerHandler.toString(), "0 0 N");
    }

    @Test
    public void execute_one_instruction_test() throws MowerException {
        List<Instructions> instructionList = new ArrayList<>();
        instructionList.add(Instructions.AVANCE);
        Coordinates coordinates = new Coordinates(2, 4);
        Mower mower = new Mower(coordinates, Orientation.NORTH);
        MowerHandler mowerHandler = new MowerHandler();
        mowerHandler.setCoordinatesMax(coordinatesMax);
        mowerHandler.setMower(mower);
        mowerHandler.setInstructionsList(instructionList);
        mowerHandler.executeInstructions();
        assertEquals(mowerHandler.toString(), "2 5 N");
    }

    @Test
    public void execute_multiple_instructions_test() throws MowerException{
        List<Instructions> instructionList = new ArrayList<>();
        instructionList.add(Instructions.AVANCE);
        instructionList.add(Instructions.GAUCHE);
        instructionList.add(Instructions.GAUCHE);
        instructionList.add(Instructions.AVANCE);
        instructionList.add(Instructions.DROITE);
        instructionList.add(Instructions.AVANCE);
        instructionList.add(Instructions.AVANCE);
        Coordinates coordinates = new Coordinates(2, 2);
        Mower mower = new Mower(coordinates, Orientation.SOUTH);
        MowerHandler mowerHandler = new MowerHandler();
        mowerHandler.setCoordinatesMax(coordinatesMax);
        mowerHandler.setMower(mower);
        mowerHandler.setInstructionsList(instructionList);
        mowerHandler.executeInstructions();
        assertEquals(mowerHandler.toString(), "4 2 E");
    }

    @Test
    public void move_forward_north_coordinates_test() throws MowerException {
        int x = 0;
        int y = 0;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.NORTH);
        InstructionsHandler.executerInstruction(mower, Instructions.AVANCE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(x, y+1));
        assertEquals(mower.getOrientation(), Orientation.NORTH);
    }

    @Test
    public void move_forward_east_coordinates_test() throws MowerException {
        int x = 0;
        int y = 0;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.EAST);
        InstructionsHandler.executerInstruction(mower, Instructions.AVANCE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(x+1, y));
        assertEquals(mower.getOrientation(), Orientation.EAST);
    }

    @Test
    public void move_forward_south_coordinates_test() throws MowerException {
        int x = 1;
        int y = 5;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.SOUTH);
        InstructionsHandler.executerInstruction(mower, Instructions.AVANCE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(x, y-1));
        assertEquals(mower.getOrientation(), Orientation.SOUTH);
    }

    @Test
    public void move_forward_west_coordinates_test() throws MowerException {
        int x = 5;
        int y = 5;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.WEST);
        InstructionsHandler.executerInstruction(mower, Instructions.AVANCE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(x-1, y));
        assertEquals(mower.getOrientation(), Orientation.WEST);
    }

    @Test
    public void swing_right_north_coordinates_test() throws MowerException {
        int x = 4;
        int y = 3;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.NORTH);
        InstructionsHandler.executerInstruction(mower, Instructions.DROITE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(x, y));
        assertEquals(mower.getOrientation(), Orientation.EAST);
    }

    @Test
    public void swing_right_east_coordinates_test() throws MowerException {
        int x = 4;
        int y = 3;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.EAST);
        InstructionsHandler.executerInstruction(mower, Instructions.DROITE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(x, y));
        assertEquals(mower.getOrientation(), Orientation.SOUTH);
    }

    @Test
    public void swing_right_west_coordinates_test() throws MowerException {
        int x = 4;
        int y = 3;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.WEST);
        InstructionsHandler.executerInstruction(mower, Instructions.DROITE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(x, y));
        assertEquals(mower.getOrientation(), Orientation.NORTH);
    }

    @Test
    public void swing_right_south_coordinates_test() throws MowerException {
        int x = 4;
        int y = 3;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.SOUTH);
        InstructionsHandler.executerInstruction(mower, Instructions.DROITE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(x, y));
        assertEquals(mower.getOrientation(), Orientation.WEST);
    }

    @Test
    public void swing_left_west_coordinates_test() throws MowerException {
        int x = 4;
        int y = 3;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.WEST);
        InstructionsHandler.executerInstruction(mower, Instructions.GAUCHE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(x, y));
        assertEquals(mower.getOrientation(), Orientation.SOUTH);
    }

    @Test
    public void swing_left_east_coordinates_test() throws MowerException {
        int x = 4;
        int y = 3;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.EAST);
        InstructionsHandler.executerInstruction(mower, Instructions.GAUCHE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(x, y));
        assertEquals(mower.getOrientation(), Orientation.NORTH);
    }

    @Test
    public void swing_left_north_coordinates_test() throws MowerException {
        int x = 4;
        int y = 3;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.NORTH);
        InstructionsHandler.executerInstruction(mower, Instructions.GAUCHE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(x, y));
        assertEquals(mower.getOrientation(), Orientation.WEST);
    }
    @Test
    public void swing_left_south_coordinates_test() throws MowerException {
        int x = 4;
        int y = 3;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.SOUTH);
        InstructionsHandler.executerInstruction(mower, Instructions.GAUCHE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(x, y));
        assertEquals(mower.getOrientation(), Orientation.EAST);
    }

    @Test
    public void execute_case_test() throws MowerException{
        List<Instructions> instructionsList = new ArrayList<>();
        instructionsList.add(Instructions.GAUCHE);
        instructionsList.add(Instructions.AVANCE);
        instructionsList.add(Instructions.GAUCHE);
        instructionsList.add(Instructions.AVANCE);
        instructionsList.add(Instructions.GAUCHE);
        instructionsList.add(Instructions.AVANCE);
        instructionsList.add(Instructions.GAUCHE);
        instructionsList.add(Instructions.AVANCE);
        instructionsList.add(Instructions.AVANCE);
        int x = 1;
        int y = 2;
        Coordinates coordinates = new Coordinates(x, y);
        Mower mower = new Mower(coordinates, Orientation.NORTH);
        MowerHandler mowerHandler = new MowerHandler();
        mowerHandler.setCoordinatesMax(coordinatesMax);
        mowerHandler.setMower(mower);
        mowerHandler.setInstructionsList(instructionsList);
        mowerHandler.executeInstructions();
        assertEquals(mowerHandler.toString(), "1 3 N");
    }
}

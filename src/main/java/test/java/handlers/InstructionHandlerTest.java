package test.java.handlers;

import com.entities.Coordinates;
import com.entities.Instructions;
import com.entities.Mower;
import com.entities.Orientation;
import com.exceptions.MowerException;
import com.handlers.InstructionsHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionHandlerTest {

    @Test
    public void moveForward_keep_orientation_test() throws MowerException {
        Coordinates coordinatesMax = new Coordinates(5, 5);
        Coordinates coordinates = new Coordinates(1, 5);
        Mower mower = new Mower(coordinates, Orientation.WEST);
        InstructionsHandler.executerInstruction(mower, Instructions.AVANCE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(0, 5));
        assertEquals(mower.getOrientation(), Orientation.WEST);
    }

    @Test
    public void mower_swing_right_test() throws MowerException {
        Coordinates coordinatesMax = new Coordinates(5, 5);
        Coordinates coordinates = new Coordinates(1, 5);
        Mower mower = new Mower(coordinates, Orientation.WEST);
        InstructionsHandler.executerInstruction(mower, Instructions.DROITE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(1, 5));
        assertEquals(mower.getOrientation(), Orientation.NORTH);
    }

    @Test
    public void mower_swing_left_test() throws MowerException {
        Coordinates coordinatesMax = new Coordinates(5, 5);
        Coordinates coordinates = new Coordinates(1, 5);
        Mower mower = new Mower(coordinates, Orientation.WEST);
        InstructionsHandler.executerInstruction(mower, Instructions.GAUCHE, coordinatesMax);
        assertEquals(mower.getCoordinates(), new Coordinates(1, 5));
        assertEquals(mower.getOrientation(), Orientation.SOUTH);
    }


    @Test
    public void swing_right_test() throws MowerException {
        Orientation newOrientation = InstructionsHandler.swingRight(Orientation.EAST);
        assertEquals(newOrientation, Orientation.SOUTH);

        newOrientation = InstructionsHandler.swingRight(Orientation.WEST);
        assertEquals(newOrientation, Orientation.NORTH);

        newOrientation = InstructionsHandler.swingRight(Orientation.NORTH);
        assertEquals(newOrientation, Orientation.EAST);

        newOrientation = InstructionsHandler.swingRight(Orientation.SOUTH);
        assertEquals(newOrientation, Orientation.WEST);
    }

    @Test
    public void swing_left_test() throws MowerException {
        Orientation newOrientation = InstructionsHandler.swingLeft(Orientation.EAST);
        assertEquals(newOrientation, Orientation.NORTH);

        newOrientation = InstructionsHandler.swingLeft(Orientation.WEST);
        assertEquals(newOrientation, Orientation.SOUTH);

        newOrientation = InstructionsHandler.swingLeft(Orientation.NORTH);
        assertEquals(newOrientation, Orientation.WEST);

        newOrientation = InstructionsHandler.swingLeft(Orientation.SOUTH);
        assertEquals(newOrientation, Orientation.EAST);
    }
}

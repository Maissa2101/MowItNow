package test.java.handlers;

import com.entities.Coordinates;
import com.entities.Instructions;
import com.entities.Orientation;
import com.handlers.LineFormatter;
import org.junit.Test;

import static org.junit.Assert.*;


public class LineFormatterTest {

    @Test
    public void mowerLine_format_test() {
        assertEquals(LineFormatter.mowerLineFormat("5 1 W").getCoordinates(),
                new Coordinates(5, 1));
        assertEquals(LineFormatter.mowerLineFormat("1 1 S").getOrientation(),
                Orientation.SOUTH);
    }

    @Test
    public void coordinateMaxFormat_test() {
        assertEquals(LineFormatter.coordinatesMaxFormat("5 7"),
                new Coordinates(5, 7));
    }

    @Test
    public void instructionsFormat_test() {
        assertEquals(LineFormatter.instructionsFormat("GADGGA").size(), 6);
        assertTrue(LineFormatter.instructionsFormat("GADGGA").contains(Instructions.DROITE));
        assertTrue(LineFormatter.instructionsFormat("GADGGA").contains(Instructions.GAUCHE));
        assertTrue(LineFormatter.instructionsFormat("GADGGA").contains(Instructions.AVANCE));
    }

    @Test
    public void getOrientation_test() {
        assertEquals(LineFormatter.getOrientation('E'), Orientation.EAST);
        assertEquals(LineFormatter.getOrientation('N'), Orientation.NORTH);
        assertEquals(LineFormatter.getOrientation('S'), Orientation.SOUTH);
        assertEquals(LineFormatter.getOrientation('W'), Orientation.WEST);
        assertNull(LineFormatter.getOrientation('a'));
    }

    @Test
    public void getInstruction_test() {
        assertEquals(LineFormatter.getInstruction('A'),Instructions.AVANCE);
        assertEquals(LineFormatter.getInstruction('D'), Instructions.DROITE);
        assertEquals(LineFormatter.getInstruction('G'), Instructions.GAUCHE);
        assertNull(LineFormatter.getInstruction(' '));
    }
}

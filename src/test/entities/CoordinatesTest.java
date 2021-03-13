package test.entities;

import static org.junit.Assert.*;

import com.entities.Coordinates;
import org.junit.Test;

public class CoordinatesTest {

    @Test
    public void verify_coordinates_equality(){
        Coordinates c1 = new Coordinates(1, 2);
        Coordinates c2 = new Coordinates(1, 2);
        assertEquals(c1, c2);
        c2 = new Coordinates(1, 3);
        assertNotEquals(c1,c2);
    }

    @Test
    public void verify_not_outisde_lawn() {
        Coordinates coordinates = new Coordinates(5,5);
        Coordinates c0 = new Coordinates(-1,-6);
        Coordinates c1 = new Coordinates(0,1);
        assertFalse(coordinates.isInsideLawn(c0));
        assertTrue(coordinates.isInsideLawn(c1));
    }
}

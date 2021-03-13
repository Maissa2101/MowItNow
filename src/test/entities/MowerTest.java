package test.entities;

import com.entities.Coordinates;
import com.entities.Mower;
import com.entities.Orientation;
import org.junit.Test;
import static org.junit.Assert.*;

public class MowerTest {

    @Test
    public void verify_mower_equality() {
        Coordinates coordinates = new Coordinates(1, 5);
        Mower m1 = new Mower(coordinates, Orientation.NORTH);
        Mower m2 = new Mower(coordinates, Orientation.NORTH);
        assertEquals(m1, m2);
        m2 = new Mower(new Coordinates(0,5), Orientation.NORTH);
        assertNotEquals(m1,m2);
        m2 = new Mower(new Coordinates(1,5), Orientation.SOUTH);
        assertNotEquals(m1,m2);
    }
}

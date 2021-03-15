package parser;

import com.parser.MowerParser;
import org.junit.Test;

import static org.junit.Assert.*;


public class MowerParserTest {

    @Test
    public void mower_parse_test(){
        assertFalse(MowerParser.mowerParse(""));
        assertFalse(MowerParser.mowerParse("0 2 7"));
        assertFalse(MowerParser.mowerParse("12N"));
        assertTrue(MowerParser.mowerParse("1 2 N"));
        assertTrue(MowerParser.mowerParse("2 4 S"));
    }

    @Test
    public void instruction_parse_test(){
        assertFalse(MowerParser.instructionParse(""));
        assertFalse(MowerParser.instructionParse(" "));
        assertFalse(MowerParser.instructionParse("D G"));
        assertFalse(MowerParser.instructionParse("DAAGGGDGAN"));
        assertFalse(MowerParser.instructionParse("DDAA AAN"));
        assertTrue(MowerParser.instructionParse("DGA"));
        assertTrue(MowerParser.instructionParse("AGGADAA"));
    }

    @Test
    public void coordinateMax_parse_test(){
        assertFalse(MowerParser.coordinateMaxParse(""));
        assertFalse(MowerParser.coordinateMaxParse("1 2 9"));
        assertFalse(MowerParser.coordinateMaxParse("123"));
        assertFalse(MowerParser.coordinateMaxParse("1 2 "));
        assertTrue(MowerParser.coordinateMaxParse("1 2"));
        assertFalse(MowerParser.coordinateMaxParse("1 N"));
        assertFalse(MowerParser.coordinateMaxParse("A 0"));
    }
}

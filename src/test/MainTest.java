package test;

import com.Main;
import com.entities.Constants;
import com.exceptions.MowerException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MainTest {

    final String FILE_PATH = "./src/resources/";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void args_error_test() throws MowerException, IOException {
        Main.main("a", "b", "4");
    }

    @Test
    public void file_not_found_test() throws MowerException, IOException {
        expectedException.expect(MowerException.class);
        expectedException.expectMessage(Constants.ERROR_UNFOUND_FILE);
        Main.main("fileNotFound");
    }

    @Test
    public void error_line_test() throws MowerException, IOException {
        expectedException.expect(MowerException.class);
        expectedException.expectMessage(Constants.ERROR_INCORRECT_DATA);
        Main.main(FILE_PATH + "file1.txt");
    }
    @Test
    public void missing_line_in_file_test() throws MowerException, IOException {
        expectedException.expect(MowerException.class);
        expectedException.expectMessage(Constants.ERROR_INCORRECT_DATA);
        Main.main(FILE_PATH + "file_missing_lines.txt");

    }
    @Test
    public void empty_file_test() throws MowerException, IOException {
        expectedException.expect(MowerException.class);
        expectedException.expectMessage(Constants.ERROR_INCORRECT_DATA);
        Main.main(FILE_PATH + "empty_file.txt");

    }

    @Test
    public void file_ko_test() throws MowerException, IOException {
        expectedException.expect(MowerException.class);
        expectedException.expectMessage(Constants.ERROR_INCORRECT_DATA);
        Main.main(FILE_PATH + "file_ko.txt");
    }

    @Test
    public void file_ok_test() throws MowerException, IOException {
        Main.main(FILE_PATH + "file_ok.txt");
        assertNotNull(Main.results);
        assertTrue(Main.results.size() == 2);
        assertTrue(Main.results.contains("1 3 N"));
        assertTrue(Main.results.contains("5 1 E"));
    }
}

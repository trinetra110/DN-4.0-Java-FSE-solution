
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class SampleServiceTest {

    private SampleService service;

    @Before
    public void setUp() {
        // Setup — runs before each test
        service = new SampleService();
        System.out.println("Setup completed.");
    }

    @After
    public void tearDown() {
        // Teardown — runs after each test
        service = null;
        System.out.println("Teardown completed.");
    }

    @Test
    public void testSquare() {
        // Arrange
        int input = 4;

        // Act
        int result = service.square(input);

        // Assert
        assertEquals(16, result);
    }

    @Test
    public void testIsPositive() {
        // Arrange
        int input = 10;

        // Act
        boolean result = service.isPositive(input);

        // Assert
        assertTrue(result);
    }
}

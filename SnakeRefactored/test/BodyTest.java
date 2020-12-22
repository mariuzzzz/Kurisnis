import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodyTest {
    private final Body bodyTest = new Body(3, 3, 10);

    @Test
    public void getxC() throws Exception{
        assertEquals(bodyTest.getxC(), 3);
    }

    @Test
    public void getyC() throws Exception{
        assertEquals(bodyTest.getyC(), 3);
    }
}
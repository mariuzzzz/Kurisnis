import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodTest {
    private final Food foodTest = new Food(3, 3, 10);
    @Test
    public void getxC() throws Exception{
        assertEquals(foodTest.getxC(), 3);
    }

    @Test
    public void getyC() throws Exception{
        assertEquals(foodTest.getyC(), 3);
    }
}
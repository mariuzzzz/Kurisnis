import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void snakeAteItself() {
        Board snake = new Board();
        assertEquals(10, snake.getxC());
    }

    @Test
    public void snakeHitTheBoarder() {
        Board snake = new Board();
        assertEquals(10, snake.getxC());
    }

    @Test
    void isSnakeExists() {
        ArrayList<Body> snake = new ArrayList<Body>();
        assertFalse(Board.isSnakeExists(snake));
    }

    @Test
    void TheBoarderIsHit() {
        Board snake = new Board();
        assertFalse(Board.TheBoarderIsHit(snake.getxC(), snake.getyC()));
    }

}
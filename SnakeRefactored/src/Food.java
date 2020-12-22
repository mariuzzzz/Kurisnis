import java.awt.*;

public class Food {

    private int xC, yC, width, height;

    public Food(int xC, int yC, int foodSize) {
        this.xC = xC;
        this.yC = yC;
        width = foodSize;
        height = foodSize;
    }


    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(xC * width, yC * height, width, height);

    }

    public int getxC() {
        return xC;
    }

    public void setxC(int xC) {
        this.xC = xC;
    }

    public int getyC() {
        return yC;
    }

    public void setyC(int yC) {
        this.yC = yC;
    }
}

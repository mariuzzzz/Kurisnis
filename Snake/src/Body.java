import java.awt.*;

public class Body {

    private int xC,yC, width, height;

    public Body(int xC, int yC, int snakePixelSize) {
        this.xC =xC;
        this.yC=yC;
        width = snakePixelSize;
        height = snakePixelSize;
    }

    public void mark() {

    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(xC*width,yC*height, width, height);

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


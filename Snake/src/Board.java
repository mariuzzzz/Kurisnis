import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Board extends JPanel implements Runnable, KeyListener {

    private static final int WIDTH = 500, HEIGHT = 500;

    private Thread thread;

    private boolean started;

    private boolean right = true, left = false, up = false, down = false;

    private Body b;
    private ArrayList<Body> snake;

    private Food food;
    private ArrayList<Food> foods;

    Random r;
    private int xC = 10, yC = 10, size = 5;
    private int dots = 0;


    public Board() {
        setFocusable(true);

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);

        snake = new ArrayList<Body>();
        foods = new ArrayList<Food>();

        r = new Random();

        start();

    }

    public void start() {
        started = true;
        thread = new Thread(this);
        thread.start();
    }

    public void end() {
        started = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    int speed = 800000;

    public void mark() {

        if (snake.size() == 0) {
            b = new Body(xC, yC, 10);
            snake.add(b);
        }
        dots++;
        if (dots > speed) {
            if (right) xC++;
            if (left) xC--;
            if (up) yC--;
            if (down) yC++;

            dots = 0;

            b = new Body(xC, yC, 10);
            snake.add(b); //gyvatele sukuriama kitoje vietoje, priklausomai nuo kur buvo paeita

            if (snake.size() > size) {
                snake.remove(0);//sunaikinamas gyvateles paskutinis pixelis.
            }
        }
        if (foods.size() == 0) {
            int xC = r.nextInt(49);
            int yC = r.nextInt(49);

            food = new Food(xC, yC, 10);
            foods.add(food);
        }
        for (int i = 0; i < foods.size(); i++) {
            if (xC == foods.get(i).getxC() && yC == foods.get(i).getyC()) {
                size++;
                foods.remove(i);
                i++;
            }
        }
        for (int i = 0; i < snake.size(); i++) {
            if (xC == snake.get(i).getxC() && yC == snake.get(i).getyC()) {
                if (i != snake.size() - 1) {
                    System.out.println("Game Over");
                    end();
                }
            }
        }

        if (xC < 0 || xC > 49 || yC < 0 || yC > 49) {
            System.out.println("Game Over");
            end();
        }
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        for (int i = 0; i < WIDTH / 10; i++) {
            g.drawLine(i * 10, 0, i * 10, HEIGHT);
        }

        for (int i = 0; i < HEIGHT / 10; i++) {
            g.drawLine(0, i * 10, HEIGHT, i * 10);
        }

        for (int i = 0; i < snake.size(); i++) {
            snake.get(i).draw(g);
        }
        for (int i = 0; i < foods.size(); i++) {
            foods.get(i).draw(g);
        }
    }

    @Override
    public void run() {
        while (started) {
            mark();
            repaint();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT && !left) {
            right = true;
            up = false;
            down = false;
        }
        if (key == KeyEvent.VK_LEFT && !right) {
            left = true;
            up = false;
            down = false;
        }
        if (key == KeyEvent.VK_UP && !down) {
            up = true;
            right = false;
            left = false;
        }
        if (key == KeyEvent.VK_DOWN && !up) {
            right = false;
            left = false;
            down = true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D && !left) {
            right = true;
            up = false;
            down = false;
        }
        if (key == KeyEvent.VK_A && !right) {
            left = true;
            up = false;
            down = false;
        }
        if (key == KeyEvent.VK_W && !down) {
            up = true;
            right = false;
            left = false;
        }
        if (key == KeyEvent.VK_S && !up) {
            right = false;
            left = false;
            down = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

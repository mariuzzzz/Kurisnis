import javax.swing.*;

public class Main {

    public Main() {
        JFrame frame = new JFrame();
        Board board = new Board();

        frame.add(board);
        frame.setTitle("SNAKE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Main();

    }
}

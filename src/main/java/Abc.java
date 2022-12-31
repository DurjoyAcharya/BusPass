import javax.swing.*;
import java.awt.*;

public class Abc extends JFrame {
    public Abc() throws HeadlessException {
        setTitle("Home");
        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Abc();
    }
}

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class AboutDev {
    public static void main(String[] args) {
        new AboutDev().createWindow();
    }
    public   void createWindow() {
        JFrame frame = new JFrame("About Developer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(560, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void createUI(final JFrame frame){
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);

        JEditorPane jEditorPane = new JEditorPane();
        jEditorPane.setEditable(false);
        URL url= AboutDev.class.getResource("test.htm");

        try {
            jEditorPane.setPage(url);
        } catch (IOException e) {
            jEditorPane.setContentType("text/html");
            jEditorPane.setText("<html>Page not found.</html>");
        }

        JScrollPane jScrollPane = new JScrollPane(jEditorPane);
        jScrollPane.setPreferredSize(new Dimension(540,400));

        panel.add(jScrollPane);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}

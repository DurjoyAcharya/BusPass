import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class VirtualConsoleController extends JPanel {
    private Path path;
    private ArrayList<String> list;
    private JTextArea textArea = new JTextArea(30, 60);
    private VirtualConsole taOutputStream = new VirtualConsole(
            textArea, "");
    private void fetchData() throws IOException {
        list=new ArrayList<>();
        path=Path.of("/home/rupkotha/IdeaProjects/BusPass/src/main/resources/bus-list.txt");
        var s=  Files.readAllLines(path);
        list= (ArrayList<String>) s;
    }
    public VirtualConsoleController() throws IOException {
        setLayout(new BorderLayout());
        textArea.setBackground(new Color(135,246,235));
        add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        System.setOut(new PrintStream(taOutputStream));
        System.out.println("\t\tBus-List With Start-Point And End-Point");
        textArea.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
        fetchData();
        list.forEach(System.out::println);

    }
    private static void createAndShowGui() throws IOException {
        JFrame frame = new JFrame("Bus List Starts Point & Destination Point");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new VirtualConsoleController());
        frame.pack();
        frame.setSize(900,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

   public void VirtualConsoleTester() {
       SwingUtilities.invokeLater(() -> {
           try {
               createAndShowGui();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       });
   }

}

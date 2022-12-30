import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BusVara extends JFrame {
    private static final long serialVersionUID = 1L;
    public static ArrayList<String> list,list_1;

    public static final int W_FRAME = 540;
    public static final int H_FRAME = 360;
    private JPanel contentPane;
    private JButton button_login;
    private JLabel label_username, label_password;
    private JTextField textField_username;
    private JTextField destText;
    private Insets insets;

    private JLabel busName,vara,time;
    public BusVara() throws HeadlessException {
        setTitle("Bus-Vara");
        setSize(700,500);
        setIconImage(new ImageIcon("/home/rupkotha/IdeaProjects/BusPass/src/icon.png").getImage());


        insets = this.getInsets();

        GUI();


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    private void GUI() {

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBounds(insets.left, insets.top, W_FRAME - insets.left - insets.right,
                H_FRAME - insets.bottom - insets.top);

        label_username = new JLabel("Starting Point: ");
        label_username.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        label_username.setBounds(100, 100, 180, 20);
        contentPane.add(label_username);

        label_password = new JLabel("Destination Point: ");
        label_password.setFont(label_username.getFont());
        label_password.setBounds(label_username.getX(), label_username.getY() + 40,
                label_username.getWidth(), label_username.getHeight());
        contentPane.add(label_password);

        textField_username = new JTextField();
        textField_username.setBounds(label_username.getX() + label_username.getWidth() + 30,
                label_username.getY(), 250, label_username.getHeight());
        textField_username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //passwordField_password.requestFocus();
            }
        });
        contentPane.add(textField_username);

        destText = new JTextField();
        destText.setBounds(textField_username.getX(), label_password.getY(),
                250, label_password.getHeight());
        destText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button_login.doClick();
            }
        });
        contentPane.add(destText);

        button_login = new JButton("Search");
        button_login.setBounds(textField_username.getX(), label_username.getY() + 80, 100, 22);
        button_login.setFocusPainted(false);
        button_login.setBackground(Color.ORANGE);
        button_login.setFont(new Font(Font.MONOSPACED,Font.BOLD,16));
        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        contentPane.add(button_login);

        contentPane.setBackground(Color.pink);

        busName=new JLabel("Bus Name: Rajdhani");
        busName.setSize(300,30);
        busName.setLocation(label_username.getX(),250);
        busName.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
        busName.setForeground(Color.BLUE);
        contentPane.add(busName);

        vara=new JLabel("Vara: 50TK");
        vara.setSize(300,30);
        vara.setLocation(label_username.getX(),300);
        vara.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
        vara.setForeground(Color.BLUE);
        contentPane.add(vara);


        time=new JLabel("Time: 6AM-8PM");
        time.setSize(300,30);
        time.setLocation(label_username.getX(),350);
        time.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
        time.setForeground(Color.BLUE);
        contentPane.add(time);

        setContentPane(contentPane);
    }
    private static void fetchDataFromStart() throws IOException {
        Path path;
        list=new ArrayList<>();
        path= Path.of("/home/rupkotha/IdeaProjects/BusPass/src/main/resources/StartPoint.txt");
        var s=  Files.readAllLines(path);
        list= (ArrayList<String>) s;
    }
    private static void fetchDataFromDestination() throws IOException {
        Path path;
        list_1=new ArrayList<>();
        path= Path.of("/home/rupkotha/IdeaProjects/BusPass/src/main/resources/DestPoint.txt");
        var s=  Files.readAllLines(path);
        list_1= (ArrayList<String>) s;
    }
    public static void main(String[] args) throws IOException {
        fetchDataFromStart();
        var find=list
                          .stream()
                          .filter(x->x.equals("Savar"))
                          .findFirst();
        System.out.println(find.orElse("null"));
        fetchDataFromDestination();
        var dest=list_1
                .stream()
                .filter(x->x.equals("Mirpur 1"))
                .findFirst()
                .orElse("null");
        System.out.println(dest);



    }
}
//        List<String> collect = list.stream()
//                .collect(Collectors
//                .groupingBy(Function.identity(),Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(p->p.getValue()>1)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());

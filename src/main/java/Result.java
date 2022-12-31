import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;

public class Result extends JFrame {
    private static final long serialVersionUID = 1L;
    public static final int W_FRAME = 540;
    private static final Path path=Path.of("/home/rupkotha/IdeaProjects/BusPass/src/main/resources/dbfiles/vara.txt");
    public static final int H_FRAME = 360;
    private JPanel contentPane;
    private JLabel label_username, label_password;

    private Insets insets;
    public int value;

    private JLabel distance;
    private JLabel title;
    private JButton Print;
    private JLabel date;
    private Date dateNow;

    public Result() throws HeadlessException {
        setTitle("Bus-Vara");
        setIconImage(new ImageIcon("/home/rupkotha/IdeaProjects/BusPass/src/icon.png").getImage());
        setBounds(0,0,600,400);
        insets = this.getInsets();
        GUI();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void GUI() {

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBounds(insets.left, insets.top, W_FRAME - insets.left - insets.right,
                H_FRAME - insets.bottom - insets.top);


        label_username = new JLabel("Starting Point: ");
        label_username.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
        label_username.setBounds(100, 40, 250, 20);
        contentPane.add(label_username);


        title=new JLabel("Hisab");
        title.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
        title.setBounds(250,0,180,20);
        contentPane.add(title);


        label_password = new JLabel("Destination Point: ");
        label_password.setFont(label_username.getFont());
        label_password.setBounds(label_username.getX(), label_username.getY() + 40,
                label_username.getWidth()+60, label_username.getHeight());
        contentPane.add(label_password);


        distance = new JLabel("Total Vara: ");
        distance.setFont(label_username.getFont());
        distance.setBounds(label_username.getX(), label_username.getY() + 80,
                label_username.getWidth(), label_username.getHeight());
        contentPane.add(distance);
        Print=new JButton("Print");
        Print.setFont(distance.getFont());
        Print.setUI(new StyledButtonUI());
        Print.setBackground(Color.GREEN);
        Print.setBounds(label_username.getX(),label_username.getY()+120,100,40);
        //
        label_username.setText("Starting Point: "+BusVara.textField_username.getText());
        label_password.setText("Destination Point: "+BusVara.destText.getText());
        value=5*Integer.parseInt(String.valueOf(BusVara.textDist.getText()));
        distance.setText("Total Vara: "+value);

        Print.addActionListener(e->{
            try {

                String temp="From: "+BusVara.textField_username.getText()+"\n"+"To: "+BusVara.destText.getText()
                        +"\nBus Vara: "+value;

             Files.writeString(path,temp);
             JOptionPane.showMessageDialog(null,"File Store Successfully");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        contentPane.add(Print);
        contentPane.setBackground(Color.pink);
        date=new JLabel("");
        date.setFont(distance.getFont());
        date.setBounds(distance.getX(),distance.getY()+100,distance.getWidth()+80, distance.getHeight());
        dateNow=new Date();
        date.setText(dateNow.toString());
        contentPane.add(date);
        setResizable(false);
        setContentPane(contentPane);
    }

    public static void main(String[] args) {
        new Result();
    }
}

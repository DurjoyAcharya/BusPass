import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame {
    public Home()
    {
        setTitle("Home");
        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setIcon(new ImageIcon("/home/rupkotha/IdeaProjects/BusPass/src/image.png"));
        label.setBounds(50, 50, 200, 200);
        getContentPane().add(label);
        var t1=new JLabel("Welcome to BusPass");
        t1.setBounds(300,100, 350,30);
        Font  f3  = new Font(Font.DIALOG,  Font.BOLD, 24);
        t1.setFont(f3);
        var btn=new JButton("Next");
        btn.setBounds(470,620,200,100);
        btn.setBackground(Color.GREEN);
        var btn1=new JButton("Exit");
        btn1.setBounds(200,620,200,100);
        btn1.setBackground(Color.RED);


        btn.setFont(new Font("Calibri", Font.BOLD, 24));
        btn.setBackground(Color.GREEN);
        btn.setForeground(Color.white);
        btn.setUI(new StyledButtonUI());

        btn1.setFont(new Font("Calibri", Font.BOLD, 24));
        btn1.setBackground(Color.RED);
        btn1.setForeground(Color.white);
        btn1.setUI(new StyledButtonUI());


        label.add(btn);
        label.add(btn1);
        label.add(t1);
        getContentPane().add(label);
        btn1.addActionListener((e)->{
            System.exit(0);
        });
        btn.addActionListener((event)->{
            new NextPage();
            setVisible(false);
        });
        setIconImage(new ImageIcon("/home/rupkotha/IdeaProjects/BusPass/src/icon.png").getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Home();
    }
}


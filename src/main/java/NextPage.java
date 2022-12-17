import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class NextPage extends JFrame {
    public NextPage() throws HeadlessException {
        setTitle("BusPass-Index");
        setSize(700,700);
        setIconImage(new ImageIcon("/home/rupkotha/IdeaProjects/BusPass/src/icon.png").getImage());
        JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        var btn=new JButton("Find Routes");
        btn.setBounds(120,250,200,100);
        var btn2=new JButton("Buses List");
        btn2.setBounds(350,250,200,100);
        label.add(btn);
        label.add(btn2);
        var btn3=new JButton("Bus Vara");
        btn3.setBounds(350,370,200,100);
        label.add(btn3);

        var btn4=new JButton("Safety Tips");
        btn4.setBounds(120,370,200,100);
        label.add(btn4);

        var btn5=new JButton("Developer Info");
        btn5.setBounds(140,490,400,100);
        label.add(btn5);

        add(label);
        getContentPane().setBackground(new Color(247, 207, 184));

        btn.addActionListener((event)->{
            System.out.println("Button-1");
        });
        btn2.addActionListener((event)->{
            System.out.println("Button-2");
        });
        btn3.addActionListener((event)->{
            System.out.println("Button-3");
        });
        btn4.addActionListener((event)->{
            System.out.println("Button-4");
        });
        btn5.addActionListener((event)->{
            new AboutDev().createWindow();
            setVisible(false);
        });
        //button design
        btn.setFont(new Font("Calibri", Font.BOLD, 18));
        btn.setBackground(new Color(0x2dce98));
        btn.setForeground(Color.white);
        btn.setUI(new StyledButtonUI());
        btn2.setFont(new Font("Calibri", Font.BOLD, 18));
        btn2.setBackground(new Color(0x2dce98));
        btn2.setForeground(Color.white);
        btn2.setUI(new StyledButtonUI());

        btn3.setFont(new Font("Calibri", Font.BOLD, 18));
        btn3.setBackground(new Color(0x2dce98));
        btn3.setForeground(Color.white);
        btn3.setUI(new StyledButtonUI());

        btn4.setFont(new Font("Calibri", Font.BOLD, 18));
        btn4.setBackground(new Color(0x2dce98));
        btn4.setForeground(Color.white);
        btn4.setUI(new StyledButtonUI());

        btn5.setFont(new Font("Calibri", Font.BOLD, 18));
        btn5.setBackground(new Color(0x2dce98));
        btn5.setForeground(Color.white);
        btn5.setUI(new StyledButtonUI());



        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



    }
    public static void main(String[] args) {
    new NextPage();
    }
}
class StyledButtonUI extends BasicButtonUI {

    @Override
    public void installUI (JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c.getBackground().darker());
        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
        g.setColor(c.getBackground());
        g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
    }
}
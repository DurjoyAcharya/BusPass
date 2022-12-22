import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

public class VirtualConsole extends OutputStream {
    private final JTextArea textArea;
    private final StringBuilder sb = new StringBuilder();
    private String title;

    public VirtualConsole(JTextArea textArea, String title) {
        this.textArea = textArea;
        this.title = title;
    }
    @Override
    public void flush() {
    }
    @Override
    public void close() {
    }
    @Override
    public void write(int b) throws IOException {
        if (b == '\r')
            return;
        if (b == '\n') {
            final String text = sb + "\n";
            SwingUtilities.invokeLater(()->{
                textArea.append(text);
            });
            sb.setLength(0);
            sb.append(title);
            return;
        }
        sb.append((char) b);
    }
}

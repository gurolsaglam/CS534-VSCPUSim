import javax.swing.*;
import javax.swing.text.JTextComponent;

public class MessageMediator {
    private JComponent jComponent;

    public MessageMediator(JComponent jComponent) {
        this.jComponent = jComponent;
    }

    public void sendMessage (String string) {
        if (jComponent == null) {
            System.out.println(string);
        } else {
            if (this.jComponent instanceof JTextComponent) {
                ((JTextComponent) this.jComponent).setText(string);
            } else if (this.jComponent instanceof JLabel) {
                ((JLabel) this.jComponent).setText(string);
            } else {
                System.out.println(string);
            }
        }
    }
}

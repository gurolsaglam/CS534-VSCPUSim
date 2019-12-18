import javax.swing.*;
import javax.swing.text.JTextComponent;


//MEDIATOR PATTERN
public class MessageMediator {
    private static MessageMediator messageMediator = new MessageMediator();
    private JComponent jComponent;

    private MessageMediator() {
    }

    public static MessageMediator getInstance(JComponent jComponent) {
        messageMediator.setJComponent(jComponent);
        return messageMediator;
    }

    private void setJComponent(JComponent jComponent) {
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

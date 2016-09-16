package window;

import javax.swing.*;

import static com.sun.glass.ui.Cursor.setVisible;

/**
 * Created by AKrzos on 2016-09-06.
 */
public class DispenserWindow extends JFrame{
    private JPanel rootPanel;
    private BallButton ballButton;

    public DispenserWindow() {
        super("Diablo Saver");
        setResizable(false);
        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

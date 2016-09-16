package window;

import main.Main;

import javax.swing.*;

/**
 * Created by AKrzos on 2016-09-07.
 */
public class BallButton extends JButton {
    private static ImageIcon createImageIcon(String path,
                                             String description) {
        java.net.URL imgURL = Main.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}

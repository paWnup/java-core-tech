package com.pa.note.v1ch11.RobotTest;

import javax.swing.*;

/**
 * A frame with a button panel
 *
 * @author Cay Horstmann
 * @version 1.31 2004-05-11
 */
class ButtonFrame extends JFrame {
    public ButtonFrame() {
        setTitle("ButtonTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // add panel to frame

        ButtonPanel panel = new ButtonPanel();
        add(panel);
    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
}

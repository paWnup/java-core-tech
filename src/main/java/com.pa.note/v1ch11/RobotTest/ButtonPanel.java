package com.pa.note.v1ch11.RobotTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A panel with three buttons
 *
 * @author Cay Horstmann
 * @version 1.32 2004-05-11
 */
class ButtonPanel extends JPanel {
    public ButtonPanel() {
        // create buttons

        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");

        // add buttons to panel

        add(yellowButton);
        add(blueButton);
        add(redButton);

        // create button actions

        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);

        // associate actions with buttons

        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }

    /**
     * An action listener that sets the panel's background color.
     */
    private class ColorAction implements ActionListener {
        public ColorAction(Color c) {
            backgroundColor = c;
        }

        public void actionPerformed(ActionEvent event) {
            setBackground(backgroundColor);
        }

        private Color backgroundColor;
    }
}

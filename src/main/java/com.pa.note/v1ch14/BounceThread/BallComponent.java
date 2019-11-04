package com.pa.note.v1ch14.BounceThread;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The component that draws the balls.
 *
 * @author Cay Horstmann
 * @version 1.33 2007-05-17
 */
public class BallComponent extends JComponent {
    /**
     * Add a ball to the panel.
     *
     * @param b the ball to add
     */
    public void add(Ball b) {
        balls.add(b);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

    private ArrayList<Ball> balls = new ArrayList<Ball>();
}


package com.pa.note.v1ch10.NotHelloWorldApplet;/*
 * The following HTML tags are required to display this applet in a browser: <applet
 * code="NotHelloWorldApplet.class" width="300" height="100"> </applet>
 */

import javax.swing.*;
import java.awt.*;

/**
 * @author Cay Horstmann
 * @version 1.22 2007-06-12
 */
public class NotHelloWorldApplet extends JApplet {
    public void init() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JLabel label = new JLabel("Not a Hello, World applet", SwingConstants.CENTER);
                add(label);
            }
        });
    }
}
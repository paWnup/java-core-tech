package com.pa.note.v2ch08.ChartBean.com.horstmann.corejava;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyEditorSupport;

/**
 * The panel for setting the inverse property. It contains a button to toggle between normal and
 * inverse coloring.
 *
 * @author Cay Horstmann
 * @version 1.30 2007-10-03
 */
public class InverseEditorPanel extends JPanel {
    public InverseEditorPanel(PropertyEditorSupport ed) {
        editor = ed;
        button = new JButton();
        updateButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                editor.setValue(!(Boolean) editor.getValue());
                updateButton();
            }
        });
        add(button);
    }

    private void updateButton() {
        if ((Boolean) editor.getValue()) {
            button.setIcon(inverseIcon);
            button.setText("Inverse");
        } else {
            button.setIcon(normalIcon);
            button.setText("Normal");
        }
    }

    private JButton button;
    private PropertyEditorSupport editor;
    private ImageIcon inverseIcon = new ImageIcon(getClass().getResource(
            "ChartBean_INVERSE_16x16.gif"));
    private ImageIcon normalIcon = new ImageIcon(getClass().getResource("ChartBean_MONO_16x16.gif"));
}

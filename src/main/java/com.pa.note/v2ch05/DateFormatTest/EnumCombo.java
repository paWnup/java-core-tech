package com.pa.note.v2ch05.DateFormatTest;

import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * A combo box that lets users choose from among static field
 * values whose names are given in the constructor.
 *
 * @author Cay Horstmann
 * @version 1.13 2007-07-25
 */
public class EnumCombo extends JComboBox {
    /**
     * Constructs an EnumCombo.
     *
     * @param cl     a class
     * @param labels an array of static field names of cl
     */
    public EnumCombo(Class<?> cl, String[] labels) {
        for (String label : labels) {
            String name = label.toUpperCase().replace(' ', '_');
            int value = 0;
            try {
                java.lang.reflect.Field f = cl.getField(name);
                value = f.getInt(cl);
            } catch (Exception e) {
                label = "(" + label + ")";
            }
            table.put(label, value);
            addItem(label);
        }
        setSelectedItem(labels[0]);
    }

    /**
     * Returns the value of the field that the user selected.
     *
     * @return the static field value
     */
    public int getValue() {
        return table.get(getSelectedItem());
    }

    private Map<String, Integer> table = new TreeMap<String, Integer>();
}

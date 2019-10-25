package com.pa.note.v2ch11.Property.com.horstmann.corejava;

import com.pa.note.v2ch08.ChartBean.com.horstmann.corejava.ChartBean;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;

/**
 * A custom editor for the titlePosition property of the ChartBean. The editor lets the user choose
 * between Left, Center, and Right
 *
 * @author Cay Horstmann
 * @version 1.20 2007-12-14
 */
public class TitlePositionEditor extends PropertyEditorSupport {
    public String[] getTags() {
        return tags;
    }

    public String getJavaInitializationString() {
        return ChartBean.Position.class.getName().replace('$', '.') + "." + getValue();
    }

    public String getAsText() {
        int index = ((ChartBean.Position) getValue()).ordinal();
        return tags[index];
    }

    public void setAsText(String s) {
        int index = Arrays.asList(tags).indexOf(s);
        if (index >= 0) setValue(ChartBean.Position.values()[index]);
    }

    private String[] tags = {"Left", "Center", "Right"};
}

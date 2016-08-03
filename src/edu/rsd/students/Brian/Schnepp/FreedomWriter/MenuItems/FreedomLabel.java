package edu.rsd.students.Brian.Schnepp.FreedomWriter.MenuItems;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FreedomLabel extends JLabel
{
    public FreedomLabel(String str)
    {
	super(str);
    }

    @Override
    public void setText(String newText)
    {
	this.setForeground(Color.WHITE);
	super.setText(newText);
    }
}

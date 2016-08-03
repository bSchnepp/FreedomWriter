package edu.rsd.students.Brian.Schnepp.FreedomWriter.kernel;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OverlayBar extends Main
{
    // once had a purpose, now does effectively nothing but be pretty to look at
    // I also don't have a silly video game reference to put in here ):
    public OverlayBar(boolean n)
    {
	this.showWindow = n;
	port = new JPanel(new BorderLayout());
	jframe = new JFrame("FreedomWriter 2, created by Brian Schnepp");
	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

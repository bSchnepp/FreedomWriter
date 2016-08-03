package edu.rsd.students.Brian.Schnepp.FreedomWriter.kernel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class IsolatedTextArea extends JTextArea implements Printable
{
    String wordContents;
    public IsolatedTextArea()
    {
	super();
    }
    
    public void setWordContents(String words)
    {
	this.wordContents = words;
    }

    public void asIsolatedArea(JTextPane area)
    {
	this.setText(area.getText());
	this.setWordContents(area.getText());	//Technically this is a waste to do, instead of just jamming it into the main class, but since the code got long and complex and all over the place, well, this exists.
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException
    {

	if (pageIndex > 0)
	{
	    return NO_SUCH_PAGE;
	}

	Graphics2D g2d = (Graphics2D) graphics;
	g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	ArrayList<String> strL = breakUp();
	graphics.drawString(strL.get(0), 100, 100);
	for (int i = 1; i < strL.size(); i++)
	{
	    graphics.drawString(strL.get(i), 100, 100 + i * 14);
	}
	return PAGE_EXISTS;
    }
    
    public ArrayList<String> breakUp()
    {
	Scanner scanner = new Scanner(wordContents);
	ArrayList<String> arr = new ArrayList<String>();
	while (scanner.hasNextLine())
	{
	    arr.add(scanner.nextLine());
	}
	scanner.close();
	return arr;
    }

}

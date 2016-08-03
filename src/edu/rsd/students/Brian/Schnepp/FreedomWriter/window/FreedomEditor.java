package edu.rsd.students.Brian.Schnepp.FreedomWriter.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

import edu.rsd.students.Brian.Schnepp.FreedomWriter.MenuItems.FreedomLabel;

@SuppressWarnings("serial")
public class FreedomEditor extends JPanel implements Printable, ActionListener
{
    private JTextPane jedit;
    private JScrollPane scroll;
    private Font textFont;

    private UndoManager undos;

    private static File currentFile;
    private JLabel status;

    public FreedomEditor()
    {
	super(new BorderLayout());
	this.undos = new UndoManager();
	undos.setLimit(4096);
	int[] sizes = ScreenSizeHandler.setup();
	setSize(sizes[0], sizes[1] - 45);
    }

    public FreedomEditor display()
    {
	jedit = new JTextPane();
	status = new FreedomLabel("freedomwriter");
	scroll = new JScrollPane(jedit);
	add(scroll, BorderLayout.CENTER);
	add(status, BorderLayout.SOUTH);
	jedit.getDocument().addUndoableEditListener(undos);
	jedit.addComponentListener(new ComponentListener()
	{
	    @Override
	    public void componentHidden(ComponentEvent arg0)
	    {
		jedit.repaint();
	    }

	    @Override
	    public void componentMoved(ComponentEvent arg0)
	    {
		jedit.repaint();
	    }

	    @Override
	    public void componentResized(ComponentEvent arg0)
	    {
		jedit.repaint();
	    }

	    @Override
	    public void componentShown(ComponentEvent arg0)
	    {
		jedit.repaint();
	    }
	});

	jedit.getDocument().addDocumentListener(new DocumentListener()
	{

	    @Override
	    public void removeUpdate(DocumentEvent e)
	    {
		undos.addEdit((UndoableEdit) e);
	    }

	    @Override
	    public void insertUpdate(DocumentEvent e)
	    {
		undos.addEdit((UndoableEdit) e);
	    }

	    @Override
	    public void changedUpdate(DocumentEvent arg0)
	    {
		undos.addEdit((UndoableEdit) arg0);
	    }
	});

	setVisible(true);
	return this;
    }

    public String getSelectedText()
    {
	return this.jedit.getSelectedText();
    }

    public int getSelectionStart()
    {
	return this.jedit.getSelectionStart();
    }

    public int getSelectionEnd()
    {
	return this.jedit.getSelectionEnd();
    }

    public Color getSelectedTextColor()
    {
	return this.jedit.getSelectedTextColor();
    }

    public FreedomEditor getInstance()
    {
	return this;
    }

    public JTextPane getJedit()
    {
	return jedit;
    }

    public Font getTextFont()
    {
	return textFont;
    }

    public String getText()
    {
	return jedit.getText();
    }

    public void setTextFont(Font textFont)
    {
	this.textFont = textFont;
    }

    public void setText(String contents)
    {
	this.jedit.setText(contents);
    }

    public File getCurrentFile()
    {
	return currentFile;
    }

    public void setCurrentFile(File currentFile)
    {
	FreedomEditor.currentFile = currentFile;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
	;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException
    {
	if (pageIndex < 0)
	{
	    return NO_SUCH_PAGE;
	}
	Graphics2D g2d = (Graphics2D) graphics;
	g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	graphics.drawString(getText(), 100, 100);
	return PAGE_EXISTS;
    }

    public int getPos()
    {
	return this.jedit.getCaretPosition();
    }

    public void write(String str)
    {
	String pre = getText().substring(0, getPos());
	String post = getText().substring(getPos());
	this.jedit.setText("" + pre + str + post);
    }

    public void undo()
    {
	UndoManager undoM = this.undos;
	undos.end();
	undos.undo();
	undos = undoM;
    }

    public void redo()
    {
	UndoManager undoM = this.undos;
	undos.end();
	undos.redo();
	undos = undoM;
    }

    public void setColor(Color color)
    {
	this.jedit.select(0, getText().length());
	this.jedit.setSelectedTextColor(color);
	this.jedit.select(0, 0);
    }

    public Color getColor()
    {
	this.jedit.select(0, getText().length());
	Color color = this.jedit.getSelectedTextColor();
	this.jedit.select(0, 0);
	return color;
    }

    public void setUsedFont(Font font)
    {
	this.jedit.setFont(font);
    }

    public Font getUsedFont()
    {
	return this.jedit.getFont();
    }
}

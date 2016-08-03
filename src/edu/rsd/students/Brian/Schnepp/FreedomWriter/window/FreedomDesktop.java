package edu.rsd.students.Brian.Schnepp.FreedomWriter.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/*
 * TODO:
 * 	Implement Aero-like snap feature
 * 	Try really hard to make this look like XP.
 * 	FIX ANNOYING PROBLEM WITH WINDOWS GOING OUTSIDE BORDERS.
 */

@SuppressWarnings("serial")
public class FreedomDesktop extends JDesktopPane
{

    private Image img;

    public FreedomDesktop()
    {
	super();
	this.setDragMode(LIVE_DRAG_MODE);
    }

    public void addPane(JPanel panel, JMenu file, JMenu home, JMenu insert, JMenu translate, JMenuItem viewitem)
    {
	JMenuBar jbar = new JMenuBar();
	JMenu view = new JMenu("View");
	view.setForeground(Color.WHITE);
	view.add(viewitem);

	jbar.add(file);
	jbar.add(home);
	jbar.add(insert);
	jbar.add(translate);
	jbar.add(view);

	int le = this.getAllFrames().length;
	final JInternalFrame jint = new JInternalFrame("FreedomEditor #" + ++le, true, true, true, true);

	BorderLayout layout = new BorderLayout(1, 2);
	jint.setLayout(layout);

	jint.add(jbar, BorderLayout.NORTH);
	jint.add(panel, BorderLayout.CENTER);
	jint.setLocation(30 * le, 50 * le);
	jint.pack();
	int[] sizes = ScreenSizeHandler.setup();
	jint.setSize(sizes[0] / 4, sizes[1] / 4);
	jint.setVisible(true);

	jint.addComponentListener(new ComponentListener()
	{
	    @Override
	    public void componentHidden(ComponentEvent e)
	    {
		;
	    }

	    @Override
	    public void componentMoved(ComponentEvent e)
	    {
		jint.repaint();
	    }

	    @Override
	    public void componentResized(ComponentEvent e)
	    {
		jint.repaint();
	    }

	    @Override
	    public void componentShown(ComponentEvent e)
	    {
		jint.repaint();
	    }
	});

	this.add(jint);
    }

    @Override
    public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	g.drawImage(getImg(), 0, 0, this.getWidth(), this.getHeight(), null);
	for (JInternalFrame j : getAllFrames())
	{
	    j.repaint();
	}
    }

    private Image getImg()
    {
	return img;
    }

    public void setImg(Image img)
    {
	this.img = img;
    }

    public Graphics getG()
    {
	return this.getGraphics();
    }
}

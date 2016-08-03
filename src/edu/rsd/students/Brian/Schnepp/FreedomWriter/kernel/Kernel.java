package edu.rsd.students.Brian.Schnepp.FreedomWriter.kernel;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Kernel
{
    //Initially this thing's purpose was just to handle all of our fancy drawing stuff. Now it doesn't really.
    public void run()
    {

	UIManager.put("nimbusBase", new Color(30, 30, 30));
	UIManager.put("nimbusBlueGrey", new Color(0, 0, 0));
	UIManager.put("control", new Color(50, 50, 50));
	UIManager.put("nimbusBorder", new Color(40, 40, 220));
	UIManager.put("nimbusFocus", new Color(40, 40, 220));
	UIManager.put("Menu.textColor", new Color(50, 50, 50));
	UIManager.put("MenuBar.background", new Color(50, 50, 50));
	UIManager.put("desktop", new Color(40, 40, 220));
	UIManager.put("OptionPane.foreground", Color.white);
	UIManager.put("OptionPane.foreground", Color.WHITE);
	UIManager.put("OptionPane.disabledText", Color.WHITE);
	UIManager.put("OptionPane.foreground", Color.WHITE);
	try
	{
	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
	    {
		if ("Nimbus".equals(info.getName()))
		{
		    UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	}
	catch (Exception e)
	{
	    try
	    {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    }
	    catch (UnsupportedLookAndFeelException e1)
	    {
		e1.printStackTrace();
	    }
	    catch (ClassNotFoundException e1)
	    {
		e1.printStackTrace();
	    }
	    catch (InstantiationException e1)
	    {
		e1.printStackTrace();
	    }
	    catch (IllegalAccessException e1)
	    {
		e1.printStackTrace();
	    }
	}

	Main main = new OverlayBar(true);
	main.show();
    }

}

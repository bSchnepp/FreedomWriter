package edu.rsd.students.Brian.Schnepp.FreedomWriter.window;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/*
 * This has more or less saved me soooooo muuuccch trrrouuubbbllleee.
 */
public class ScreenSizeHandler
{
    private static int width;
    private static int length;

    public static int[] setup()
    {
	int[] size = new int[2];
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = gd.getDisplayMode().getWidth();
	int length = gd.getDisplayMode().getHeight();
	size[0] = width;
	size[1] = length;
	return size;
    }

    public static int getWidth()
    {
	return width;
    }

    public static int getLength()
    {
	return length;
    }

}

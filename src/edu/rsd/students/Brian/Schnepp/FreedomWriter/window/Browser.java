package edu.rsd.students.Brian.Schnepp.FreedomWriter.window;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Browser
{
    public void use(String url)
    {
	if (Desktop.isDesktopSupported())
	{
	    try
	    {
		Desktop.getDesktop().browse(new URI(url));
	    }
	    catch (IOException | URISyntaxException e)
	    {
		e.printStackTrace();
	    }
	}
    }
}

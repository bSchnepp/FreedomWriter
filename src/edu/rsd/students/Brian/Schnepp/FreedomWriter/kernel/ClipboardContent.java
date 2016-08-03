package edu.rsd.students.Brian.Schnepp.FreedomWriter.kernel;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardContent implements ClipboardOwner
{

    @Override
    public void lostOwnership(java.awt.datatransfer.Clipboard arg0, Transferable arg1)
    {
	; //i got lazy and had to rush this in 20 minutes, sorry!
    }

    public String getClipboardContents()
    {
	String res = "";
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	Transferable contents = clipboard.getContents(null);
	boolean hasTransferableText = contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor);

	if (hasTransferableText)
	{
	    try
	    {
		res = (String) contents.getTransferData(DataFlavor.stringFlavor);
	    }
	    catch (UnsupportedFlavorException | IOException e)
	    {
		e.printStackTrace();
	    }
	}
	return res;
    }

    public void setClipboardContents(String string)
    {
	StringSelection stringSelection = new StringSelection(string);
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	clipboard.setContents(stringSelection, this);
    }

}

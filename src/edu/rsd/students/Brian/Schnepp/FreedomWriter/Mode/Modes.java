package edu.rsd.students.Brian.Schnepp.FreedomWriter.Mode;

public enum Modes
{
    WAITING("Waiting"), 
    SAVING("Saving"), 
    OPENING("Opening"), 
    CLOSING("Closing"), 
    PRINTING("Printing"), 
    UNDOING("Undoing action"), 
    TRANSLATING("Translating"), 
    REDOING("Redoing action");

    public final String str;

    Modes(final String str)
    {
	this.str = str;
    }

    /**
     * @return Node name of value.
     */

    public String getNodeName()
    {
	if (str.equals("Waiting"))
	{
	    return "freedomwriter.waiting";
	}
	else if (str.equals("Saving"))
	{
	    return "freedomwriter.saved";
	}
	else if (str.equals("Translating"))
	{
	    return "freedomwriter.translate.piglatin";
	}
	else if (str.equals("Opening"))
	{
	    return "freedomwriter.opened";
	}
	else if (str.equals("Closing"))
	{
	    return "freedomwriter.closed";
	}
	else if (str.equals("Printing"))
	{
	    return "freedomwriter.printed";
	}
	else if (str.equals("Undoing action"))
	{
	    return "freedomwriter.undo";
	}
	else if (str.equals("Redoing action"))
	{
	    return "freedomwriter.redo";
	}
	else
	{
	    return "freedomwriter.other";
	}
    }
}

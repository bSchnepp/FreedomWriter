package edu.rsd.students.Brian.Schnepp.CurtainLib;

import javax.swing.JOptionPane;

public class DebugFile
{
    /* Used during testing. */
    private String debugInfo;

    public DebugFile(String str)
    {
	debugInfo = str;
    }

    public void writeToDebug(String str)
    {
	debugInfo = debugInfo + '\n' + str;
    }

    public void readDebug()
    {
	JOptionPane.showMessageDialog(null, debugInfo);
    }

}

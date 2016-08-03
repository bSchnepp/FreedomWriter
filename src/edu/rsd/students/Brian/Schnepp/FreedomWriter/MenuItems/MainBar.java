package edu.rsd.students.Brian.Schnepp.FreedomWriter.MenuItems;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MainBar extends JMenuBar
{
    private JMenuBar bar = new JMenuBar();
    public MainBar(JMenu file, JMenu home, JMenu insert, JMenu translate, JMenuItem help)
    {
	bar.add(file);
	bar.add(home);
	bar.add(insert);
	bar.add(translate);
	bar.add(help);
    }
    
    public JMenuBar getBar()
    {
	return bar;
    }
}

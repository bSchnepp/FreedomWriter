package edu.rsd.students.Brian.Schnepp.FreedomWriter.MenuItems;

import java.util.Scanner;

/*
 * CHANGES SINCE IN CLASS:
 * 	7/22/16: Fixed spacing problem
 * 	7/22/16: Fixed potential memory leak
 * 	7/22/16: Fixed case problem
 * 	7/22/16: Removed Notched Pickaxe
 */

public class PigLatin
{
    public static String translate(String str)
    {
	Scanner scanner = new Scanner(str);
	String b = "";
	while (scanner.hasNextLine())
	{
	    String sta = scanner.nextLine();
	    String[] words = sta.split("\\s+");

	    int i = 0;
	    while (i < words.length)
	    {
		b = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ".contains("" + words[i].charAt(0))
		        ? String.valueOf(b) + words[i].substring(1, words[i].length()) + words[i].charAt(0) + "ay"
		        : String.valueOf(b) + words[i] + "yay";
		if (i != words.length - 1)
		{
		    b = String.valueOf(b) + " ";
		}
		++i;
		b += "\n";
	    }
	}
	scanner.close();
	return b;
    }
}

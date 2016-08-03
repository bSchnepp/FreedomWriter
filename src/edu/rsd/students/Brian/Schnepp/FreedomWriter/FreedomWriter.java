package edu.rsd.students.Brian.Schnepp.FreedomWriter;

import edu.rsd.students.Brian.Schnepp.FreedomWriter.kernel.Kernel;

public class FreedomWriter
{
    // The sole purpose of this class is for convenience in BlueJ (which was
    // used in class). Shouldn't
    // affect performance too badly in real world, and isn't annoying in
    // Eclipse.
    public static void main(String[] args)
    {
	Kernel program = new Kernel();
	program.run();
    }
    /*
     * Edit 8/3/16: Removed dumb comments
     * 
     * Known bugs:
     * 		I think I fixed most of the ones I felt like were important to fix.
     * 		StyledDocument was never used - coloring doesn't work. I didn't know it existed when I wrote this.
     * 		Oh and yeah I got rid of the font thing. It was awful.
     * 		And I mean *really* bad.
     */
}

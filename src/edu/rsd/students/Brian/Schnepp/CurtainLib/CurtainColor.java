package edu.rsd.students.Brian.Schnepp.CurtainLib;

import java.awt.Color;

/**
 * @author Brian 
 * Replacement for the deprecated ColorModifier class.
 */
public class CurtainColor
{
    public static Color getInvertedColor(Color color)
    {
	// Normalizes the colors.
	double nRed = (double) color.getRed() / 255;
	double nBlue = (double) color.getBlue() / 255;
	double nGreen = (double) color.getGreen() / 255;

	// Inverts them. (This does not hue shift.)
	double invRed = 1 - nRed;
	double invBlue = 1 - nBlue;
	double invGreen = 1 - nGreen;

	// Returns the inverted color.
	return new Color((int) (invRed * 255), (int) (invBlue * 255), (int) (invGreen * 255));
    }

    public static Color getHueInvertedColor(Color color)
    {
	float[] hsvVal = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getRed(), null);
	float hue = hsvVal[0];
	float sat = hsvVal[1];
	float bri = hsvVal[2];

	float invHue = 1 - hue;

	return new Color(Color.HSBtoRGB(invHue, sat, bri));
    }
}

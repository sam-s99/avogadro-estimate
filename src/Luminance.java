
/******************************************************************************
% *  Compilation:  javac Luminance.java
 *  Execution:    java Luminance r1 g1 b1 r2 g2 b2
 *
 *  Library for dealing with monochrome luminance. 
 *  Uses the NTSC formula  Y = 0.299*r + 0.587*g + 0.114*b.
 *
 *  % java Luminance 0 0 0 0 0 255
 *
 ******************************************************************************/

import java.awt.Color;

public class Luminance {

    // return the monochrome luminance of given color
    @Deprecated
    public static double lum(Color color) {
        return intensity(color);
    }

    // return the monochrome luminance of given color
    public static double intensity(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        return 0.299 * r + 0.587 * g + 0.114 * b;
    }

    // return a gray version of this Color
    public static Color toGray(Color color) {
        int y = (int) (Math.round(lum(color))); // round to nearest int
        Color gray = new Color(y, y, y);
        return gray;
    }

    // are the two colors compatible?
    public static boolean areCompatible(Color a, Color b) {
        return Math.abs(intensity(a) - intensity(b)) >= 128.0;
    }

    // test client
    public static void main(String[] args) {
        int[] a = new int[6];
        for (int i = 0; i < 6; i++) {
            a[i] = Integer.parseInt(args[i]);
        }
        Color c1 = new Color(a[0], a[1], a[2]);
        Color c2 = new Color(a[3], a[4], a[5]);
        StdOut.println("c1 = " + c1);
        StdOut.println("c2 = " + c2);
        StdOut.println("intensity(c1) =  " + intensity(c1));
        StdOut.println("intensity(c2) =  " + intensity(c2));
        StdOut.println(areCompatible(c1, c2));
    }
}

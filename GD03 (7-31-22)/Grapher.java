import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grapher {
    public static void main(String[] args) {
        In in = new In("vcfd_incidents.csv");
        String input = in.readAll();
        // StdOut.println(input);
        String m = "Medical";
        String f = "Fire";
        String t = "TC";
        String fb = "Fire - Brush";
        Integer med = count(input, m);
        Integer fire = count(input, f) - count(input, fb);
        Integer fireb = count(input, fb);
        Integer tc = count(input, t);

        Integer[] myIntArray = {med, fire, fireb, tc};

        double myScalingFactor = 0.9;                         // The actual size of the bars being printed
        double myIncrement = (double) 1 / 4 / 2;
        int myMax = 0;
        //Integer[] myArgs = new Integer[4];          // Create a new array from args[] that has actual Integers in it.
        for (int i = 0; i < 4; i++) {
            //myArgs[i] = Integer.parseInt(myIntArray[i]);
            if (myIntArray[i] > myMax) {
                myMax = myIntArray[i];
            }
        }

        StdDraw.setCanvasSize(1000, 500);

        StdDraw.setPenColor(Color.RED);
        StdDraw.text(0.5, 0.85, "Unsorted");
        for (int i = 1; i <= myIntArray.length; i++) {
            double mySize = (double) myIntArray[i - 1];
            mySize = mySize / myMax;
            StdDraw.setPenColor(Color.RED);
            StdDraw.filledRectangle((i * 2 * myIncrement) - myIncrement, 0.5 + (myIncrement * mySize * myScalingFactor), myIncrement * myScalingFactor, myIncrement * myScalingFactor * mySize);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.text((i * 2 * myIncrement) - myIncrement, 0.70, String.valueOf(myIntArray[i - 1]));
        }

        //System.out.println("The occurrence of " + m + " in the file is " + count(input, m));
        //System.out.println("The occurrence of " + fb + " in the file is " + count(input, fb));
        //System.out.println("The occurrence of " + t + " in the file is " + count(input, t));
        //System.out.println("The occurrence of " + f + " in the file is " + (count(input, f) - count(input, fb)));
    }

    public static int count(String s, String c) {

        // Use Matcher class of java.util.regex
        // to match the character
        Matcher matcher
                = Pattern.compile(c)
                .matcher(s);

        int res = 0;

        // for every presence of character ch
        // increment the counter res by 1
        while (matcher.find()) {
            res++;
        }

        return res;

    }

}

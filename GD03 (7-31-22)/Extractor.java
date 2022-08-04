import edu.princeton.cs.algs4.In;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {
    public static void main(String[] args) {
        In in = new In("test.csv");
        String input = in.readAll();
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        //StdOut.println(sb);
        String m = ",,";
        String f = ",Fire,";
        String t = "TC";
        String fb = "Fire - Brush";
        System.out.println("The occurrence of " + m + " in the file is " + count(sb, m));
        //System.out.println("The occurrence of " + fb + " in the file is " + count(input, fb));
        //System.out.println("The occurrence of " + t + " in the file is " + count(input, t));
        //System.out.println("The occurrence of " + f + " in the file is " + count(input, f));
    }

    public static long count(StringBuilder s, String c) {

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

    public static void harvest(StringBuilder s, String c) {
        String regexp = c;
        StringBuilder input = s;
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            // StdOut.println(matcher.group());
        }
    }
}

// Java program to count occurrences
// of a character using Regex

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {

    // Method that returns the count of the given
    // character in the string
    public static long count(String s, String c) {

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

    // Driver method
    public static void main(String args[]) {
        String str = "geeksforgeeks";
        String c = "Medical";
        System.out.println("The occurrence of " + c + " in "
                + input + " is " + count(str, c));
    }
}

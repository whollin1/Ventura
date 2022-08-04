import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LatLon {
    public static void main(String[] args) {
        ArrayList<String> arrli1 = new ArrayList<String>();
        ArrayList<String> arrli2 = new ArrayList<String>();
        In in = new In("test.csv");
        String input = in.readAll();
        String r1 = ",\\d{8},";
        String r2 = ",\\d{9}\\r?\\n";
        Pattern p1 = Pattern.compile(r1);
        Pattern p2 = Pattern.compile(r2);
        Matcher m1 = p1.matcher(input);
        Matcher m2 = p2.matcher(input);
        while (m1.find()) {
            String lat = m1.group();
            String newlat = delfl(addChar(lat, '.', 3));
            arrli1.add(newlat);
            //input = input.replace(m1.group(), newlat);
            //StdOut.println(m1.group());
        }
        while (m2.find()) {
            String lon = m2.group();
            String newlon = delfl(addChar(lon, '.', 4));
            String newlonneg = addChar(newlon, '-', 0);
            arrli2.add(newlonneg);
            //input = input.replace(m2.group(), newlon);
            //StdOut.println(m2.group());
        }
        for (int i = 0, j = 0; i <= arrli1.size() - 1 &&
                j <= arrli2.size() - 1; i++, j++)
            System.out.println(arrli1.get(i) + " " + arrli2.get(j));

    }

    public static String addChar(String str, char ch, int position) {
        int len = str.length();
        char[] updatedArr = new char[len + 1];
        str.getChars(0, position, updatedArr, 0);
        updatedArr[position] = ch;
        str.getChars(position, len, updatedArr, position + 1);
        return new String(updatedArr);
    }

    public static String delfl(String str) {

        // Removing first and last character
        // of a string using substring() method
        str = str.substring(1, str.length() - 1);

        // Return the modified string
        return str;
    }
}

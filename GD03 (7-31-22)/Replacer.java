import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Replacer {
    public static void main(String[] args) {

        In in = new In("vcfd_incidents.csv");
        String input = in.readAll();
        input = input.replaceAll("\\r?\\n.*,,.*", "");
        input = input.replaceAll("\\r?\\n.*,#+,.*", "");
        input = input.replaceAll(",,", "");
        StdOut.println(input);

    }
}

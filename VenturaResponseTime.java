import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;


class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("vcfd_incidents.csv"));

        String headers = sc.nextLine();
        int count = 0;
        int total = 0;


        String m = "Medical";
        String f = "Fire";
        String t = "TC";
        String fb = "Fire - Brush";

        Pattern mp = Pattern.compile(m);
        Pattern fp = Pattern.compile(f);
        Pattern tp = Pattern.compile(t);
        Pattern fbp = Pattern.compile(fb);

        int mc = 0;
        int fc = 0;
        int tc = 0;
        int fbc = 0;

        int mt = 0;
        int ft = 0;
        int tt = 0;
        int fbt = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(",");
            String rt = parts[8];

            String[] subparts = rt.split(":");

            if (subparts.length != 3) {
                continue;
            }

            if (subparts[1].charAt(0) == '0') {
                subparts[1] = subparts[1].substring(1);
            }

            if (subparts[2].charAt(0) == '0') {
                subparts[2] = subparts[2].substring(1);
            }

            int hrs = Integer.parseInt(subparts[0]);
            int mins = Integer.parseInt(subparts[1]);
            int secs = Integer.parseInt(subparts[2]);

            secs += mins * 60;
            secs += hrs * 3600;
            total += secs;
            count += 1;
            if (mp.matcher(parts[10]).matches()) {
                mc++;
                mt += secs;
            } else if (tp.matcher(parts[10]).matches()) {
                tc++;
                tt += secs;
            } else if (fbp.matcher(parts[10]).matches()) {
                fbc++;
                fbt += secs;
            } else if (fp.matcher(parts[10]).matches()) {
                fc++;
                ft += secs;
            }
        }

        System.out.println("Overall average: " + makeTimePretty(total / count));
        System.out.println("Medical average: " + makeTimePretty(mt / mc));
        System.out.println("TC average: " + makeTimePretty(tt / tc));
        System.out.println("Fire - Brush average: " + makeTimePretty(fbt / fbc));
        System.out.println("Fire average: " + makeTimePretty(ft / fc));

    }

    public static String makeTimePretty(int seconds) {
        String result = "" + (seconds / 60) + ":";

        if (seconds % 60 < 10) {
            result += "0" + (seconds % 60);
        } else {
            result += (seconds % 60);
        }
        return result;
    }
}

package BOJ19532;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ19532 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int a;
    static int b;
    static int c;
    static int d;
    static int e;
    static int f;
    public static int[] bruteForce(int a, int b, int c, int d, int e, int f) {
        for(int x = -999; x <= 999; x++) {
            for(int y = -999; y <= 999; y++) {
                if((a*x)+(b*y) == c && (d*x) + (e*y) ==f) {
                    return new int[] {x, y};
                }
            }
        }

        return null;
    }

    public static int[] bruteForceRecursive(int a, int b, int c, int d, int e, int f, int x) {
        if(x > 999) {
            return null;
        }

        for(int y = -999 ; y <= 999; y++) {
            if((a*x)+(b*y) == c && (d*x) + (e*y) ==f) {
                return new int[] {x, y};
            }
        }

        return bruteForceRecursive(a,b,c,d,e,f, x+1);
    }

    public static int[] simultaneousEquation(int a, int b, int c, int d, int e, int f) {
        return new int[] {(e * c - b * f) / (a * e - b * d) ,(d * c - a * f) / (b * d - a * e)};
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

//        int[] result = bruteForceRecursive(a,b,c,d,e,f,-999);
//        int[] result = bruteForce(a,b,c,d,e,f);
        int[] result = simultaneousEquation(a,b,c,d,e,f);

        if(result == null) {
            return;
        }
        bw.write(result[0] + " " + result[1]);
        bw.flush();
        bw.close();
    }
}

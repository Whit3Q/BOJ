package BOJ18512;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ18512 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int X;
    static int Y;
    static int P1;
    static int P2;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        P1 = Integer.parseInt(st.nextToken());
        P2 = Integer.parseInt(st.nextToken());

        HashSet<Integer> hs = new HashSet<>();
        int count = 0;

        while(true) {
            int tmp1 = P1 + (count * X);
            int tmp2 = P2 + (count * Y);
            if(count == 1000) {
                System.out.println(-1);
                break;
            }

            if(hs.contains(tmp1) ) {
                System.out.println(tmp1);
                break;
            } else if(hs.contains(tmp2)) {
                System.out.println(tmp2);
                break;
            } else {
                hs.add(tmp1);
                hs.add(tmp2);
                count++;
            }
        }
    }
}

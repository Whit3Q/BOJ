package BOJ1459;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1459 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long waking = Integer.parseInt(st.nextToken());
        long cross = Integer.parseInt(st.nextToken());
        long result = 0;

        if (waking > cross) {
            long tmp = Math.min(x, y);
            result += (long) tmp * cross;
            long tmp2 = (y - tmp) + (x - tmp);
            result += ((tmp2 / 2) * 2) * cross;
            result += (tmp2 % 2) * waking;
        } else if (waking * 2 > cross) {
            long tmp = Math.min(x, y);
            result += (long) tmp * cross;
            long tmp2 = (y - tmp) + (x - tmp);
            result += (long) tmp2 * waking;
        } else {
            result = (long) (x + y) * waking;
        }

        System.out.println(result);
    }
}

package BOJ1300;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1300 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long N;
    static long K;

    public static long binarySearch(long start, long end, long mid) {
        if(start > end) {
            return mid;
        }

        long nowMid = (start + end)/2;
        long midVal = function(nowMid);

         if(midVal >= K) {
             return binarySearch(start, nowMid - 1, nowMid);
         } else {
             return binarySearch(nowMid + 1, end, mid);
         }
    }

    public static long function(long mid) {
        long result = 0;
        for(int i = 1; i <= N; i++) {
            result += Math.min(mid/i, N);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        N = Long.parseLong(br.readLine());
        K = Long.parseLong(br.readLine());

        bw.write(binarySearch(1, K, 1) + "");

        bw.flush();
        bw.close();
    }

}

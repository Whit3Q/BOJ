package BOJ11558;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11558 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T;
    static int N;
    static int[] list;

    public static int solve(int[] list, int index, int count) {
        if(count > N) {
            return 0;
        }
        if(index == N) {
            return count;
        }

        return solve(list, list[index], count+1);
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            list = new int[N+1];

            for(int i = 1; i < N+1; i++) {
                list[i] = Integer.parseInt(br.readLine());
            }

            bw.write(solve(list, 1, 0) + "\n");
        }

        bw.flush();
        bw.close();
    }
}

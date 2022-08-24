package BOJ14248;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14248 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] rocks;
    static boolean[] memory;
    static int start;

    public static int dfs(int index) {

        int result = 0;
        memory[index] = true;
        int jumpSize = rocks[index];
        int nextPlus = index + jumpSize;
        int nextMinus = index - jumpSize;
        if(!(nextMinus < 0 || memory[nextMinus])) {
            result += dfs(nextMinus) + 1;
        }

        if(!(nextPlus > N || memory[nextPlus])) {
            result += dfs(nextPlus) + 1;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        rocks = new int[N+1];
        memory = new boolean[N+1];
        memory[0] = true;


        for(int i = 1; i < N+1; i++) {
            rocks[i] = Integer.parseInt(st.nextToken());
        }

        start = Integer.parseInt(br.readLine());

        System.out.println(dfs(start)+1);
    }

}

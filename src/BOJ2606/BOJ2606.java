package BOJ2606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringTokenizer st2;
    static int N;
    static int M;
    static LinkedList<Integer>[] link;
    static boolean[] check;
    static int result;

    public static void solve(int index) {

        if(check[index]) {
            return;
        }
        check[index] = true;
        result++;

        int size = link[index].size();
        int result = 0;
        for(int i = 0; i < size; i++) {
            int now = link[index].get(i);
            solve(now);
        }

    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        link = new LinkedList[N+1];
        check = new boolean[N+1];
        for(int i = 0; i < N+1; i++) {
            link[i] = new LinkedList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int link1 = Integer.parseInt(st.nextToken());
            int link2 = Integer.parseInt(st.nextToken());

            link[link1].add(link2);
            link[link2].add(link1);
        }
        check[0] = true;
        solve(1);
        System.out.println( result - 1+ "");
    }
}

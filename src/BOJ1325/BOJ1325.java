package BOJ1325;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1325 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static ArrayList<Integer>[] list;
    static int[] memory;

    public static int dfs(int start) {

        int size = list[start].size();
        ArrayList<Integer> now = list[start];
        int result = 0;
        memory[start] = 1;
        for(int i = 0; i < size; i++) {
            if(memory[now.get(i)] != 1) {
                result += dfs(now.get(i)) + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];

        for(int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i =0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

//            list[start].add(end);
            list[end].add(start);
        }

        ArrayList<int[]> result = new ArrayList<>();
        for(int i = 1; i < N+1; i++) {
            memory = new int[N+1];
            int[] tmp = {i,dfs(i)};
            result.add(tmp);
        }

        Collections.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int pre = result.get(0)[1];
        for(int[] now : result) {
            if(pre == now[1]) {
                bw.write(now[0] + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}

package BOJ18232;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18232 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static int S;
    static int E;
    static ArrayList<Integer>[] field;
    static boolean[] memory;
    static int[] dx = {1, -1};

    public static int bfs(int start, int end) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        memory[start] = true;
        int count = 0;
        int size = 0;
        while ((size = queue.size()) != 0) {
            count++;
            while (size-- > 0) {
                int nowIndex = queue.remove();

                for (int i = 0; i < 2; i++) {
                    int newIndex = nowIndex + dx[i];

                    if (newIndex < 1 || newIndex > N || memory[newIndex]) {
                        continue;
                    }
                    memory[newIndex] = true;

                    if (newIndex == end) {
                        return count;
                    }

                    queue.add(newIndex);
                }

                if (field[nowIndex].size() != 0) {
                    for (int i = 0; i < field[nowIndex].size(); i++) {
                        int newIndex = field[nowIndex].get(i);
                        if(newIndex == end) {
                            return count;
                        }

                        if (memory[newIndex]) {
                            continue;
                        }
                        memory[newIndex] = true;
                        queue.add(newIndex);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        field = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            field[i] = new ArrayList<>();
        }

        memory = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int tt = Integer.parseInt(st.nextToken());

            field[to].add(tt);
            field[tt].add(to);
        }

        bw.write(bfs(S, E) + "");
        bw.flush();
        bw.close();

    }
}

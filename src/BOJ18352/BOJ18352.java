package BOJ18352;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18352 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N; // 도시의 개수
    static int M; // 도로의 개수
    static int K; // 거리 정보
    static int X; //출발 도시의 번호
    static ArrayList<Integer>[] list;
    static int[] memory;

    public static void bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        memory[start] = Integer.MAX_VALUE;

        int count = 0;
        int size = 0;
        while ((size = queue.size()) != 0) {
            count++;
            if (target < count) { //불필요한 연산 줄임
                return;
            }
            while (size-- > 0) {
                int now = queue.remove();

                for (int i = 0; i < list[now].size(); i++) {
                    int newIndex = list[now].get(i);
                    if (memory[newIndex] > 0) {
                        continue;
                    }
                    memory[newIndex] = count;
                    queue.add(newIndex);
                }

            }

        }

    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        memory = new int[N + 1];
        memory[0] = Integer.MAX_VALUE;

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            list[t1].add(t2);
        }

        bfs(X, K);

        boolean check = false;
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == K) {
                bw.write(i + "\n");
                check = true;
            }
        }
        if (!check) {
            bw.write("-1");
        }
        bw.flush();
        bw.close();
    }
}

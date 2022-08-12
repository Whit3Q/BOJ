package BOJ2644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static Point target;
    static LinkedList<Integer>[] link;
    static boolean[] check;

    public static int dfs() {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.add(target.num);

        while (queue.size() != 0) {
            count++;
            int t = queue.size();
            while(t-- > 0) {
                int now = queue.remove();
                check[now] = true;

                int size = link[now].size();
                for (int i = 0; i < size; i++) {
                    int tmp = link[now].get(i);
                    if (tmp == target.num2) {
                        return count;
                    } else {
                        if (check[tmp]) {
                            continue;
                        }
                        queue.add(tmp);
                    }
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        check = new boolean[N + 1];
        link = new LinkedList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            link[i] = new LinkedList<>();
        }
        st = new StringTokenizer(br.readLine());
        target = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            link[num].add(num2);
            link[num2].add(num);
        }

        System.out.println(dfs());

    }

    public static class Point {
        int num;
        int num2;

        public Point(int num, int num2) {
            this.num = num;
            this.num2 = num2;
        }
    }
}

package BOJ1916;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static ArrayList<ArrayList<Point>> list;
    static int S;
    static int E;
    static int[] memory;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        N++;
        memory = new int[N];
        check = new boolean[N];
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.MAX_VALUE;
        }

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int wight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Point(end, wight));
        }

        PriorityQueue<Point> pointPriorityQueue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < list.get(S).size(); i++) {
            Point tmp = list.get(S).get(i);
//            pointPriorityQueue.add(tmp);
//            memory[tmp.end] = Math.min(memory[tmp.end], tmp.wight);
        }
        pointPriorityQueue.add(new Point(S, 0));
        memory[S] = 0;


        while (pointPriorityQueue.size() != 0) {
            Point now = pointPriorityQueue.poll();
            if(check[now.end]) {
                continue;
            }
            check[now.end] = true;

            for (int i = 0; i < list.get(now.end).size(); i++) {
                Point tmp = list.get(now.end).get(i);
                if (memory[tmp.end] > memory[now.end] + tmp.wight) {
                    memory[tmp.end] = memory[now.end] + tmp.wight;
                    pointPriorityQueue.add(new Point(tmp.end, memory[tmp.end]));
                }
            }

        }

        System.out.println(memory[E]);

    }


    static class Point implements Comparable<Point> {
        //        int start;
        int end;
        int wight;

        public Point(int end, int wight) {
            this.end = end;
            this.wight = wight;
        }

        @Override
        public int compareTo(Point o) {
            return this.wight - o.wight;
        }
    }
}

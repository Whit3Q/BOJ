package BOJ1916;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//벨만포드
public class Main2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
//    static ArrayList<ArrayList<Point>> list;
    static ArrayList<Point> list;
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

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int wight = Integer.parseInt(st.nextToken());

            list.add(new Point(start, end, wight));
        }


        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        memory[S] = 0;
        boolean bfMinusCycleCheck = false;

        loop :
        for(int i = 1; i < N; i++) {

            for(int j = 0; j < M; j++) {
                Point now = list.get(j);
                int start = now.start;
                int end = now.end;
                int nowWeight = now.wight;

                if(memory[start] != Integer.MAX_VALUE && memory[end] > memory[start] + nowWeight) {
                    memory[end] = memory[start] + nowWeight;
                    if(i == N-1) {
                        bfMinusCycleCheck = true;
                        break loop;
                    }
                }
            }
        }

        System.out.println(memory[E]);

    }


    static class Point implements Comparable<Point> {
        int start;
        int end;
        int wight;

        public Point(int start, int end, int wight) {
            this.start = start;
            this.end = end;
            this.wight = wight;
        }

        @Override
        public int compareTo(Point o) {
            return this.wight - o.wight;
        }
    }
}

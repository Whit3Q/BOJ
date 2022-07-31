package BOJ1927;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ1927 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Point> pq = new PriorityQueue<>();

        while(N-- > 0) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0) {
                try {
                    bw.write(pq.remove().num+"");
                    bw.newLine();
                } catch (Exception e) {
                    bw.write("0");
                    bw.newLine();
                }
            } else {
                pq.add(new Point(tmp));
            }
        }
        bw.flush();
        bw.close();
    }
    static class Point implements Comparable<Point>{
        int num;
        int abs;
        public Point(int num)  {
            this.num = num;
            abs = Math.abs(num);
        }

        @Override
        public int compareTo(Point o) {
            if(this.abs == o.abs) {
                return this.num - o.num;
            }
            return this.abs - o.abs;
        }
    }
}

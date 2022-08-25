package BOJ1726;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1726 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int Y;
    static int X;
    static int[][] field;
    static boolean[][][] memory;
    static int[][] moveDx = {{0, 0, 0}, {1, 2, 3}, {-1, -2, -3}, {0, 0, 0}, {0, 0, 0}};
    static int[][] moveDy = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {1, 2, 3}, {-1, -2, -3}};
    static int[] left = {0, 4, 3, 1, 2};
    static int[] right = {0, 3, 4, 2, 1};

    public static int bfs(Point start, Point end) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        if (start.y == end.y && start.x == end.x && start.d == end.d) {
            return 0;
        }

        int size = 0;
        int count = 0;
        while ((size = queue.size()) != 0) {
            count++;
            while (size-- > 0) {
                Point now = queue.remove();

                for (int i = 0; i < 3; i++) {
                    int newY = now.y + moveDy[now.d][i];
                    int newX = now.x + moveDx[now.d][i];
                    int newD = now.d;

                    if (newY == end.y && newX == end.x && newD == end.d) {
                        return count;
                    }

                    if (newY < 0 || newX < 0 || newY > Y || newX > X || field[newY][newX] == 1) {
                        break;
                    }
                    if (memory[newY][newX][newD]) {
                        continue;
                    }

                    memory[newY][newX][newD] = true;

                    queue.add(new Point(newY, newX, newD));
                }

                //right
                {
                    int newY = now.y;
                    int newX = now.x;
                    int newD = right[now.d];

                    if (newY == end.y && newX == end.x && newD == end.d) {
                        return count;
                    }


                    if (!memory[newY][newX][newD]) {
                        memory[newY][newX][newD] = true;
                        queue.add(new Point(newY, newX, newD));
                    }

                }
                //left
                {
                    int newY = now.y;
                    int newX = now.x;
                    int newD = left[now.d];

                    if (newY == end.y && newX == end.x && newD == end.d) {
                        return count;
                    }

                    if (!memory[newY][newX][newD]) {
                        memory[newY][newX][newD] = true;
                        queue.add(new Point(newY, newX, newD));
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        if (Y == 0 && X == 0) {
            bw.write("0");

            bw.flush();
            bw.close();
            return;
        }

        field = new int[Y + 1][X + 1];
        memory = new boolean[Y + 1][X + 1][5];

        for (int y = 0; y < Y + 1; y++) {
            field[y][0] = 1;
        }
        for (int x = 0; x < X + 1; x++) {
            field[0][x] = 1;
        }

        for (int y = 1; y < Y + 1; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x < X + 1; x++) {
                field[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

        bw.write(bfs(start, end) + "");

        bw.flush();
        bw.close();
    }

    static class Point {
        int y;
        int x;
        int d;

        public Point(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

    }
}

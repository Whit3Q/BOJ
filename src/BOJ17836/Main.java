package BOJ17836;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    static int Y;
    static int X;
    static int T;
    static int[][] field;
    static boolean[][][] memory;

    public static void main(String[] args) throws IOException {
		/*
6 6 16
0 0 0 0 1 1
0 0 0 0 0 2
1 1 1 0 1 0
0 0 0 0 0 0
0 1 1 1 1 1
0 0 0 0 0 0
		 */
//10
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        field = new int[Y][X];
        memory = new boolean[Y][X][T];

        for(int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < X; x++) {
                field[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        if(result == -1) {
            bw.write("Fail");
        } else {
            bw.write(String.valueOf(result));
        }
        bw.flush();
        bw.close();
    }

    public static int bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, 0));
        memory[0][0][0]=true;
        int count = 0;

        while(!queue.isEmpty()) {
            if(count == T) {
                return -1;
            }

            int size = queue.size();
            while(size-- > 0) {
                Point now = queue.remove();

                for(int i = 0; i < 4; i++) {
                    int newY = now.y + dy[i];
                    int newX = now.x + dx[i];
                    if(newY == Y-1 && newX == X -1) {
                        return count + 1;
                    }

                    if(newY < 0 || newX < 0 || newY > Y - 1 || newX > X - 1  || memory[newY][newX][now.gram]) { //가면 안되는 곳
                        continue;
                    }


                    if((now.gram != 1) && (field[newY][newX] == 1)) {
                        continue;
                    }

                    if(field[newY][newX] == 2) { //그람 찾았니?
                        memory[newY][newX][1] = true;
                        memory[newY][newX][0] = true;
                        queue.add(new Point(newY, newX, 1)); //찾았다
                        continue;
                    }

                    memory[newY][newX][now.gram] = true;
                    queue.add(new Point(newY, newX, now.gram));

                }
            }
            count++;
        }

        return -1;
    }

    static class Point {
        int y;
        int x;
        int gram;

        public Point(int y, int x, int gram) {
            this.y = y;
            this.x = x;
            this.gram = gram;
        }
    }
}

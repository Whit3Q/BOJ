package BOJ16933;

import java.io.*;
import java.util.*;

public class BOJ16933 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int Y;
    static int X;
    static int K;
    static int[][] field;
    static boolean[][][] memory;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    //20
    public static int bfs(int k) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, k, 0));
        for (int i = 0; i < K + 1; i++) {
            memory[0][0][i] = true;
        }
        if(Y - 1 == 0 && X - 1 == 0) {
            return 0;
        }

        int count = 0;
        int size = 0;
        while ((size = queue.size()) != 0) {
            count++;
            while (size-- > 0) {
                Point now = queue.remove();

                for (int i = 0; i < 4; i++) {
                    int newY = now.y + dy[i];
                    int newX = now.x + dx[i];
                    int newD = now.d == 0 ? 1 : 0; // 0은 낮 , 1은 밤

                    if (newY == Y - 1 && newX == X - 1) {
                        return count;
                    }

                    if (newY < 0 || newX < 0 || newY > Y - 1 || newX > X - 1) { //갈수 있는 지역인가?
                        continue;
                    }

                    if (field[newY][newX] == 1) { //벽이 있는가?
                        if (now.k > 0) { //벽을 뚫을 수 있는가?
                            if (now.d == 0) { // 낮이면 뚫고가기
                                if (!memory[newY][newX][now.k - 1]) { // 방문한적 없으면
                                    memory[newY][newX][now.k - 1] = true;
                                    queue.add(new Point(newY, newX, now.k - 1, newD));
                                }
                            } else { // 밤이면 대기하기 //줄인다고 하면 이 부분을 줄여야 할꺼 같은데 Point에 int변수를 하나 주고 벽뚫은 시간을 추가로 저장해줘서
                                // 마지막에 더해주는 방식 이러면 최단 거리가 안 나올꺼 같음
                                memory[now.y][now.x][now.k] = true;
                                queue.add(new Point(now.y, now.x, now.k, newD));
                            }
                        }
                        continue;
                    }

                    if (memory[newY][newX][now.k]) {
                        continue;
                    }
                    memory[newY][newX][now.k] = true;

                    queue.add(new Point(newY, newX, now.k, newD));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        field = new int[Y][X];
        memory = new boolean[Y][X][K + 1]; //0은 낮 , 1은 밤

        for (int y = 0; y < Y; y++) {
            String line = br.readLine();
            for (int x = 0; x < X; x++) {
                field[y][x] = line.charAt(x) - 48;
            }
        }

        int tmp = bfs(K);
        if(tmp == -1) {
            bw.write("-1");
        } else {
            bw.write(tmp + 1 + "");
        }
        bw.flush();
        bw.close();
    }

    static class Point {
        int y;
        int x;
        int k;
        int d;

        public Point(int y, int x, int k, int d) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.d = d;
        }

    }
}

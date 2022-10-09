package BOJ16137;

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

    static int Y;
    static int X;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int bridgeTime;

    static int[][] field;
    static boolean[][][] memory;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        Y = X = Integer.parseInt(st.nextToken());
        bridgeTime = Integer.parseInt(st.nextToken());

        field = new int[Y][X];
        memory = new boolean[Y][X][2];

        for(int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x= 0; x < X; x++) {
                field[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        checkDeppPoint();

//		for(int y = 0; y < Y; y++) {
//			for(int x = 0; x < X; x++) {
//				bw.write(field[y][x]+" ");
//			}
//			bw.newLine();
//		}

        bw.write(workingBfs()+"");

        bw.flush();
        bw.close();
    }

    public static void checkDeppPoint() {
        for(int y = 0; y < Y; y++) {
            if(field[y][0] != 1) {
                checkDeepPointDFS(y, 0, 1);
            }
            if(field[y][X-1] != 1) {
                checkDeepPointDFS(y, X-1, 3);
            }
        }

        for(int x = 0; x < X; x++) {
            if(field[0][x] != 1) {
                checkDeepPointDFS(0, x, 2);
            }
            if(field[Y-1][x] != 1) {
                checkDeepPointDFS(Y-1, x, 0);
            }
        }

    }

    public static void checkDeepPointDFS(int y, int x, int d) {
        int count = 0;

        for(int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if(newY < 0 || newX < 0 || newY > Y - 1 || newX > X - 1 || field[newY][newX] == 1||memory[newY][newX][0]) {
                continue;
            }

            if(d != i) {
                count++;
            }

            memory[y][x][0] = true;
            checkDeepPointDFS(newY, newX, i);
            memory[y][x][0] = false;
        }

        if(count > 0) {
            if(field[y][x] == 0) {
                field[y][x] = -1;
            }
        }

    }

    public static int workingBfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0,0,false, false));
        memory[0][0][0] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while(size-- > 0) {
                Point now = queue.remove();
                if(field[now.y][now.x] == 1) {
                    queue.add(now);
                }
                for(int i = 0; i < 4; i++) { //4방향 순회
                    int newY = now.y + dy[i];
                    int newX = now.x + dx[i];

                    if(newY < 0 || newX < 0 || newY > Y - 1 || newX > X - 1 || field[newY][newX] == -1 || memory[newY][newX][now.briedg ? 1 : 0]) {
                        continue;
                    }

                    if(newY == Y - 1 && newX == X - 1) { // 목표 지점 도착
                        return count;
                    }

                    if(field[newY][newX] > 1) { // 까치가 놓는 오작교
                        if(count%field[newY][newX] == 0 && !now.check) {
                            memory[newY][newX][1] = true;
                            queue.add(new Point(newY, newX, false, true));
                            continue;
                        }

                        continue;
                    }

                    if(field[newY][newX] == 0) { // 견우가 요청하는 오작교
                        if(count%bridgeTime == 0 && !now.briedg && !now.check) {
                            memory[newY][newX][1] = true;
                            queue.add(new Point(newY, newX, true, true));
                        }
                        continue;
                    }

                    memory[newY][newX][now.briedg ? 1 : 0]= true;
                    queue.add(new Point(newY, newX, now.briedg, false));
                }


            }
        }

        return 0;
    }

    static class Point {
        int y;
        int x;
        boolean briedg;
        boolean check;

        public Point(int y, int x, boolean breiedg, boolean check) {
            this.y = y;
            this.x = x;
            this.briedg = breiedg;

            this.check = check;
        }
    }
}

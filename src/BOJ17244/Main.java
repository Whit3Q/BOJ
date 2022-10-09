package BOJ17244;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int Y;
    static int X;
    static char[][] field;
    static boolean[][][] memory;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int target;

    public static int bfs(Point start) {
        int result = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        int count=0;
        memory = new boolean[Y][X][32];
        memory[start.y][start.x][0] = true;
        roop :
        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for(int i = 0; i < size; i++) {
                Point now = queue.poll();

                for(int j = 0; j < 4; j++) {
                    int newY = now.y + dy[j];
                    int newX = now.x + dx[j];
                    int newBitMask = now.bitMask;

                    if(field[newY][newX] == '#' || memory[newY][newX][newBitMask]) { // 벽
                        continue;
                    } else if(field[newY][newX] == 'E') { //문
                        if(now.bitMask == target) { //물건 다 챙여오는지 확인
                            break roop;
                        }
                        continue;
                    } else if (field[newY][newX] == '.'){
                        memory[newY][newX][newBitMask]=true;;
                        queue.add(new Point(newY, newX, newBitMask)); //빈 곳
                        continue;
                    } else { // 물건
                        int X = field[newY][newX] - '0';
//						System.out.println(field[newY][newX]);
                        if((newBitMask&(1<<X)) == 0) {
                            newBitMask = newBitMask|(1<<X);
                            memory[newY][newX][newBitMask] = true;
                        }
                        queue.add(new Point(newY, newX, newBitMask));
                    }

                }

            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        field = new char[Y][X];
        Point start = null;
        target = 0;
        char things = '0';
        int startY = 0;
        int startX = 0;
        for(int y = 0; y < Y; y++) {
            String line = br.readLine();
            for(int x = 0; x < X; x++) {
                char tmp = line.charAt(x);
                if(tmp == 'X') {
                    field[y][x] = things;
                    things++;
                    target++;
                    continue;
                } else if(tmp == 'S') {
                    startY = y;
                    startX = x;
                    field[y][x]='.';
                    continue;
                }
                field[y][x] = tmp;
            }
        }

        target = (1<<target);
        target--;
        start = new Point(startY, startX, 0);
        System.out.println(bfs(start));
    }

    static class Point {
        int y;
        int x;
        int bitMask;

        public Point(int y, int x, int bitMask) {
            this.y = y;
            this.x = x;
            this.bitMask = bitMask;
        }


    }
}

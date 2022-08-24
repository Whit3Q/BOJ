package BOJ17198;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17198 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static int[][] field = new int[10][10];
    static boolean[][] memory = new boolean[10][10];
    static int Y = 10;
    static int X = 10;
    static int[] start;
    static int[] end;

    public static int bfs(int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        memory[start[0]][start[1]] = true;
        int size = 0;
        int count = 0;
        while((size = queue.size()) != 0) {
            count++;

            while(size-- > 0) {
                int[] now = queue.remove();

                for(int i =0; i < 4; i++) {
                    int newY = now[0] + dy[i];
                    int newX = now[1] + dx[i];

                    if(newY < 0 || newX < 0 || newY > 9 || newX > 9 || memory[newY][newX]) {
                        continue;
                    }
                    if(newY == end[0] && newX == end[1]) {
                        return count - 1;
                    }
                    memory[newY][newX] = true;
                    queue.add(new int[] {newY, newX});
                }

            }

        }
        return 0;
    }


    public static void main(String[] args) throws IOException {

        for(int y = 0; y < Y; y++) {
            String line = br.readLine();
            for(int x = 0; x < X; x++) {
                char tmp = line.charAt(x);
                int tn = 0;
                if(tmp == 'B'){
                    tn = 3;
                    end = new int[] {y,x};
                } else if(tmp == 'L') {
                    tn = 2;
                    start = new int[] {y,x};
                } else if(tmp == 'R'){
                    memory[y][x] = true;
                    tn = 1;
                }
                field[y][x] = tn;
            }
        }

        bw.write(bfs(start, end)+"");

        bw.flush();
        bw.close();
    }
}

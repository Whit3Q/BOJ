package BOJ11967;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11967 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    public static ArrayDeque<int[]>[][] field;
    public static boolean[][] memory;
    public static boolean[][] memory2;
    public static int[] dy = {0,0,-1,1};
    public static int[] dx = {-1,1,0,0};
    public static int maxCount = 1;

    public static boolean bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {y,x});
        memory2[y][x] = true;
        memory[y][x] = true;
        turnON(y,x);
        int count = 1;
        boolean check = false;
        while(queue.size() != 0) {
            int[] now = queue.remove();

            for(int i = 0; i < 4; i++) {
                int newY = now[0] + dy[i];
                int newX = now[1] + dx[i];

                if(newY < 1 || newX < 1 || newY > N || newX > N || memory2[newY][newX] || !memory[newY][newX]) {
                    continue;
                }
                memory2[newY][newX] = true;

                if(turnON(newY,newX)) {
                    check = true;
                }
                queue.add(new int[] {newY, newX});
            }
        }

        return check;
    }

    public static boolean turnON(int y, int x) {
        boolean check = false;
        int size = field[y][x].size();
        for(int i = 0; i < size; i++) {
            int[] point = field[y][x].remove();
            if(memory[point[0]][point[1]]) {
                continue;
            }
            check = true;
            maxCount++;
            memory[point[0]][point[1]] = true;
        }
        return check;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new ArrayDeque[N+1][N+1];
        memory = new boolean[N+1][N+1];
        memory2 = new boolean[N+1][N+1];

        for(int y = 0; y < N+1; y++) {
            for(int x = 0; x < N+1; x++) {
                field[y][x] = new ArrayDeque<>();
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int ty = Integer.parseInt(st.nextToken());
            int tx = Integer.parseInt(st.nextToken());

            field[y][x].add(new int[] {ty, tx});
        }

        while(bfs(1, 1)) {
            memory2 = new boolean[N+1][N+1];
        }

        bw.write(maxCount+"");

        bw.flush();
        bw.close();
    }
}

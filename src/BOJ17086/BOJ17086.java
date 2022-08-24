package BOJ17086;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int Y;
    static int X;
    static int[][] field;
    static boolean[][] memory;
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dx = {-1, 1, 0, 0, 1, -1, -1, 1};


    public static int bfs(ArrayList<int[]> list) {

        int result = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int[] now : list) {
            memory[now[0]][now[1]] = true;
            queue.add(now);
        }

        int size = 0;
        int count = 0;
        while ((size = queue.size()) != 0) {
            count++;

            while (size-- > 0) {
                int[] now = queue.remove();

                for (int i = 0; i < 8; i++) {
                    int newY = now[0] + dy[i];
                    int newX = now[1] + dx[i];

                    if (newY < 0 || newX < 0 || newY > Y - 1 || newX > X - 1 || memory[newY][newX]) {
                        continue;
                    }
                    memory[newY][newX] = true;

                    field[newY][newX] = count;
                    result = count;
                    queue.add(new int[]{newY, newX});
                }

            }

        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        field = new int[Y][X];
        memory = new boolean[Y][X];

        ArrayList<int[]> shark = new ArrayList<>();

        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < X; x++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    shark.add(new int[]{y, x});
                }
                field[y][x] = tmp;
            }
        }

        bw.write(bfs(shark) + "");

        bw.flush();
        bw.close();
    }
}

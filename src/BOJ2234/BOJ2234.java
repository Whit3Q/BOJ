package BOJ2234;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ2234 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[] dd = {2, 8, 1, 4};

    static int[][] field;
    static int[][] memory;
    static boolean[][] memory2;
    static int Y;
    static int X;

    public static int dfs(int y, int x, int count) {
        int result = 0;
        int brokenWall = 0;
        memory[y][x] = count;

        for (int i = 0; i < 4; i++) {

            if ((dd[i] & field[y][x]) == dd[i]) {
                continue;
            }

            int newY = y + dy[i];
            int newX = x + dx[i];

            if (newY < 0 || newX < 0 || newY > Y - 1 || newX > X - 1 || memory[newY][newX] > 0) {
                continue;
            }

            result += dfs(newY, newX, count) + 1;

        }

        return result + brokenWall;
    }

    public static int dfs2(int y, int x, HashMap<Integer, Integer> hm) {
        int result = 0;
        memory2[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (newY < 0 || newX < 0 || newY > Y - 1 || newX > X - 1 || memory2[newY][newX]) {
                continue;
            }

            if ((dd[i] & field[y][x]) == dd[i]) {
                if(memory[newY][newX] == memory[y][x]) {
                    continue;
                }
                result = Math.max(result, hm.get(memory[newY][newX]));
                continue;
            }

            result = Math.max(result,dfs2(newY, newX, hm));
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        field = new int[Y][X];
        memory = new int[Y][X];
        memory2 = new boolean[Y][X];
        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < X; x++) {
                field[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        int max = 0;
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (memory[y][x] == 0) {
                    count++;
                    int tmp = dfs(y, x, count)+1;
                    hm.put(count, tmp);
                    max = Math.max(max, tmp);
                }
            }
        }

        int sumMax = 0;
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (!memory2[y][x]) {
                    int tmp = dfs2(y, x, hm);
                    sumMax = Math.max(sumMax, tmp + hm.get(memory[y][x]));
                }
            }
        }


        bw.write(count + "\n");
        bw.write(max + "\n");
        bw.write(sumMax + "\n");

        bw.flush();
        bw.close();
    }
}

package BOJ9328;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T;
    static int Y;
    static int X;
    static char[][] field;
    static boolean[][] memory;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int result, newC;

    public static void bfs(Queue<Point> queue, boolean[][] memory) {
//        System.out.println("start");
        while(queue.size() != 0) {
            Point now = queue.remove();

            for(int i = 0 ; i < 4; i ++) {
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];

                if(newY < 0 || newX < 0 || newY > Y + 1 || newX > X + 1 || field[newY][newX] == '*' || memory[newY][newX]) {
                    continue;
                }

                if(field[newY][newX] == '$') {
                    result++;
                    memory[newY][newX] = true;
                    field[newY][newX] = '.';
                    queue.add(new Point(newY, newX));
                    continue;
                }

                if(field[newY][newX] != '.') {
                    char tmp = field[newY][newX];
                    int tn = 0;
                    if(tmp < 91) { // 문일때
                        tn = (field[newY][newX] - 'A');
                        tn = newC & (1 << tn);
                        if(tn == 0) {
                            memory[newY][newX] = true;
                            continue;
                        }
                        if(!memory[newY][newX]) {
                            memory[newY][newX] = true;
                            field[newY][newX] = '.';
                            queue.add(new Point(newY, newX));
                            continue;
                        }
                    } else { // 열쇠
                        tn = (field[newY][newX] - 'a');
                        int tmp2 = 0;
                        if( (tmp2 = newC & (1 << tn)) != 0) {
                            field[newY][newX] = '.';
                            queue.add(new Point(newY,newX));
                            continue;
                        }
                        newC = newC | (1 << tn);
                        Queue<Point> tmpQ = new ArrayDeque<>();
                        tmpQ.add(new Point(newY, newX));
                        boolean[][] memory2 = new boolean[Y+2][X+2];
                        field[newY][newX] ='.';
                        bfs(tmpQ, memory2);
                        continue;
                    }
                    continue;
                }

                memory[newY][newX] = true;
                queue.add(new Point(newY, newX));
            }
        }

    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            result = 0;
            newC = 0;
            st = new StringTokenizer(br.readLine());
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            field = new char[Y+2][X+2];
            memory = new boolean[Y+2][X+2];
            Queue<Point> queue = new ArrayDeque<>();

            for(int y = 0; y <= Y+1; y++) {
                Arrays.fill(field[y],'.');
            }
            for(int y = 1; y <= Y; y++) {
                String line = br.readLine();
                for(int x = 1; x <= X; x++) {
                    field[y][x] = line.charAt(x-1);
                }
            }

            int t = 0;
            String tmp = br.readLine();
            if(tmp.charAt(0) != '0') {
                for(int i = 0; i < tmp.length(); i++) {
                    int num = 1;
                    char tm = tmp.charAt(i);
                    int number = tm - 97;
                    newC = newC | (num << number);
                }
            }
            memory[0][0] = true;
            queue.add(new Point(0,0));
            bfs(queue, memory);
            bw.write(result+"\n");
        }


        bw.flush();
        bw.close();
    }

    static class Point {
        int y;
        int x;


        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }
}
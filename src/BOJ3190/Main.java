package BOJ3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int[][] field;
    static int Y;
    static int X;

    static int K;
    static Point[] apple;
    static Command[] commands;

    static int C;


    public static void main(String[] args) throws IOException {
        Y = X = Integer.parseInt(br.readLine());
        field = new int[Y][X];

        K = Integer.parseInt(br.readLine());

        apple = new Point[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            apple[i] = new Point(y, x);
            field[y][x] = 1;
        }

        C = Integer.parseInt(br.readLine());

        commands = new Command[C];
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char com = st.nextToken().charAt(0);
            commands[i] = new Command(time, com);
        }
        Snake snake = new Snake();
        for(Command c : commands) {
            if(!snake.moveCom(c.time, c.com)) {
                System.out.println(snake.nowTime());
                return;
            }
        }

        while(snake.move()) {
            continue;
        }
        System.out.println(snake.nowTime());
    }

    static class Snake {
        Point head;
        Point tail;
        int length;
        int d;
        private int time;

        static int[] dy;
        static int[] dx;

        static int[] L;
        static int[] R;
        Deque<Point> snakeBody;

        public Snake() {
            head = new Point(0, 0);
            tail = new Point(0, 0);
            field[0][0] = 2;
            length = 1;
            time = 0;
            d = 1;
            snakeBody = new ArrayDeque<>();
            snakeBody.add(head);
//            snakeBody.add(tail);

            dy = new int[]{-1, 0, 1, 0};
            dx = new int[]{0, 1, 0, -1};

            L = new int[]{3, 0, 1, 2};
            R = new int[]{1, 2, 3, 0};
        }

        public boolean move() {
            return moveCom(this.time+1, '0');
        }

        public boolean moveCom(int time, char rotate) {
            for(int i = this.time; i < time; i++) {
                this.time++;
                int newY = this.head.y + dy[this.d];
                int newX = this.head.x + dx[this.d];
                if(!check(newY,newX)) {
                    return false;
                }
                boolean apple = false;
                //머리 이동
                if(field[newY][newX] == 1) {
                    apple = true;
                }
                field[newY][newX] = 2;
                this.head = new Point(newY, newX);
                snakeBody.addFirst(this.head);

                //꼬리 이동
                if(apple) {
                    this.length++;
                    apple = false;
                } else {
                    Point tail = this.snakeBody.removeLast();
                    field[tail.y][tail.x] = 0;
                }

            }
            if(rotate == 'L') {
                this.d = L[this.d];
            } else if(rotate == 'D') {
                this.d = R[this.d];
            }
            return true;
        }

        public boolean check(int newY, int newX) {
            return newY >= 0 && newX >= 0 && newY <= Y - 1 && newX <= X - 1 && field[newY][newX] != 2;
        }

        public int nowTime() {
            return this.time;
        }
    }


    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Command {
        int time;
        char com;

        public Command(int time, char com) {
            this.time = time;
            this.com = com;
        }
    }
}

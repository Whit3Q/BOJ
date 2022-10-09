package BOJ1400;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T;
    static int Y;
    static int X;
    static int crossWayCount;

    static char[][] field;
    static int[][] memory;
    static ArrayList<Cross> crossWays;

    static int[] dy = {0, 0, -1, 1}; //동,서,남,북
    static int[] dx = {1, -1, 0, 0};

    static Point start;
    static Point end;

    public static void main(String[] args) throws IOException {

        while(true) {
            st = new StringTokenizer(br.readLine()); //크기 받기
            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            crossWayCount = -1;
            if(Y == 0 && X == 0) { // 종료 조건 확인
                break;
            }

            field = new char[Y][X]; //필드 생성

            for(int y = 0; y < Y; y++) { // 필드 초기화
                String line = br.readLine();
                for(int x = 0; x < X; x++) {
                    char tmp = line.charAt(x);
                    int tmpNum = tmp - '0';
                    field[y][x] = tmp;

                    if(tmpNum >= 0 && tmpNum < 10) { // 교차로 크기 확인
                        crossWayCount = Math.max(crossWayCount, tmpNum);
                    } else if(tmp == 'A') {
                        start = new Point(y,x);
                        field[y][x]='#';
                    } else if(tmp == 'B') {
                        end = new Point(y,x);
                    }
                }
            }
            crossWays = new ArrayList<>();

            for(int i = 0; i <= crossWayCount; i++) { //교차로 초기화
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String dir = st.nextToken();
                int timeOne = Integer.parseInt(st.nextToken());
                int timeTwo = Integer.parseInt(st.nextToken());

                crossWays.add(new Cross(dir, timeOne, timeTwo));
            }

            int result = bfs();

            if(result == -1) {
                bw.write("impossible");
            } else {
                bw.write(result+"");
            }
            bw.newLine();
            br.readLine();
        }

        bw.flush();
        bw.close();
    }

    public static int bfs() {
        int count = 0;
        memory = new int[Y][X];
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;

            while(size-- > 0) {
                Point now = queue.remove();

                for(int i = 0; i < 4; i++) {
                    int newY = now.y + dy[i];
                    int newX = now.x + dx[i];

                    if(newY < 0 || newX < 0 || newY > Y - 1 || newX > X - 1 || field[newY][newX] == '.' || memory[newY][newX] != 0) {
                        continue;
                    }

                    if(field[newY][newX] == '#') { //도로
                        memory[newY][newX] = 1;
                        queue.add(new Point(newY, newX));
                    } else if(field[newY][newX] == 'B') { //목적지
                        return count;
                    } else { //교차로일때
                        int nowNum = field[newY][newX] - '0'; //교차로 번호
                        int dir = crossWays.get(nowNum).nowDir();
                        if(dir == 1) {
                            if(i == 0 || i == 1) { //동서방향 차단
                                queue.add(now);
                                continue;
                            }
                            memory[newY][newX] = 1;
                            queue.add(new Point(newY, newX));
                        } else {
                            if(i == 2 || i == 3) { //남북방향 차단
                                queue.add(now);
                                continue;
                            }
                            memory[newY][newX] = 1;
                            queue.add(new Point(newY, newX));
                        }
                    }

                }

            }

            for(Cross cross : crossWays) {
                cross.timefly();
            }
        }

        return -1;
    }


    static class Point { //차량 위치
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Cross {
        int now; // 현재
        int[] timeTable;
        int size;

        public Cross(String now, int timeOne, int timeTwo) {
            this.size = timeOne + timeTwo; //타임테이블 크기
            timeTable = new int[size];
            for(int i = timeOne; i < size; i++) { //타임 테이블 초기화
                timeTable[i] = 1;
            }

            if(now.equals("|")) { //초기 시간 세팅
                this.now = timeOne; // 남북
            } else {
                this.now = 0; // 동서
            }
        }

        public int nowDir() { //현재 방향
            return timeTable[now%size];
        }

        public void timefly() { //시간 흐름
            now++;
        }
    }
}


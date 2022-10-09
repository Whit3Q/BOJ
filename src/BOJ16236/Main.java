package BOJ16236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int Y;
    static int X;

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0 ,0};

    static int[][] field;
    static boolean[][] memory;
    static int[] fishCount;
    static int fishTotal;
    static Point sharkPoint;

    public static void main(String[] args) throws IOException {
        Y = X = Integer.parseInt(br.readLine());

        field = new int[Y][X];
        fishCount = new int[7];

        for(int y = 0; y < Y; y++) { //필드 받기
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < X; x++) {
                int tmpNum = Integer.parseInt(st.nextToken());
                field[y][x]= tmpNum;
                if(tmpNum == 9) {
                    sharkPoint = new Point(y, x, 0);
                    field[y][x] = 0;
                    continue;
                } else if(tmpNum == 0) {
                    continue;
                }
                fishCount[field[y][x]]++;
                fishTotal++;
            }
        }

        while(remaindBabyFeed()) {
            memory = new boolean[Y][X];
            if(!feedDisBfs()) {
                break;
            }
        }

        bw.write(sharkPoint.day+"");
        bw.flush();
        bw.close();
    }

    public static boolean remaindBabyFeed() {
        boolean check = false;
        if(sharkPoint.babySharkSize < 7) {
            for(int i = sharkPoint.babySharkSize - 1; i >= 0; i--) {
                if(fishCount[i] > 0) {
                    check = true;
                }
            }
        } else {
            if(fishTotal > 0) {
                check = true;
            }
        }

        return check;
    }

    public static boolean feedDisBfs() {
        Queue<Fish> queue = new ArrayDeque<>();
        PriorityQueue<Fish> result = new PriorityQueue<>(new Comparator<Fish>() {

            @Override
            public int compare(Fish o1, Fish o2) {
                // TODO Auto-generated method stub
                if(o1.y == o2.y) {
                    return o1.x - o2.x;
                }
                return o1.y - o2.y;
            }
        });

        queue.add(new Fish(sharkPoint.y , sharkPoint.x));

        int count = 0;
        boolean check = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(check) {
                break;
            }
            count++;
            while(size-- > 0) {
                Fish now = queue.remove();

                for(int i = 0; i < 4; i ++) {
                    int newY = now.y + dy[i];
                    int newX = now.x + dx[i];

                    if(newY < 0 || newX < 0 || newY > Y -1 || newX > X - 1 || memory[newY][newX] ||field[newY][newX] > sharkPoint.babySharkSize) {
                        continue;
                    }

                    if(field[newY][newX] == 0 || field[newY][newX] == sharkPoint.babySharkSize) {
                        memory[newY][newX] = true;
                        queue.add(new Fish(newY, newX));
                        continue;
                    }

                    check = true;
                    memory[newY][newX] = true;
                    result.add(new Fish(newY, newX));
                }

            }

        }

        if(result.size() != 0) { //먹이 먹이기
            Fish resultFish = result.poll();
            sharkPoint.y = resultFish.y;
            sharkPoint.x = resultFish.x;
            sharkPoint.day += count;
            fishCount[field[resultFish.y][resultFish.x]]--;
            field[resultFish.y][resultFish.x] = 0;
            sharkPoint.feeding();
            fishTotal--;

            return true;
        }

        return false;
    }

    static class Point {
        int y;
        int x;
        int day;
        int babySharkSize;
        int feed;

        public Point(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
            this.babySharkSize = 2;
            this.feed = 0;
        }

        public void feeding() {
            feed++;
            if(feed == babySharkSize) {
                babySharkSize++;
                feed = 0;
            }
        }
    }

    static class Fish {
        int y;
        int x;
        //		int dis;
        public Fish (int y, int x) {
            this.y = y;
            this.x = x;
//			this.dis = dis;
        }
    }
}
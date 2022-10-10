package BOJ17135;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[][] field;
    static int[][] bakField;
    static byte[][][] arrowD;
    static int Y;
    static int X;
    static int D;

    static Archer[] archers;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        field = new int[Y+1][X];
        bakField = new int[Y+1][X];

        for(int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < X; x++) {
                int tmp = Integer.parseInt(st.nextToken());
                field[y][x] = tmp;
                bakField[y][x] = tmp;
            }
        }

        archers = new Archer[3];
        int result = 0;
        for(int i = 0; i < (1<<X); i++) { //궁수 조합
            if(Integer.bitCount(i) == 3) { // 3명 조합 했을 때
                copyField(); // 필드 원상복구
                String str = Integer.toBinaryString(i);
                if(str.length() < X) {
                    int tmp = X - str.length();
                    StringBuilder sb = new StringBuilder();
                    while(tmp-- > 0) {
                        sb.append("0");
                    }
                    sb.append(str);
                    str = sb.toString();
                }
                int archersIndex = 0;
                for(int j = X -1 ; j >= 0; j--) {
                    if(str.charAt(j) - '0' == 1) {
                        field[Y][j] = 2;
                        archers[archersIndex] = new Archer(Y, j);
                        archers[archersIndex].makeArrowD(Y, X, D);
                        archersIndex++;
                    }
                }

                //게임 시작
                int tmp = simul();
                result = Math.max(result, tmp);
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    public static int simul() {
        int killCount = 0;
        for(int i = 0; i < Y; i++) { //맵끝에 있는 적까지 내려오는 범위
            ArrayList<Point> target = new ArrayList<>();

            for(int a = 0; a < 3; a++) { // 궁수 공격
                Point tmp = archers[a].attack();
                if(tmp != null) {
                    target.add(tmp);
                }
            }
            for(Point point : target) {
                if(field[point.y][point.x] == 1) {
                    field[point.y][point.x] = 0;
                    killCount++;
                }
            }

            enemyMove();
        }
        return killCount;
    }

    public static void copyField() {
        for(int y = 0; y < Y+1; y++) {
            for(int x = 0; x < X; x++) {
                field[y][x] = bakField[y][x];
            }
        }
    }

    public static void enemyMove() { //적 움직임
        for(int x = 0; x < X; x++) { //성과 만난 적 다 제거
            field[Y-1][x] = 0;
        }

        for(int y = Y-2; y >= 0; y--) {
            for(int x = X-1; x >= 0; x--) {
                if(field[y][x] == 1) { //적 발견
                    field[y][x] = 0;
                    field[y+1][x] = 1;
                }
            }
        }
    }

    static class Archer {
        int y;
        int x;
        ArrayList<Point> attackPoint;
//		PriorityQueue<Point> attackPoint;

        public Archer(int y, int x) {
            this.y = y;
            this.x = x;
            attackPoint = new ArrayList<>();
//			attackPoint = new PriorityQueue<>(new Comparator<Point>() {
//
//				@Override
//				public int compare(Point o1, Point o2) {
//						if(o1.d == o2.d) {
//							return o1.x - o2.x;
//						}
//					return o1.d - o2.d;
//				}
//			});
        }

        public void addPoint(int y, int x, int d) { //공격 포인트 추가
//			this.attackPoint.add(new Point(y, x));
            this.attackPoint.add(new Point(y, x, d));
        }

//		public void addPoint(Point point) { //공격 포인트 추가
////			this.attackPoint.add(point);
//			this.attackPoint.add(point);
//		}

        public void makeArrowD(int Y, int X ,int D) { //거리 테이블 만들기고 공격 포인트 추가 X : 테이블 X크기, Y: 테이블 Y크기 D: 공격 거리

            for(int y = 0; y < Y; y++) {
                for(int x = 0; x < X; x++) {
                    int tmpD = Math.abs(y-this.y) + Math.abs(x - this.x);
                    if(tmpD <= D) {
                        this.addPoint(y, x, tmpD);
                    }
                }
            }
            Collections.sort(this.attackPoint, new Comparator<Point>() {

                @Override
                public int compare(Point o1, Point o2) {
                    // TODO Auto-generated method stub
                    if(o1.d == o2.d) {
                        return o1.x - o2.x;
                    }
                    return o1.d - o2.d;
                }
            });
        }

        public Point attack() { //공격
//			Iterator<Point> it = attackPoint.iterator();
//			while(it.hasNext()) {
//				Point point = it.next();
//				if(field[point.y][point.x] == 1) {
//					field[point.y][point.x] = 0;
//					return true;
//				}
//			}
            for(int i = 0; i < attackPoint.size(); i++) {
                Point point = attackPoint.get(i);
                if(field[point.y][point.x] == 1) {

                    return point;
                }
            }

            return null;
        }
    }

    static class Point {
        int y;
        int x;
        int d;

        public Point(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
            int d = -1;
        }
    }
}

package BOJ2504;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String str;

    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        str = br.readLine();
        int result = 0;
        int sum = 0;
        boolean check = false;
        boolean faillCheck = false;
        mainLoop:
        for (int i = 0; i < str.length(); i++) {
            int tmpNum = 0;
            String tmp = "";
            switch (String.valueOf(str.charAt(i))) {
                case "(":
                case "[":
                    stack.add(String.valueOf(str.charAt(i)));
                    break;
                case ")":
                    if (stack.isEmpty()) {
                        faillCheck = true;
                        break;
                    }
                    while (!stack.isEmpty()) {
                        tmp = stack.pop();
                        if (tmp.equals("(")) {
                            if (tmpNum == 0) {
                                tmpNum += 2;
                            } else {
                                tmpNum *= 2;
                            }
                            stack.add(String.valueOf(tmpNum));
                            break;
                        } else if (tmp.equals("[")) {
                            faillCheck = true;
                            break mainLoop;
                        } else {
                            int tn = Integer.parseInt(tmp);
                            tmpNum += tn;
                        }
                    }

                    break;
                case "]":
                    tmp = "";
                    if (stack.isEmpty()) {
                        faillCheck = true;
                        break;
                    }
                    while (!stack.isEmpty()) {
                        tmp = stack.pop();
                        if (tmp.equals("[")) {
                            if (tmpNum == 0) {
                                tmpNum += 3;
                            } else {
                                tmpNum *= 3;
                            }
                            stack.add(String.valueOf(tmpNum));
                            break;
                        } else if (tmp.equals("(")) {
                            faillCheck = true;
                            break mainLoop;
                        } else {
                            int tn = Integer.parseInt(tmp);
                            tmpNum += tn;
                        }
                    }

                    break;
            }

        }

        for (String i : stack) {
            if (i.equals("(") || i.equals("[")) {
                faillCheck = true;
                break;
            } else {
                result += Integer.parseInt(i);
            }
        }
        if (faillCheck) {
            bw.write("0");
        } else {
            bw.write(result + "");
        }

        bw.flush();
        bw.close();
    }
}

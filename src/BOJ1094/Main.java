package BOJ1094;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int bar = scanner.nextInt();

        System.out.println(Integer.bitCount(bar));
    }
}

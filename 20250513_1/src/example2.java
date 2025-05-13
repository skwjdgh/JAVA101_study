import java.util.Scanner;

public class example2 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("금액을 입력하시오.>>");
        String input = scanner.next();

        int won = Integer.parseInt(input);

        int a = won / 50000;      // 오만원권
        won = won % 50000;

        int b = won / 10000;      // 만원권
        won = won % 10000;

        int c = won / 5000;       // 오천원권
        won = won % 5000;

        int d = won / 1000;       // 천원권
        won = won % 1000;

        int e = won / 500;        // 500원 동전
        won = won % 500;

        int f = won / 100;        // 100원 동전
        won = won % 100;

        int g = won / 50;         // 50원 동전
        won = won % 50;

        int h = won / 10;         // 10원 동전
        won = won % 10;

        int i = won;           // 10원 미만 잔돈

        System.out.println("오만원권 " + a + "매");
        System.out.println("만원권 " + b + "매");
        System.out.println("오천원권 " + c + "매");
        System.out.println("천원권 " + d + "매");
        System.out.println("오백원 " + e + "개");
        System.out.println("백원 " + f + "개");
        System.out.println("오십원 " + g + "개");
        System.out.println("십원 " + h + "개");
        System.out.println("일원 "+ i + "원");
		scanner.close();
    }
}

/*
import java.util.Scanner;

public class example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("금액을 입력하시오.>>");
        int won = Integer.parseInt(scanner.next());

        // 권종/동전 단위 배열 (내림차순)
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        String[] names = {"오만원권", "만원권", "오천원권", "천원권", "500원", "100원", "50원", "10원"};

        for (int i = 0; i < units.length; i++) {
            int count = won / units[i];
            System.out.println(names[i] + " " + count + (i < 4 ? "매" : "개"));
            won %= units[i];
        }
        System.out.println("잔돈(10원 미만): " + won + "원");
    }
}
*/
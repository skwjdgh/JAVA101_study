import java.util.Scanner;


public class example1 {
	public static void main(String[] args) {
		
		//입력을 위한 세트
		Scanner scanner = new Scanner(System.in);
		System.out.print("원화를 입력하세요(단위 원):");
		int won = scanner.nextInt(); // 정수로 입력 받기
		
		double dollar = won / 1200.0;

		System.out.print(won + "원은 ");
		System.out.printf("$%.2f입니다.",dollar);
		
		scanner.close();
	}
}

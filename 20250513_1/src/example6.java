import java.util.Scanner;

public class example6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("달을 입력하세요(1~12)>>");
		int month = scanner.nextInt();	
	
		switch (month) {
			case 3:
			case 4:
			case 5:
				System.out.print("봄");
				break;
			case 6:
			case 7:
			case 8:
				System.out.print("여름");
				break;
			case 9:
			case 10:
			case 11:
				System.out.print("가을");
				break;
			case 12:
			case 1:
			case 2:
				System.out.print("겨울");
				break;
					
			default:
				System.out.println("잘못 입력하셨습니다.");

		}	
		scanner.close();
	}
}

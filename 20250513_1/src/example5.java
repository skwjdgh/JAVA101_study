import java.util.Scanner;

public class example5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("원의 중심과 반지름을 입력하시오.(x1, y1, r)>>");
		
		float x1 = scanner.nextFloat();
		float y1 = scanner.nextFloat();
		float r1 = scanner.nextFloat();
		
		System.out.println("점을 입력하시오(x1, y2)>>");
		
		float x2 = scanner.nextFloat();
		float y2 = scanner.nextFloat();
		
		double r2 = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
		
		if (r2 <= r1) {
			System.out.println("점 ("+ x2 +"," + y2 + "는 원 안에 있습니다.");
		}
		else {
			System.out.println("점 ("+ x2 +"," + y2 + "는 원 밖에 있습니다.");			
		}
		scanner.close();
	}

}

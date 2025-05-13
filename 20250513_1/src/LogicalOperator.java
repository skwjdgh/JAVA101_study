
public class LogicalOperator {
	public static void main(String[] args) {
		// 대문자 string과의 차이?
		
		System.out.println('a' > 'b');
		System.out.println(3 >= 2);
		System.out.println(-1 < 0);
		System.out.println(3.45 <= 2);
		System.out.println(3 == 2);
		System.out.println(3 != 2);
		System.out.println(!(3 != 2));
		
		
		System.out.println((3 > 2) && (3 > 4));
		System.out.println((3 != 2) || (-1 > 0)); //dead code?
		System.out.println((3 != 2) ^ (-1 > 0));
	}

}

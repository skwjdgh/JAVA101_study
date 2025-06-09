package sec01.ex01;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.ResultSet;


public class MemberDAO{
	private Connection con;
	private Statement stmt;
	public List listMembers() 
	{
		List list = new ArrayList();
		try
		{
			connDB();
			String query = "select * from t_member";
			
			System.out.println(query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	private void connDB() {
	    try {
	        // 1. JDBC 드라이버 로드
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        
	        // 2. DB 연결 정보
	        String url = "jdbc:oracle:thin:@localhost:1521:testdb"; // DB URL
	        String user = "scott"; // DB 사용자명
	        String password = "tiger"; // DB 비밀번호

	        // 3. Connection 객체 생성
	        con = java.sql.DriverManager.getConnection(url, user, password);

	        // 4. Statement 객체 생성
	        stmt = con.createStatement();

	        System.out.println("DB 연결 성공");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
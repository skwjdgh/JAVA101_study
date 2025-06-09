package sec02.ex02;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
public class MemberDAO{
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List listMembers() 
	{
		
		List list = new ArrayList();
		try
		{
			//connDB();
			
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
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
			pstmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void delMember(String id) {
	    try {
	        con = dataFactory.getConnection();
	        String query = "DELETE FROM t_member " + " WHERE id = ?";
	        System.out.println("prepareStatement: " + query);
	        pstmt = con.prepareStatement(query);
	        pstmt.setString(1, id);
	        pstmt.executeUpdate();
	        pstmt.close();
	        con.close(); // 꼭 연결 해제
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void addMember(MemberVO memberVO) {
		try {
			con = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String query = " insert into t_member";
			query += " (id,pwd,name,email)";
			query += " values(?,?,?,?)";
			System.out.println("prepareStatement: "+ query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			pstmt.setString(3,name);
			pstmt.setString(4,email);
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*private void connDB() {
	    try {
	    	/*
	        // 1. JDBC 드라이버 로드
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        
	        // 2. DB 연결 정보
	        String url = "jdbc:oracle:thin:@localhost:1521:testdb"; // DB URL
	        String user = "scott"; // DB 사용자명
	        String password = "tiger"; // DB 비밀번호
			*/
	        // 3. Connection 객체 생성
	        //con = java.sql.DriverManager.getConnection(url, user, password);

	

	        // 4. Statement 객체 생성
	        /*
	        pstmt = con.createStatement();

	        System.out.println("DB 연결 성공");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}*/
}

package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/pro7/member3")
public class MemberServlet extends HttpServlet {
/*
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        MemberDAO dao = new MemberDAO();
        List list = dao.listMembers();

        out.print("<html><body>");
        out.print("<table border='1'><tr align='center' bgcolor='lightgreen'>");
        out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");

        for (int i = 0; i < list.size(); i++) {
            MemberVO memberVO = (MemberVO) list.get(i);
            String id = memberVO.getId();
            String pwd = memberVO.getPwd();
            String name = memberVO.getName();
            String email = memberVO.getEmail();
            Date joinDate = memberVO.getJoinDate(); 

            out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td></tr>");
        }
        out.print("</table></body></html>");
        
    }   
    */
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    doHandle(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
		{
		    request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
		    MemberDAO dao = new MemberDAO();
		    PrintWriter out = response.getWriter();
	        List list = dao.listMembers();
	        
	        
	        // 테이블 구조를 항상 출력 (공통 부분)
	        out.print("<html><body>");
	        out.print("<table border='1'><tr align='center' bgcolor='lightgreen'>");
	        out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");

	
		    String command = request.getParameter("command");
	
		    if (command != null && command.equals("addMember")) {
		    	
		    	MemberVO vo = new MemberVO();
		        String _id = request.getParameter("id");
		        String _pwd = request.getParameter("pwd");
		        String _name = request.getParameter("name");
		        String _email = request.getParameter("email");
		        vo.setId(_id);
		        vo.setPwd(_pwd);
		        vo.setName(_name);
		        vo.setEmail(_email);
		        dao.addMember(vo);
		       
		    }
		    else if (command != null && command.equals("delMember")) {
		    	String id = request.getParameter("id");
		    	dao.delMember(id);
		    }
		    
		    list = dao.listMembers();
		    
		    for (int i = 0; i < list.size(); i++)
	        {
	            MemberVO memberVO = (MemberVO) list.get(i);
	            String id = memberVO.getId();
	            String pwd = memberVO.getPwd();
	            String name = memberVO.getName();
	            String email = memberVO.getEmail();
	            Date joinDate = memberVO.getJoinDate();
	            out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate
	                + "</td><td> <a href='/pro7/member3?command=delMember&id=" + id + "'> 삭제 </a></td></tr>");
	        }
	        out.print("</table></body></html>");
	        out.print("<a href='/pro7/membersForm.html'>새 회원 등록하기</a>");
		}
}
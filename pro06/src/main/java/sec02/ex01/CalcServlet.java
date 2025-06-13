package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	
    private static final float USD_RATE = 1350.0f;
    private static final float JPY_RATE = 9.2f;
    private static final float CNY_RATE = 190.5f;
    private static final float GBP_RATE = 1650.7f;
    private static final float EUR_RATE = 1450.3f;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();

        String command = request.getParameter("command");    // 수행할 요청을 받아 옵니다.
        String won = request.getParameter("won");            // 변환할 원화를 받아 옵니다.
        String operator = request.getParameter("operator");  // 변환할 외화 종류를 받아 옵니다.
        
        if (command != null && command.equals("calculate")) {
            String result = calculate(Float.parseFloat(won), operator);
            pw.print("<html><font size=10>변환 결과<br></font>");
            pw.print("<font size=10>" + result + "</font><br>");
            pw.print("<a href='/pro06/calc'>환율 계산기</a>");
            return;
        }

        pw.print("<html><title>환율 계산기</title>");
        pw.print("<font size=5>환율 계산기</font><br>");
        pw.print("<form name='frmCalc' method='get' action='/pro06/calc'>");
        pw.print("원화: <input type='text' name='won' size=10 /><br>");
        pw.print("<select name='operator'>");
        pw.print("<option value='dollar'>달러</option>");
        pw.print("<option value='en'>엔화</option>");
        pw.print("<option value='wian'>위안</option>");
        pw.print("<option value='pound'>파운드</option>");
        pw.print("<option value='euro'>유로</option>");
        pw.print("</select><br>");
        pw.print("<input type='hidden' name='command' value='calculate' />");
        pw.println("<input type='submit' value='변환' />");
        pw.println("</form>");
        pw.println("</html>");
        pw.close();
    }
    private static String calculate(float won, String operator) {
        String result = null;
        if (operator.equals("dollar")) {
            result = String.format("%.6f", won / USD_RATE);
        } else if (operator.equals("en")) {
            result = String.format("%.6f", won / JPY_RATE);
        } else if (operator.equals("wian")) {
            result = String.format("%.6f", won / CNY_RATE);
        } else if (operator.equals("pound")) {
            result = String.format("%.6f", won / GBP_RATE);
        } else if (operator.equals("euro")) {
            result = String.format("%.6f", won / EUR_RATE);
        }
        return result;
    }

  
}
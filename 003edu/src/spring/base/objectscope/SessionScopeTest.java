package spring.base.objectscope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 		SessionScopeTest.java / 01SessionScopeTest.jsp 와 비교 
 */
public class SessionScopeTest extends HttpServlet {

	/// service()
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = res.getWriter();

		// 1. HttpSession 객체 Get
		HttpSession session = req.getSession(true);

		// 2. session Object Scope "count" 추출
		Integer count = (Integer) session.getAttribute("count");

		// 3. 없다면..
		// ==> name : "count" value : new Integer(1)
		if (count == null) {
			out.println(" :: Browser 켜고 1 번째 방문 ::");
			session.setAttribute("count", new Integer(1));
		}

		// 4. 있다면
		// ==> session ObjectScope 추출한 출력
		// ==> count 값을 증가 (+1) 다시 session ObjectScope 저장
		else {
			int changeCount = count.intValue() + 1;
			out.println(":: Browser 켜고 " + changeCount + " 번째 방문 ::");

			session.setAttribute("count", new Integer(changeCount));
		}
	}
}

package spring.base.objectscope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 		ApplicationScopeTest.java / 02ApplicationScopeTest.jsp 와 비교 
 */
public class ApplicationScopeTest extends HttpServlet {

	/// service()
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = res.getWriter();

		// 1. ServletContext(application 내장객체) 객체 Get
		ServletContext application = this.getServletContext();

		// 2. application Object Scope "count" 추출.
		Integer count = (Integer) application.getAttribute("count");

		// 3. 없다면...
		// ==> name : "count" value : new Integer(1)
		if (count == null) {
			out.println(" :: 해당 페이지 1 번째 출력 ::");
			application.setAttribute("count", new Integer(1));
		}

		// 4. 있다면..
		// ==> application ObjectScope 추출한 출력
		// ==> count 값을 증가(+1) 다시 application ObjectScope 저장
		else {
			int changeCount = count.intValue() + 1;
			out.println("::  해당 페이지 " + changeCount + " 번째 출력 ::");

			application.setAttribute("count", new Integer(changeCount));
		}
	}

}

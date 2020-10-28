package spring.base.objectscope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 		RequestScopeTest.java / 03RequestScopeTest.jsp 와 비교 
 */
public class RequestScopeTest extends HttpServlet {

	/// service()
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();

		// 1. request Object Scope "count" 추출.
		Integer count = (Integer) request.getAttribute("count");

		// 2. 없다면..
		// ==> name : "count" value : new Integer(1)
		if (count == null) {
			out.println(" :: 1 번째 Request ::");
			request.setAttribute("count", new Integer(1));
		}

		// 3. 있다면..
		// ==> request ObjectScope 추출한 출력
		// ==> count 값을 증가(+1) 다시 request ObjectScope 저장
		else {
			int changeCount = count.intValue() + 1;
			out.println(":: " + changeCount + " 번째 Request :: ");

			request.setAttribute("count", new Integer(changeCount));
		}
	}
}

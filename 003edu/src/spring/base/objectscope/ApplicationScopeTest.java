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
 * 		ApplicationScopeTest.java / 02ApplicationScopeTest.jsp �� �� 
 */
public class ApplicationScopeTest extends HttpServlet {

	/// service()
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = res.getWriter();

		// 1. ServletContext(application ���尴ü) ��ü Get
		ServletContext application = this.getServletContext();

		// 2. application Object Scope "count" ����.
		Integer count = (Integer) application.getAttribute("count");

		// 3. ���ٸ�...
		// ==> name : "count" value : new Integer(1)
		if (count == null) {
			out.println(" :: �ش� ������ 1 ��° ��� ::");
			application.setAttribute("count", new Integer(1));
		}

		// 4. �ִٸ�..
		// ==> application ObjectScope ������ ���
		// ==> count ���� ����(+1) �ٽ� application ObjectScope ����
		else {
			int changeCount = count.intValue() + 1;
			out.println("::  �ش� ������ " + changeCount + " ��° ��� ::");

			application.setAttribute("count", new Integer(changeCount));
		}
	}

}

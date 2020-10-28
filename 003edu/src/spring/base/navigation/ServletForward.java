package spring.base.navigation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import spring.service.domain.User;

/*
 * 		Servlet Navigation :: Forward
 * 		JSP Standard Action Tag : <jsp:forwad page ="~~.jsp"/> �� ��
 * 		Servlet ���� ������ ObjectScope�� ������ Bean ��
 * 		JSP�� Forward �� ����� Bean ���� ���� Ȯ��
 */
public class ServletForward extends HttpServlet {

	/// service()
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("[ ServletForward.service() start.......]");

		// ==> Request ObjectScope ����
		request.setAttribute("user01", new User("ȫ�浿", "1111"));

		// ==> Session ObjectScope ����
		HttpSession session = request.getSession(true);
		session.setAttribute("user02", new User("�̼���", "2222"));

		// ==> Application ObjectScope ����
		ServletContext application = this.getServletContext();
		application.setAttribute("user03", new User("�庸��", "3333"));

		// 1. ServletContext object ����
		ServletContext sc = this.getServletContext();
		// 2. Context ���� resource �̵� �� �� �ִ� ����� �����ϴ� RequestDisppatcher ��ü ����
		RequestDispatcher rd = sc.getRequestDispatcher("/02Navigation/view.jsp");
		// 3. Forward
		rd.forward(request, response);

		System.out.println("[ ServletForward.service() end........]");
	}

}

/*
 * 	������ : http://127.0.0.1:8080/003edu/ServletForward
 * 	1. web.xml mapping Ȯ��
 * 	2. URL Ȯ�� / Browser ȭ���� Servlet ȭ���ΰ� ? Jsp ȭ���ΰ� ?
 * 	3. ������ ObjectScope �ٽ� Ȯ��
 * 	4. forward�� sendRedirect ������ ? 
 * 
 */

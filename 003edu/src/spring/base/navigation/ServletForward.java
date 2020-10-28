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
 * 		JSP Standard Action Tag : <jsp:forwad page ="~~.jsp"/> 와 비교
 * 		Servlet 에서 각각의 ObjectScope에 저장한 Bean 을
 * 		JSP로 Forward 시 저장된 Bean 공유 유무 확인
 */
public class ServletForward extends HttpServlet {

	/// service()
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("[ ServletForward.service() start.......]");

		// ==> Request ObjectScope 저장
		request.setAttribute("user01", new User("홍길동", "1111"));

		// ==> Session ObjectScope 저장
		HttpSession session = request.getSession(true);
		session.setAttribute("user02", new User("이순신", "2222"));

		// ==> Application ObjectScope 저장
		ServletContext application = this.getServletContext();
		application.setAttribute("user03", new User("장보고", "3333"));

		// 1. ServletContext object 추출
		ServletContext sc = this.getServletContext();
		// 2. Context 내의 resource 이동 할 수 있는 기능을 제공하는 RequestDisppatcher 객체 추출
		RequestDispatcher rd = sc.getRequestDispatcher("/02Navigation/view.jsp");
		// 3. Forward
		rd.forward(request, response);

		System.out.println("[ ServletForward.service() end........]");
	}

}

/*
 * 	실행방법 : http://127.0.0.1:8080/003edu/ServletForward
 * 	1. web.xml mapping 확인
 * 	2. URL 확인 / Browser 화면은 Servlet 화면인가 ? Jsp 화면인가 ?
 * 	3. 각각의 ObjectScope 다시 확인
 * 	4. forward와 sendRedirect 차이점 ? 
 * 
 */

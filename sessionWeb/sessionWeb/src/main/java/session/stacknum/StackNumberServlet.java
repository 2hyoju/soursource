package session.stacknum;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StackNumberServlet
 */
@WebServlet("/stacknums/stack")
public class StackNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * 요청한 사용자가 볼 숫자를 생성해서 요청시마다 누적.
	 *  => 로그인한 사용자만 사용할 수 있는 서비스. 
	 *  1. 로그인 여부 체크 
	 *  2. 새로운 숫자를 생성 
	 *  3. 생성한 숫자를 Session에 추가 
	 *  4. show_numbers.jsp로 이동
	 *  
	 * 		1-a : 로그인을 하지 않은 사용자이면 -> login_form.jsp로 이동
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. HttpSession조회
		HttpSession session = request.getSession();
		// 2. 로그인 여부 체크 - X : login_form.jsp로 이동.
		if (session.getAttribute("loginMember") == null) {
			request.setAttribute("errorMessage", "숫자누적 프로그램을 사용하려면 로그인이 필요합니다.");
			request.getRequestDispatcher("/login/login_form.jsp");
			return;
		}
		// 3. 숫자를 생성
		int num = (int) (Math.random() * 1000); // 누적할 새 숫자.
		/*
		 * 누적 숫자들을 저장할 List를 session에서 조회 - 없으면 만들어서 session에 넣는다.
		 */
		ArrayList<Integer> list = (ArrayList<Integer>)session.getAttribute("numberList");
		if (list == null) {
			list = new ArrayList<>();
			session.setAttribute("numberList", list);
		}
		// 숫자를 list에 넣는다. - 누적.
		list.add(num);
		// 응답
		request.getRequestDispatcher("/stacknums/show_numbers.jsp").forward(request, response);
	}
}

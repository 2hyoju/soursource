package session.stacknum;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/stacknums/stack")
public class StackNumberServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	/*
	 * 요청한 사용자가 볼 숫자를 생성해서 요청시마다 누적한다. 로그인한 사용자만 사용할 수 있는 서비스로 만든다. (=로그인 체크)
	 * 1. 로그인 여부 확인
	 * 2. 새로운 숫자를 생성
	 * 3. 생성한 숫자를 Session에 추가
	 * 4. show_numbers.jsp로 이동(응답)
	 * 
	 * 1-a. 로그인을 하지 않은 사용자라면 login_form.jsp로 이동
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. HttpSession 조회
		HttpSession session = request.getSession();
//		2. 로그인 여부 확인 -> 로그인을 안 했으면 login_form.jsp로 이동
		if(session.getAttribute("loginMember") == null) {
			request.setAttribute("errorMessage", "숫자 누적은 로그인을 해야 합니다.");
			request.getRequestDispatcher("/login/login_form.jsp").forward(request, response);
			return;
		}
//		누적할 새 숫자
		int num = (int)(Math.random()*1000);
//		누적한 숫자들을 저장할 List를 Session에서 조회한다. 이 때 List가 없으면 새로 만들어서 Session에 넣는다.
		ArrayList<Integer> list = (ArrayList<Integer>) session.getAttribute("numberList");
		if(list == null) {
			list = new ArrayList<>();
			session.setAttribute("numberList", list);
		}
//		누적
		list.add(num);
//		응답
		request.getRequestDispatcher("/stacknums/show_numbers.jsp").forward(request, response);
	}
}
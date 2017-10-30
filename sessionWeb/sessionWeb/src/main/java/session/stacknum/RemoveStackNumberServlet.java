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
 * Servlet implementation class RemoveStackNumberServlet
 */
@WebServlet("/stacknums/removenums")
public class RemoveStackNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * 누적된 숫자 제거 기본흐름 
	 * 1. 로그인 여부 체크 
	 * 2. 누적된 숫자 제거 
	 * 3. show_numbers.jsp로 이동
	 * 
	 * 예외흐름 
	 * 1-a : 로그인을 하지 않은 경우 - login_form.jsp로 이동
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginMember")==null) {
			request.setAttribute("errorMessage", "누적된 숫자 제거 프로그램을 사용하려면 로그인이 필요합니다.");
			request.getRequestDispatcher("/login/login_form.jsp").forward(request, response);;
			return;
		}
		ArrayList<Integer> list = (ArrayList<Integer>)session.getAttribute("numberList");
		session.removeAttribute("numberList"); //누적된 숫자는 컬렉션에 남겨놓고 세션에서만 날림
		//list.clear();
		request.getRequestDispatcher("/stacknums/show_numbers.jsp").forward(request, response);
	}

}

package session.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.LoginFailException;
import vo.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청 파라미터 조회
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		try {
			// 2. Business logic 처리(로그인 처리) - Model을 호출
			Member member = authenticate(id, password);
			// 인증 성공 - 로그인 처리 : HttpSession생성+로그인여부 체크 속성추가.
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", member);
			// 3. 처리결과 응답 - View를 호출.
			request.getRequestDispatcher("/login/login_success.jsp").forward(request, response);
		} catch (LoginFailException e) {
			// 인증 실패
			// 3. 처리결과(실패결과) 응답.
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/login/login_form.jsp").forward(request, response);
		}
	}

	/*
	 * 회원 인증(로그인) 처리하는 메소드 => MemberService(Business Service)에 있는 메소드.
	 * 
	 * 기본흐름 1. 매개변수로 받은 ID와 패스워드가 회원데이터 베이스에 있는지 확인. 2. 회원의 정보를 리턴한다.
	 * 
	 * 오류흐름 2-1. 회원정보가 틀리면 예외를 던진다.
	 */
	public Member authenticate(String id, String password) throws LoginFailException {
		// memberDao.selectmemberById(id);
		// select id, password, name, email from member where id = ?
		Member member = null; // 없는 ID
		member = new Member(id, "servlet", "김회원", "kim@a.com"); // id가 있다.

		if (member != null) { // 있는 ID
			if (password.equals(member.getPassword())) {
				// 인증 성공
				return member;
			} else { // ID는 맞는데 Pwd 틀린경우 - 인증 실패
				throw new LoginFailException("패스워드를 확인하세요.");
			}
		} else { // 없는 ID
			throw new LoginFailException("ID를 확인하세요.");
		}
	}

}

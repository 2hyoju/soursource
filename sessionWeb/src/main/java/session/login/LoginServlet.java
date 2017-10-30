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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 요청파라미터 조회
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		try {
//		2. 비즈니스 로직 처리(로그인 처리) : model(비즈니스 로직)을 호출한다.
			Member member = authenticate(id, password);
//			★이 줄로 내려오면 인증 성공 - 로그인 처리(=HttpSession을 생성하고, 로그인 여부를 체크하는 속성을 추가한다.)
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", member);
//		3. 처리 결과 응답 : view를 호출
			request.getRequestDispatcher("/login/login_success.jsp").forward(request, response);
		} catch (LoginFailException e) {
//			★이 줄로 내려오면 인증 실패
//			3. 실패 결과 응답
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/login/login_form.jsp").forward(request, response);
		}
	}
	/*
	 * 회원 인증(로그인) 처리하는 메소드. 원래는 MemberService(B/S) class에 있는 메소드이다.
	 * 기본흐름
	 * 1. 매개변수로 받은 id와 패스워드가 회원 DB에 있는지 확인한다.
	 * 2. 회원의 정보를 리턴한다.
	 * 오류흐름
	 * 2-1. 회원정보가 틀리면 예외를 던진다.
	 */
	public Member authenticate(String id, String password) throws LoginFailException {
//		Member memebr = memberDao.selectMemberById(id);
//						select id, password, name, email from member where id=?
		Member member = null;	//없는 id
		member = new Member(id, "servlet", "김회원", "kim@a.com");	//있는 id
		
		if(member != null) {//있는 id라면
			if(password.equals(member.getPassword())) {
//				인증 성공
				return member;
			} else {//id는 맞는데 password는 틀린 경우
				throw new LoginFailException("password를 확인하세요.");
			}
		} else {//없는 id라면
			throw new LoginFailException("ID를 확인하세요.");
		}
	}
}
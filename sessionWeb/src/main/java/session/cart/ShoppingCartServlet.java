package session.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/cart/addCart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*기본흐름
	 * 1. 로그인 체크
	 * 
	 * 2. 장바구니에 상품 담기
	 * 	2-1 요청파라미터 조회
	 * 	2-2 장바구니에 상품 추가
	 * 3. 응답 - cart_list.jsp 로 이동
	 * 
	 * 
	 * 오류 흐름
	 * 1-a 로그인이 안된 상태 -> login_form.jsp로 이동
	 * 2-a-1 사용자가 장바구니에 담도록 요청한 상품이 없는 경우 -> 상품목록(/cart/showItems)으로 이동
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		1. 로그인 체크
		HttpSession session = request.getSession();
		if (session.getAttribute("loginMember") == null) {
			request.setAttribute("errorMessage", "상품을 장바구니에 담으려면 사용하려면 로그인이 필요합니다.");
			request.getRequestDispatcher("/login/login_form.jsp").forward(request, response);;
			return;
		}
//		2. 장바구니에 상품을 담는 작업 처리
//		2-1. 요청 파라미터 조회(담을 상품 조회)
//		request.setCharacterEncoding("UTF-8");	//한글처리
		String[] list = request.getParameterValues("items");
//		사용자가 전달한 상품이 없는 경우 바로 상품목록으로 이동한다.
		if (list == null) {
			request.setAttribute("errorMessage", "상품이 선택되지 않았습니다.");
			request.getRequestDispatcher("/cart/showItems").forward(request, response);
			return;
		}
//		2-2. 장바구니에 추가
//		장바구니 조회
		HashMap<String, Integer> items = (HashMap<String, Integer>) session.getAttribute("itemList");
		if (items == null) {// 장바구니 처리를 처음하는 경우 Map객체를 생성해 session에 추가(binding)
			items = new HashMap<>();
			session.setAttribute("itemList", items);
		}
		// 상품을 장바구니에 추가 || 수량 갱신 (key: 제품명, value: 주문수량)
		for (int i = 0; i < list.length; i++) {// 이미 담은 상품 - 수량 갱신 (+1)
			// int newCount = cart.get(items[i])+1; cart.put(items[i], newCount);
			if (items.containsKey(list[i])) {
				items.put(list[i], items.get(list[i]) + 1);
			} else {// 처음 담는 상품 - 추가
				items.put(list[i], 1);
			}
		}
		// 3. 응답 - /session/cart_list.jsp
//		request.getRequestDispatcher("/cart/cart_list.jsp").forward(request, response);
//		위에까지 처리했고 응답결과는 /sessionWeb/cart/cart_list.jsp 얘한테 보렴!
		response.sendRedirect("/sessionWeb/cart/cart_list.jsp");
	}
}
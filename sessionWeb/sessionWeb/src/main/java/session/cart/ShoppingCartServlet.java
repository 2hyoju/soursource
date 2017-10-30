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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("loginMember") == null) {
			request.setAttribute("errorMessage", "상품을 장바구니에 담으려면 사용하려면 로그인이 필요합니다.");
			request.getRequestDispatcher("/login/login_form.jsp").forward(request, response);;
			return;
		}
		
		String[] list = request.getParameterValues("items");
		if (list == null) {
			request.setAttribute("errorMessage", "상품이 선택되지 않았습니다.");
			request.getRequestDispatcher("/cart/showItems").forward(request, response);
			return;
		}
		
		HashMap<String, Integer> items = (HashMap<String, Integer>) session.getAttribute("itemList");
		if (items == null) {
			items = new HashMap<>();
			session.setAttribute("itemList", items);
		}
		for (int i = 0; i < list.length; i++) {
			if (items.containsKey(list[i])) {
				items.put(list[i], items.get(list[i]) + 1);
			} else {
				items.put(list[i], 1);
			}
		}

		request.getRequestDispatcher("/cart/cart_list.jsp").forward(request, response);

	}

}

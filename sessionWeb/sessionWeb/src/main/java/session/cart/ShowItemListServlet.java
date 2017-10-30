package session.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowItemListServlet
 */
@WebServlet("/cart/showItems")
public class ShowItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 상품 목록 보기 - 상품 목록 보기 링크 -> ShowItemListServlet -> item_list.jsp
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 상품 목록을 DB에서 조회 -> 상품 목록 : request scope의 Attribute 설정

		request.getRequestDispatcher("/cart/item_list.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}

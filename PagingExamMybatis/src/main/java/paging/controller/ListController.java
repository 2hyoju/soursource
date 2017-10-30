package paging.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paging.service.ItemService;
import paging.service.impl.ItemServiceImpl;

@WebServlet("/itemList")
/**
 * 목록을 조회 처리 Controller 
 */
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청파라미터 조회 - 보여줄 페이지
		//잘못된 값이 넘어오면 그냥 첫번째 페이지 보여주겠다.
		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {}
		//2. 비지니스로직 : ItemService.getItemList(page) 호출
		ItemService service = ItemServiceImpl.getInstance();
		Map<String, Object> map = service.getItemList(page);
		//3. 응답 처리 : ltem_list.jsp로 이동 - 요청디스패치
		request.setAttribute("list", map.get("list"));
		request.setAttribute("pageBean", map.get("pageBean"));
		request.getRequestDispatcher("/item_list.jsp").forward(request, response);
	}
}
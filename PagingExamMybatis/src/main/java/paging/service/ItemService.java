package paging.service;

import java.util.Map;

public interface ItemService {

	/**
	 * item_list.jsp에 보여줄 내용들을 조회처리하는 메소드
	 * 보려는 page 기준으로 그 페이지에 보여줄 항목들(List<Item>)과 페이징처리에 필요한 PagingBean을 리턴
	 * @param page 보려는 페이지
	 * @return Map 내에 그 페이지에서 보여줄 Item들을 담은 List와 PaingBean 객체를 리턴
	 */
	Map<String, Object> getItemList(int page);

}
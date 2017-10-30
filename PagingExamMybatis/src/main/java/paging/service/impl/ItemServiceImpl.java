package paging.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import paging.dao.ItemsDao;
import paging.dao.impl.ItemsDaoImpl;
import paging.service.ItemService;
import paging.util.PagingBean;
import paging.util.SqlSessionFactoryManager;
import paging.vo.Item;

public class ItemServiceImpl implements ItemService {
	
	private SqlSessionFactory factory;
	private ItemsDao dao;
	private static ItemService instance;

	private ItemServiceImpl() throws IOException {
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao = ItemsDaoImpl.getInstance();
	}
	
	public static ItemService getInstance() throws IOException {
		if (instance == null) instance = new ItemServiceImpl();
		return instance;
	}
	
	@Override
	public Map<String, Object> getItemList(int page){
		SqlSession session = factory.openSession();
//		처리결과를 담을 Map - List<Item>, PagingBean 객체
		HashMap<String, Object> map = new HashMap<>();
		try {
//			PagingBean 생성
			PagingBean pb = new PagingBean(dao.selectItemCount(session), page);
			map.put("pageBean", pb);
			List<Item> list = dao.selectItemList(session, pb.getBeginItemInPage(), pb.getEndItemInPage());
			map.put("list", list);
			return map;
		}finally {
			session.close();
		}
	}
}
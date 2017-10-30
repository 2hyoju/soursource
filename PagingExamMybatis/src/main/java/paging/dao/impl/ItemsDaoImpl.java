package paging.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import paging.dao.ItemsDao;
import paging.vo.Item;

public class ItemsDaoImpl implements ItemsDao {
	
	private static ItemsDao instance;

	private ItemsDaoImpl() {}

	public static ItemsDao getInstance() {
		if (instance == null) instance = new ItemsDaoImpl();
		return instance;
	}
	
	private String makeSql(String sqlId){
		return "paging.config.mapper.pagingMapper."+sqlId;
	}

	@Override
	public List<Item> selectItemList(SqlSession session, int beginItemNum, int endItemNum) {
		HashMap<String, Integer> params = new HashMap<>();
		params.put("begin", beginItemNum);
		params.put("end", endItemNum);
		return session.selectList(makeSql("selectItemList"), params);
	}

	@Override
	public int selectItemCount(SqlSession session){
		return session.selectOne(makeSql("selectItemCount"));
	}
}
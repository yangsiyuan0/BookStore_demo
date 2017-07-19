package ebook_store.dao;

import java.sql.SQLException;
import java.util.List;

import ebook_store.domain.BookBean;

public interface IBookDao {

	// 查询分类下的书籍总数
	Integer findTotalItem(String cid) throws SQLException;

	// 查询当前页面下的书籍信息
	List<BookBean> findCurrentPageByCid(String cid, int begin, Integer pageSize)  throws SQLException;

	BookBean findByBid(String bid) throws SQLException;

}

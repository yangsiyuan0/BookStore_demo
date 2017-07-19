package ebook_store.service;

import java.sql.SQLException;

import ebook_store.domain.BookBean;
import ebook_store.domain.PageBean;

public interface IBookService {

	// 对书籍进行分页展示
	PageBean<BookBean> findPageByCid(String cid, Integer currentPage) throws SQLException;

	// 查询书籍详情
	BookBean findByBid(String bid) throws SQLException;

}

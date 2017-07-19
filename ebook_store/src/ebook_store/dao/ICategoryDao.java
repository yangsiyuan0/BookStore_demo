package ebook_store.dao;

import java.sql.SQLException;
import java.util.List;

import ebook_store.domain.CategoryBean;

public interface ICategoryDao {

	// 查询所有的书籍分类
	List<CategoryBean> findAllCategory() throws SQLException;

}

package ebook_store.service;

import java.sql.SQLException;
import java.util.List;

import ebook_store.domain.CategoryBean;

public interface ICategoryService {

	// 查询所有的书籍分类
	List<CategoryBean> findAllCategory() throws SQLException;

}

package ebook_store.service.impl;

import java.sql.SQLException;
import java.util.List;

import ebook_store.dao.ICategoryDao;
import ebook_store.domain.CategoryBean;
import ebook_store.service.ICategoryService;
import ebook_store.utils.BeanFactory;

public class CategoryServiceImpl implements ICategoryService {
	private ICategoryDao categoryDao = (ICategoryDao) BeanFactory.getBean("categoryDao");
	/**
	 * 查询所有的书籍分类
	 */
	@Override
	public List<CategoryBean> findAllCategory() throws SQLException {
		return categoryDao.findAllCategory();
	}

}

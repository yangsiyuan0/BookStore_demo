package ebook_store.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import ebook_store.dao.ICategoryDao;
import ebook_store.domain.CategoryBean;
import ebook_store.utils.C3P0Utils;

public class CategoryDaoImpl implements ICategoryDao {
	private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	/**
	 * 查询所有的书籍分类
	 */
	@Override
	public List<CategoryBean> findAllCategory() throws SQLException {
		String sql = "select * from category where status = ?";
		List<CategoryBean> list = qr.query(sql, new BeanListHandler<CategoryBean>(CategoryBean.class), 1);
		return list;
	}

}

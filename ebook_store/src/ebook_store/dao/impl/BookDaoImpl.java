package ebook_store.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import ebook_store.dao.IBookDao;
import ebook_store.domain.BookBean;
import ebook_store.utils.C3P0Utils;

public class BookDaoImpl implements IBookDao {
	private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	/**
	 * 当前分类的书籍总数
	 */
	@Override
	public Integer findTotalItem(String cid) throws SQLException {
		String sql = "select count(*) from book where cid = ? and isdel = ?";
		Long count = (Long)qr.query(sql, new ScalarHandler(), cid,0);
		System.out.println("count:\t"+count);
		return count.intValue();
	}

	/**
	 * 书籍的分页展示
	 * @throws SQLException 
	 */
	@Override
	public List<BookBean> findCurrentPageByCid(String cid, int begin, Integer pageSize) throws SQLException {
		String sql = "select * from book where cid = ? and isdel = ? limit ?,?";
		List<BookBean> list = qr.query(sql, new BeanListHandler<BookBean>(BookBean.class), cid,0,begin,pageSize);
		return list;
	}

	/**
	 * 查询书籍详情
	 */
	@Override
	public BookBean findByBid(String bid) throws SQLException {
		String sql = "select * from book where bid = ?";
		BookBean bookBean = qr.query(sql, new BeanHandler<BookBean>(BookBean.class), bid);
		return bookBean;
	}

}

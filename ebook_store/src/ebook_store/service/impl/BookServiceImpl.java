package ebook_store.service.impl;

import java.sql.SQLException;
import java.util.List;

import ebook_store.dao.IBookDao;
import ebook_store.domain.BookBean;
import ebook_store.domain.PageBean;
import ebook_store.service.IBookService;
import ebook_store.utils.BeanFactory;

public class BookServiceImpl implements IBookService {
	private IBookDao bookDao = (IBookDao) BeanFactory.getBean("bookDao");
	/**
	 * 对书籍按分类进行分页展示
	 */
	@Override
	public PageBean<BookBean> findPageByCid(String cid, Integer currentPage) throws SQLException {
		//初始化PageBean的参数
				PageBean<BookBean> pageBean = new PageBean<BookBean>();
				// 1. 当前页数
				pageBean.setCurrentPage(currentPage);
				// 2. 每页条目数
				Integer pageSize = 12;
				pageBean.setPageSize(pageSize);
				// 3. 总条目数:向数据库中查询
				Integer totalItem = bookDao.findTotalItem(cid); //查询对应商品分类的商品总数
				double totalTemp = totalItem;
				pageBean.setTotalItem(totalItem);
				// 4. 总页数
				Double totalPage = Math.ceil(totalTemp/pageSize);
				pageBean.setTotalPage(totalPage.intValue());
				// 5. 当前页面详情:通过起始数,条目数向数据库查询
				int begin = (currentPage-1)*pageSize;
				List<BookBean> list = bookDao.findCurrentPageByCid(cid,begin,pageSize);
				pageBean.setList(list);
				
				return pageBean;
	}
	
	/**
	 * 查询书籍详情
	 */
	@Override
	public BookBean findByBid(String bid) throws SQLException {
		
		return bookDao.findByBid(bid);
	}

}

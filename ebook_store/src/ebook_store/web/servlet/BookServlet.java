package ebook_store.web.servlet;

import ebook_store.domain.BookBean;
import ebook_store.domain.PageBean;
import ebook_store.service.IBookService;
import ebook_store.utils.BaseServlet;
import ebook_store.utils.BeanFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 图书模块
 */
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IBookService bookService = (IBookService) BeanFactory.getBean("bookService");
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public Object findPageByCid(HttpServletRequest request, HttpServletResponse response){
		try{
			// 1. 获取参数:书籍的分类ID
			String cid = request.getParameter("cid");
			Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));
			// 2. 调用控制层,查询对应的书籍:结果封装在Pagebean类中
			PageBean<BookBean> pageBean = bookService.findPageByCid(cid,currentPage);
			request.setAttribute("pageBean", pageBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/jsp/book_list.jsp";
	}

	public Object findByBid(HttpServletRequest request, HttpServletResponse response){
		try{
			String bid = request.getParameter("bid");
			BookBean bookBean = bookService.findByBid(bid);
			request.setAttribute("bookBean", bookBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/jsp/book_info.jsp";
	}
}

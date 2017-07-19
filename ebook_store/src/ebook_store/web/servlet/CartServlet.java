package ebook_store.web.servlet;

import ebook_store.domain.BookBean;
import ebook_store.domain.CartBean;
import ebook_store.domain.CartItemBean;
import ebook_store.service.IBookService;
import ebook_store.utils.BaseServlet;
import ebook_store.utils.BeanFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 购物车模块
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 获取CartBean对象(存储在session中,名称为cart)
	 * @param name
	 * @return
	 */
	public CartBean getCart(HttpServletRequest request){
		// 从session中获取cart对象
		HttpSession session = request.getSession();
		CartBean cart = (CartBean) session.getAttribute("cart");
		// 进行判断:cart是否存在
		if(cart == null){ // 如果不存在，则新建一个存入session
			cart = new CartBean();
			session.setAttribute("cart", cart);
		}
		return cart;
	}

   /**
    * @param request
    * @param response
    * @return
    */
   public Object addCart(HttpServletRequest request, HttpServletResponse response){
	   try{
		   String bid = request.getParameter("bid");
		   Integer count =  Integer.parseInt(request.getParameter("count"));
		   IBookService bookService = (IBookService) BeanFactory.getBean("bookService");
		   BookBean bookBean = bookService.findByBid(bid);
		   CartItemBean cartItemBean = new CartItemBean();
		   cartItemBean.setItemCount(count);
		   cartItemBean.setBookBean(bookBean);
		   CartBean cart = getCart(request); //利用封装的自定义方法获取cart对象
		   cart.add(cartItemBean); 
		   // 页面跳转
		   response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return null;
   }

   /**
    * @param request
    * @param response
    * @return
    */
   public Object removeCart(HttpServletRequest request, HttpServletResponse response){
	   try{
		   String bid = request.getParameter("bid");
		   CartBean cart = getCart(request);
		   cart.remove(bid);
		   response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return null;
   }
   
   /**
    * @param request
    * @param response
    * @return
    */
   public Object clearCart(HttpServletRequest request, HttpServletResponse response){
	   try{
		   // 调用方法clear()，清空购物车
		   CartBean cart = getCart(request);
		   cart.clear();
		  // 页面跳转
		   response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return null;
   }
}

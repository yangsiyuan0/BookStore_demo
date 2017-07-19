package ebook_store.web.servlet;

import ebook_store.domain.CartBean;
import ebook_store.domain.CartItemBean;
import ebook_store.domain.OrderBean;
import ebook_store.domain.OrderItemBean;
import ebook_store.service.IOrderService;
import ebook_store.utils.BaseServlet;
import ebook_store.utils.BeanFactory;
import ebook_store.utils.UUIDUtils;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 订单模块
 */
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	IOrderService orderService = (IOrderService) BeanFactory.getBean("orderService");
	/**
	 * 创建订单: 订单的相关数据均来自购物车（存储在sesion中【cart】）
	 * @param request
	 * @param response
	 * @return
	 */
	public Object createOrder(HttpServletRequest request, HttpServletResponse response){

		// 2. 从session中获取购物车信息
		CartBean cart = (CartBean) request.getSession().getAttribute("cart");
		if(cart == null){// 购物车为空：提醒用户(转发到信息页)
			request.setAttribute("msg", "您没有购买任何商品,立即<a href='/store_alpha/'>开始购物</a>~~");
			return "/jsp/msg.jsp";
		}
		
		// 2. 初始化Orderbean对象：①随机订单号，②获取当前时间作为下单时间,③订单状态1：未付款
		OrderBean orderBean = new OrderBean();
		String oid = UUIDUtils.getUUID();
		Date orderTime = new Date();
		orderBean.setOrderTime(orderTime);
		orderBean.setOid(oid);
		orderBean.setState(1);
		
		double total = cart.getTotal(); // 商品总金额
		orderBean.setTotal(total);
		for (CartItemBean cartItemBean: cart.getMap().values()) { // 获取商品条目信息:保存至OrderItemBean
			OrderItemBean orderItemBean = new OrderItemBean();
			orderItemBean.setCount(cartItemBean.getItemCount()); //商品数量
			orderItemBean.setSubtotal(cartItemBean.getSubtotal()); //金额小计
			orderItemBean.setItemId(UUIDUtils.getUUID()); //商品id：随机字符串
			orderItemBean.setBookBean(cartItemBean.getBookBean()); // 对应的product对象
			orderItemBean.setOrderBean(orderBean); //隶属的OrderBean对象
			// 将orderItemBean保存到OrderBean对象中
			orderBean.getOrderItems().add(orderItemBean);
		}
		
		// 3. 调用业务层：将orderBean保存到数据库
		orderService.createOrder(orderBean);
		
		// 4. 清空购物车（★★★★）
		cart.clear();
		// 5. 将页面跳转
		request.setAttribute("orderBean", orderBean);
		return "/jsp/order_info.jsp";
	}
	
	/**
	 * 查询用户的所有订单(分页查询):
	 *  - 从session中获取用户的信息
	 *  - 接收当前页面数currentPage:用于分页查询
	 * @param request
	 * @param response
	 * @return
	 */
public Object findAllOrder(HttpServletRequest request, HttpServletResponse response){
		
			try {
				//  调用业务层:对订单进行查询
				List<OrderBean> list = orderService.findAllOrder();
				request.setAttribute("list", list);
				return "/jsp/order_list.jsp";
				}catch (Exception e) {
				e.printStackTrace();
		}
		
			return null;
	}

/**
 * 免费下单(没有付费功能)
 * @param request
 * @param response
 * @return
 */
public Object payForfree(HttpServletRequest request, HttpServletResponse response){
	
	// 扭送公安局
	return "/jsp/prison.jsp";
}
}

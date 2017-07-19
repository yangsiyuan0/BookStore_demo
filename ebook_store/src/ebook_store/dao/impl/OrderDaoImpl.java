package ebook_store.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import ebook_store.dao.IOrderDao;
import ebook_store.domain.BookBean;
import ebook_store.domain.OrderBean;
import ebook_store.domain.OrderItemBean;
import ebook_store.utils.C3P0Utils;

public class OrderDaoImpl implements IOrderDao {
	private QueryRunner qr = new QueryRunner(); //用于事务的连接:saveOrder + saveOrderItem
	private QueryRunner qr1 = new QueryRunner(C3P0Utils.getDataSource());
	@Override
	public void saveOrderItem(OrderBean orderBean, Connection conn) throws SQLException {
		String sql = "INSERT INTO `orderitem` (`itemid`, `count`, `subtotal`, `bid`, `oid`) VALUES (?, ?, ?, ?, ?);";
		List<OrderItemBean> list = orderBean.getOrderItems();
		for (OrderItemBean orderItemBean : list) {
			Object[] params = {orderItemBean.getItemId(),orderItemBean.getCount(),orderItemBean.getSubtotal(),
					orderItemBean.getBookBean().getBid(),orderItemBean.getOrderBean().getOid()};
			qr.update(conn, sql, params);
		}
	}

	@Override
	public void saveOrder(OrderBean orderBean, Connection conn)throws SQLException  {
		String sql = "INSERT INTO `orders` (`oid`, `ordertime`, `total`, `state`, `address`)"
				+ " VALUES (?, ?, ?, ?, ?);";
		Object[] params = {orderBean.getOid(),orderBean.getOrderTime(),orderBean.getTotal(),orderBean.getState(),
				orderBean.getAddress()};
		qr.update(conn, sql, params);
	}

	@Override
	public List<OrderBean> findAllOrder() throws Exception {
		// 1. 查询所有订单
		String sql = "select * from orders";
		List<OrderBean> list = qr1.query(sql, new BeanListHandler<OrderBean>(OrderBean.class));
		// 2. 多表查询,获取所有订单项
		for (OrderBean orderBean : list) {
			sql = "select * from orderitem o,book b where o.bid = b.bid AND oid = ?";
			List<Map<String, Object>> oList = qr1.query(sql, new MapListHandler(), orderBean.getOid());
			for (Map<String, Object> map : oList) {
				BookBean bookBean = new BookBean();
				BeanUtils.populate(bookBean,map); 
				OrderItemBean orderItemBean = new OrderItemBean();
				BeanUtils.populate(orderItemBean, map); // 将查询到的订单条目信息封装到OrderItemBean
				orderItemBean.setBookBean(bookBean);
				orderBean.getOrderItems().add(orderItemBean);
			}
		}
		return list;
	}

}

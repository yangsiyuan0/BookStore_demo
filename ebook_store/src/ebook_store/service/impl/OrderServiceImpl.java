package ebook_store.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import ebook_store.dao.IOrderDao;
import ebook_store.domain.OrderBean;
import ebook_store.service.IOrderService;
import ebook_store.utils.BeanFactory;
import ebook_store.utils.C3P0Utils;

public class OrderServiceImpl implements IOrderService {
	private IOrderDao orderDao = (IOrderDao) BeanFactory.getBean("orderDao");
	@Override
	public void createOrder(OrderBean orderBean) {
		// 1. 开启事务
				Connection conn = C3P0Utils.getConnection(); //保证dao层中的同一事务内的操作使用统一connection
				try {
					conn.setAutoCommit(false);
					// 2. 保存Order
					orderDao.saveOrder(orderBean,conn);
					// 2. 保存OrdeItem
					orderDao.saveOrderItem(orderBean,conn);
					// 3. 提交事务
					DbUtils.commitAndCloseQuietly(conn);
				} catch (SQLException e) {
					e.printStackTrace();
					// 3. 如果保存失败，进行回滚
					DbUtils.rollbackAndCloseQuietly(conn);
				}
	}
	
	/**
	 * 查询所有订单
	 */
	@Override
	public List<OrderBean> findAllOrder()  throws Exception {
		
		return orderDao.findAllOrder();
	}

}

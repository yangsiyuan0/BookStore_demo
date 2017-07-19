package ebook_store.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ebook_store.domain.OrderBean;

public interface IOrderDao {


	void saveOrderItem(OrderBean orderBean, Connection conn) throws SQLException ;

	void saveOrder(OrderBean orderBean, Connection conn) throws SQLException ;

	// 查询所有订单
	List<OrderBean> findAllOrder()  throws Exception ;

}

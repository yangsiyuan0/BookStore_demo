package ebook_store.service;

import java.util.List;

import ebook_store.domain.OrderBean;

public interface IOrderService {

	// 创建订单
	void createOrder(OrderBean orderBean);

	// 查询所有订单
	List<OrderBean> findAllOrder()  throws Exception ;

}

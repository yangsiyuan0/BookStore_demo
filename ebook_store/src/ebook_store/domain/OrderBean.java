package ebook_store.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 订单实体类
 * 订单状态：
 *  1：未付款
 *  2：已经付款,未发货
 *  3：已发货
 *  4：确认收货（订单结束）
 * @author yang
 *
 */
public class OrderBean {
	
	private String oid; //订单ID
	private Date orderTime; // 下单时间
	private Double total; //订单总金额
	private Integer state; //订单状态
	private String address; // 收货地址
	private List<OrderItemBean> orderItems = new ArrayList<OrderItemBean>(); // 订单商品详情
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<OrderItemBean> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemBean> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}

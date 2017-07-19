package ebook_store.domain;
/**
 * 订单中每条记录的实体类
 * @author yang
 *
 */
public class OrderItemBean {
	private String itemId; //商品id
	private Integer count; // 商品数量
	private Double subtotal; //金额小计
	private BookBean bookBean; // 对应的产品对象
	private OrderBean orderBean;  //隶属的订单对象
	
	public BookBean getBookBean() {
		return bookBean;
	}
	public void setBookBean(BookBean bookBean) {
		this.bookBean = bookBean;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
	public OrderBean getOrderBean() {
		return orderBean;
	}
	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}
	
	
	
}

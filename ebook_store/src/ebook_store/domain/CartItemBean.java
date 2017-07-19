package ebook_store.domain;
/**
 * 购物项 实体
 * @author yang
 *
 */

public class CartItemBean {
	public BookBean bookBean;
	private Integer itemCount; //  商品数量
	private double subtotal; // 金额小计
	
	public BookBean getBookBean() {
		return bookBean;
	}
	public void setBookBean(BookBean bookBean) {
		this.bookBean = bookBean;
	}
	public Integer getItemCount() {
		return itemCount;
	}
	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}
	
	// 小计金额：数量*商城单价
	public double getSubtotal() {
		return itemCount*bookBean.getPrice();
	}

	
}

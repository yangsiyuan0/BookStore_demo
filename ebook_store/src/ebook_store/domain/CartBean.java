package ebook_store.domain;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车的 实体类：用于存储购物车中的信息+金额总计 
 * @author yang
 *
 */
public class CartBean {
	// 由于要对购物项进行增加、删除、清空等操作：所以选择Map集合（存在key），比List更合适
	private Map<String,CartItemBean> map = new LinkedHashMap<String,CartItemBean>();; // 购物项(pid,购物项)
	private double total = 0d;  // 商品价格总计
	
	public Map<String, CartItemBean> getMap() {
		return map;
	}
	
	public double getTotal() {
		return total;
	}
	

	
	/**
	 * 增加商品（购物项）操作
	 * @param pid
	 * @return
	 */
	public void add(CartItemBean item){
		String bid = item.getBookBean().getBid();
		if(map.containsKey(bid)){ // 如果已经包含此商品 : 增加数量即可
			CartItemBean itemBean = map.get(bid);
			itemBean.setItemCount(itemBean.getItemCount() + item.getItemCount());
		}else{ // 购物车中没有该商品:需要增加该商品
			map.put(bid, item);
		}
		total += item.getSubtotal();
	}
	
	/**
	 * 移除商品（购物项）操作
	 * @param pid
	 * @return
	 */
	public void remove(String bid){
		CartItemBean removeItem = map.remove(bid); //返回值即被移除的对象
		total -= removeItem.getSubtotal(); 
	}
	
	/**
	 * 清空购物车操作
	 * @param pid
	 * @return
	 */
	public void clear(){
		map.clear();
		total = 0d;
	}
	
}

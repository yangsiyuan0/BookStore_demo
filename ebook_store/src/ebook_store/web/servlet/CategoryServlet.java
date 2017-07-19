package ebook_store.web.servlet;

import ebook_store.domain.CategoryBean;
import ebook_store.service.ICategoryService;
import ebook_store.utils.BaseServlet;
import ebook_store.utils.BeanFactory;
import net.sf.json.JSONArray;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 书籍分类模块
 */
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public Object findAllCategory(HttpServletRequest request, HttpServletResponse response){
		try{
			ICategoryService categoryService = (ICategoryService) BeanFactory.getBean("categoryService");
			List<CategoryBean> list = categoryService.findAllCategory();
			//将书籍分类列表:以json文件存储
			String categoryList = JSONArray.fromObject(list).toString();
			// 将Json文件传回页面:(页面AJAX异步获取)
			response.getWriter().println(categoryList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null; //返回原页面
	}

}

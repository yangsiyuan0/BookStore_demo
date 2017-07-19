package ebook_store.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ebook_store.utils.BaseServlet;


/**
 * 绑定在项目根目录下的空白index页面
 *   向真实首页跳转
 */
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	public String index(HttpServletRequest request, HttpServletResponse response){
		return "/jsp/index.jsp";
	}
}

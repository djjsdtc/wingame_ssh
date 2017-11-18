package org.wingame.interceptors;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object username = ActionContext.getContext().getSession().get("username");
		if(username != null) return invocation.invoke();
		else{
			HttpServletRequest request = ServletActionContext.getRequest();  
			String redirect = request.getRequestURI();
			redirect = redirect.substring(redirect.indexOf('/', 1));
			String query = request.getQueryString();
			if(query != null) redirect += ("?" + query);
			ActionContext.getContext().getSession().put("redirect", redirect);
			return "login";
		}
	}

}

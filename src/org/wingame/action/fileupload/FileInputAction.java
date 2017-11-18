package org.wingame.action.fileupload;

import org.wingame.action.MessageActionBase;

import com.opensymphony.xwork2.ActionContext;

public class FileInputAction extends MessageActionBase {
	private int id;

	@Override
	public String execute() throws Exception {
		Integer idObj = (Integer) ActionContext.getContext().getSession().get("id");
		id = (idObj == null) ? -1 : idObj;
		return SUCCESS;
	}

	public int getId() {
		return id;
	}
}

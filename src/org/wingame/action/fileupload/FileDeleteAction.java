package org.wingame.action.fileupload;

import org.apache.struts2.ServletActionContext;
import org.wingame.service.FileService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileDeleteAction extends ActionSupport {
	private FileService fileService;
	private int id;

	public int getId() {
		return id;
	}
	
	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	@Override
	public String execute() throws Exception {
		String username = (String) ActionContext.getContext().getSession().get("username");
		Integer idObj = (Integer) ActionContext.getContext().getSession().get("id");
		id = (idObj == null) ? -1 : idObj;
		if(username == null || id == -1) return ERROR;
		//文件存放路径，是本Web服务主目录下的upload目录
		String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
		//删除原来有的文件（如果没有就随它去）
		fileService.removeFile(username, id, uploadPath);
		return SUCCESS;
	}
}

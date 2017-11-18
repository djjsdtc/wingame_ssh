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
		//�ļ����·�����Ǳ�Web������Ŀ¼�µ�uploadĿ¼
		String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
		//ɾ��ԭ���е��ļ������û�о�����ȥ��
		fileService.removeFile(username, id, uploadPath);
		return SUCCESS;
	}
}

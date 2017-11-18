package org.wingame.action.fileupload;

import org.wingame.action.MessageActionBase;
import org.wingame.dao.TDocument;
import org.wingame.service.FileService;

import com.opensymphony.xwork2.ActionContext;

public class FileStatusAction extends MessageActionBase {
	private FileService fileService;
	private int id = -1;
	private String filename;
	private String status;
	private long currentTime;
	private long deadline;
	private long datetime;
	
	public long getDatetime() {
		return datetime;
	}

	public long getCurrentTime() {
		return currentTime;
	}

	public long getDeadline() {
		return deadline;
	}
	
	public FileService getFileService() {
		return fileService;
	}
	
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public String getStatus() {
		return status;
	}
	
	@Override
	public String execute() throws Exception {
		if(id == -1) return ERROR;
		String username = (String) ActionContext.getContext().getSession().get("username");
		if(username == null) return ERROR;
		currentTime = System.currentTimeMillis();
		deadline = fileService.getDeadline(id);
		datetime = fileService.getDatetime(id);
		TDocument document = fileService.getDocument(username, id);
		if(document != null){
			filename = document.getDocFilename();
			switch(document.getDocStatus().charAt(0)){
			case 'p':
				status = "已通过";
				break;
			case 'f':
				status = "未通过";
				break;
			default:
				status = "待审核";
				break;
			}
		}
		else{
			filename = null;
			status = "";
		}
		return SUCCESS;
	}
}

package org.wingame.action.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.wingame.service.FileService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	private final long MAX_SIZE_LIMIT = 1024 * 1024 * 10;
	//文件大小的上限，为10MB（可上传范围包含10MB）
	
	private File file;				//文件
	private String fileFileName;	//文件名，用于取得扩展名
	private FileService fileService;
	private int id;
	
	public void setFile(File file) {
		this.file = file;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public int getId() {
		return id;
	}

	public File getFile() {
		return file;
	}
	
	public String getFileFileName() {
		return fileFileName;
	}
	
	public FileService getFileService() {
		return fileService;
	}
	
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	@Override
	public String execute() throws Exception {
		Integer idObj = (Integer) ActionContext.getContext().getSession().get("id");
		id = (idObj == null) ? -1 : idObj;
		String username = (String) ActionContext.getContext().getSession().get("username");
		if(username == null || id == -1) return ERROR;
		if(file == null) return "null";
		//文件存放路径，是本Web服务主目录下的upload目录
		String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
		//先删除原来有的文件（如果没有就随它去）
		fileService.removeFile(username, id, uploadPath);
		String filename = getFileName();
		String savePath = uploadPath + File.separator + filename;
		saveFile(savePath);
		//写文件记录
		fileService.createFileRecord(username, id, filename);
		return SUCCESS;
	}
	
	private String getFileName(){
		//设置文件名，服务器上的文件名是：UUID+原文件扩展名
		String extension = fileFileName.substring(fileFileName.lastIndexOf('.'));
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString() + extension;
		return filename;
	}
	
	private void saveFile(String savePath) throws IOException{
		//使用Java IO写文件，这是Struts2封装的成果
		FileOutputStream fos = new FileOutputStream(new File(savePath));
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024*1024];		//缓冲区，每次读1MB
		int actualReadSize;
		while((actualReadSize = fis.read(buffer)) > 0){
			fos.write(buffer, 0, actualReadSize);
		}
		fis.close();
		fos.close();
	}
}

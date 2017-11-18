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
	//�ļ���С�����ޣ�Ϊ10MB�����ϴ���Χ����10MB��
	
	private File file;				//�ļ�
	private String fileFileName;	//�ļ���������ȡ����չ��
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
		//�ļ����·�����Ǳ�Web������Ŀ¼�µ�uploadĿ¼
		String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
		//��ɾ��ԭ���е��ļ������û�о�����ȥ��
		fileService.removeFile(username, id, uploadPath);
		String filename = getFileName();
		String savePath = uploadPath + File.separator + filename;
		saveFile(savePath);
		//д�ļ���¼
		fileService.createFileRecord(username, id, filename);
		return SUCCESS;
	}
	
	private String getFileName(){
		//�����ļ������������ϵ��ļ����ǣ�UUID+ԭ�ļ���չ��
		String extension = fileFileName.substring(fileFileName.lastIndexOf('.'));
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString() + extension;
		return filename;
	}
	
	private void saveFile(String savePath) throws IOException{
		//ʹ��Java IOд�ļ�������Struts2��װ�ĳɹ�
		FileOutputStream fos = new FileOutputStream(new File(savePath));
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024*1024];		//��������ÿ�ζ�1MB
		int actualReadSize;
		while((actualReadSize = fis.read(buffer)) > 0){
			fos.write(buffer, 0, actualReadSize);
		}
		fis.close();
		fos.close();
	}
}
